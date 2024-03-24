package com.testrun.manager.repository

import com.testrun.manager.model.Scenario
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository


@Repository
interface ScenarioRepository: ReactiveMongoRepository<Scenario, String> {
}