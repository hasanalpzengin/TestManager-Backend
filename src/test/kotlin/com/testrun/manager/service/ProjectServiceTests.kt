package com.testrun.manager.service

import com.testrun.manager.model.Project
import com.testrun.manager.model.Suite
import com.testrun.manager.repository.ProjectRepository
import io.kotest.core.spec.style.FunSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import reactor.core.publisher.Mono

@SpringBootTest(classes = [ProjectService::class])
class ProjectServiceTests(
    @MockBean private val projectRepositoryMock: ProjectRepository,
    @Autowired private val projectService: ProjectService
) : FunSpec({

    test("add suite to project") {
        /* expected */
        val expectedProject = Project(
            "someProjectId",
            "this is the project",
            mutableListOf(Suite("suiteId", "suiteName", listOf("someTag"), emptyList()))
        )
        /* prepare mock */
        given(
            projectRepositoryMock.findById("someProjectId")
        ).willReturn(
            Mono.just(Project("someProjectId", "this is the project", mutableListOf()))
        )
        given(
            projectRepositoryMock.save(
                Project(
                    "someProjectId",
                    "this is the project",
                    mutableListOf(Suite("suiteId", "suiteName", listOf("someTag"), emptyList()))
                )
            )
        ).willReturn(
            Mono.just(expectedProject)
        )
        /* test */
        val value = projectService.addSuiteToProject(
            "someProjectId", Suite("suiteId", "suiteName", listOf("someTag"), emptyList())
        )
        value.block() shouldBe expectedProject
    }
})