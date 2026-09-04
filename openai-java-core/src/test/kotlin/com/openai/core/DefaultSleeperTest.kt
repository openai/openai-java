package com.openai.core

import java.time.Duration
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DefaultSleeperTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun doesNotTruncateSubMillisecondMinimum(async: Boolean) {
        val sleeper = DefaultSleeper()
        try {
            val duration = Duration.ofNanos(500_000)
            val started = System.nanoTime()
            if (async) sleeper.sleepAsync(duration).get(5, TimeUnit.SECONDS)
            else sleeper.sleep(duration)
            assertThat(System.nanoTime() - started).isGreaterThanOrEqualTo(duration.toNanos())
        } finally {
            sleeper.close()
        }
    }
}
