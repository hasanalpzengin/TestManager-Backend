package com.testrun.manager.service

import com.testrun.manager.model.Project
import com.testrun.manager.model.Suite
import com.testrun.manager.repository.ProjectRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ProjectService(private val projectRepository: ProjectRepository) {
    fun createProject(project: Project): Mono<Project> {
        return projectRepository.save(project)
    }

    fun deleteProject(projectId: String): Mono<Void> {
        return projectRepository.deleteById(projectId)
    }

    fun updateProject(projectId: String, project: Project): Mono<Project> {
        project.id = projectId
        return projectRepository.save(project)
    }

    fun getAllProjects(): Flux<Project>{
        return projectRepository.findAll()
    }

    fun addSuiteToProject(projectId: String, suite: Suite): Mono<Project> {
        val project = projectRepository.findById(projectId).flatMap {
            if(it != null){
                it.addSuite(suite)
                projectRepository.save(it)
            }else{
                Mono.error(NoSuchElementException("Project with id ${projectId} not found"))
            }
        }
        return project
    }

    fun deleteSuiteFromProject(projectId: String, suiteName: String): Mono<Project> {
        val project = projectRepository.findById(projectId).flatMap {
            if(it != null){
                it.deleteSuite(suiteName)
                projectRepository.save(it)
            }else{
                Mono.error(NoSuchElementException("Project with id ${projectId} not found"))
            }
        }
        return project
    }
}