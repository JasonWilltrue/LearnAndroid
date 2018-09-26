package com.example.jason.prioritydemo;

//取款
public class DrawAccount implements Runnable {
    Bank bank;
    public DrawAccount(Bank bank){
        this.bank=bank;

    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("线程"+"正在运行"+i);
        }
        bank.drawAccount();
    }


}
