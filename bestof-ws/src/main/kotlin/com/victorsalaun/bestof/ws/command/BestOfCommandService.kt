package com.victorsalaun.bestof.ws.command

import com.victorsalaun.bestof.ws.domain.BestOf
import com.victorsalaun.bestof.ws.repository.BestOfRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.*

@Service
class BestOfCommandService constructor(
        private val bestOfRepository: BestOfRepository
) {

    private val logger = LoggerFactory.getLogger(BestOfCommandService::class.java)

    fun create(bestOf: BestOf): BestOf {
        bestOf.id = UUID.randomUUID().toString()
        logger.info("Saving new " + bestOf.toString())
        return bestOfRepository.save(bestOf)
    }

    fun update(bestOf: BestOf): BestOf {
        val oldBestOf: BestOf? = bestOfRepository.findOne(bestOf.id)
        return if (oldBestOf != null) {
            logger.info("Updating " + oldBestOf.toString())
            logger.info("To " + bestOf.toString())
            bestOfRepository.save(bestOf)
        } else {
            bestOf
        }
    }

    fun delete(id: String) {
        val bestOf: BestOf? = bestOfRepository.findOne(id)
        if (bestOf != null) {
            logger.info("Deleting " + bestOf.toString())
            bestOfRepository.delete(id)
        } else {
            logger.error("Could not find BestOf #" + id)
        }
    }

}