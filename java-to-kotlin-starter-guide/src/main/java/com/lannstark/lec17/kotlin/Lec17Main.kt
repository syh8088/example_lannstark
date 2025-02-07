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



    /**
     * all: 조건을 모두 만족하면 true 그렇지 않으면 false
     */
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    /**
     * none : 조건을 모두 불만족하면 true 그렇지 않으면 false
     */
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

    /**
     * any : 조건을 하나라도 만족하면 true 그렇지 않으면 false
     */
    val isAnyApple = fruits.any { fruit -> fruit.price >= 10_000 }

    /**
     * count: 개수를 센다
     */
    val fruitCount = fruits.count()

    /**
     * sortedBy: 오름차순 정렬을 한다.
     */
    val fruitCount2 = fruits.sortedBy { fruit -> fruit.price }

    /**
     * sortedBy: 내림차순 정렬을 한다.
     */
    val fruitCount3 = fruits.sortedByDescending { fruit -> fruit.price }

    /**
     * distinctBy: 변형된 값을 기준으로 중복을 제거한다.
     */
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.price }
        .map { fruit -> fruit.name }


    /**
     * last : 마지막 값을 가져온다 (무조건 null이 아니어야함)
     * lastOrNull : 첫번째 값 또는 null을 가져온다
     */
    fruits.last()
    fruits.lastOrNull()

    /**
     * 과일이름 -> List<과일>
     *     Map 이 필요해요!
     */
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name  }

    /**
     * id -> 과일
     * Map 이 필요해요!
     */
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.price.toLong() }

    /**
     * 과일이름 → List<출고가> Map이 필요해요!
     */
    val map3: Map<String, List<Int>> = fruits.groupBy(
        { fruit -> fruit.name },
        { fruit -> fruit.price },
    )

    /**
     * id → 출고가 Map이 필요해요!
     */
    val map5: Map<Int, Int> = fruits.associateBy(
        { fruit -> fruit.price },
        { fruit -> fruit.price },
    )


    /**
     * Map에 대해서도 앞선 기능들을 대부분 사용할 수 있습니다.
     */
    val map6: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
        .filter { (key, value) -> key == "사과" }


//    val fruitsInList: List<List<Fruit>> = list0f(
//        list0f(
//            Fruit( 1L, "사과", 1_000, 1_500),
//            Fruit( 2L, "사과", 1_200, 1_500),
//            Fruit( 3L, "사과", 1_200, 1_500),
//            Fruit( 4L, "사과", 1_500, 1_500)
//        ),
//        list0f(
//            Fruit( 5L, "바나나", 3_000, 3_200),
//            Fruit( 6L, "바나나", 3_200, 3_200),
//            Fruit( 7L, "바나나", 2_500, 3_200),
//        ),
//        list0f(
//            Fruit( 8L, "수박", 10_000, 10_000),
//        )
//    )
//
//
//    /**
//     * 이 상황에서, 출고가와 현재가가 동일한 과일을 골라주세요!
//     */
//    val samePriceFruits = fruitsInList.flatMap { list ->
//        list.filter { fruit -> fruit. factoryPrice == fruit.currentPrice }
//
//    }

    /**
     * List<List<Fruit>>를 List<Fruit>로 그냥 바꾸어주세요!
     */
//    fruitsInList.flatten()
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


private fun filterFruits2(
    fruits: List<Fruit>,
    filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits
    .filter(filter)
}


