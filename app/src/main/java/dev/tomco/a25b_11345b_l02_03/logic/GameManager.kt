package dev.tomco.a25b_11345b_l02_03.logic

import dev.tomco.a25b_11345b_l02_03.model.Country
import dev.tomco.a25b_11345b_l02_03.model.DataManager
import dev.tomco.a25b_11345b_l02_03.utilities.Constants

class GameManager(private val lifeCount: Int = 3) {
    var score: Int = 0
        private set

    private val allCountries: List<Country> = DataManager.getAllCountries()

    var currentIndex: Int = 0
        private set

    var wrongAnswers: Int = 0
        private set

    val isGameEnded: Boolean
        get() = currentIndex == allCountries.size

    val isGameOver: Boolean
        get() = wrongAnswers == lifeCount

    val currentCountry: Country
        get() = allCountries[currentIndex]

    fun checkAnswer(expected: Boolean) {
        // check answer and add score:
        if (expected == currentCountry.canEnter)
            score += Constants.GameLogic.SCORE_DEFAULT

        // else: add 1 to wrongAnswers
        else
            wrongAnswers++

        // NEXT!
        currentIndex++
    }


}