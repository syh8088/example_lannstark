package com.lannstark.lec20

fun main() {

}

/**
 * Scope Function 무엇?
 *
 * 람다를 사용해 일시적인 영역을 만들고
 * 코드를 더 간결하게 만들거나, method chaning에 활용하는 함수를
 * scope function이라고 합니다.
 *
 * this : 생략이 가능한 대신, 다른 이름을 붙일 수 없다.
 * it   : 생략이 불가능한 대신, 다른 이름을 붙일 수 있다.
 */
fun printPerson(person: Person?) {

    person?.let {
        println(it.name)
        println(it.age)
    }

    if (person != null) {
        println(person.name)
        println(person.age)
    }
}



class Person(
    val name: String,
    var age: Int
) {

}