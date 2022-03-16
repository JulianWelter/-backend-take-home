package com.example.backend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
data class BadRequestException(override val message: String, val errors: List<String> = listOf(), val clientMessage: String = "Invalid input") : RuntimeException()
