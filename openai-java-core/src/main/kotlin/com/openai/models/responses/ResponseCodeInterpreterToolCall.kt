// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A tool call to run code. */
@NoAutoDetect
class ResponseCodeInterpreterToolCall
@JsonCreator
private constructor(
    @JsonProperty("id") @ExcludeMissing private val id: JsonField<String> = JsonMissing.of(),
    @JsonProperty("code") @ExcludeMissing private val code: JsonField<String> = JsonMissing.of(),
    @JsonProperty("results")
    @ExcludeMissing
    private val results: JsonField<List<Result>> = JsonMissing.of(),
    @JsonProperty("status")
    @ExcludeMissing
    private val status: JsonField<Status> = JsonMissing.of(),
    @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** The unique ID of the code interpreter tool call. */
    fun id(): String = id.getRequired("id")

    /** The code to run. */
    fun code(): String = code.getRequired("code")

    /** The results of the code interpreter tool call. */
    fun results(): List<Result> = results.getRequired("results")

    /** The status of the code interpreter tool call. */
    fun status(): Status = status.getRequired("status")

    /** The type of the code interpreter tool call. Always `code_interpreter_call`. */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /** The unique ID of the code interpreter tool call. */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /** The code to run. */
    @JsonProperty("code") @ExcludeMissing fun _code(): JsonField<String> = code

    /** The results of the code interpreter tool call. */
    @JsonProperty("results") @ExcludeMissing fun _results(): JsonField<List<Result>> = results

    /** The status of the code interpreter tool call. */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): ResponseCodeInterpreterToolCall = apply {
        if (validated) {
            return@apply
        }

        id()
        code()
        results().forEach { it.validate() }
        status()
        _type().let {
            if (it != JsonValue.from("code_interpreter_call")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [ResponseCodeInterpreterToolCall].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .code()
         * .results()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseCodeInterpreterToolCall]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var code: JsonField<String>? = null
        private var results: JsonField<MutableList<Result>>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonValue = JsonValue.from("code_interpreter_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseCodeInterpreterToolCall: ResponseCodeInterpreterToolCall) =
            apply {
                id = responseCodeInterpreterToolCall.id
                code = responseCodeInterpreterToolCall.code
                results = responseCodeInterpreterToolCall.results.map { it.toMutableList() }
                status = responseCodeInterpreterToolCall.status
                type = responseCodeInterpreterToolCall.type
                additionalProperties =
                    responseCodeInterpreterToolCall.additionalProperties.toMutableMap()
            }

        /** The unique ID of the code interpreter tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /** The unique ID of the code interpreter tool call. */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The code to run. */
        fun code(code: String) = code(JsonField.of(code))

        /** The code to run. */
        fun code(code: JsonField<String>) = apply { this.code = code }

        /** The results of the code interpreter tool call. */
        fun results(results: List<Result>) = results(JsonField.of(results))

        /** The results of the code interpreter tool call. */
        fun results(results: JsonField<List<Result>>) = apply {
            this.results = results.map { it.toMutableList() }
        }

        /** The results of the code interpreter tool call. */
        fun addResult(result: Result) = apply {
            results =
                (results ?: JsonField.of(mutableListOf())).also {
                    checkKnown("results", it).add(result)
                }
        }

        /** The output of a code interpreter tool call that is text. */
        fun addResult(logs: Result.Logs) = addResult(Result.ofLogs(logs))

        /** The output of a code interpreter tool call that is text. */
        fun addLogsResult(logs: String) = addResult(Result.Logs.builder().logs(logs).build())

        /** The output of a code interpreter tool call that is a file. */
        fun addResult(files: Result.Files) = addResult(Result.ofFiles(files))

        /** The output of a code interpreter tool call that is a file. */
        fun addFilesResult(files: List<Result.Files.File>) =
            addResult(Result.Files.builder().files(files).build())

        /** The status of the code interpreter tool call. */
        fun status(status: Status) = status(JsonField.of(status))

        /** The status of the code interpreter tool call. */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** The type of the code interpreter tool call. Always `code_interpreter_call`. */
        fun type(type: JsonValue) = apply { this.type = type }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        fun build(): ResponseCodeInterpreterToolCall =
            ResponseCodeInterpreterToolCall(
                checkRequired("id", id),
                checkRequired("code", code),
                checkRequired("results", results).map { it.toImmutable() },
                checkRequired("status", status),
                type,
                additionalProperties.toImmutable(),
            )
    }

    /** The output of a code interpreter tool call that is text. */
    @JsonDeserialize(using = Result.Deserializer::class)
    @JsonSerialize(using = Result.Serializer::class)
    class Result
    private constructor(
        private val logs: Logs? = null,
        private val files: Files? = null,
        private val _json: JsonValue? = null,
    ) {

        /** The output of a code interpreter tool call that is text. */
        fun logs(): Optional<Logs> = Optional.ofNullable(logs)

        /** The output of a code interpreter tool call that is a file. */
        fun files(): Optional<Files> = Optional.ofNullable(files)

        fun isLogs(): Boolean = logs != null

        fun isFiles(): Boolean = files != null

        /** The output of a code interpreter tool call that is text. */
        fun asLogs(): Logs = logs.getOrThrow("logs")

        /** The output of a code interpreter tool call that is a file. */
        fun asFiles(): Files = files.getOrThrow("files")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T {
            return when {
                logs != null -> visitor.visitLogs(logs)
                files != null -> visitor.visitFiles(files)
                else -> visitor.unknown(_json)
            }
        }

        private var validated: Boolean = false

        fun validate(): Result = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitLogs(logs: Logs) {
                        logs.validate()
                    }

                    override fun visitFiles(files: Files) {
                        files.validate()
                    }
                }
            )
            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Result && logs == other.logs && files == other.files /* spotless:on */
        }

        override fun hashCode(): Int = /* spotless:off */ Objects.hash(logs, files) /* spotless:on */

        override fun toString(): String =
            when {
                logs != null -> "Result{logs=$logs}"
                files != null -> "Result{files=$files}"
                _json != null -> "Result{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Result")
            }

        companion object {

            /** The output of a code interpreter tool call that is text. */
            @JvmStatic fun ofLogs(logs: Logs) = Result(logs = logs)

            /** The output of a code interpreter tool call that is a file. */
            @JvmStatic fun ofFiles(files: Files) = Result(files = files)
        }

        /** An interface that defines how to map each variant of [Result] to a value of type [T]. */
        interface Visitor<out T> {

            /** The output of a code interpreter tool call that is text. */
            fun visitLogs(logs: Logs): T

            /** The output of a code interpreter tool call that is a file. */
            fun visitFiles(files: Files): T

            /**
             * Maps an unknown variant of [Result] to a value of type [T].
             *
             * An instance of [Result] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Result: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Result>(Result::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Result {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "logs" -> {
                        tryDeserialize(node, jacksonTypeRef<Logs>()) { it.validate() }
                            ?.let {
                                return Result(logs = it, _json = json)
                            }
                    }
                    "files" -> {
                        tryDeserialize(node, jacksonTypeRef<Files>()) { it.validate() }
                            ?.let {
                                return Result(files = it, _json = json)
                            }
                    }
                }

                return Result(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Result>(Result::class) {

            override fun serialize(
                value: Result,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.logs != null -> generator.writeObject(value.logs)
                    value.files != null -> generator.writeObject(value.files)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Result")
                }
            }
        }

        /** The output of a code interpreter tool call that is text. */
        @NoAutoDetect
        class Logs
        @JsonCreator
        private constructor(
            @JsonProperty("logs")
            @ExcludeMissing
            private val logs: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /** The logs of the code interpreter tool call. */
            fun logs(): String = logs.getRequired("logs")

            /** The type of the code interpreter text output. Always `logs`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /** The logs of the code interpreter tool call. */
            @JsonProperty("logs") @ExcludeMissing fun _logs(): JsonField<String> = logs

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Logs = apply {
                if (validated) {
                    return@apply
                }

                logs()
                _type().let {
                    if (it != JsonValue.from("logs")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Logs].
                 *
                 * The following fields are required:
                 * ```java
                 * .logs()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Logs]. */
            class Builder internal constructor() {

                private var logs: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("logs")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(logs: Logs) = apply {
                    this.logs = logs.logs
                    type = logs.type
                    additionalProperties = logs.additionalProperties.toMutableMap()
                }

                /** The logs of the code interpreter tool call. */
                fun logs(logs: String) = logs(JsonField.of(logs))

                /** The logs of the code interpreter tool call. */
                fun logs(logs: JsonField<String>) = apply { this.logs = logs }

                /** The type of the code interpreter text output. Always `logs`. */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): Logs =
                    Logs(checkRequired("logs", logs), type, additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Logs && logs == other.logs && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(logs, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Logs{logs=$logs, type=$type, additionalProperties=$additionalProperties}"
        }

        /** The output of a code interpreter tool call that is a file. */
        @NoAutoDetect
        class Files
        @JsonCreator
        private constructor(
            @JsonProperty("files")
            @ExcludeMissing
            private val files: JsonField<List<File>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing private val type: JsonValue = JsonMissing.of(),
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            fun files(): List<File> = files.getRequired("files")

            /** The type of the code interpreter file output. Always `files`. */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<File>> = files

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            private var validated: Boolean = false

            fun validate(): Files = apply {
                if (validated) {
                    return@apply
                }

                files().forEach { it.validate() }
                _type().let {
                    if (it != JsonValue.from("files")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                validated = true
            }

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Files].
                 *
                 * The following fields are required:
                 * ```java
                 * .files()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Files]. */
            class Builder internal constructor() {

                private var files: JsonField<MutableList<File>>? = null
                private var type: JsonValue = JsonValue.from("files")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(files: Files) = apply {
                    this.files = files.files.map { it.toMutableList() }
                    type = files.type
                    additionalProperties = files.additionalProperties.toMutableMap()
                }

                fun files(files: List<File>) = files(JsonField.of(files))

                fun files(files: JsonField<List<File>>) = apply {
                    this.files = files.map { it.toMutableList() }
                }

                fun addFile(file: File) = apply {
                    files =
                        (files ?: JsonField.of(mutableListOf())).also {
                            checkKnown("files", it).add(file)
                        }
                }

                /** The type of the code interpreter file output. Always `files`. */
                fun type(type: JsonValue) = apply { this.type = type }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                fun build(): Files =
                    Files(
                        checkRequired("files", files).map { it.toImmutable() },
                        type,
                        additionalProperties.toImmutable(),
                    )
            }

            @NoAutoDetect
            class File
            @JsonCreator
            private constructor(
                @JsonProperty("file_id")
                @ExcludeMissing
                private val fileId: JsonField<String> = JsonMissing.of(),
                @JsonProperty("mime_type")
                @ExcludeMissing
                private val mimeType: JsonField<String> = JsonMissing.of(),
                @JsonAnySetter
                private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
            ) {

                /** The ID of the file. */
                fun fileId(): String = fileId.getRequired("file_id")

                /** The MIME type of the file. */
                fun mimeType(): String = mimeType.getRequired("mime_type")

                /** The ID of the file. */
                @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

                /** The MIME type of the file. */
                @JsonProperty("mime_type")
                @ExcludeMissing
                fun _mimeType(): JsonField<String> = mimeType

                @JsonAnyGetter
                @ExcludeMissing
                fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

                private var validated: Boolean = false

                fun validate(): File = apply {
                    if (validated) {
                        return@apply
                    }

                    fileId()
                    mimeType()
                    validated = true
                }

                fun toBuilder() = Builder().from(this)

                companion object {

                    /**
                     * Returns a mutable builder for constructing an instance of [File].
                     *
                     * The following fields are required:
                     * ```java
                     * .fileId()
                     * .mimeType()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [File]. */
                class Builder internal constructor() {

                    private var fileId: JsonField<String>? = null
                    private var mimeType: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(file: File) = apply {
                        fileId = file.fileId
                        mimeType = file.mimeType
                        additionalProperties = file.additionalProperties.toMutableMap()
                    }

                    /** The ID of the file. */
                    fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                    /** The ID of the file. */
                    fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                    /** The MIME type of the file. */
                    fun mimeType(mimeType: String) = mimeType(JsonField.of(mimeType))

                    /** The MIME type of the file. */
                    fun mimeType(mimeType: JsonField<String>) = apply { this.mimeType = mimeType }

                    fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                        this.additionalProperties.clear()
                        putAllAdditionalProperties(additionalProperties)
                    }

                    fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                        additionalProperties.put(key, value)
                    }

                    fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                        apply {
                            this.additionalProperties.putAll(additionalProperties)
                        }

                    fun removeAdditionalProperty(key: String) = apply {
                        additionalProperties.remove(key)
                    }

                    fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                        keys.forEach(::removeAdditionalProperty)
                    }

                    fun build(): File =
                        File(
                            checkRequired("fileId", fileId),
                            checkRequired("mimeType", mimeType),
                            additionalProperties.toImmutable(),
                        )
                }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return /* spotless:off */ other is File && fileId == other.fileId && mimeType == other.mimeType && additionalProperties == other.additionalProperties /* spotless:on */
                }

                /* spotless:off */
                private val hashCode: Int by lazy { Objects.hash(fileId, mimeType, additionalProperties) }
                /* spotless:on */

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "File{fileId=$fileId, mimeType=$mimeType, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Files && files == other.files && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(files, type, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Files{files=$files, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    /** The status of the code interpreter tool call. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val INTERPRETING = of("interpreting")

            @JvmField val COMPLETED = of("completed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            INTERPRETING,
            COMPLETED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            IN_PROGRESS,
            INTERPRETING,
            COMPLETED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                IN_PROGRESS -> Value.IN_PROGRESS
                INTERPRETING -> Value.INTERPRETING
                COMPLETED -> Value.COMPLETED
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                IN_PROGRESS -> Known.IN_PROGRESS
                INTERPRETING -> Known.INTERPRETING
                COMPLETED -> Known.COMPLETED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Status && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponseCodeInterpreterToolCall && id == other.id && code == other.code && results == other.results && status == other.status && type == other.type && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, code, results, status, type, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseCodeInterpreterToolCall{id=$id, code=$code, results=$results, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
