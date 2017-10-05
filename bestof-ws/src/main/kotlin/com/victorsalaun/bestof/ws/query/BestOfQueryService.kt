package com.victorsalaun.bestof.ws.query

import com.victorsalaun.bestof.ws.domain.BestOf
import com.victorsalaun.bestof.ws.repository.BestOfRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class BestOfQueryService constructor(
        private val bestOfRepository: BestOfRepository
) {

    fun get(id: String): BestOf? {
        return bestOfRepository.findOne(id)
    }

    fun list(pageable: Pageable): Page<BestOf> {
        return bestOfRepository.findAll(pageable)
    }

}