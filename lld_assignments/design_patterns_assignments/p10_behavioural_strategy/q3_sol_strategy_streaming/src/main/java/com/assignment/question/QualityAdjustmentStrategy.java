package com.assignment.question;

// The QualityAdjustmentStrategy interface defines operations that all concrete quality adjustment strategies must implement.
public interface QualityAdjustmentStrategy {
    VideoQuality supportsType(); // Returns the type of video quality the strategy supports

    Video adjust(Video video); // Adjusts the video according to the strategy
}
