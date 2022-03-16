package com.example.backend.models

import com.example.backend.dtos.ProDTO
import com.example.backend.exceptions.BadRequestException

data class Pro(

    val age: Int,
    val educationLevel: String,
    val internet: Internet,
    val pastExperiences: PastExperiences,
    val referralCode: String,
    val writingScore: Float,

    ) {

    constructor(proDTO: ProDTO) : this(
        proDTO.age,
        proDTO.education_level,
        Internet(proDTO.internet_test),
        PastExperiences(proDTO.past_experiences),
        proDTO.referral_code,
        proDTO.writing_score
    )

    fun validateEducationLevel() {
        val validEducationLevels = listOf(
            "high_school",
            "bachelors_degree_or_high",
            "no_education"
        )
        if (!validEducationLevels.contains(this.educationLevel)) throw BadRequestException("Invalid education level")
    }

    fun validateWritingScore() {
        if (this.writingScore > 1 || this.writingScore < 0) throw BadRequestException("Invalid writing score")
    }

    fun validateAge() {
        if (this.age < 0) throw BadRequestException("Invalid age")
    }

    fun calculateEducationLevel(): Int {
        validateEducationLevel()
        return when (this.educationLevel) {
            "high_school" -> 1
            "bachelors_degree_or_high" -> 2
            else -> 0
        }
    }

    fun verifyReferralCode(): Int {
        return if (this.referralCode == "token1234") 1
        else 0
    }

    fun calculateWritingScore(): Int {
        validateWritingScore()
        return when {
            this.writingScore > 0.7 -> 2
            this.writingScore < 0.3 -> -1
            else -> 1
        }
    }

    fun eligibilityScore(): Int {
        validateAge()
        var score = 0
        if (this.age < 18) return 0
        score += calculateEducationLevel()
        score += this.internet.verifyDownloadSpeed()
        score += this.internet.verifyUploadSpeed()
        score += this.pastExperiences.calculatePastExperiences()
        score += calculateWritingScore()
        score += verifyReferralCode()
        return score
    }

}
