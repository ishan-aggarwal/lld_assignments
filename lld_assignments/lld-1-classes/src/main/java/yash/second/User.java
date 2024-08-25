package yash.second;

// Inheritance - IS-A relationship

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    String name;
    Address address; // association - HAS-A

//    public User(String name, Address add) {
//        this.name = name;
//        this.address = add;
//    }

}
