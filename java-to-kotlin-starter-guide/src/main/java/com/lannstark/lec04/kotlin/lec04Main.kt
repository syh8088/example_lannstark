package com.lannstark.lec04.kotlin

import com.lannstark.lec04.JavaMoney

fun main() {

    val money1 = JavaMoney(2000L)
    val money2 = JavaMoney(1000L)

    if (money1 > money2) {
        println("Money1 이 Money2 보다 금액이 큽니다.")
    }

    val money3 = JavaMoney(2000L)
    val money4 = money3
    val money5 = JavaMoney(2000L)

    /**
     * 동일성
     */
    println(money3 === money4)

    /**
     * 동등성
     */
    println(money4 == money5)


}