package com.victorsalaun.bestof.ws.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class BestOf(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,
        val title: String,
        val text: String
)