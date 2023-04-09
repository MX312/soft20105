package com.study.singleton;


public class Boss2 {
    //创建私有静态属性(不创建对象)
    private static Boss2 boss;

    //构造方法私有化
    private Boss2 (){
        System.out.println("执行构造方法");
    }

    //提供公共的接口
    public static Boss2 getInstance() {
        if (boss == null) {
            boss = new Boss2();

        }
        return boss;
    }
}
