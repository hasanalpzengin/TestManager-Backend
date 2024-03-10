package com.testrun.manager.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Scenario(
        @Id
        val id: String? = null,
        val title: String,
        val description: String,
        val steps: List<Step>
)
