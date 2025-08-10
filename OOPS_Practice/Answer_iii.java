public class Answer_iii {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.show(10);
        d.show(Integer.valueOf(15));
        d.show((short) 4); 
    }
}
//method overloading
class Demo {
    void show(int a) {
        System.out.println("Primitive int method");
    }
    void show(Integer a) {
        System.out.println("Wrapper Integer method");
    }
}


/*
-> exact match for primitive -> chosen first
-> short -> int is preferred over autoboxing (short -> Short)
-> Autoboxing (primitive -> wrapper) comes after widening
 */