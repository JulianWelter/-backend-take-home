package com.example.backend.dtos

import com.example.backend.models.Pro

data class ProDTO(

    val age: Int,
    val education_level: String,
    val internet_test: InternetDTO,
    val past_experiences: PastExperiencesDTO,
    val referral_code: String,
    val writing_score: Float

) {

    constructor(pro: Pro) : this(
        pro.age,
        pro.educationLevel,
        InternetDTO(pro.internet),
        PastExperiencesDTO(pro.pastExperiences),
        pro.referralCode, pro.writingScore
    )

}
