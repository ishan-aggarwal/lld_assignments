package com.assignment.question;

import lombok.*;

@ExtrinsicState
@Getter
@Setter
public class GraphicExtrinsicState {
    private GraphicIntrinsicState object;
    private int x; // x coordinate
    private int y; // y coordinate
}