package com.example.backend.dtos

import org.springframework.http.HttpStatus
import java.time.Instant

data class ErrorResponseDTO(
    val timestamp: Instant,
    val httpStatus: HttpStatus,
    val clientMessage: String,
    val errors: List<String> = listOf(),
    val developerMessage: String? = null
) {
    constructor(timestamp: Instant, status: HttpStatus, clientMessage: String, error: String, developerMessage: String? = null) :
        this(timestamp, status, clientMessage, listOf<String>(error), developerMessage)
}
