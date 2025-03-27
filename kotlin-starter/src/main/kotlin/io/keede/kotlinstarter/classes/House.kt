package io.keede.kotlinstarter.classes

/*
    Kotlin은 기본적으로 바깥 클래스 참조를 하지 않는다. ( static )
    만약 하고 싶다면 inner 키워드를 추가한다.
 */
class House (
    var address: String,
    var livingRoom: LivingRoom = LivingRoom(10.0)
) {

    // Java의 중첩클래스와 같다.( 권장되는 클래스 안의 클래스 )
    class LivingRoom (
        private val area: Double
    )

    // 권장되지 않는 클래스 ( 기본적으로 클래스를 권장하기 때문이다. )
    class InnerLivingRoom(
        private val area: Double
    )  {
        private val address: String
            get() = this@InnerLivingRoom.address
    }

}