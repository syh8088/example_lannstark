package com.lannstark.lec16.kotlin

import com.lannstark.lec16.Person

fun main() {

    val str = "ABC"
    println(str.lastChar())

    /**
     * 멤버함수와 확장함수의 시그니처가 같다면 ?!
     * - 맴버함수가 우선적으로 호출 합니다.
     * - 확장함수를 만들었지만, 다른 기능의 똑같은 멤버함수가 생기면 ?!
     * 오류가 발생할 수 있다 !!
     */
    val person = Person("A", "B", 100)
    person.nextYearAge()

    /**
     * 확장 함수가 오버라이드 된다면 ?!
     */
}

/**
 * 확장 함수
 * - String 이라는 클래스를 확장 함수 하는구나~
 */
fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}