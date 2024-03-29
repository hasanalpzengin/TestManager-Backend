package com.testrun.manager.controller

import com.testrun.manager.model.Suite
import com.testrun.manager.service.SuiteService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/suites")
class SuiteController(private val suiteService: SuiteService) {
    @PostMapping
    fun createSuite(@RequestBody suite: Suite): Mono<Suite> {
        return suiteService.createSuite(suite)
    }

    @GetMapping("/{suiteId}")
    fun getSuite(@PathVariable suiteId: String): Mono<Suite> {
        return suiteService.getSuite(suiteId)
    }

    @GetMapping
    fun getAllSuites(): Flux<Suite> {
        return suiteService.getAllSuites()
    }

    @PutMapping("/{suiteId}")
    fun updateSuite(@PathVariable suiteId: String, @RequestBody suite: Suite): Mono<Suite> {
        return suiteService.updateSuite(suiteId, suite)
    }

    @PutMapping("/{suiteId}")
    fun updateSuite(@PathVariable suiteId: String): Mono<Void> {
        return suiteService.deleteSuite(suiteId)
    }
}