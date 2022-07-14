package com.example.onlinetutor;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.annotation.Nullable;

public class MediaService extends Service implements MediaPlayer.OnPreparedListener {
    private static final String ACTION_PLAY = "com.example.action.PLAY";
    private static final String ACTION_PAUSE = "com.example.action.PAUSE";
    private static final String ACTION_STOP = "com.example.action.STOP";
    MediaPlayer mediaPlayer = null;

    public MediaService() {
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(ACTION_PLAY)) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(this, R.raw.music1);
                mediaPlayer.setOnPreparedListener(this);
            } else {
                mediaPlayer.start();
            }
            return Service.START_STICKY;
        } else if (intent.getAction().equals(ACTION_PAUSE)) {
            mediaPlayer.pause();
        } else if (intent.getAction().equals(ACTION_STOP)) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        return Service.START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /** Called when MediaPlayer is ready */
    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }
}