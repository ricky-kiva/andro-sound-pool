package com.rickyslash.soundapp

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var sp: SoundPool
    private var soundId: Int = 0
    private var spLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSound = findViewById<Button>(R.id.btn_sound_pool)

        sp = SoundPool.Builder() // instantiate SoundPool
            .setMaxStreams(2) // make the max sound play to 2
            .build() // build SoundPool

        sp.setOnLoadCompleteListener { _, _, status ->
            if (status == 0) {
                // set flags to check if the sound is loaded
                spLoaded = true
            } else {
                Toast.makeText(this@MainActivity, "Fail to load", Toast.LENGTH_SHORT).show()
            }
        }

        // load the desired sound
        soundId = sp.load(this, R.raw.clinking_glasses, 1)

        btnSound.setOnClickListener {
            if (spLoaded) {
                // play the SoundPool on button click
                sp.play(soundId, 1f, 1f, 0, 0, 1f)
            }
        }
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