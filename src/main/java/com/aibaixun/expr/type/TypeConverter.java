package com.aibaixun.expr.type;

/**
 * @author wang xiao
 * date 2022/10/10
 */
public interface TypeConverter {

    boolean canConvert( TypeDescriptor sourceType, TypeDescriptor targetType);


    Object convertValue( Object value, TypeDescriptor sourceType, TypeDescriptor targetType);

}
