package com.example.teste.facades

import com.example.teste.dtos.ProDTO
import com.example.teste.models.Pro
import com.example.teste.models.Output
import com.example.teste.models.Project
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service

@Service
class ProFacade {

    @Autowired
    private lateinit var projectFacade: ProjectFacade

    companion object {
        val projectList = listOf(
            Project(10, "Calculate the Dark Matter of the universe for Nasa"),
            Project(5, "Determine if the Schrodinger's cat is alive"),
            Project(3, "Attend to users support for a YXZ Company"),
            Project(2, "Collect specific people information from their social media for XPTO Company")
        )
    }

    fun evaluatesPro(pro: Pro): Long {
        return pro.eligibilityScore()
    }

    fun classifyPro(proDTO: ProDTO): Output {
        val score = evaluatesPro(Pro(proDTO))
            return Output(
                score,
                projectFacade.selectMainProject(score, projectList),
                projectFacade.selectEligibleProjects(score, projectList),
                projectFacade.selectIneligibleProjects(score, projectList)
            )
    }

}