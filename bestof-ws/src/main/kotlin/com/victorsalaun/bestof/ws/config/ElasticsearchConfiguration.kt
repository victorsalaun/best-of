package com.victorsalaun.bestof.ws.config

import org.apache.commons.logging.LogFactory
import org.elasticsearch.client.node.NodeClient
import org.elasticsearch.node.NodeBuilder
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate
import java.io.IOException
import java.nio.file.Files

@Configuration
@EnableConfigurationProperties(ElasticsearchProperties::class)
open class ElasticsearchConfiguration : DisposableBean {

    @Autowired
    private val properties: ElasticsearchProperties? = null

    private var client: NodeClient? = null

    @Bean
    open fun elasticsearchTemplate(): ElasticsearchTemplate {
        return ElasticsearchTemplate(esClient())
    }

    @Bean
    open fun esClient(): NodeClient? {
        try {
            if (logger.isInfoEnabled()) {
                logger.info("Starting Elasticsearch client")
            }
            val nodeBuilder = NodeBuilder()
            nodeBuilder.clusterName(this.properties!!.clusterName).local(false)
            nodeBuilder.settings().put("http.enabled", true).put("path.home",getTempPath())
            this.client = nodeBuilder.node().client() as NodeClient?
            return this.client
        } catch (ex: Exception) {
            throw IllegalStateException(ex)
        }

    }

    @Throws(IOException::class)
    fun getTempPath(): String  {
        val tempDir = Files.createTempDirectory("elastic")
        return tempDir.toFile().absolutePath
    }

    @Throws(Exception::class)
    override fun destroy() {
        if (this.client != null) {
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("Closing Elasticsearch client")
                }
                if (this.client != null) {
                    this.client!!.close()
                }
            } catch (ex: Exception) {
                if (logger.isErrorEnabled()) {
                    logger.error("Error closing Elasticsearch client: ", ex)
                }
            }

        }
    }

    companion object {
        private val logger = LogFactory.getLog(ElasticsearchConfiguration::class.java)
    }
}