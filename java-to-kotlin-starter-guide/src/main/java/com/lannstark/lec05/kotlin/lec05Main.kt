package com.lannstark.lec05.kotlin

fun main() {

    fun validateScoreIsNotNegative(score: Int) {
        if (score < 0) {
            throw IllegalArgumentException("${score}는 0 보다 작을 수 없습니다.")
        }
    }

    fun validateScoreIsNotNegative2(score: Int) {
        if (score !in 0..100) {
            throw IllegalArgumentException("score 범위는 0 부터 100 까지 입니다.")
        }
    }

    fun validateScore(score: Int) {
        if (score in 0..100) {

        }
    }

    fun getGradeWithSwitch(score: Int): String {
        return when (score / 10) {
            9 -> "A"
            8 -> "B"
            7 -> "C"
            else -> "D"
        }
    }

    fun getGradeWithSwitch2(score: Int): String {
        return when (score) {
            in 90..99 -> "A"
            in 80..89 -> "B"
            in 70..79 -> "C"
            else -> "D"
        }
    }

    fun getPassOrFail(score: Int): String {
        return if (score >= 50) {
            "P"
        } else {
            "F"
        }
    }

    fun getGrade(score: Int): String {
        return if (score >= 90) {
            "A"
        }
        else if (score >= 80) {
            "B"
        }
        else {
            "C"
        }
    }

    fun startSWithA(obj: Any): Boolean {
        return when (obj) {
            is String -> obj.startsWith("A")
            else -> false
        }
    }

    fun judgeNumber(number: Int) {
        when (number) {
            1, 0, -1 -> println("어디서 많이 본 숫자 입니다.")
            else -> println("잘 모르는 숫자 입니다.")
        }
    }

    fun judgeNumber2(number: Int) {
        when {
            number == 0 -> print("주어진 숫자는 0 입니다.")
            number % 2 == 0 -> println("주어진 숫자는 짝수 입니다.")
            else -> println("주어진 숫자는 홀수 입니다.")
        }
    }
}