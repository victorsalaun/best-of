package com.victorsalaun.bestof.ws.domain

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "bestof", type = "bestof", shards = 1, replicas = 0, refreshInterval = "-1")
data class BestOf(
        @Id
        var id: String? = null,
        var title: String? = null,
        var text: String? = null
)