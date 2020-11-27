package javalib.data;

public class Person {
    public static void process(Func f, double x) {
        System.out.print("result: ");
        System.out.println(f.apply(x));
    }

    public void sayHello() {
        System.out.println("Hello");
    }
}
