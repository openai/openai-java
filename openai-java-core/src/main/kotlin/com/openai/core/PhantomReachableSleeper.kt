package com.openai.core

import java.time.Duration
import java.util.concurrent.CompletableFuture

/**
 * A delegating wrapper around a [Sleeper] that closes it once it's only phantom reachable.
 *
 * This class ensures the [Sleeper] is closed even if the user forgets to do it.
 */
internal class PhantomReachableSleeper(private val sleeper: Sleeper) : Sleeper {

    init {
        closeWhenPhantomReachable(this, sleeper)
    }

    override fun sleep(duration: Duration) = sleeper.sleep(duration)

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
        sleeper.sleepAsync(duration)

    override fun close() = sleeper.close()
}
