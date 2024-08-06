package example_I1_I2_I_interface.other;

public interface I extends I1, I2 {
    @Override
    default void fun() {
//        I1.super.fun();
        I2.super.fun();
    }
}
