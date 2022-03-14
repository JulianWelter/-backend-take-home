package com.example.teste.models

data class Output(

    val score:Long,
    val selected_project: String,
    val eligible_projects: List<String> = listOf(),
    val ineligible_projects: List<String> = listOf()

)