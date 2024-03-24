package com.testrun.manager.service

import com.testrun.manager.model.Scenario
import com.testrun.manager.repository.ScenarioRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class ScenarioService(private val scenarioRepository: ScenarioRepository) {
    fun createScenario(scenario: Scenario): Mono<Scenario> {
        return scenarioRepository.save(scenario)
    }

    fun deleteScenario(scenarioId: String): Mono<Void> {
        return scenarioRepository.deleteById(scenarioId)
    }

    fun updateScenario(scenarioId: String, scenario: Scenario): Mono<Scenario> {
        scenario.id = scenarioId
        return scenarioRepository.save(scenario)
    }

    fun getAllScenarios(): Flux<Scenario> {
        return scenarioRepository.findAll()
    }
}