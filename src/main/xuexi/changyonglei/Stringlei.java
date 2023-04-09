package changyonglei;

public class Stringlei {
    public static void main(String[] args) {
        //字符串String的本质是字符数组cher[]

        String s = "asdfG";

        //length
        int s1 = s.length();
        System.out.println(s1);

        //equals
        boolean s2 = s.equals("asd");
        System.out.println(s2);

        //根据下标取值
        char s3 = s.charAt(0);
        System.out.println(s3);

        //indexOf 找到返回起始下标 找不到返回-1
        int s4 = s.indexOf("sd");
        System.out.println(s4);

        //contains 是否包含字符串
        boolean s5 = s.contains("d");
        System.out.println(s5);

        //去除字符串两边的空格
        String s6 = "   qwer    ".trim();
        System.out.println(s6);

        //repalce 替换字符
        String s7 = "qweqweqweqwe".replace("qw","你");
        System.out.println(s7);

        //截取 下标为1,2的值
        String s8 = s.substring(1, 3);
        System.out.println(s8);

        //转大写
        String s9 = s.toUpperCase();
        System.out.println(s9);

        //split
        String[] s10 =s.split(",");
        for (String t : s10) {
            System.out.print(t);
        }



    }
}
