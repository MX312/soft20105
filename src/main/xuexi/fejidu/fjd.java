package fejidu;

public class fjd {
    private int m_;
    public int getM_(){

        return this.m_;
    }
    public void setm_(int m_) {
        this.m_ = m_;

    }

    public static void main(String[] args) {
        fjd a = new fjd();
        a.setm_(1);

        System.out.println(a.getM_());
    }
}
