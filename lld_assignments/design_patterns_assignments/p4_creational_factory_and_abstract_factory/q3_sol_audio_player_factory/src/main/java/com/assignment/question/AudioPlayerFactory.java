package com.assignment.question;

// Factory class for creating audio players
public class AudioPlayerFactory {
    // Factory method for creating the appropriate audio player based on the media format
    public static AudioPlayer getAudioPlayer(MediaFormat mediaFormat, int volume, double playBackRate) {
        return switch (mediaFormat) {
            case WAV -> new WAVPlayer(volume, playBackRate);
            case FLAC -> new FLACPlayer(volume, playBackRate);
            case MP3 -> new MP3Player(volume, playBackRate);
            default -> throw new IllegalArgumentException("Invalid media format");
        };
    }
}

/*
    In this code, the AudioPlayer class is an abstract class that declares methods for
    playing, pausing, and stopping audio, as well as getting the type of media the player supports.
    The AudioPlayerFactory class is a factory class that has a factory method getAudioPlayer
    for creating the appropriate AudioPlayer based on the MediaFormat.
    The FLACPlayer, MP3Player, and WAVPlayer classes are concrete classes that implement
    these methods to play FLAC, MP3, and WAV audio, respectively.

    This is a classic implementation of the Factory Method Pattern.
    This pattern separates the details of implementation of a set of objects from their
    general usage and relies on object composition: object creation methods are implemented in methods
    exposed in the factory interface.
 */