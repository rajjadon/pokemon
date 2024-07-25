package com.raj.common.qualifiers

enum class AppScreenEnum(val route: String) {
POKEMON_LIST_SCREEN("pokemon_list_screen"), POKEMON_DETAILS_SCREEN("pokemon_details_screen")
}

enum class ApiConstantEnum(val value: String) {
    ACCESS_TOKEN("access_token"),
    POKEMON_LIST("v2/cards"),
    BASE_URL("base_url")
}