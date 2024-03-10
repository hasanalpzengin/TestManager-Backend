package com.testrun.manager.repository

import com.testrun.manager.model.Project
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ProjectRepository: ReactiveMongoRepository<Project, String> {
}