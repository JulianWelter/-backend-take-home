package com.example.teste.dtos

import com.example.teste.models.InternetTest

data class InternetTestDTO(

    val download_speed: Double,
    val upload_speed: Double

) {

    constructor(internetTest: InternetTest) : this(
        internetTest.downloadSpeed,
        internetTest.uploadSpeed
    )

}
