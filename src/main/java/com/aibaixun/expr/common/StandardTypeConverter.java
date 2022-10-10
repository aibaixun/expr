package com.aibaixun.expr.common;

import com.aibaixun.expr.TypeConverter;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public class StandardTypeConverter implements TypeConverter {

    @Override
    public <T> T convertValue(Object value, Class<T> targetType) {
        return convert(value, targetType);
    }


    public static<T> T convert(Object obj, Class<T> type) {
        return null;
    }
}
