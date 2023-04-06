package Text;
class Text1{
   private String text = "1";
    int age;
    String name;
    boolean isMan;

    public void Textone(){
        Text1 textone = new Text1();
        String text = "qwe";
        this.text = text;

        textone.text = "测试成果";
        System.out.println(textone.text);

    }
}
public class Textall extends Text1{
    public static void main(String[] args) {
        Textall all = new Textall();
        all.Textone();

    }
}

