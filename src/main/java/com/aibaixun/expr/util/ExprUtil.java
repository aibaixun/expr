package com.aibaixun.expr.util;

import com.aibaixun.expr.EvalExprContext;
import com.aibaixun.expr.TypeConverter;

import java.util.Objects;

/**
 * @author wang xiao
 * date 2022/10/9
 */
public abstract class ExprUtil {

    public static <T> T convertValue(EvalExprContext context,Object source,Class<?> targetType){

        if (Objects.isNull(targetType)){
            return (T) source;
        }
        if (Objects.nonNull(context)){
            context.getTypeConverter().convertValue(source, targetType);
        }
        return (T)source;
    }


    public static Integer toInt(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Integer.class);
    }

    public static Boolean toBoolean(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Boolean.class);
    }

    public static Double toDouble(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Double.class);
    }

    public static Long toLong(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Long.class);
    }

    public static Character toChar(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Character.class);
    }

    public static Short toShort(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Short.class);
    }

    public static Float toFloat(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Float.class);
    }

    public static Byte toByte(TypeConverter typeConverter, Object source) {
        return convertValue(typeConverter, source, Byte.class);
    }

    private static <T> T convertValue(TypeConverter typeConverter, Object source, Class<T> targetType) {
        Object result = typeConverter.convertValue(source, targetType);
        if (result == null) {
            throw new IllegalStateException("Null conversion result for value [" + source + "]");
        } else {
            return (T)result;
        }
    }
}
