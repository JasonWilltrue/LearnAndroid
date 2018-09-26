package com.example.jason.prioritydemo;

public class MyThread extends Thread {
    private String name;
    public MyThread(String name){
        this.name = name;
    }
    public void  run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("线程"+getName()+"正在运行"+i);

        }
    }

}
