package com.openai

import java.nio.channels.FileChannel
import java.nio.channels.FileLock
import java.nio.file.Paths
import java.nio.file.StandardOpenOption.CREATE
import java.nio.file.StandardOpenOption.WRITE
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Serializes conversation item tests across Gradle worker JVMs that share the Steady mock server.
 *
 * The JUnit resource lock on the test classes covers concurrency within each worker JVM; this file
 * lock covers concurrency between workers.
 */
internal class ConversationItemTestLockExtension : BeforeAllCallback {

    override fun beforeAll(context: ExtensionContext) {
        val channel = FileChannel.open(LOCK_FILE, CREATE, WRITE)
        val lock =
            try {
                channel.lock()
            } catch (throwable: Throwable) {
                channel.close()
                throw throwable
            }

        context.getStore(NAMESPACE).put(LOCK_KEY, LockResource(channel, lock))
    }

    private class LockResource(private val channel: FileChannel, private val lock: FileLock) :
        ExtensionContext.Store.CloseableResource {

        override fun close() {
            try {
                lock.release()
            } finally {
                channel.close()
            }
        }
    }

    companion object {

        private val LOCK_FILE =
            Paths.get(
                System.getProperty("java.io.tmpdir"),
                "openai-java-conversation-item-tests.lock",
            )
        private val NAMESPACE =
            ExtensionContext.Namespace.create(ConversationItemTestLockExtension::class.java)
        private const val LOCK_KEY = "conversation-item-tests"
    }
}
