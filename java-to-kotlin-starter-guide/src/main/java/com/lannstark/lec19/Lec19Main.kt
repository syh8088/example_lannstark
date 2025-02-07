package com.lannstark.lec19

fun main() {

    /**
     * break 사용법
     */
    val numbers = listOf(1, 2, 3, 4, 5)
    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@run
            }

            println(number)
        }
    }

    /**
     * continue
     */
    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@forEach
            }

            println(number)
        }
    }

    
}