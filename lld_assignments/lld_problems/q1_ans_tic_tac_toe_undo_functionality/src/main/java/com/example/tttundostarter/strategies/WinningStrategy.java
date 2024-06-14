package com.example.tttundostarter.strategies;

import com.example.tttundostarter.models.Board;
import com.example.tttundostarter.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
