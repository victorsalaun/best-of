package com.victorsalaun.bestof.ws.command

import com.victorsalaun.bestof.ws.domain.BestOf
import org.springframework.stereotype.Service

@Service
class BestOfCommandService {

    fun create(bestOf: BestOf): BestOf {
        return bestOf
    }

    fun update(bestOf: BestOf): BestOf {
        return bestOf
    }

    fun delete(id: Long) {
    }

}