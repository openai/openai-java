package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.io.TempDir

class CoreTestCompilationLayoutTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `generated tests are assigned once while handwritten bridges stay together`() {
        val models = (0..15).map { source("models/Model$it.kt", generated = true) }
        val services = (0..3).map { source("services/Service$it.kt", generated = true) }
        val fixture = source("TestServerExtension.kt")
        val handwritten = source("models/Handwritten.kt")
        val bridge = source("services/Bridge.kt", generated = true, body = "ExampleContractCases()")
        val sources = models + services + listOf(fixture, handwritten, bridge)
        val layout = CoreTestCompilationLayout(sources)
        assertEquals(8, layout.models.size)
        assertEquals(2, layout.services.size)
        assertEquals(models.toSet(), layout.models.flatten().toSet())
        assertEquals(services.toSet(), layout.services.flatten().toSet())
        assertEquals(models.size, layout.models.flatten().size)
        assertEquals(services.size, layout.services.flatten().size)
        assertEquals(fixture, layout.fixture)
        assertTrue(fixture in layout.moved)
        assertFalse(handwritten in layout.moved)
        assertFalse(bridge in layout.moved)
        val reordered = CoreTestCompilationLayout(sources.reversed())
        assertEquals(layout.models, reordered.models)
        assertEquals(layout.services, reordered.services)
    }

    private fun source(name: String, generated: Boolean = false, body: String = "class Example") =
        directory
            .resolve("com/openai/$name")
            .also {
                it.parent.createDirectories()
                it.writeText(
                    (if (generated) "// File generated from our OpenAPI spec by Castiron.\n"
                    else "") + body
                )
            }
            .toFile()
}
