package com.testrun.manager

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestrunManagerApplication

fun main(args: Array<String>) {
	runApplication<TestrunManagerApplication>(*args)
}
