package com.openai.gradle

import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CoreCompilationShardsTest {
    @Test
    fun `all generated model and service sources are assigned`() {
        val sourceRoot = File("../openai-java-core/src/main/kotlin")
        val sources = sourceRoot.walkTopDown().filter { it.isFile && it.extension == "kt" }.toList()

        val unexpectedClientLayerSources =
            sources.filter { source ->
                val path = source.relativeTo(sourceRoot).invariantSeparatorsPath
                CoreCompilationShards.shardFor(path) == null &&
                    !path.startsWith("com/openai/client/") &&
                    !path.startsWith("com/openai/helpers/")
            }

        assertTrue(
            unexpectedClientLayerSources.isEmpty(),
            "Only client implementations and helpers should remain in the final compilation: " +
                unexpectedClientLayerSources.joinToString(),
        )
        CoreCompilationShard.values().forEach { shard ->
            assertTrue(
                sources.any { source ->
                    CoreCompilationShards.shardFor(
                        source.relativeTo(sourceRoot).invariantSeparatorsPath
                    ) == shard
                },
                "${shard.id} must own at least one source file",
            )
        }
    }

    @Test
    fun `root service aggregators follow their domain`() {
        assertEquals(
            CoreCompilationShard.SERVICES_ADMIN,
            CoreCompilationShards.shardFor("com/openai/services/async/AdminServiceAsync.kt"),
        )
        assertEquals(
            CoreCompilationShard.SERVICES_BETA,
            CoreCompilationShards.shardFor("com/openai/services/blocking/BetaServiceImpl.kt"),
        )
        assertEquals(
            CoreCompilationShard.SERVICES_RESPONSES,
            CoreCompilationShards.shardFor("com/openai/services/ResponseStreamEventValidation.kt"),
        )
    }

    @Test
    fun `service shards depend only on their model domains`() {
        assertEquals(
            listOf(CoreCompilationShard.MODELS_COMMON),
            CoreCompilationShard.CLIENT_BASE.dependencies,
        )
        assertEquals(
            listOf(CoreCompilationShard.CLIENT_BASE, CoreCompilationShard.MODELS_ADMIN),
            CoreCompilationShard.SERVICES_ADMIN.dependencies,
        )
        assertEquals(
            listOf(
                CoreCompilationShard.CLIENT_BASE,
                CoreCompilationShard.MODELS_BETA,
                CoreCompilationShard.MODELS_BETA_RESPONSES,
            ),
            CoreCompilationShard.SERVICES_BETA.dependencies,
        )
        assertEquals(
            listOf(CoreCompilationShard.CLIENT_BASE, CoreCompilationShard.MODELS_REALTIME),
            CoreCompilationShard.SERVICES_RESPONSES.dependencies,
        )
        assertEquals(
            listOf(
                CoreCompilationShard.CLIENT_BASE,
                CoreCompilationShard.MODELS_GENERAL,
                CoreCompilationShard.MODELS_EVALS,
            ),
            CoreCompilationShard.SERVICES_GENERAL.dependencies,
        )
    }

    @Test
    fun `shard dependencies are acyclic`() {
        val visited = mutableSetOf<CoreCompilationShard>()
        val visiting = mutableSetOf<CoreCompilationShard>()

        fun visit(shard: CoreCompilationShard) {
            assertTrue(visiting.add(shard), "Cycle found at ${shard.id}")
            shard.dependencies.forEach { dependency ->
                if (dependency !in visited) visit(dependency)
            }
            visiting.remove(shard)
            visited.add(shard)
        }

        CoreCompilationShard.values().forEach(::visit)
    }
}
