package com.testrun.manager.repository

import com.testrun.manager.model.Suite
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface SuiteRepository: ReactiveMongoRepository<Suite, String> {
}