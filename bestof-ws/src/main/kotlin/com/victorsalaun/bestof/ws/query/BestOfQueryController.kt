package com.victorsalaun.bestof.ws.query

import com.victorsalaun.bestof.ws.domain.BestOf
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class BestOfQueryController @Autowired constructor(
        private val bestOfQueryService: BestOfQueryService
) {

    private val logger = LoggerFactory.getLogger(BestOfQueryController::class.java)

    @RequestMapping(
            value = "/bestof",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun get(@RequestParam id: String): Optional<BestOf>? {
        logger.debug("Getting BestOf #" + id)
        return bestOfQueryService.get(id.toLong())
    }
}