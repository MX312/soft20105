package com.study.singleton;

public class Boss3 {
    private static Boss3 boss;

    private Boss3(){

    }
    public static Boss3 getInstance(){
        if(boss==null ){
            boss = new Boss3();
        }
        return boss;
    }
}
class TextBoss3{
    public static void main(String[] args) {
        Boss3 boss1 = Boss3.getInstance();
        Boss3 boss2 = Boss3.getInstance();

        System.out.println(boss1);
        System.out.println(boss2);

    }
}
