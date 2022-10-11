package com.aibaixun.expr;

/**
 * Expr 解析后的类
 * 表示解析后的表达式
 * @author wang xiao
 * date 2022/10/8
 */
public interface Expr {

    /**
     * 获取表达式
     * @return string expression
     */
    String getExpression();

    /**
     * 执行表达式 并获取值
     * 使用默认的执行上下文
     *
     * @return object 执行后的结果
     * @throws ExprEvalException exception
     */
    Object getValue() throws ExprEvalException;


    /**
     * 执行表达式 并获取值
     * 使用默认的执行上下文
     *
     * @param tClass class
     * @param <T>    T class type
     * @return 执行后的结果
     * @throws ExprEvalException exception
     */
    <T> T getValue(Class<T> tClass) throws ExprEvalException;


    /**
     * 执行表达式 并获取值
     *
     * @param rootObj 获取变量值参数
     * @return 执行后的结果
     * @throws ExprEvalException exception
     */
    Object getValue(Object rootObj) throws ExprEvalException;


    /**
     * 执行表达式 并获取值
     *
     * @param rootObj 获取变量值参数
     * @param tClass  class
     * @param <T>     T class type
     * @return 执行后的结果
     * @throws ExprEvalException exception
     */
    <T> T getValue(Object rootObj, Class<T> tClass) throws ExprEvalException;

    /**
     * 执行表达式 并获取值
     *
     * @param context 执行上下文
     * @return 执行后的结果
     * @throws ExprEvalException exception
     */
    Object getValue(ExprEvalContext context) throws ExprEvalException;

    /**
     * 执行表达式 并获取值
     *
     * @param context 执行上下文
     * @param rootObj 获取变量值参数
     * @return 执行后的结果
     * @throws ExprEvalException exception
     */
    Object getValue(ExprEvalContext context, Object rootObj) throws ExprEvalException;

    /**
     * 执行表达式 并获取值
     *
     * @param context 执行上下文
     * @param tClass  class
     * @param <T>     T class type
     * @return 执行结果
     * @throws ExprEvalException exception
     */
    <T> T getValue(ExprEvalContext context, Class<T> tClass) throws ExprEvalException;

    /**
     * 执行表达式 并获取值
     *
     * @param context 执行上下文
     * @param rootObj 获取变量值参数
     * @param tClass  class
     * @param <T>     T class type
     * @return 执行结果
     * @throws ExprEvalException exception
     */
    <T> T getValue(ExprEvalContext context, Object rootObj, Class<T> tClass) throws ExprEvalException;


    /**
     * 获取执行结果的 类型
     *
     * @return class type
     * @throws ExprEvalException exception
     */
    Class<?> getValueType() throws ExprEvalException;

    /**
     * 获取执行结果的 类型
     *
     * @param context 执行上下文
     * @return class type
     * @throws ExprEvalException exception
     */
    Class<?> getValueType(ExprEvalContext context) throws ExprEvalException;

    /**
     * 获取执行结果的 类型
     *
     * @param rootObj 获取变量值参数
     * @return class type
     * @throws ExprEvalException exception
     */
    Class<?> getValueType(Object rootObj) throws ExprEvalException;

    /**
     * 获取执行结果的 类型
     *
     * @param context 执行上下文
     * @param rootObj 获取变量值参数
     * @return class type
     * @throws ExprEvalException exception
     */
    Class<?> getValueType(ExprEvalContext context, Object rootObj) throws ExprEvalException;


    /**
     * 是否可写入值
     *
     * @param context 执行上下文
     * @return boolean
     * @throws ExprEvalException exception
     */
    boolean isWriteable(ExprEvalContext context) throws ExprEvalException;

    /**
     * 是否可写入值
     *
     * @param context 执行上下文
     * @param rootObj 获取变量值参数
     * @return boolean
     * @throws ExprEvalException exception
     */
    boolean isWriteable(ExprEvalContext context, Object rootObj) throws ExprEvalException;

    /**
     * 写入值
     *
     * @param context 执行上下文
     * @param value   值
     */
    void writeValue(ExprEvalContext context, Object value);

    /**
     * 写入值
     *
     * @param rootObj 获取变量值参数
     * @param value   值
     */
    void writeValue(Object rootObj, Object value);

    /**
     * 写入值
     *
     * @param context 执行上下文
     * @param rootObj 获取变量值参数
     * @param value   值
     */
    void writeValue(ExprEvalContext context, Object rootObj, Object value);


}
