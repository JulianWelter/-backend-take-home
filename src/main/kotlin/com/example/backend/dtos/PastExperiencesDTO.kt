package com.example.backend.dtos

import com.example.backend.models.PastExperiences

data class PastExperiencesDTO(

    val sales: Boolean,
    val support: Boolean

) {

    constructor(pastExperiences: PastExperiences) : this(
        pastExperiences.sales,
        pastExperiences.support
    )

}
