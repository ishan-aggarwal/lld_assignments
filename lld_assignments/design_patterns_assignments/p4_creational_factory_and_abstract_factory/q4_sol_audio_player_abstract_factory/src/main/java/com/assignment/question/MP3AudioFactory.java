package com.assignment.question;

import com.assignment.question.decoder.*;
import com.assignment.question.player.*;
import com.assignment.question.processor.*;

import com.assignment.question.decoder.AudioDecoder;
import com.assignment.question.decoder.MP3Decoder;
import com.assignment.question.player.AudioPlayer;
import com.assignment.question.player.MP3Player;
import com.assignment.question.processor.AudioProcessor;
import com.assignment.question.processor.MP3AudioProcessor;

// Concrete factory class for creating MP3 audio systems
public class MP3AudioFactory extends AudioFactory {
    // Method for getting the format of audio the factory supports
    public MediaFormat supportsFormat() {
        return MediaFormat.MP3;
    }

    // Methods for creating different parts of an MP3 audio system
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new MP3Player(volume, playbackRate);
    }

    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new MP3Decoder(audioData);
    }

    public AudioProcessor createAudioProcessor(byte[] audioData) {
        return new MP3AudioProcessor(audioData);
    }
}
