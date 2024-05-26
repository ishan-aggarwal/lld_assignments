package com.assignment.question;

// The design pattern used here is the Strategy Pattern. This pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
// Strategy lets the algorithm vary independently of clients that use it.
// The VideoStreamingManager class uses the Strategy Pattern to adjust the quality of a video.
public class VideoStreamingManager {
    private Video video; // The video to be streamed
    private QualityAdjustmentStrategy qualityAdjustmentStrategy; // The strategy for adjusting the quality of the video

    // Constructor for the VideoStreamingManager class
    public VideoStreamingManager(Video video, QualityAdjustmentStrategy qualityAdjustmentStrategy) {
        this.video = video;
        this.qualityAdjustmentStrategy = qualityAdjustmentStrategy;
    }

    // The streamVideo method adjusts the video according to the strategy and returns the adjusted video.
    public Video streamVideo() {
        return qualityAdjustmentStrategy.adjust(video);
    }
}

/*
    In this code, the QualityAdjustmentStrategy interface defines operations that all concrete quality adjustment strategies must implement.
    The HighVideoAdjustmentStrategy, LowVideoAdjustmentStrategy, and MediumVideoAdjustmentStrategy classes are concrete strategies for adjusting high-quality, low-quality, and medium-quality videos, respectively.
    They implement the QualityAdjustmentStrategy interface and provide their own implementations of the supportsType and adjust methods.
    The VideoStreamingManager class uses the Strategy Pattern to adjust the quality of a video.
    It maintains a reference to a QualityAdjustmentStrategy object and uses this object to adjust the quality of a video.

    This is a classic implementation of the Strategy Pattern.
    It is a behavioral design pattern that enables selecting an algorithm at runtime.
*/