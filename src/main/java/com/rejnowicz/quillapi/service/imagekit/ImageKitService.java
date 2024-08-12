package com.rejnowicz.quillapi.service.imagekit;

import com.rejnowicz.quillapi.repository.user.UserRepository;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.config.Configuration;
import io.imagekit.sdk.models.BaseFile;
import io.imagekit.sdk.models.GetFileListRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageKitService {
    private final UserRepository userRepository;

    @Value("${imagekit.url-endpoint}")
    private String URL_ENDPOINT;

    @Value("${imagekit.public-key}")
    private String PUBLIC_KEY;

    @Value("${imagekit.private-key}")
    private String PRIVATE_KEY;

    private ImageKit getInstance() {
        ImageKit imageKit = ImageKit.getInstance();

        Configuration configuration = new Configuration(PUBLIC_KEY, PRIVATE_KEY, URL_ENDPOINT);

        imageKit.setConfig(configuration);

        return imageKit;
    }

    @SneakyThrows
    public void cleanUp()  {
        GetFileListRequest getFileListRequest = new GetFileListRequest();
        getFileListRequest.setPath("/quill/avatars");
        List<BaseFile> resultList = getInstance().getFileList(getFileListRequest).getResults();

        List<String> urls = resultList.stream()
                .map(BaseFile::getUrl)
                .map(url -> url.split("\\?")[0])
                .toList();

        List<String> existingUrls = userRepository.findExistingAvatarUrls(urls);

        var unusedAvatarsIds = resultList.stream()
                .filter(result -> !existingUrls.contains(result.getUrl().split("\\?")[0]))
                .map(BaseFile::getFileId)
                .toList();

        if (unusedAvatarsIds.isEmpty()) {
            log.info("No unused avatars found");
            return;
        }

        log.info("Deleting {} unused avatars", unusedAvatarsIds.size());
        for (String url : urls) {
            log.info(url);
        }
        getInstance().bulkDeleteFiles(unusedAvatarsIds);
    }
}
