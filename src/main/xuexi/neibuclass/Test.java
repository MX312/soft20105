package neibuclass;

public class Test {
    public class MyImplement implements MyIntterface {
        @Override
        public void test() {
            System.out.println("内部类实现接口");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        MyImplement implement = test.new MyImplement();
        implement.test();
    }

}
