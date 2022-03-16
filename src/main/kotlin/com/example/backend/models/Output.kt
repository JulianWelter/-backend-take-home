package com.example.backend.models

data class Output(

    val score: Int,
    var selected_project: String = "",
    val eligible_projects: MutableList<String> = mutableListOf(),
    val ineligible_projects: MutableList<String> = mutableListOf()

) {

    fun selectMainProject( projectList: List<Project>) {
        var bestScore = 0

        projectList.forEach { project ->
            if (this.score >= project.score && this.score > bestScore) {
                bestScore = this.score
                this.selected_project = project.name
            }
        }
    }

    fun selectIneligibleProjects( projectList: List<Project>) {
        projectList.forEach { e -> if (e.score > this.score) this.ineligible_projects.add(e.name) }
    }

    fun selectEligibleProjects( projectList: List<Project>) {
        projectList.forEach { e -> if (e.score <= this.score) this.eligible_projects.add(e.name) }
    }

}