package com.assignment.question;

// The MediumVideoAdjustmentStrategy class is a concrete strategy for adjusting medium-quality videos.
public class MediumVideoAdjustmentStrategy implements QualityAdjustmentStrategy {
    @Override
    public VideoQuality supportsType() {
        return VideoQuality.MEDIUM; // This strategy supports medium-quality videos
    }

    @Override
    public Video adjust(Video video) {
        video.setCodec(VideoCodec.H265); // Set the codec to H265 for medium-quality videos
        video.setBitrate(1000); // Set the bitrate to 1000 for medium-quality videos
        return video;
    }
}
