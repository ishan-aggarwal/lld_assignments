package com.assignment.question;

// The HighVideoAdjustmentStrategy class is a concrete strategy for adjusting high-quality videos.
public class HighVideoAdjustmentStrategy implements QualityAdjustmentStrategy {
    @Override
    public VideoQuality supportsType() {
        return VideoQuality.HIGH; // This strategy supports high-quality videos
    }

    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.VP9); // Set the codec to VP9 for high-quality videos
        video.setBitrate(2000); // Set the bitrate to 2000 for high-quality videos
        return video;
    }
}
