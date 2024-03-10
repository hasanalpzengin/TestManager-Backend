package com.testrun.manager.controller

import com.testrun.manager.model.Project
import com.testrun.manager.model.Suite
import com.testrun.manager.service.ProjectService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/projects")
class ProjectController(private val projectService: ProjectService) {

    @PostMapping
    fun createProject(@RequestBody project: Project): Mono<Project> {
        return projectService.createProject(project)
    }

    @GetMapping
    fun getAllProjects(): Flux<Project>{
        return projectService.getAllProjects()
    }

    @PatchMapping("/{projectId}")
    fun addSuiteToProject(@PathVariable projectId: String, @RequestBody suite: Suite): Mono<Project>{
        return projectService.addSuiteToProject(projectId, suite)
    }

    @DeleteMapping("/{projectId}/{suiteName}")
    fun deleteSuiteFromProject(@PathVariable projectId: String, suiteName: String): Mono<Project>{
        return projectService.deleteSuiteFromProject(projectId, suiteName)
    }
}