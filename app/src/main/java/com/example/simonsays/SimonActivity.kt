package com.example.simonsays

import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import java.util.Timer
import java.util.TimerTask

class SimonActivity : AppCompatActivity(), View.OnClickListener {

    private var simonSoundPoolLoaded = false
    private var simonLevel = 1
    private var simonCellOnList: Array<Int>? = null
    private var simonCount = 0
    private var simonCurrentCellIndex = 0
    private var simonTimer: Timer? = null
    private var simonTimerTask: TimerTask? = null
    private val simonSoundID = IntArray(4)
    private var simonSoundVolume = 0f
    private var simonPreySoundStreamID = 0
    private var simonScore = 0
    private var simonTimerForClick: CountDownTimer? = null
    private var simonSoundOn = true
    private var simonCountdownTimer: CountDownTimer? = null
    private var simonTimerTaskCompleted = true
    private var simonInstanceSaved = false

    var soundPool: SoundPool? = null

    var simonImageView = arrayOfNulls<SimonCellType>(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simon)

        simonImageView[0] = findViewById<View>(R.id.greenCell) as SimonCellType
        simonImageView[1] = findViewById<View>(R.id.redCell) as SimonCellType
        simonImageView[2] = findViewById<View>(R.id.yellowCell) as SimonCellType
        simonImageView[3] = findViewById<View>(R.id.blueCell) as SimonCellType
        simonImageView[0]!!.setCellType(SimonCellType.CELL_TYPE_GREEN)
        simonImageView[1]!!.setCellType(SimonCellType.CELL_TYPE_RED)
        simonImageView[2]!!.setCellType(SimonCellType.CELL_TYPE_YELLOW)
        simonImageView[3]!!.setCellType(SimonCellType.CELL_TYPE_BLUE)

        for (i in 0..3) {
            simonImageView[i]!!.setOnClickListener(this)
            simonImageView[i]!!.settOff()
        }
    }

    override fun onClick(p0: View?) {
        
    }

    companion object {
        private const val LEVEL_UP = 1
        private const val GAME_OVER = 2
        private const val CELL = "SimonCell"
        private const val SCORE = "Score"
        private const val LEVEL = "Level"
        private const val TIMER = "GameDisplayTimerCompleted"
    }
}