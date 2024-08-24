package doubts.copy_constructor;

public class Address {
    String location;

    public Address(String location) {
        this.location = location;
    }

//    public Address(Address a) {
//        this.location = a.location;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "location='" + location + '\'' +
                '}';
    }
}
