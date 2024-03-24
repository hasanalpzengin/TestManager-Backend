package com.testrun.manager.model

import lombok.Builder
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.DocumentReference

@Document
data class Suite(
    @Id
    var id: String? = null,
    val name: String,
    val tags: List<String>,
    @DocumentReference(db="scenario")
    val scenarios: List<Scenario>?
)
