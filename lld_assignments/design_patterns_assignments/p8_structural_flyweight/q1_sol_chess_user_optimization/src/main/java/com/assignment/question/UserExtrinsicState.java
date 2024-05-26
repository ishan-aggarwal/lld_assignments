package com.assignment.question;

import lombok.Getter;

@ExtrinsicState
@Getter
// The UserExtrinsicState class represents the extrinsic state of a user.
// These are states that vary and cannot be shared.
public class UserExtrinsicState {
    private Colour colour; // The colour associated with the user
    private int currentGameStreak; // The current game streak of the user
    private UserIntrinsicState user; // The intrinsic state of the user
}

// Intrinsic = which does not change frequently and so allows to be shared.
// Extrinsic = which changes frequently and can't be shared.