package com.assignment.question;

// The LowVideoAdjustmentStrategy class is a concrete strategy for adjusting low-quality videos.
public class LowVideoAdjustmentStrategy implements QualityAdjustmentStrategy {
    @Override
    public VideoQuality supportsType() {
        return VideoQuality.LOW; // This strategy supports low-quality videos
    }

    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.H264); // Set the codec to H264 for low-quality videos
        video.setBitrate(500); // Set the bitrate to 500 for low-quality videos
        return video;
    }
}
