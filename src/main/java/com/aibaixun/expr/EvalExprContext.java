package com.aibaixun.expr;

import com.aibaixun.expr.type.TypeConverter;

/**
 * 执行表达式上下文
 * @author wang xiao
 * date 2022/10/8
 */
public interface EvalExprContext {

    /**
     * 获取类型转换器
     * @return  instance of typeConverter
     */
    TypeConverter getTypeConverter();
}
