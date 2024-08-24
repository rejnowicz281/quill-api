package com.rejnowicz.quillapi.service.redis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class RedisService {

    @Value("${redis.host}")
    private String HOST;

    @Value("${redis.port}")
    private int PORT;

    @Value("${redis.password}")
    private String PASSWORD;

    public Jedis getJedisPool() {
        Jedis jedis = new Jedis(HOST, PORT, true);
        jedis.auth(PASSWORD);

        return jedis;
    }
}
