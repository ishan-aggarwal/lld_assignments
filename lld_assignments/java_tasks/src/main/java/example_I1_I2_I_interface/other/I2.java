package example_I1_I2_I_interface.other;

public interface I2 {
    default void fun() {
        System.out.println("I2 fun");
    }
    
    public void fun2();
}