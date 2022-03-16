package com.example.backend.models

import com.example.backend.dtos.InternetDTO
import com.example.backend.exceptions.BadRequestException

data class Internet(

    val downloadSpeed: Float,
    val uploadSpeed: Float

) {

    constructor(internetDTO: InternetDTO) : this(
        internetDTO.download_speed,
        internetDTO.upload_speed
    )

    fun validateInternetSpeedy(speed: Float) {
        if (speed < 0) throw BadRequestException("Invalid internet speedy")
    }

    private fun verifyInternetSpeedy(speed: Float): Int {
        validateInternetSpeedy(speed)
        return when {
            speed > 50 -> 1
            speed < 5 -> -1
            else -> 0
        }
    }

    fun verifyDownloadSpeed(): Int {
        return verifyInternetSpeedy(this.downloadSpeed)
    }

    fun verifyUploadSpeed(): Int {
        return verifyInternetSpeedy(this.uploadSpeed)
    }

}
