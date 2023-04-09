package com.study.singleton;


/**
 * 饿汉式单例
 */
public class Boss {
    //创建私有静态属性
    private static Boss boss = new Boss();

    //构造方法私有化
    private Boss(){

    }
    //提供公公的访问接口
    public static Boss getInstance() {
        return boss;
    }
}
