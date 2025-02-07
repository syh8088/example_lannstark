package com.lannstark.lec17.kotlin

import com.lannstark.lec17.Fruit

fun main() {

    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1400),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000),
    )

    // 람다를 만드는 방법 1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    // 람다를 만드는 방법 2 <-- 가장 많이 사용
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    isApple(fruits[0])
    isApple.invoke(fruits[1])

    val filterFruits = filterFruits(fruits, isApple)

    /**
     * 함수를 호출하며, 마지막 파라미터인 람다를 쓸 때는 소괄호 밖으로
     * 람다를 뺄 수 있다.
     */
    val filterFruits2 = filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }
    val filterFruits3 = filterFruits(fruits) { fruit -> fruit.name == "사과" }
    val filterFruits4 = filterFruits(fruits) { it.name == "사과" }
}

/**
 * Kotlin 에서는 함수가 1급 시민으로 간주한다. (Java 에서는 2급 시민)
 */
private fun filterFruits(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter(fruit)) {
            results.add(fruit)
        }
    }

    return results
}