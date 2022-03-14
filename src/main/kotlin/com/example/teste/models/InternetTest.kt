package com.example.teste.models

import com.example.teste.dtos.InternetTestDTO

data class InternetTest(

    val downloadSpeed: Double,
    val uploadSpeed: Double

) {

    constructor(internetTestDTO: InternetTestDTO) : this(
        internetTestDTO.download_speed,
        internetTestDTO.upload_speed
    )

    private fun verifyInternetSpeedy(speed: Double): Long {
        return when {
            speed > 50 -> 1
            speed < 5 -> -1
            else -> 0
        }
    }

    fun verifyDownloadSpeed(): Long {
        return verifyInternetSpeedy(this.downloadSpeed)
    }

    fun verifyUploadSpeed(): Long {
        return verifyInternetSpeedy(this.uploadSpeed)
    }

}
