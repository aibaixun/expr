package com.aibaixun.expr;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public interface TypeConverter {


    /**
     * 转换类型
     * @param value value
     * @param targetType 目标类型
     * @return Object
     */
    <T> T convertValue( Object value, Class<T> targetType);

}
