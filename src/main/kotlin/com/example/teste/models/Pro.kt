package com.example.teste.models

import com.example.teste.dtos.ProDTO

data class Pro(

    val age: Long,
    val educationLevel: String,
    val internetTest: InternetTest,
    val pastExperiences: PastExperiences,
    val referralCode: String,
    val writingScore: Double,

    ) {

    constructor(proDTO: ProDTO) : this(
        proDTO.age,
        proDTO.education_level,
        InternetTest(proDTO.internet_test),
        PastExperiences(proDTO.past_experiences),
        proDTO.referral_code,
        proDTO.writing_score
    )

    fun calculateEducationLevel(): Long {
        return when (this.educationLevel) {
            "high_school" -> 1
            "bachelors_degree_or_high" -> 2
            else -> 0
        }
    }

    fun verifyReferralCode(): Long {
        return if (this.referralCode == "token1234") 1
        else 0
    }

    fun calculateWritingScore(): Long {
        return when {
            this.writingScore > 0.7 -> 2
            this.writingScore < 0.3 -> -1
            else -> 1
        }
    }

    fun eligibilityScore(): Long {
        var score: Long = 0
        if (this.age < 18) return 0
        score += calculateEducationLevel()
        score += this.internetTest.verifyDownloadSpeed()
        score += this.internetTest.verifyUploadSpeed()
        score += this.pastExperiences.calculatePastExperiences()
        score += calculateWritingScore()
        score += verifyReferralCode()
        return score
    }

}
