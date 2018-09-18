package com.example.jason.myheroadd;

import java.util.ArrayList;

public class Demo01Hero {

    public static void  main(String[] args){
        //创建一个集合
        ArrayList<Hero>  team = new ArrayList<>();

        Hero one = new Hero("yi",102);
        Hero two = new Hero("er",277);
        Hero three = new Hero("san",320);
        Hero four = new Hero("si",440);
        Hero five = new Hero("wu",501);

        team.add(one);
        team.add(two);
        team.add(three);
        team.add(four);
        team.add(five);

        int sum = 0;
        for (int i = 0; i < team.size(); i++) {
            Hero hero = team.get(i);
            sum += hero.getAttack();
        }

        System.out.println("平均值"+(sum/team.size()));

    }
}
