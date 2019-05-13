package s80;

public class TestCase {
    public static void main(String[] args) {
        Animal[]  as =new Animal[]{
                new Dog("a"),
                new Cat("b"),
                new Dog("c"),
                new Cat("d")
        };
        System.out.println(as[0].hashCode());
       System.out.println(as[2].hashCode());

    }
}



class  Animal{

    String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class  Cat extends  Animal{
    Cat(String name){
        this.name = name;
    }
}

class  Dog extends  Animal{
    Dog(String name){
        this.name = name;
    }
}