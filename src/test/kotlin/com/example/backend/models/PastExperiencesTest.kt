package com.example.backend.models

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PastExperiencesTest {

    @Test
    fun `should return the maximum past experience scorewith one parameters as true`() {
        val pastExperiences = PastExperiences(true, false)
        val score = pastExperiences.calculatePastExperiences()
        Assertions.assertEquals(5, score)
    }

    @Test
    fun `should return the maximum past experience score with two parameters as true`() {
        val pastExperiences = PastExperiences(true, true)
        val score = pastExperiences.calculatePastExperiences()
        Assertions.assertEquals(5, score)
    }

    @Test
    fun `should return the lowest past experience score`() {
        val pastExperiences = PastExperiences(false, false)
        val score = pastExperiences.calculatePastExperiences()
        Assertions.assertEquals(0, score)
    }

    @Test
    fun `should return the intermediate past experience score`() {
        val pastExperiences = PastExperiences(false, true)
        val score = pastExperiences.calculatePastExperiences()
        Assertions.assertEquals(3, score)
    }

}