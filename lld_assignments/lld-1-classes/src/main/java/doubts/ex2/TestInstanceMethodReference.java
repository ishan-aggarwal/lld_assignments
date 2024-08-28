package doubts.ex2;

interface B {
    public void add(int x, int y);
}

class Addition {
    public void sum(int a, int b) {
        System.out.println("The sum for the numbers is :" + (a + b));
    }
}

public class TestInstanceMethodReference {

    public static void main(String[] args) {

        Addition object = new Addition();
        //*** Using Lambda Expression ***//
        B b1 = (a, b) -> System.out.println("The sum is :" + (a + b));
        b1.add(10, 14);

        //*** Using Method Reference ***//
        B b2 = object::sum;
		b2.add(100, 140);
    }
}
