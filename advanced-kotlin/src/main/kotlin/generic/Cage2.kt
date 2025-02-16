package generic

fun main() {
  val cage: Cage2<out Fish> = Cage2<GoldFish>()
}

class Cage2<T : Any> {
  private val animals: MutableList<T> = mutableListOf()

  fun getFirst(): T {
    return animals.first()
  }

  fun put(animal: T) {
    this.animals.add(animal)
  }

  /**
   * out: (함수 파라미터 입장에서의) 생성자, 공변
   */
  fun moveFrom(otherCage: Cage2<out T>) {
    this.animals.addAll(otherCage.animals)
  }

  /**
   * int: (함수 파라미터 입장에서의) 소비자, 반공변
   */
  fun moveTo(otherCage: Cage2<in T>) {
    otherCage.animals.addAll(this.animals)
  }
}
