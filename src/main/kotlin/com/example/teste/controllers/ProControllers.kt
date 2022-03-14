package com.example.teste.controllers

import com.example.teste.dtos.ProDTO
import com.example.teste.facades.ProFacade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class ProControllers {

    @Autowired
    private lateinit var proFacades: ProFacade

    @PostMapping("/sendPerson")
    fun sendPro(@RequestBody proDTO: ProDTO): ResponseEntity<Any> {
        return try {
            ResponseEntity.ok(proFacades.classifyPro(proDTO))
        } catch (e: Exception) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Uncaught exception $e")
        }
    }

}