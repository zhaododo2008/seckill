package com.seckill.analysis.core.util;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;


/**
 * @author zhaododo
 */
public class CodeHelperUtil {

	public static boolean isEmpty(Collection<?> collection) {
        return isNull(collection) || collection.size() < 1;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return isNull(map) || map.size() < 1;
    }

    public static boolean isEmpty(Object object) {
        if (object instanceof Collection) {
            return isEmpty((Collection<?>) object);
        } else if (object instanceof Map) {
            return isEmpty((Map<?, ?>) object);
        }
        return isNull(object) || "".equals(object);
    }

    public static boolean isPositive(Integer number){
	    return  number != null &&  number >0;
    }

    public static boolean isPositive(Short number){
        return  number != null &&  number >0;
    }

    public static boolean isPositive(Byte number){
        return  number != null &&  number >0;
    }

    public static boolean isPositive(Long number){
        return  number != null &&  number >0;
    }

    public static boolean isPositive(BigDecimal number){
        return  number != null &&  number.doubleValue() >0;
    }

    public static boolean isNotZero(BigDecimal number){
	    return number != null && (number.doubleValue() >0 || number.doubleValue() < 0);
    }

    public static boolean isNegative(Long number){
        return  number != null &&  number <0;
    }

    public static boolean isNegative(Byte number){
        return  number != null &&  number <0;
    }

    public static boolean isEmpty(Object[] object) {
        return isNull(object) || object.length < 1;
    }

    public static boolean isEmpty(String text) {
        return isNull(text) || text.trim().length() < 1;
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    public static boolean isNotEmpty(Object[] object) {
        return !isEmpty(object);
    }

    public static boolean isNotEmpty(String text) {
        return !isEmpty(text);
    }

    private static boolean isNull(Object object) {
        return object == null;
    }

    private static boolean isNotNull(Object object) {
        return object != null;
    }


    public static boolean hasLength(String text) {
        return text != null && text.length() > 0;
    }

    public static boolean hasText(String text) {
        if (!hasLength(text)) {
            return false;
        }
        int strLen = text.length();
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(text.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isContain(String textToSearch, String substring) {
        if (hasLength(textToSearch) && hasLength(substring) && textToSearch.contains(substring)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAssignable(Class<?> superType, Class<?> subType) {
        if (isNotNull(superType) && isNotNull(subType) && superType.isAssignableFrom(subType)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isInstanceOf(Class<?> type, Object object) {
        if (isNotNull(type) && type.isInstance(object)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串的内容是不是全是数字
     * @param text
     * @return
     */
    public static boolean isNumeric(String text) {
        if (isEmpty(text)) {
            return false;
        }
        int size = text.length();
        for (int i = 0; i < size; i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isLessZero(Integer number){
        return  null == number || (number != null && number <= 0);
    }

    /**
     * 逗号","分割的id转换为整型数组
     * @param idStr
     * @return
     */
    public static Integer[] convertIdSplit(String idStr) {
        if(StringUtils.isEmpty(idStr)) {
            return new Integer[0];
        }
        String[] ids = idStr.split(",");
        Set<Integer> roleIdList = new HashSet<>();
        for(String id : ids) {
            if(StringUtils.isEmpty(id)) {
                continue;
            }
            roleIdList.add(Integer.valueOf(id));
        }
        return roleIdList.toArray(new Integer[0]);
    }

    /**
     * 是否全部都满足指定的参数行为
     * @param numbers
     * @return
     */
    public static boolean isAllPositive(Number... numbers) {
        return Arrays
                .asList(numbers)
                .stream()
                .allMatch(number -> isPositive(number.intValue()));
    }

    /**
     * 是否存在一个或多个满足指定的参数行为
     * @param numbers
     * @return
     */
    public static boolean isAnyPositive(Number... numbers) {
        return Arrays
                .asList(numbers)
                .stream()
                .anyMatch(number -> isPositive(number.intValue()));
    }

    /**
     * 是否不存在满足指定行为的元素
     * @param numbers
     * @return
     */
    public static boolean isNonePositive(Number... numbers) {
        return Arrays
                .asList(numbers)
                .stream()
                .noneMatch(number -> isPositive(number.intValue()));
    }

}
