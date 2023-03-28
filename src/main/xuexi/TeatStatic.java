public class TeatStatic {
    int num;

    public  void show() {
        System.out.println("show"+ num);
    }

    public static void main(String[] args) {
        TeatStatic test = new TeatStatic();
        test.num = 123;
        test.show();

    }
}
