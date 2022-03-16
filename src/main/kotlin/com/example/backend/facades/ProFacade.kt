package com.example.backend.facades

import com.example.backend.dtos.ProDTO
import com.example.backend.models.Output
import com.example.backend.models.Pro
import com.example.backend.models.Project
import org.springframework.stereotype.Service

@Service
class ProFacade {

    companion object {
        val projectList = listOf(
            Project(10, "Calculate the Dark Matter of the universe for Nasa"),
            Project(5, "Determine if the Schrodinger's cat is alive"),
            Project(3, "Attend to users support for a YXZ Company"),
            Project(2, "Collect specific people information from their social media for XPTO Company")
        )
    }

    fun evaluatesPro(pro: Pro): Int {
        return pro.eligibilityScore()
    }

    fun classifyPro(proDTO: ProDTO): Output {
        val score = evaluatesPro(Pro(proDTO))
        val output = Output(score)
        output.selectMainProject(projectList)
        output.selectEligibleProjects(projectList)
        output.selectIneligibleProjects(projectList)
        return output
    }

}