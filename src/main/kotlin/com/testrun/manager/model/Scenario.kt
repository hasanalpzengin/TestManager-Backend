package com.testrun.manager.model

import lombok.Data
import org.bson.BsonTimestamp
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.TimeSeries

@Document
@Data
@TimeSeries(timeField = "timestamp")
data class Scenario(
        @Id
        var id: String? = null,
        var historyId: String? = null,
        val title: String,
        var tags: Map<String, String>,
        val description: String,
        val status: Status,
        val start: BsonTimestamp,
        val stop: BsonTimestamp,
        val steps: MutableList<Step>
){
        fun addStep(step: Step){
                steps.addLast(step)
        }

        fun deleteStep(stepTitle: String){
                steps.removeAll { it.title == stepTitle }
        }
}
