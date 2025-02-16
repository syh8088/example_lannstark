package generic

fun main() {

  val cage = Cage()
  cage.put(Carp("잉어"))
//  val carp: Carp = cage.getFirst() // <-- Type Error

  // 제네릭으로 해보자...
  val cage2 = Cage2<Carp>()
  cage2.put(Carp("잉어"))
  val carp2: Carp = cage2.getFirst()


  val goldFishCage = Cage2<GoldFish>()
  goldFishCage.put(GoldFish("금붕어"))

  val fishCage = Cage2<Fish>()
  // fishCage.moveFrom(goldFishCage) // Type mismatch
}

class Cage {
  private val animals: MutableList<Animal> = mutableListOf()

  fun getFirst(): Animal {
    return animals.first()
  }

  fun put(animal: Animal) {
    this.animals.add(animal)
  }

  fun moveFrom(cage: Cage) {
    this.animals.addAll(cage.animals)
  }
}
