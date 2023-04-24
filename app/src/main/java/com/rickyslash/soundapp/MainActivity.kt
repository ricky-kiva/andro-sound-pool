package com.rickyslash.soundapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// Some of the Media that is important in Android:
// - SoundPool: short sound effect
// - MediaPlayer: play audio/video on an app
// - ExoPlayer: advanced MediaPlayer with Dynamic Adaptive Streaming over HTTP (DASH), smooth streaming, to common encryption
// - CameraX: make custom camera in an app, including adding effects
// - Intent Camera: implicit intent to open Android's default camera
// - Intent Gallery: implicit intent to open Android's default gallery

// audio files are placed on `res/raw`
// SoundPool saves audio data in memory without compression. suitable to play short audio. the audio file need to be loaded first
// MediaPlayer suitable for media more than 1 MB. it could also run video & supports playback control. this could also play media from internet
// ExoPlayer is an opensource library from MediaCodec API. it's more advanced than MediaPlayer