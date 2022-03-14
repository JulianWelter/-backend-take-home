package com.example.teste.facades

import com.example.teste.models.Project
import org.springframework.stereotype.Service

@Service
class ProjectFacade {

    fun selectMainProject(score: Long, projectList: List<Project>): String {
        var selectedProject = ""
        var bestScore: Long = 0

        projectList.forEach { project ->

            if (score >= project.score && score > bestScore) {
                bestScore = score
                selectedProject = project.name

            }
        }

        return selectedProject
    }

    fun selectIneligibleProjects(score: Long, projectList: List<Project>): List<String> {

        val ineligibleProjects: MutableList<String> = mutableListOf()

        projectList.forEach { e -> if (e.score > score) ineligibleProjects.add(e.name) }
        return ineligibleProjects

    }

    fun selectEligibleProjects(score: Long, projectList: List<Project>):List<String>{
        val eligibleProjects: MutableList<String> = mutableListOf()

        projectList.forEach{ e -> if(e.score<= score) eligibleProjects.add(e.name) }
        return eligibleProjects
    }

}