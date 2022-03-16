package com.example.backend

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties
class MyApplication

fun main(args: Array<String>) {
    runApplication<MyApplication>(*args)
}
