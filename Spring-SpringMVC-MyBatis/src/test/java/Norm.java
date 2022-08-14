public class Norm {
    public static void main(String[] args) {
        new k(){

        }.say();
    }
}

interface k{
    default void say(){
        System.out.println("hello");
    }
}

