package s80;



/**
 * @author cc
 * java 方法执行时传参数是传值，然后拷贝一个副本，方法中修改的是拷贝的副本，并不是值本身
 *
 * 当参数是引用类型时，传的值是引用的值，不是对象的值。拷贝一份引用的副本，副本的值和原来的值相等
 * 也就是说副本指向的对象和原值指向的是同一个对象
 */
public class PassValueTest
{

    public static void main(String[] args)
    {
        PassValueTest p = new PassValueTest();
        final int i = 1;
        boolean b = true;

        System.out.println("===测试int类型参数会拷贝副本后使用" );
        System.out.println("原来i=" + i);
        p.changeI(i);
        System.out.println("在调用changeI之后 i = " + i);//i的值没有被改变
        System.out.println();

        System.out.println("===测试boolean类型参数会拷贝副本后使用" );
        System.out.println("原来b=" +b);
        p.changeB(b);
        System.out.println("在调用changeB之后b = " + b);
        System.out.println();

        System.out.println("===测试引用类型参数传递的是引用的值并拷贝副本后使用 ");
        User user = new User("dd", 28);
        p.changeUser(user);
        System.out.println("在调用ChangeUser方法之后user：" + user);
        System.out.println();

        System.out.println("===测试引用类型参数传到方法里面后是否会被先拷贝副本");
        User userA = new User("userA", 10);
        User userB = new User("userB", 12);

        p.changeCopy(userA, userB);

        System.out.println("在调用changeCopy方法之后，实际上userA和userB并没有改变:userA： " + userA
                +"，userB:" + userB);//实际上userA 和userB的引用并没有被改变
        System.out.println("如果在方法中没有拷贝参数而直接使用参数的话，userA和userB的引用应该会像在方法中被调换的");
    }
    public int  changeI(int i)
    {
        i = i+2;
        System.out.println("在changeI方法中修改后i副本= " + i);
        return i;
    }
    public boolean changeB(boolean b)
    {
        b = false;
        System.out.println("在changeB方法中修改后b副本= " + b);
        return b;
    }

    public void changeUser(User user)
    {
        System.out.println("在changeUser方法中，user参数副本指向的对象和user参数指向的对象是同一个对象，修改前user：" + user);
        user.setName("cici");
        user.setAge(18);
        System.out.println("在changeUser方法中，修改了参数副本所指向对象的值，修改后user：" + user);
    }

    public void changeCopy(User userA,User userB)
    {
        System.out.println("在方法changeCopy中UserA和UserB的引用副本在修改前是 ,userA副本 :"
                + userA +", userB副本 : " + userB);
        User temp = userA;//把A引用副本赋值给temp，就是说temp引用指向A对象
        userA = userB;//把B引用副本赋值给A引用副本，就是说此时A引用副本指向B对象
        userB = temp;//把temp引用赋值给B引用副本，就是说此时B引用副本指向A对象

        System.out.println("在方法changeCopy中UserA和UserB的引用副本已经被调换 ,userA副本 :"
                + userA +", userB副本 : " + userB);
    }
}