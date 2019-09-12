package com.seckill.analysis.core.util;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public List<Object> getPipelinedModels(List<Integer> modelIds) {
        final RedisSerializer jsonRedisSerializer = new FastJsonRedisSerializer(Object.class);
        List<Object> list = redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (Object modelId : modelIds) {
                String key = "model_data_"+modelId.toString();
                connection.get(key.getBytes());
            }
            return null;
        },jsonRedisSerializer);
        return list;
    }

    public Long getHashCacheKeySize(String cacheKey){
        return redisTemplate.opsForHash().size(cacheKey);
    }


    public void putHash(String cacheKey, String key, Object value){

        redisTemplate.opsForHash().put(cacheKey, key, value);
    }

    /**
     * 已Hash方式存放数据
     * @param key 缓存名
     * @param value 唯一标示
     * @param timeout 存放的值
     */
    public void setValue(String key, Object value,long timeout){
        if(timeout==0){
            redisTemplate.opsForValue().set(key,value);
        }else{
            redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
        }
    }

    public Object getValue(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public List<Object> getValuesByCacheKey(String cacheKey){
        return redisTemplate.opsForHash().values(cacheKey);
    }

    public Set<Object> getKeysByCacheKey(String cacheKey){
        return redisTemplate.opsForHash().keys(cacheKey);
    }

    public List<Object> getValuesByCacheKey(String cacheKey, Integer page, Integer pageSize){
        List<Object> result = redisTemplate.opsForHash().values(cacheKey);
        int size = result.size();
        int startIndex = 0;
        int endIndex = size;
        if (page != null && pageSize != null){
            startIndex = page * pageSize - pageSize < size ? page * pageSize - pageSize : size;
            endIndex = page * pageSize < size ? page * pageSize : size;
        }
        return result.subList(startIndex, endIndex);
    }

    /**
     * 获取Hash缓存数据
     * @param cacheKey 缓存名
     * @param key 查询的KEY值
     * @return Object
     */
    public Object getValueHash(String cacheKey, Object key){
        return redisTemplate.opsForHash().get(cacheKey, key.toString() );
    }

    /**
     * 删除缓存对象
     * @param cacheKey 缓存名
     * @return
     */
    public void deleteHash(String cacheKey){
        redisTemplate.delete(cacheKey);
    }

    /**
     * 删除缓存
     * @param cacheKey 缓存名
     * @param keys 缓存KEY
     */
    public void deleteHash(String cacheKey, Object... keys){
        redisTemplate.opsForHash().delete(cacheKey, keys );
    }
    /**
     * 是否存在
     * @param cacheKey
     */
    public boolean containsKeyHash(String cacheKey, Object key){
        return redisTemplate.opsForHash().hasKey(cacheKey, key.toString() );
    }

    public void saveSocketConnectStatus(String key,Object val){
        redisTemplate.opsForList().leftPush(key,val);
        redisTemplate.expire(key,12,TimeUnit.HOURS);
    }

    public Long leftPush(String key,Object val){
        return redisTemplate.opsForList().leftPush(key,val);
    }

    public Long rightPush(String key,Object val){
        return redisTemplate.opsForList().rightPush(key,val);
    }

    public Long rightPushAll(String key, Collection<Object> list){
        return redisTemplate.opsForList().rightPushAll(key,list);
    }

    public Object rightPop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }

    public Object leftPop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
}
