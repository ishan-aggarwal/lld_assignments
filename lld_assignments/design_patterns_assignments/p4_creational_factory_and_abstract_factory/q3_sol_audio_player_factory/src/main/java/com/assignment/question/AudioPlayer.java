package com.assignment.question;

// Abstract class for an audio player
public abstract class AudioPlayer {
    private int volume;
    private final double playBackRate;

    // Constructor for the AudioPlayer class
    public AudioPlayer(int volume, double playBackRate) {
        this.volume = volume;
        this.playBackRate = playBackRate;
    }

    // Abstract methods for the AudioPlayer class
    public abstract MediaFormat supportsType();

    public abstract void play();

    public abstract void pause();

    public abstract void stop();

    // Getters for the AudioPlayer class attributes
    public int getVolume() {
        return volume;
    }

    public double getPlayBackRate() {
        return playBackRate;
    }

    // Method for setting the volume of the AudioPlayer
    public void setVolume(int volume) {
        if (volume >= 0 && volume <= 100) {
            this.volume = volume;
            System.out.println("Volume set to " + volume);
        } else {
            System.out.println("Invalid volume level");
        }
    }
}
