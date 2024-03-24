package com.testrun.manager.controller

import com.testrun.manager.model.Scenario
import com.testrun.manager.service.ScenarioService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/scenarios")
class ScenarioController(private val scenarioService: ScenarioService) {
    @PostMapping
    fun createScenario(@RequestBody scenario: Scenario): Mono<Scenario> {
        return scenarioService.createScenario(scenario)
    }

    @GetMapping
    fun getAllScenarios(): Flux<Scenario> {
        return scenarioService.getAllScenarios()
    }

    @PutMapping("/{scenarioId}")
    fun updateScenario(@PathVariable scenarioId: String, @RequestBody scenario: Scenario): Mono<Scenario>{
        return scenarioService.updateScenario(scenarioId, scenario)
    }

    @PutMapping("/{scenarioId}")
    fun updateScenario(@PathVariable scenarioId: String): Mono<Void>{
        return scenarioService.deleteScenario(scenarioId)
    }
}