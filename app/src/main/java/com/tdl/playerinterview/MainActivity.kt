package com.tdl.playerinterview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.amazonaws.ivs.player.*

class MainActivity : AppCompatActivity() {
    val TAG = "PlayerInterview"
    lateinit var playerView: PlayerView
    lateinit var textView: TextView
    var stateChangedHook: (Player.State) -> Unit = {}
    val uri = Uri.parse("https://d1niz6t8cg0nbq.cloudfront.net/ivs/v1/108971745090/qiXlbMO7L9i7/2022/3/1/17/1/RLgHOoocQsbK/media/hls/master.m3u8")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.hello)
        playerView = PlayerView(this)
        setListener()
        playerView.player.load(uri)
    }

    private fun setListener() {

        playerView.player.apply {
            addListener(object : Player.Listener() {
                override fun onCue(p0: Cue) {}

                override fun onDurationChanged(p0: Long) {}

                override fun onStateChanged(p0: Player.State) {
                    Log.d(TAG, "State changed: ${p0.name}")
                }

                override fun onError(p0: PlayerException) {
                    Log.d(TAG, "Errored with ${p0.errorMessage}")
                }

                override fun onRebuffering() {}

                override fun onSeekCompleted(p0: Long) {}

                override fun onVideoSizeChanged(p0: Int, p1: Int) {}

                override fun onQualityChanged(p0: Quality) {}

            })
        }
    }
}