package com.victorsalaun.bestof.ws.repository

import com.victorsalaun.bestof.ws.domain.BestOf
import org.springframework.data.repository.CrudRepository

interface BestOfRepository : CrudRepository<BestOf, Long>