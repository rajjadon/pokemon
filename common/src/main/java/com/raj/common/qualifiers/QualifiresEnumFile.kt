package com.raj.common.qualifiers

enum class AppScreenEnum(val route: String) {
    HOME_SCREEN("home_screen"), FAVORITE_SCREEN("favorite_screen")
}

enum class ApiConstantEnum(val value: String) {
    ACCESS_TOKEN("access_token"),
    API_KEY("api_key"),
    IMAGE_LOADING_URL("image_loading_url"),
    BASE_URL("base_url")
}