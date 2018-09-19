package com.example.jason.calculatorintface;

//定义一个计算器接口
@FunctionalInterface   //检查是否是函数试接口
public interface Calculator {
    //第一步创建一个接口
    public abstract int sum(int a ,int b) ;
}
