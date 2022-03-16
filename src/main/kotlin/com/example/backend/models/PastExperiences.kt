package com.example.backend.models

import com.example.backend.dtos.PastExperiencesDTO

data class PastExperiences(

    val sales: Boolean,
    val support: Boolean

) {
    constructor(pastExperiencesDTO: PastExperiencesDTO) : this(
        pastExperiencesDTO.sales,
        pastExperiencesDTO.support
    )

    fun calculatePastExperiences(): Int {
        return when {
            this.sales -> 5
            this.support -> 3
            else -> 0
        }
    }

}
