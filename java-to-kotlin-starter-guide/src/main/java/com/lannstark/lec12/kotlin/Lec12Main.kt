package com.lannstark.lec12.kotlin

import com.lannstark.lec12.Movable

fun main() {

    Person.Factory.newBaby("ABC")
    Person.newBaby("ABC")

    println(Singleton.a)
    Singleton.a += 10
    println(Singleton.a)

    /**
     * 익명 클래스
     */
    moveSomething(object : Movable {
        override fun move() {
            TODO("Not yet implemented")
        }

        override fun fly() {
            TODO("Not yet implemented")
        }

    })
}

class Person private constructor(
    var name: String,
    var age: Int
) {

    /**
     * static 사용법 (함수와 변수 사용법)
     */
    companion object Factory : Log {
//        private val MIN_AGE = 1 // 런타임 시에 변수가 할당된다.
        private const val MIN_AGE = 1 // 컴파일 시에 변수가 할당 된다 - const

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("나는 Person 클래스의 동행 객체 Factory 입니다.")
        }
    }
}

/**
 * 싱글톤
 */
object Singleton {
    var a: Int = 0
}

/**
 * 익명 클래스
 */
private fun moveSomething(movable: Movable) {
    movable.move()
    movable.fly()
}
