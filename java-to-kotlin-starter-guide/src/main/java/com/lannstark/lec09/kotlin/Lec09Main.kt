package com.lannstark.lec09.kotlin

fun main() {

    val person = Person("test", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    var person2 = Person("test")
}

class Person(
    val name: String,
    var age: Int
) {

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age} 일 수 없습니다.")
        }

        println("초기화 블록")
    }

    // 부생성자 (secondary constructor) 는 최종적으로 주생성자를 this 통해 호출 해야 합니다.
    constructor(name: String) : this(name, 1) {
        println("첫 번째 부생성자")
    }

    constructor(): this("test2") {
        println("두 번째 부생성자")
    }

    fun isAdult1(): Boolean {
        return this.age > 20
    }

    val isAdult: Boolean
        get() {
            return this.age >= 20
        }

//        get() this.age >= 20
}

class Person2(name: String, age: Int) {

    val name = name
    var age = age
}

// 4. backing field
class Person3(
    name: String = "test",
    var age: Int = 1
) {

    val name = name
        get() {
            return field.uppercase()
        }
}

class Person4(
    name: String = "test",
    var age: Int = 1
) {

    var name = name
        set(value) {
            field = value.uppercase()
        }
}
