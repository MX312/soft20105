import static java.time.Clock.system;

public class Teacher {
    //成员变量
    String name;
    int age;
    boolean isMale;



    public Teacher(){
        System.out.println("Teacher.Teacher(无参构造器)");
    }

    public Teacher(String name) {
        this(); //调用无参构造器
        System.out.println("Teacher.Teacher(这是一个参数的构造器)");
        this.name = name;
    }
    public Teacher(String name, int age ,boolean isMale){
//        this();  //调用无参构造器
        this(name);//调用有参构造器  构造器的复用
        System.out.println("Teacher.Teacher(有参构造器)");

        this.age = age;
        this.isMale = isMale;
    }

    public void show(){
        String name = "张三";
        System.out.println(this.name + ":" + age +  isMale);
        work();

    }
    public void work(){
        System.out.print("这是\rwork");
    }

    public static void main(String[] args) {
        //创建一个teacher对象
        Teacher student = new Teacher("Student", 40, true);
        //调用方法

        student.show();
    }
}
