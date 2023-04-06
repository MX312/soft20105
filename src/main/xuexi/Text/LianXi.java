package Text;

import java.util.Scanner;

/**
 * 【练习题】01.
 * 类的成员变量 猜数字游戏一个类A有一个成员变量v有一个初值100。
 * 定义一个类对A类的成员变量v进行猜。如果大了则提示大了小了则提示小了。
 * 等于则提示猜测成功。
 */
class A{
    int v = 100;
}
public class LianXi{
    public static void main(String[] args) {
        A a = new A();
        Scanner scanner = new Scanner(System.in);

        while (1==1){
            int i = scanner.nextInt();
            if (i>a.v){
                System.out.println("太大了");


            } else if (i < a.v) {
                System.out.println("太小了");
            }else {
                System.out.println("对了");
                break;
            }
        }
    }

}
