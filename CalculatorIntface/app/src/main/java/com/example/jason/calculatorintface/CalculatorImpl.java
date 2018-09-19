package com.example.jason.calculatorintface;

//定义接口的实现类
public class CalculatorImpl implements  Calculator {
    public int sum(int a ,int b){
        int result = a +b;
        return  result;
    };
}
