package tech.bestwebshop.api.userclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class UserClient {
    private final Map<Long, User> userCache = new LinkedHashMap<Long, User>();

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getUserCache", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "2")
    })
    public User getUser(Long userId){
        User tmpUser = restTemplate.getForObject("http://user-service/user/" + userId, User.class);
        userCache.putIfAbsent(userId, tmpUser);
        return tmpUser;
    }

    public User getUserCache(Long userId){
        return userCache.getOrDefault(userId, new User());
    }
}
