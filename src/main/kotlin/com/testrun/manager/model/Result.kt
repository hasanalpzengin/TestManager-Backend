package com.testrun.manager.model

import org.springframework.data.mongodb.core.mapping.TimeSeries

@TimeSeries(timeField = "timestamp")
data class Result(
        val resultState: ResultState,
        val timestamp: Long
)

enum class ResultState {
    PASS,
    FAIL,
    UNKNOWN,
    NO_RESULT
}