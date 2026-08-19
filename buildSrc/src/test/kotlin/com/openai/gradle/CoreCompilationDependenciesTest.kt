package com.openai.gradle

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CoreCompilationDependenciesTest {
    @Test
    fun `published dependencies follow their shared version without moving the compatibility floor`() {
        val jacksonPublishedVersion = "2.21.5"
        val publishedDependencies =
            CoreCompilationDependencies.publishedApiDependencies(jacksonPublishedVersion) +
                CoreCompilationDependencies.publishedImplementationDependencies(jacksonPublishedVersion)
        val jacksonDependencies =
            publishedDependencies.filter { it.startsWith("com.fasterxml.jackson.") }

        assertEquals(6, jacksonDependencies.size)
        assertTrue(jacksonDependencies.all { it.endsWith(":$jacksonPublishedVersion") })
        assertEquals(
            publishedDependencies,
            CoreCompilationDependencies.compilerClasspathDependencies(jacksonPublishedVersion),
        )
        assertTrue(
            CoreCompilationDependencies.jacksonCompatibilityDependencies.all {
                it.endsWith(":2.14.0")
            }
        )
    }
}
