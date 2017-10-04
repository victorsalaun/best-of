package com.victorsalaun.bestof.ws.query

import com.victorsalaun.bestof.ws.domain.BestOf
import com.victorsalaun.bestof.ws.repository.BestOfRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class BestOfQueryService constructor(
        private val bestOfRepository: BestOfRepository
) {

    fun get(id: Long): Optional<BestOf>? {
        return bestOfRepository.findById(id)
    }

}