package com.victorsalaun.bestof.ws

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

@SpringBootApplication
open class ApplicationStarter : SpringBootServletInitializer()

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationStarter::class.java, *args)
}
