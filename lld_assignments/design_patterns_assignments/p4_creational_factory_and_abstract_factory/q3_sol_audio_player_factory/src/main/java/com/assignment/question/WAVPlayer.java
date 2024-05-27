package com.assignment.question;

// Concrete class for a WAV audio player
public class WAVPlayer extends AudioPlayer {
    // Constructor for the WAVPlayer class
    public WAVPlayer(int volume, double playBackRate) {
        super(volume, playBackRate);
    }

    // Methods for playing, pausing, and stopping the WAV audio
    @Override
    public void play() {
        System.out.println("Playing WAV audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing WAV audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping WAV audio");
    }

    // Method for getting the type of media the player supports
    public MediaFormat supportsType() {
        return MediaFormat.WAV;
    }
}
