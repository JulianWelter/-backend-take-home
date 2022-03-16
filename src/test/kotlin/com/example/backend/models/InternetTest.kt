package com.example.backend.models

import com.example.backend.exceptions.BadRequestException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class InternetTest {

    @Test
    fun `should return the maximum internet score`() {
        val internet = Internet(50.4f, 50f)
        val score = internet.verifyDownloadSpeed()
        Assertions.assertEquals(1, score)
    }

    @Test
    fun `should return the lowest internet score`() {
        val internet = Internet(4f, 50f)
        val score = internet.verifyDownloadSpeed()
        Assertions.assertEquals(-1, score)
    }

    @Test
    fun `should return the intermediate internet score`() {
        val internet = Internet(40.4f, 50f)
        val score = internet.verifyDownloadSpeed()
        Assertions.assertEquals(0, score)
    }

    @Test
    fun `verify download speed should throw a BadRequestException`() {
        val internet = Internet(-40.4f, 50f)
        Assertions.assertThrows(BadRequestException::class.java) {
            internet.verifyDownloadSpeed()
        }
    }

}