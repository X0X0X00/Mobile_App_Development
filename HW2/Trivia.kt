package com.zzh133.trivia

import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.setValue


class Trivia : ViewModel() {

    data class MovieLead(val title: String, val lead: String)

    private val movieLeads = listOf(
        MovieLead( "There Will Be Blood" , "Daniel Day-Lewis"),
        MovieLead("Chinatown" , "Jack Nicholson"),
        MovieLead("Apocalypse Now" , "Marlon Brando"),
        MovieLead("Raging Bull" , "Robert De Niro"),
        MovieLead("Serpico" , "Al Pacino"),
        MovieLead("Tootsie" , "Dustin Hoffman"),
        MovieLead("The Silence of the Lambs" , "Anthony Hopkins")
    )

    // 电影的索引 （不同的题目）
    private var movieIndex by mutableIntStateOf(0)

    // 电影的演员索引 （同一题目的不同选项）
    private var displayLeadIndex by mutableIntStateOf(0)


    var currentMovie by mutableStateOf(movieLeads[0].title)
        private set

    var correctLead by mutableStateOf(movieLeads[0].lead)
        private set

    val displayLead by derivedStateOf { movieLeads[displayLeadIndex].lead }

    var responseText by mutableStateOf("")
        private set

    var showNewQuiz by mutableStateOf(false)
        private set

    /** 随机选取一个演员 电影不变 */
    fun nextAnswer() {
        displayLeadIndex += 1
        if (displayLeadIndex == movieLeads.size){
            displayLeadIndex = 0
        }
        responseText = ""
        showNewQuiz = false
    }

    /** 检查答案是否正确 */
    fun checkAnswer(): String {
        responseText = if (displayLead == correctLead){
            "Correct!"
        }else {
            "Wrong answer!\n$correctLead plays the lead in\n $currentMovie"
        }
        showNewQuiz = true
        return responseText
    }


    /** 重新开始测验 */
    fun newQuiz() {
        movieIndex += 1
        if (movieIndex == movieLeads.size){
            movieIndex = 0
        }
        currentMovie = movieLeads[movieIndex].title
        correctLead = movieLeads[movieIndex].lead
        displayLeadIndex = 0
        responseText = ""
        showNewQuiz = false
    }
}