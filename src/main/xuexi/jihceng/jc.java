package jihceng;
public class jc {
    private String name;//定义一个私有名字
    private int age;//定义一个私有年龄
    public void yaoguai() {//定义一个名叫yaoguai的方法
        System.out.println("吃人");
    }
    public String get_name(){//为私有name创建一个get方法
        this.name = name;
        return name;
    }
    public void set_name(String name){//为私有name创建一个set方法
        this.name = name;

    }
    public int get_age(){//为私有age创建一个get方法
        this.age = age;
        return age;
    }
    public void set_age(int age){//为私有age创建一个set方法
        this.age=age;

    }
}
class guaiu extends jc { //创建一个名为guaiu的类继承jc
    public void heiguai(){
        jc jc = new guaiu();
    }
}
class test { //测速类
    public static void main(String[] args) {
        jc jc = new jc();

        jc.set_name("黑熊怪");
        System.out.print(jc.get_name()+"会");
        jc.yaoguai();
        jc.set_age(999);
        System.out.println(jc.get_name()+"的年龄是"+jc.get_age()+'岁');
        /*
        String g = "哥哥";
        String j = "姐姐";
        System.out.println(g+j+"都是好人" );
         */
    }
}
