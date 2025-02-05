package com.lannstark.lec11.kotlin

fun main() {




}

val g = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

class Cat private constructor()


/**
 * 3. 다양한 구성요소의 접근 제어 - 프로퍼티
 *
 *
 * 두번째
 */
class Car2(
    internal val name: String, // 첫번째
    private var owner: String, // getter 와 setter 를 모두 private 만들고 싶을때
    _price: Int
) {

    // 두번째
    // getter 는 public 으로 두고 싶은데 setter 는 private 하는 방법
    var price = _price
        private set
}