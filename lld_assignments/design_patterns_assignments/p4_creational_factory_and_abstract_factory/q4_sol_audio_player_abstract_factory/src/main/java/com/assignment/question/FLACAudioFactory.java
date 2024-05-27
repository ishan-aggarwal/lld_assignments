package com.assignment.question;

import com.assignment.question.decoder.*;
import com.assignment.question.player.*;
import com.assignment.question.processor.*;

import com.assignment.question.decoder.AudioDecoder;
import com.assignment.question.decoder.FLACDecoder;
import com.assignment.question.player.AudioPlayer;
import com.assignment.question.player.FLACPlayer;
import com.assignment.question.processor.AudioProcessor;
import com.assignment.question.processor.FLACAudioProcessor;

// Concrete factory class for creating FLAC audio systems
public class FLACAudioFactory extends AudioFactory {
    // Methods for creating different parts of a FLAC audio system
    public AudioPlayer createAudioPlayer(int volume, double playbackRate) {
        return new FLACPlayer(volume, playbackRate);
    }

    public AudioDecoder createAudioDecoder(byte[] audioData) {
        return new FLACDecoder(audioData);
    }

    public AudioProcessor createAudioProcessor(byte[] audioData) {
        return new FLACAudioProcessor(audioData);
    }

    // Method for getting the format of audio the factory supports
    public MediaFormat supportsFormat() {
        return MediaFormat.FLAC;
    }
}
