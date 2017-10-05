package com.victorsalaun.bestof.ws.query

import com.victorsalaun.bestof.ws.domain.BestOf
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
class BestOfQueryController @Autowired constructor(
        private val bestOfQueryService: BestOfQueryService
) {

    private val logger = LoggerFactory.getLogger(BestOfQueryController::class.java)

    @RequestMapping(
            value = "/bestof/{id}",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    private fun get(@PathVariable id: String): BestOf? {
        logger.debug("Getting BestOf #" + id)
        return bestOfQueryService.get(id)
    }

    @RequestMapping(
            value = "/bestof",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    @ResponseBody
    private fun list(pageable: Pageable): Iterable<BestOf> {
        logger.debug("Getting all BestOf, " + pageable.toString())
        val list = bestOfQueryService.list(pageable)
        logger.debug("List of BestOf " + list.content.toString())
        return list.content
    }

}