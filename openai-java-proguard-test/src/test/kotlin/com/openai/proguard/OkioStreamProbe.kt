package com.openai.proguard

import java.io.ByteArrayOutputStream
import okio.buffer
import okio.sink
import okio.source

internal object OkioStreamProbe {
    @JvmStatic
    fun main(args: Array<String>) {
        val bytes = ByteArrayOutputStream()
        bytes.sink().buffer().use { it.writeUtf8("request body") }
        val body = bytes.toByteArray().inputStream().source().buffer().use { it.readUtf8() }
        check(body == "request body")
    }
}
