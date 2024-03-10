package com.testrun.manager.model

data class Step(
        val title: String,
        val detail: String,
        val results: List<Result> = listOf()
)
