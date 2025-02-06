package com.lannstark.lec14.kotlin

fun main() {

    val person = PersonDto("test", 10)
    val person2 = PersonDto("test", 10)

    println(person == person2)
    println(person)


}

/**
 * when은 Enum Class 혹은 Sealed Class와
 * 함께 사용할 경우, 더욱더 진가를 발휘한다.
 */
fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> println("Korea")
        Country.AMERICA -> println("America")
    }
}

/**
 * Data Class
 */
data class PersonDto(
    val name: String,
    val age: Int,
)

/**
 * Enum class
 */
enum class Country(
    private val code: String,
) {
    KOREA("KO"),
    AMERICA("US"),
}

/**
 * Sealed Class, Sealed Interface
 *
 * 상속이 가능하도록 추상클래스를 만들까 하는데 ...
 * 외부에서는 이 클래스를 상속받지 않았으면 좋겠어 !!
 *
 * 하위 클래스를 봉인하자 !!!
 *
 * 컴파일 타임 때 하위 클래스의 타입을 모두 기억한다.
 * 즉, 런타임때 클래스 타입이 추가될 수 없다.
 *
 * 하위 클래스는 같은 패키지에 있어야 한다.
 *
 * Enum과 다른 점
 * - 클래스를 상속받을 수 있다.
 * - 하위 클래스는 멀티 인스턴스가 가능하다.
 *
 */