package generic

/**
 * 제네릭 함수에서도 타입 정보는 사라진다!
 */
fun <T> T.toSuperStringvv(): String {
  // T가 무엇인지 런타임 때도 알 수 없기 때문에 오류가 난다
//  println(T::class.java.name)
  return "Super $this"
}

inline fun <reified T> T.toSuperString() {
  println("${T::class.java.name}: $this")
}

/**
 * reified 키워드 + inline 함수
 *
 * - inline 함수 : 코드의 본문을 호출 지점으로 이동시켜 컴파일되는 함수
 */
inline fun <reified T> List<*>.hasAnyInstanceOf(): Boolean {
  return this.any { it is T }
}

class TypeErase<T, R, B> {
}

class CageShadow<T : Animal> {
  fun <T : Animal> addAnimal(animal: T) {

  }
}


fun main() {

  val num = 3
  num.toSuperString() // "Int: 3"

  val str = "ABC"
  str.toSuperString() // "String: ABC"




  val cage = CageShadow<GoldFish>()
  cage.addAnimal(GoldFish("금붕어"))
  cage.addAnimal(Carp("잉어"))
}

open class CageV1<T : Animal> {
  open fun addAnimal(animal: T) {

  }
}

class CageV2<T : Animal> : CageV1<T>() {
  override fun addAnimal(animal: T) {
    super.addAnimal(animal)
  }
}

class GoldFishCageV2 : CageV1<GoldFish>() {
  override fun addAnimal(animal: GoldFish) {
    super.addAnimal(animal)
  }
}
