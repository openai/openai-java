package com.openai.responses.okhttp

import com.openai.core.ClientOptions
import java.io.File
import java.lang.reflect.InvocationTargetException
import java.net.URLClassLoader
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertIs
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OpenAIResponsesOkHttpClientClasspathTest {
    @Test
    fun rejectsOldCoreBeforeFactoryConfigurationInEitherClasspathOrder() {
        val old = File(System.getProperty("factoryTest.legacyCore")).toURI().toURL()
        val split =
            System.getProperty("factoryTest.splitSdk").split(File.pathSeparator).map {
                File(it).toURI().toURL()
            }
        for (oldFirst in listOf(true, false)) {
            val urls = if (oldFirst) listOf(old) + split else split + old
            URLClassLoader(urls.toTypedArray(), null).use { loader ->
                val options = loader.loadClass(ClientOptions::class.java.name)
                assertEquals(oldFirst, options.protectionDomain.codeSource.location == old)

                val factory = loader.loadClass(OpenAIResponsesOkHttpClient::class.java.name)
                for (entry in listOf("builder", "fromEnv")) {
                    val failure =
                        assertThrows<InvocationTargetException> {
                            factory.getMethod(entry).invoke(null)
                        }
                    val message = assertIs<IllegalStateException>(failure.cause).message.orEmpty()
                    assertContains(message, "openai-java-core 4.70.0")
                    assertContains(message, "openai-java-bom")
                }
            }
        }
    }
}
