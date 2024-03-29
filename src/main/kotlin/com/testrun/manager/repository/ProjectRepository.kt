package com.testrun.manager.repository

import com.testrun.manager.model.Project
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ProjectRepository: ReactiveMongoRepository<Project, String> {
}