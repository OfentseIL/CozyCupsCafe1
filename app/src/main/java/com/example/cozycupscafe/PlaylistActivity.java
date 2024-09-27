package com.example.cozycupscafe;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlaylistActivity extends AppCompatActivity {

    private Button playButton1;
    private Button playButton2;
    private Button playButton3;
    private MediaPlayer mediaPlayer;
    private final boolean isPlaying = false; // Track if a song is playing
    private final int currentSong = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        playButton1 = findViewById(R.id.playButton1);
        playButton2 = findViewById(R.id.playButton2);
        playButton3 = findViewById(R.id.playButton3);
        Button menuButton = findViewById(R.id.menuButton);

        playButton1.setOnClickListener(v -> playSong(R.raw.morning, playButton1));
        playButton2.setOnClickListener(v -> playSong(R.raw.afternoon, playButton2));
        playButton3.setOnClickListener(v -> playSong(R.raw.relaxing, playButton3));

        menuButton.setOnClickListener(v -> {
            Intent intent = new Intent(PlaylistActivity.this, GridActivity.class);
        });
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_playlist);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void playSong(int songResId, Button playButton){
        {

        }
    }
}