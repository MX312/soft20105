package duoTai;
class Test1{
    public  void test1() {
        System.out.println("Test1____1");
    }
    public void test2() {
        System.out.println("Test1____2");
    }
}
class Test2 extends Test1{
    @Override
    public void test1() { //重写Test1中的test1方法
        System.out.println("Test2____1");
    }
    public void test3() {
        System.out.println("Test2____2");
    }
}
public class demo1 {
    public static void main(String[] args) {
        //向上转型
        //Test1 test1 = new Test2();
//         Test2 test2 = new Test2();
//         Test1 test1 = test2;
//         test1.test1();
//         test1.test2();
//         test2.test3();
        Test1 test1 = new Test2();

        Test2 test2 = (Test2) test1;
        test2.test1();
        test2.test2();
        test2.test3();

    }

}
