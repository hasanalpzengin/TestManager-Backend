package com.testrun.manager.service

import com.testrun.manager.model.Scenario
import com.testrun.manager.model.Suite
import com.testrun.manager.repository.SuiteRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.instancio.Instancio
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import reactor.core.publisher.Mono

@SpringBootTest(classes = [SuiteService::class])
class SuiteServiceTests(
    @MockBean private val suiteRepositoryMock: SuiteRepository,
    @Autowired private val suiteService: SuiteService): FunSpec({
        test("create new suite") {
            val givenSuite = Suite(null, "suiteName", listOf("firstTag"), listOf(Instancio.create(Scenario::class.java)))
            val expectedSuite = Instancio.create(Suite::class.java)

            given(suiteRepositoryMock.save(givenSuite)).willReturn(Mono.just(expectedSuite))

            val response = suiteService.createSuite(givenSuite)
            response.block() shouldBe expectedSuite
        }
})