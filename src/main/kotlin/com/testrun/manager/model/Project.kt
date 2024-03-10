package com.testrun.manager.model

import lombok.Data
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
@Data
data class Project(
        @Id
        var id: String? = null,
        @Indexed(unique = true)
        val name: String,
        val suites: MutableList<Suite>
){
        fun addSuite(suite: Suite){
                suites.addLast(suite)
        }

        fun deleteSuite(suiteName: String){
                suites.removeAll { it.name == suiteName }
        }
}
