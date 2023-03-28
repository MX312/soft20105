package neibuclass;

public class MyImplenment implements MyIntterface{
    @Override
    public void test() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        //实现类
        MyIntterface my = new MyImplenment();
        my.test();
        // 匿名内部类
        // 并不是去new一个接口 而是去new一个接口的实现类
        MyIntterface my2 = new MyIntterface() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };




    }
}