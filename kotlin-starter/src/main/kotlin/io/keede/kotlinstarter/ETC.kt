package io.keede.kotlinstarter

// 다른 클래스의 같은 이름을 가진 메서드를 가져올 때 이름을 바꿔서 가져온다.
import io.keede.kotlinstarter.arrays.main as arraysMain
import io.keede.kotlinstarter.sealeds.main as sealedsMain
import io.keede.kotlinstarter.lambdas.FruitEntity

typealias FruitFilter = (FruitEntity) -> Boolean

// 만약 (FruitEntity) -> Boolean 라는 타입이 길어보인다면?
fun filterFruits(
    fruits: List<FruitEntity>, filter: FruitFilter
) {

}

class UltraSuperGuardianTribe(
    private val name: String
) {
    operator fun component1() = this.name
}
// 이름이 긴 클래스를 컬렉션에 사용할 때도 간단히 줄일 수 있다.
typealias USGTMap = Map<String, UltraSuperGuardianTribe>


fun main() {
    arraysMain()
    sealedsMain()

    // 구조분해, 복합적인 값을 분해하여 여러 변수를 한번에 할당.
    val entity = FruitEntity(1L, "사과", 1_000, 2_000)
    val (id, name, factoryPrice, currentPrice) = entity
    // 위와 아래는 같다. 아래의 componentN은 data class에서는 만들어준다.
    // data class가 아닌 클래스에서는 operator 키워드를 추가하여 만들 수 있다.
    val id2 = entity.component1()
    val name2 = entity.component2()
    val factoryPrice2 = entity.component3()
    val currentPrice2 = entity.component4()

}