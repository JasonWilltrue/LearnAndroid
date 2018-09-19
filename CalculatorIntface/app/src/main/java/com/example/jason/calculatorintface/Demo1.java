package com.example.jason.calculatorintface;

public class Demo1 {
     public static void main(String[] args){
//         调用接口定义好的实现类
//         Calculator cal = new CalculatorImpl();
//         method(cal);

           //Lambda表达式
           method((a,b) -> a+b);
     }

    public static void method(Calculator calculator){
        int result =calculator.sum(1,25);
        System.out.println("结果是："+result);
    }
}
