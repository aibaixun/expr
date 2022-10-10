package com.aibaixun.expr.util;

import com.aibaixun.expr.EvalExprContext;
import com.aibaixun.expr.type.TypeConverter;
import com.aibaixun.expr.type.TypeValue;

import java.util.Objects;

/**
 * @author wang xiao
 * date 2022/10/9
 */
public abstract class ExprUtil {

    public static <T> T convertValue(EvalExprContext context, TypeValue typeValue,Class<?> targetType){
        Object value = typeValue.getValue();
        if (Objects.isNull(targetType)){
            return (T) value;
        }
        if (Objects.nonNull(context)){
            context.getTypeConverter().convertValue(value, null, null);
        }
        return null;
    }

    public static int toInt(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Integer.class);
    }

    public static boolean toBoolean(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Boolean.class);
    }

    public static double toDouble(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Double.class);
    }

    public static long toLong(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Long.class);
    }

    public static char toChar(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Character.class);
    }

    public static short toShort(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Short.class);
    }

    public static float toFloat(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Float.class);
    }

    public static byte toByte(TypeConverter typeConverter, TypeValue TypeValue) {
        return convertValue(typeConverter, TypeValue, Byte.class);
    }

    private static <T> T convertValue(TypeConverter typeConverter, TypeValue TypeValue, Class<T> targetType) {
//        Object result = typeConverter.convertValue(TypeValue.getValue(), TypeValue.getTypeDescriptor(), TypeDescriptor.valueOf(targetType));
//        if (result == null) {
//            throw new IllegalStateException("Null conversion result for value [" + TypeValue.getValue() + "]");
//        } else {
//            return result;
//        }
        return null;
    }
}
