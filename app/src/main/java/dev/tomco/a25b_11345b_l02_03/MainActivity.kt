package dev.tomco.a25b_11345b_l02_03

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import dev.tomco.a25b_11345b_l02_03.logic.GameManager
import dev.tomco.a25b_11345b_l02_03.utilities.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var main_LBL_score: MaterialTextView

    private lateinit var main_IMG_hearts: Array<AppCompatImageView>

    private lateinit var main_IMG_flag: AppCompatImageView

    private lateinit var main_LBL_countryName: MaterialTextView

    private lateinit var main_BTN_Yes: MaterialButton

    private lateinit var main_BTN_No: MaterialButton

    private lateinit var gameManager: GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViews()
        gameManager = GameManager(main_IMG_hearts.size)
        initViews()
    }

    private fun initViews() {
        main_LBL_score.text = gameManager.score.toString()
        main_BTN_Yes.setOnClickListener { view: View -> answerClicked(true) }
        main_BTN_No.setOnClickListener { view: View -> answerClicked(false) }
        refreshUI()
    }

    private fun answerClicked(expected: Boolean){
        gameManager.checkAnswer(expected)
        refreshUI()
    }

    private fun refreshUI() {
       //Lost:
        if (gameManager.isGameOver) {
            Log.d("Game Status", "Game Over! " + gameManager.score)
            changeActivity("😭Game Over! " ,gameManager.score)
        }else if (gameManager.isGameEnded) {  //Game Ended:
            Log.d("Game Status", "You Won! " + gameManager.score)
            changeActivity("🥳You Won! " ,gameManager.score)

        }else { // Ongoing game:
            main_LBL_score.text = gameManager.score.toString()
            main_LBL_countryName.text = gameManager.currentCountry.name
            main_IMG_flag.setImageResource(gameManager.currentCountry.flagImage)
            if (gameManager.wrongAnswers != 0){
                main_IMG_hearts[main_IMG_hearts.size - gameManager.wrongAnswers]
                    .visibility = View.INVISIBLE
            }
        }


    }

    private fun changeActivity(message: String, score: Int) {
        val intent = Intent(this, ScoreActivity::class.java)
        var bundle = Bundle()
        bundle.putString(Constants.BundleKeys.MESSAGE_KEY, message)
        bundle.putInt(Constants.BundleKeys.SCORE_KEY, score)
        intent.putExtras(bundle)
        startActivity(intent)
        finish()

    }

    private fun findViews() {
        main_LBL_score = findViewById(R.id.main_LBL_score)
        main_IMG_flag = findViewById(R.id.main_IMG_flag)
        main_LBL_countryName = findViewById(R.id.main_LBL_countryName)
        main_BTN_Yes = findViewById(R.id.main_BTN_Yes)
        main_BTN_No = findViewById(R.id.main_BTN_No)
        main_IMG_hearts = arrayOf(
            findViewById(R.id.main_IMG_heart0),
            findViewById(R.id.main_IMG_heart1),
            findViewById(R.id.main_IMG_heart2)
        )
    }
}