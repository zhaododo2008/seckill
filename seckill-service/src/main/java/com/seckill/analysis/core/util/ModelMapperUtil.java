package com.seckill.analysis.core.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaododo
 **/

public class ModelMapperUtil {

    private static ModelMapper modelMapper;

    static{
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    /**
     * dto转换-通用精确匹配
     * @param source
     * @param destinationType
     * @param <D>
     * @return
     */
    public static <D> D strictMap(Object source,Class<D> destinationType){
        return modelMapper.map(source, destinationType);
    }

    /**
     * List&lt;dto>转换
     * @param source
     * @param componentType
     */
    @SuppressWarnings("unchecked")
    public static <D> List<D> strictMapList(Object source, final Class<D> componentType){
        List<D> list= new ArrayList<D>();
        List<Object> objectList = (List<Object>) source;
        for (Object obj : objectList) {
            list.add(modelMapper.map(obj, componentType));
        }
        return list;
    }


}
