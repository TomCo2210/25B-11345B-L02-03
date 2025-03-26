package dev.tomco.a25b_11345b_l02_03

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class MainActivity : AppCompatActivity() {

    val SCORE_DEFAULT: Int = 10

    private lateinit var main_LBL_score: MaterialTextView

    private lateinit var main_IMG_hearts: Array<AppCompatImageView>

    private lateinit var main_IMG_flag: AppCompatImageView

    private lateinit var main_LBL_countryName: MaterialTextView

    private lateinit var main_BTN_Yes: MaterialButton

    private lateinit var main_BTN_No: MaterialButton

    private var score: Int = 0

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
        initViews()
    }

    private fun initViews() {
        refreshUI()
        main_BTN_Yes.setOnClickListener { view: View -> increaseScore() }
        main_BTN_No.setOnClickListener { view: View -> decreaseScore() }
    }

    private fun decreaseScore() {
        this.score -= this.SCORE_DEFAULT
        refreshUI()
    }

    private fun increaseScore() {
        this.score += this.SCORE_DEFAULT
        refreshUI()
    }

    private fun refreshUI() {
        main_LBL_score.text = "$score"
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