package com.spring.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil<T> {
    private RedisTemplate<String, T> redisTemplate;
    private ValueOperations<String, T> valueOperations;
    private ListOperations<String, T> listOperations;
    private SetOperations<String, T> setOperations;
    private HashOperations<String, Integer, T> hashOperations;
    private HyperLogLogOperations<String, T> hyperlogOperations;

    @Autowired
    public RedisUtil(RedisTemplate<String, T> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
        this.listOperations = redisTemplate.opsForList();
        this.setOperations = redisTemplate.opsForSet();
        this.hashOperations = redisTemplate.opsForHash();
        this.hyperlogOperations = redisTemplate.opsForHyperLogLog();
    }
    
    //hyperlog
    @SuppressWarnings("unchecked")
	public void addHyperlog(String key, T value) {
    	hyperlogOperations.add(key, value);
    }
    
    public long getHyperlog(String key) {
    	return hyperlogOperations.size(key);
    }
    //hyperlog
    
    
    //region String
    public void putValue(String key, T value) {
        valueOperations.set(key, value);
    }

    public T getValue(String key) {
        return valueOperations.get(key);
    }

    public void setExpire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }
    //endregion


    //region List
    public void addList(String key, T value) {
        listOperations.leftPush(key, value);
    }

    public List<T> getListMembers(String key) {
        return listOperations.range(key, 0, -1);
    }

    public Long getListSize(String key) {
        return listOperations.size(key);
    }
    //endregion


    //region Set
    @SuppressWarnings("unchecked")
	public void addToSet(String key, T... values) {
        setOperations.add(key, values);
    }

    public Set<T> getSetMembers(String key) {
        return setOperations.members(key);
    }
    //endregion


    //region Hash
    public void saveHash(String key, Integer id, T value) {
        hashOperations.put(key, id, value);
    }

    public T findInHash(String key, int id) {
        return hashOperations.get(key, id);
    }

    public void deleteHash(String key, int id) {
        hashOperations.delete(key, id);
    }
    //endregion
}