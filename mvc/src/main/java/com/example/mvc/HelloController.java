package com.example.mvc;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author qiuchangdong
 * @Type HelloController
 * @Desc 。
 * @date 2021-03-10 14:43:25
 */
@RestController
public class HelloController {
    @Autowired
    private PersonRepository repository;
    private RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/database")
    public String database(@RequestParam("id") int id) {
        val person = repository.findById(id);
        return (person.isPresent() ? person.get().getName() : "null");
    }

    @GetMapping("/restful")
    public String restful() {
        val ok = restTemplate.getForObject("http://localhost:81/ok", Boolean.class);
        if (ok) {
            return "OK";
        }
        return "Oops";
    }

    @GetMapping("/redis")
    public String redis() {
        return (String) redisTemplate.opsForHash().get("testh", "test");
    }

    @GetMapping("/ok")
    public Boolean ok() {
        return true;
    }
}
