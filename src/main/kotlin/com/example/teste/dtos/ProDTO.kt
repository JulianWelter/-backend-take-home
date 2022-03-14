package com.example.teste.dtos

import com.example.teste.models.Pro

data class ProDTO(

    val age: Long,
    val education_level: String,
    val internet_test: InternetTestDTO,
    val past_experiences: PastExperiencesDTO,
    val referral_code: String,
    val writing_score: Double

) {

    constructor(pro: Pro) : this(
        pro.age,
        pro.educationLevel,
        InternetTestDTO(pro.internetTest),
        PastExperiencesDTO(pro.pastExperiences),
        pro.referralCode, pro.writingScore
    )

}
