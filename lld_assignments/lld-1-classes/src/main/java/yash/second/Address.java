package yash.second;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    String streetName;

    public Address(Address ad) {
        this.streetName = ad.streetName;
    }

}
