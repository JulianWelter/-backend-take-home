package com.example.backend.controllers

import com.example.backend.dtos.ProDTO
import com.example.backend.facades.ProFacade
import org.springframework.beans.factory.annotation.Autowired
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
        return ResponseEntity.ok(proFacades.classifyPro(proDTO))
    }

}