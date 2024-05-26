package com.assignment.question;

import lombok.Getter;

// The UserIntrinsicState class represents the intrinsic state of a user.
// These are states that can be shared among different contexts.
@IntrinsicState
@Getter
public class UserIntrinsicState {
    private String name; // The name of the user
    private int age;        // The age of the user
    private String gender;  // The gender of the user
    private String email;   // The email of the user
    private String phoneNumber;     // The phone number of the user
    private Byte[] photo;       // The photo of the user
}