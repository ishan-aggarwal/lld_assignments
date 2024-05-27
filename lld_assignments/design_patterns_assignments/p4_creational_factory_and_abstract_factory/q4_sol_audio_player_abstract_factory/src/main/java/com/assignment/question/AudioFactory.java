package com.assignment.question;

import com.assignment.question.decoder.*;
import com.assignment.question.player.*;
import com.assignment.question.processor.*;

import com.assignment.question.decoder.AudioDecoder;
import com.assignment.question.player.AudioPlayer;
import com.assignment.question.processor.AudioProcessor;

// Abstract factory class for creating different parts of an audio system
public abstract class AudioFactory {
    // Abstract method for getting the format of audio the factory supports
    public abstract MediaFormat supportsFormat();

    // Abstract methods for creating different parts of an audio system
    public abstract AudioPlayer createAudioPlayer(int volume, double playbackRate);

    public abstract AudioDecoder createAudioDecoder(byte[] audioData);

    public abstract AudioProcessor createAudioProcessor(byte[] audioData);
}


/*
    In this code, the AudioFactory class is an abstract factory class that declares methods
    for creating different parts of an audio system (AudioPlayer, AudioDecoder, and AudioProcessor)
    and a method for getting the format of audio the factory supports.
    The FLACAudioFactory and MP3AudioFactory classes are concrete factory classes
    that implement these methods to create FLAC and MP3 audio systems, respectively.

    This is a classic implementation of the Abstract Factory Pattern.
    The Abstract Factory Pattern provides an interface for creating families of
    related or dependent objects without specifying their concrete classes.
    This pattern separates the details of implementation of a set of objects from their
    general usage and relies on object composition: object creation methods are implemented
    in methods exposed in the factory interface.
 */