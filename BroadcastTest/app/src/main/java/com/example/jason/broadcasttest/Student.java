package com.example.jason.broadcasttest;

public class Student {
    private  String name;
    private  int age;
    private  String  play;
    private  boolean sex;


    public Student(){

    }
    public  Student(String name,int age){
        this.name = name;
        this.age = age;
        this.play = play;
    }
 
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPlay() {
        return play;
    }

    public void setPlay(String play) {
        this.play = play;
    }
}
