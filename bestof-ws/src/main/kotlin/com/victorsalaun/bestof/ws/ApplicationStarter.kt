package com.victorsalaun.bestof.ws

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.support.SpringBootServletInitializer
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories

@SpringBootApplication
@EnableElasticsearchRepositories
open class ApplicationStarter : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationStarter::class.java, *args)
}
