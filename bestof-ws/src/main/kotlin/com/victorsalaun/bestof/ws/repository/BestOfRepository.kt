package com.victorsalaun.bestof.ws.repository

import com.victorsalaun.bestof.ws.domain.BestOf
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository

interface BestOfRepository : ElasticsearchRepository<BestOf, String>