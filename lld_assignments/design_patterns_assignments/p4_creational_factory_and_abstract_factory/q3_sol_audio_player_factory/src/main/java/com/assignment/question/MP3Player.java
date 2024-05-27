package com.assignment.question;

// Concrete class for an MP3 audio player
public class MP3Player extends AudioPlayer {
    // Constructor for the MP3Player class
    public MP3Player(int volume, double playBackRate) {
        super(volume, playBackRate);
    }

    // Methods for playing, pausing, and stopping the MP3 audio
    @Override
    public void play() {
        System.out.println("Playing MP3 audio");
    }

    @Override
    public void pause() {
        System.out.println("Pausing MP3 audio");
    }

    @Override
    public void stop() {
        System.out.println("Stopping MP3 audio");
    }

    // Method for getting the type of media the player supports
    public MediaFormat supportsType() {
        return MediaFormat.MP3;
    }
}
