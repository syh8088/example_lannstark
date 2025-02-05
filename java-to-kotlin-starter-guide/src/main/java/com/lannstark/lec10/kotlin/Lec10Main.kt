package com.lannstark.lec10.kotlin

fun main() {
    /**
     * 0 으로 출력된다... 왜그럴까??
     *
     * Accessing non-final property number in constructor
     * 상위 클래스 생성자가 실행되는 동안 하위 클래스의 프로퍼티 즉 Derived 클래스 인스턴스화 한다는 말은
     * Derived 에 있는 number 에 값을 집어 넣어준다는 건데 이때 상위 클래스에서 number 를 호출 하게 되면
     * 하위 클래스에 있는 넘버를 가져오게 됩니다.
     *
     * 그런데 아직 상위 클래스에 constructor 가 먼저 실행 된 단계라서 하위 클래스에 number 라는 값에
     * 초기화가 이루어지지 않는 겁니다.
     * 그 상태에서 먼저 하위 클래스의 number 에 접근하니깐 100 도 아닌 300 도 아닌
     * 어떻게 보면 int 기초 값인 0 이 나오게 되는거죠
     *
     * 그래서 상위 클래스에 constructor 와
     * init 블락에서는 하위 클래스의 field에 접근 하면 안된 다는 이야기 입니다.
     */
    Derived(300)
}

open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")

        /**
         * Accessing non-final property number in constructor 경고문 나옵니다.
         */
        println(number)
    }
}

class Derived(
    override val number: Int
) : Base(number) {

    init {
        println("Derived Class")
    }
}