package com.atguigu.ioc_03;


public class HappyComponent implements A{

    //默认包含无参数构造函数

    @Override
    public void doWork() {
        System.out.println("HappyComponent.doWork");
    }
}