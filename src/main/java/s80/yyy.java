package s80;

public class yyy {
    public static void main(String[] args) {
        System.out.println(new A().x);
        System.out.println(+new A().x);
    }
}
class A{
    static A a =new A();
    static int x=3;
    static int y;

    public A(){
        x++;
        y++;
        System.out.println("x="+x+"   "+"y="+y);

    }
}
