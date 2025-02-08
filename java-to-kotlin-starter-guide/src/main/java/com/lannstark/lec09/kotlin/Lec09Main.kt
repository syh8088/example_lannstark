package com.lannstark.lec09.kotlin

fun main() {

    val person = Person("test", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    var person2 = Person("test")
}

/**
 * 그런데 사실 ... 부생성자보다는 default parameter를 권장합니다!
 *
 * Converting과 같은 경우 부생성자를 사용할 수 있지만,
 * 그보다는 정적 팩토리 메소드를 추천 드립니다!
 */
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

    /**
     * 커스텀 getter 설명
     */
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

    /**
     * 'val name' 이라고 클래스에 선호하게 되면 이게 하나의 property 이기 때문에 getter 를 자동으로 만들어준다.
     * 그러나 Custom Getter 를 만들어 주기 위해 'val' 를 빼준다.
     */
    name: String = "test",

    var age: Int = 1
) {

    /**
     * name 을 get 할때 무조건 대문자로 바꾸어 보도록 하자
     */
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
