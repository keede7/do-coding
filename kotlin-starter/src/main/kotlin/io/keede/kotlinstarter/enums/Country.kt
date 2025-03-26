package io.keede.kotlinstarter.enums

enum class Country(
    val code: String
) {

    KOREA("KO"),
    AMERICA("US")
    ;

    // Kotlin에서 when을 사용하면 좀 더 가독성 있게 사용이 가능하다.
    private fun handleCountry(country: Country) {
        when (country) {
            KOREA -> println("")
            AMERICA -> TODO()
        }
    }

}