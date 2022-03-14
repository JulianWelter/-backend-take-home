package com.example.teste.dtos

import com.example.teste.models.PastExperiences

data class PastExperiencesDTO(

    val sales: Boolean,
    val support: Boolean

) {

    constructor(pastExperiences: PastExperiences) : this(
        pastExperiences.sales,
        pastExperiences.support
    )

}
