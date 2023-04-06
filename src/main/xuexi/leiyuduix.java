public class leiyuduix {


    public static void main(String[] args) {
        Per asd = new Per();
        System.out.println(asd.asd("test"));


    }
       static class Per{
        String name;
        int value;
        public void eat() {
            System.out.println("Per");
        }
        public void sleep(int hours) {
            System.out.println("Sleep"+hours);

        }
        public String asd(String seconds) {
//            System.out.println(seconds);
            String qq = seconds + "dddd";
            return qq;
        }


    }
}
