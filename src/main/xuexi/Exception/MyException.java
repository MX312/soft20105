package Exception;

public class MyException extends Exception {
    //产传递数字>10\
    private int detail;

    public MyException(int a ) {

        this.detail = a;
    }//toString ：异常的打印信息


}
class Text{
    static void text(int a ) throws MyException{
        System.out.println("传递的参数为"+a);
        if (a>10){
            throw new MyException(a);
        }
        System.out.println("ok");
    }

    public static void main(String[] args) {
        try {
            text(11);
        } catch (MyException e) {
            System.out.println("MyException=>"+e);
        }

    }
}
