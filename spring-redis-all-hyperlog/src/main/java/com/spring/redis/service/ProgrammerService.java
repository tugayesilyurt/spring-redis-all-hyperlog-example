package com.spring.redis.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.spring.redis.dto.Programmer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProgrammerService{
	
    private static final String LIST_KEY = "LIST_KEY";
    private static final String SET_KEY = "SET_KEY";
    private static final String HASH_KEY = "HASH_KEY";
    private final RedisService redisService;
    
    public void setHyperlog(String key, String value) {
        redisService.setHyperlog(key, value);
    }
    
    public long getHyperlog(String key) {
       return  redisService.getHyperlog(key);
    }

    public void setObjectsAsString(String key, String programmer) {
        redisService.setObjectAsString(key, programmer);
    }

    public String getObjectAsString(String key) {
        return redisService.getObjectAsString(key);
    }

    public void AddToProgrammersList(Programmer programmer) {
        redisService.addToList(LIST_KEY, programmer);
    }

    public List<Programmer> getProgrammersListMembers() {
        return redisService.getListMembers(LIST_KEY);
    }

    public Long getProgrammersListCount() {
        return redisService.getListSize(LIST_KEY);
    }

    public void AddToProgrammersSet(Programmer... programmers) {
        redisService.addToSet(SET_KEY, programmers);
    }

    public Set<Programmer> getProgrammersSetMembers() {
        return redisService.getSetMembers(SET_KEY);
    }

    public void saveHash(Programmer programmer) {
        redisService.saveHash(HASH_KEY, programmer);
    }

    public Programmer findInHash(int id) {
        return redisService.findInHash(HASH_KEY, id);
    }

    public void deleteHash(int id) {
        redisService.deleteHash(HASH_KEY, id);
    }
}