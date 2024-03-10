package com.testrun.manager.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document
data class Suite(
    val name: String,
    val tags: List<String>,
    @DocumentReference(db="scenario")
    val scenarios: List<Scenario>?
)
