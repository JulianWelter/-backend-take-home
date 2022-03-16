package com.example.backend.facades

import com.example.backend.dtos.InternetDTO
import com.example.backend.dtos.PastExperiencesDTO
import com.example.backend.dtos.ProDTO
import com.example.backend.models.Pro
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProFacadeTest {

    @Autowired
    private lateinit var proFacades: ProFacade

    @Test
    fun `classify Pro should return a completed Output`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val selectedProject = "Determine if the Schrodinger's cat is alive"
        val ineligibleProjects = mutableListOf("Calculate the Dark Matter of the universe for Nasa")
        val eligibleProjects = mutableListOf(
            "Determine if the Schrodinger's cat is alive",
            "Attend to users support for a YXZ Company",
            "Collect specific people information from their social media for XPTO Company"
        )
        val proDTO = ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.6f)
        val output = proFacades.classifyPro(proDTO)
        Assertions.assertEquals(7, output.score)
        Assertions.assertEquals(selectedProject, output.selected_project)
        Assertions.assertEquals(eligibleProjects, output.eligible_projects)
        Assertions.assertEquals(ineligibleProjects, output.ineligible_projects)
    }

    @Test
    fun `classify Pro should return a not eligible Output`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val selectedProject = ""
        val ineligibleProjects = mutableListOf(
            "Calculate the Dark Matter of the universe for Nasa",
            "Determine if the Schrodinger's cat is alive",
            "Attend to users support for a YXZ Company",
            "Collect specific people information from their social media for XPTO Company"
        )
        val eligibleProjects = mutableListOf<String>()
        val proDTO = ProDTO(0, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.6f)
        val output = proFacades.classifyPro(proDTO)
        Assertions.assertEquals(0, output.score)
        Assertions.assertEquals(selectedProject, output.selected_project)
        Assertions.assertEquals(eligibleProjects, output.eligible_projects)
        Assertions.assertEquals(ineligibleProjects, output.ineligible_projects)
    }

    @Test
    fun `evaluates Pro should return a score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 40.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.6f))
        val score = proFacades.evaluatesPro(pro)
        Assertions.assertEquals(7, score)
    }

    @Test
    fun `evaluates Pro should return a invalid score`() {
        val pastExperiencesDTO = PastExperiencesDTO(false, true)
        val internetTestDTO = InternetDTO(50.4f, 50.2f)
        val pro = Pro(ProDTO(35, "high_school", internetTestDTO, pastExperiencesDTO, "token1234", 0.6f))
        val score = proFacades.evaluatesPro(pro)
        Assertions.assertNotEquals(7, score)
    }

}