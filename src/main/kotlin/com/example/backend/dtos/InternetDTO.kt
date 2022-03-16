package com.example.backend.dtos

import com.example.backend.models.Internet

data class InternetDTO(

    val download_speed: Float,
    val upload_speed: Float

) {

    constructor(internet: Internet) : this(
        internet.downloadSpeed,
        internet.uploadSpeed
    )

}
