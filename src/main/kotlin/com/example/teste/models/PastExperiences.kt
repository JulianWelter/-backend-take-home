package com.example.teste.models

import com.example.teste.dtos.PastExperiencesDTO

data class PastExperiences(

    val sales: Boolean,
    val support: Boolean

) {
    constructor(pastExperiencesDTO: PastExperiencesDTO) : this(
        pastExperiencesDTO.sales,
        pastExperiencesDTO.support
    )

    fun calculatePastExperiences(): Long {
        return when {
            this.sales -> 5
            this.support -> 3
            else -> 0
        }
    }

}
