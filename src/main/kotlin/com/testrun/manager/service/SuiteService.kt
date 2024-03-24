package com.testrun.manager.service

import com.testrun.manager.model.Suite
import com.testrun.manager.repository.SuiteRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SuiteService(private val suiteRepository: SuiteRepository) {
    fun getSuite(suiteId: String): Mono<Suite> {
        return suiteRepository.findById(suiteId)
    }

    fun createSuite(suite: Suite): Mono<Suite> {
        return suiteRepository.save(suite)
    }

    fun deleteSuite(suiteId: String): Mono<Void>{
        return suiteRepository.deleteById(suiteId)
    }

    fun updateSuite(suiteId: String, suite: Suite): Mono<Suite>{
        suite.id = suiteId
        return suiteRepository.save(suite)
    }

    fun getAllSuites(): Flux<Suite> {
        return suiteRepository.findAll()
    }
}