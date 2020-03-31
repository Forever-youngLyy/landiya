package com.jack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LandiyaApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        int cnt = 0;
        for (int i = 0; i < 1000; i++) {
            byte[] bytes = new byte[1024*1024];
            redisTemplate.opsForValue().set(++cnt,bytes);
        }
    }

}
