package com.assignment.question;

// Concrete class for a FLAC audio player
public class FLACPlayer extends AudioPlayer {
    // Constructor for the FLACPlayer class
    public FLACPlayer(int volume, double playBackRate) {
        super(volume, playBackRate);
    }

    // Methods for playing, pausing, and stopping the FLAC audio
    @Override
    public void play() {
        System.out.println("Playing FLAC audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing FLAC audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping FLAC audio");
    }

    // Method for getting the type of media the player supports
    public MediaFormat supportsType() {
        return MediaFormat.FLAC;
    }
}
