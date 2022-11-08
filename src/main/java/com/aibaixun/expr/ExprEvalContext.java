package com.aibaixun.expr;



/**
 * 执行表达式上下文
 * @author wang xiao
 * date 2022/10/8
 */
public interface ExprEvalContext {

    /**
     * 获取类型转换器
     * @return  instance of typeConverter
     */
    TypeConverter getTypeConverter();

    /**
     * 获取操作数据
     * @return Object
     */
    Object getRootObject();
}
