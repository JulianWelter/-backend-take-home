package com.example.backend.models

import com.example.backend.dtos.InternetDTO
import com.example.backend.dtos.PastExperiencesDTO
import com.example.backend.dtos.ProDTO
import com.example.backend.exceptions.BadRequestException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ProTest {

    @Test
    fun `should return the maximum writing score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.8f))
        val score = pro.calculateWritingScore()
        Assertions.assertEquals(2, score)
    }

    @Test
    fun `should return the lowest writing score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.1f))
        val score = pro.calculateWritingScore()
        Assertions.assertEquals(-1, score)
    }

    @Test
    fun `should return the intermediate writing score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.5f))
        val score = pro.calculateWritingScore()
        Assertions.assertEquals(1, score)
    }

    @Test
    fun `should return the score of a valid referral code`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.5f))
        val score = pro.verifyReferralCode()
        Assertions.assertEquals(1, score)
    }

    @Test
    fun `should return the score of an invalid referral code`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "invalidToken1234", 0.5f))
        val score = pro.verifyReferralCode()
        Assertions.assertEquals(0, score)
    }

    @Test
    fun `should return the maximum education level score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "bachelors_degree_or_high", internetTestDTO, pastExperiencesDTO, "token1234", 0.8f))
        val score = pro.calculateEducationLevel()
        Assertions.assertEquals(2, score)
    }

    @Test
    fun `should return the lowest education level score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "no_education", internetTestDTO, pastExperiencesDTO, "token1234", 0.1f))
        val score = pro.calculateEducationLevel()
        Assertions.assertEquals(0, score)
    }

    @Test
    fun `should return the intermediate education level score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.5f))
        val score = pro.calculateEducationLevel()
        Assertions.assertEquals(1, score)
    }

    @Test
    fun `calculate education level should throw a BadRequestException`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "middle_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.5f))
        Assertions.assertThrows(BadRequestException::class.java){
            pro.calculateEducationLevel()
        }
    }

    @Test
    fun `validate writing score should throw a BadRequestException`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", -0.5f))
        Assertions.assertThrows(BadRequestException::class.java){
            pro.calculateWritingScore()
        }
    }

    @Test
    fun `eligibility Score should throw a BadRequestException`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(-1, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.5f))
        Assertions.assertThrows(BadRequestException::class.java){
            pro.eligibilityScore()
        }
    }

}