package com.example.backend.handlers

import com.example.backend.dtos.ErrorResponseDTO
import com.example.backend.exceptions.BadRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.Instant

@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(exception: BadRequestException): ResponseEntity<Any> {
        val errorResponseDTO = ErrorResponseDTO(Instant.now(), HttpStatus.BAD_REQUEST, exception.clientMessage, exception.errors, exception.message)
        return ResponseEntity(errorResponseDTO, errorResponseDTO.httpStatus)
    }

}