package dev.khalil.jokenpo.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dev.khalil.jokenpo.R
import dev.khalil.jokenpo.databinding.ActivityMainBinding
import dev.khalil.jokenpo.ui.about.AboutActivity
import dev.khalil.jokenpo.ui.game.GameActivity
import dev.khalil.jokenpo.ui.rank.RankActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initListeners()
    }

    private fun initListeners() {
        binding.buttonExit.setOnClickListener { finish() }
        binding.buttonPlay.setOnClickListener {
            startActivity(GameActivity.createIntent(this@MainActivity))
        }
        binding.buttonAbout.setOnClickListener {
            startActivity(AboutActivity.createIntent(this@MainActivity))
        }
        binding.buttonRanking.setOnClickListener {
            startActivity(RankActivity.createIntent(this@MainActivity))
        }
    }
}
