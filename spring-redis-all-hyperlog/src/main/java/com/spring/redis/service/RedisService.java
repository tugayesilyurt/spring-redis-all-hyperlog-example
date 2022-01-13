package com.spring.redis.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.spring.redis.dto.Programmer;
import com.spring.redis.util.RedisUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RedisService {
    private final RedisUtil<String> redisStringUtil;
    private final RedisUtil<Programmer> redisProgrammerUtil;
    
    //hyperlog monitoring last one day how many device open our app
    public void setHyperlog(String key, String value) {
    	redisStringUtil.addHyperlog(key, value);
    }
    
    public long getHyperlog(String key) {
    	return redisStringUtil.getHyperlog(key);
    }
   //hyperlog monitoring last one day how many device open our app

    //region String
    public void setObjectAsString(String key, String value) {
        redisStringUtil.putValue(key, value);
        redisStringUtil.setExpire(key, 5, TimeUnit.MINUTES);
    }

    public String getObjectAsString(String key) { return redisStringUtil.getValue(key); }
    //endregion


    //region List
    public void addToList(String key, Programmer programmer) { redisProgrammerUtil.addList(key, programmer); }

    public List<Programmer> getListMembers(String key) {
        return redisProgrammerUtil.getListMembers(key);
    }

    public Long getListSize(String key) {
        return redisProgrammerUtil.getListSize(key);
    }
    //endregion


    //region Set
    public void addToSet(String key, Programmer... programmers) { redisProgrammerUtil.addToSet(key, programmers); }

    public Set<Programmer> getSetMembers(String key) {
        return redisProgrammerUtil.getSetMembers(key);
    }
    //endregion


    //region Hash
    public void saveHash(String key, Programmer programmer) {
        redisProgrammerUtil.saveHash(key, programmer.getId(), programmer);
    }

    public Programmer findInHash(String key, int id) { return redisProgrammerUtil.findInHash(key, id); }

    public void deleteHash(String key, int id) { redisProgrammerUtil.deleteHash(key, id); }
    //endregion
}