package com.lannstark.lec13.kotlin


/**
 * Effective Java 3rd Edition - Item24, Item86
 *
 * 1. 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어,
 * 참조를 해지하지 못하는 경우 메모리 누수가 생길 수 있고,
 * 이를 디버깅 하기 어렵다.
 *
 * 2. 내부 클래스의 직렬화 형태가 명확하게 정의되지 않아
 * 직렬화에 있어 제한이 있다.
 */
fun main() {




}

/**
 * 중첩 클래스 - static 을 사용하는 클래스
 *
 * 코틀린에서는 이러한 가이드를 따르기 위해
 * - 클래스 안에 기본 클래스를 사용하면 바깥 클래스에 대한 참조가 없고
 * - 바깥 클래스를 참조하고 싶다면, inner 키워드를 붙여야 한다.
 *
 */
class JavaHouse(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    class LivingRoom(
        private val area: Double
    )
}

/**
 * 중첩 클래스 - static 을 사용하지 않는 클래스
 */
class JavaHouseInner(
    private val address: String,
    private val livingRoom: LivingRoom
) {
    inner class LivingRoom(
        private val area: Double
    ) {
        val address: String
            get() = this@JavaHouseInner.address
    }
}