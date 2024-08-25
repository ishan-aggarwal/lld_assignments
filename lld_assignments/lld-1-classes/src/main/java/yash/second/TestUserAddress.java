package yash.second;

public class TestUserAddress {

    public static void main(String[] args) {

        Address ad = new Address();

        User user1 = new User("Ishan", ad);


        User user2 = new User("Yash", new Address(ad));

        System.out.println(user2.getAddress().getStreetName());

        user1.getAddress().setStreetName("Gurgaon");


        System.out.println("wait here to check how many objects got created");
        System.out.println(user2.getAddress().getStreetName());


    }
}
