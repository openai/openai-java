package com.openai.azure

import java.util.concurrent.ConcurrentHashMap

class AzureOpenAIServiceVersion private constructor(@get:JvmName("value") val value: String) {

    companion object {
        private val values: ConcurrentHashMap<String, AzureOpenAIServiceVersion> =
            ConcurrentHashMap()

        @JvmStatic
        fun fromString(version: String): AzureOpenAIServiceVersion =
            values.computeIfAbsent(version) { AzureOpenAIServiceVersion(version) }

        @JvmStatic val V2022_12_01 = fromString("2022-12-01")
        @JvmStatic val V2023_05_15 = fromString("2023-05-15")
        @JvmStatic val V2024_02_01 = fromString("2024-02-01")
        @JvmStatic val V2024_06_01 = fromString("2024-06-01")
        @JvmStatic val V2024_10_21 = fromString("2024-10-21")
        @JvmStatic val V2023_06_01_PREVIEW = fromString("2023-06-01-preview")
        @JvmStatic val V2023_07_01_PREVIEW = fromString("2023-07-01-preview")
        @JvmStatic val V2024_02_15_PREVIEW = fromString("2024-02-15-preview")
        @JvmStatic val V2024_03_01_PREVIEW = fromString("2024-03-01-preview")
        @JvmStatic val V2024_04_01_PREVIEW = fromString("2024-04-01-preview")
        @JvmStatic val V2024_05_01_PREVIEW = fromString("2024-05-01-preview")
        @JvmStatic val V2024_07_01_PREVIEW = fromString("2024-07-01-preview")
        @JvmStatic val V2024_08_01_PREVIEW = fromString("2024-08-01-preview")
        @JvmStatic val V2024_09_01_PREVIEW = fromString("2024-09-01-preview")
        @JvmStatic val V2024_10_01_PREVIEW = fromString("2024-10-01-preview")
        @JvmStatic val V2024_12_01_PREVIEW = fromString("2024-12-01-preview")
        @JvmStatic val V2025_01_01_PREVIEW = fromString("2025-01-01-preview")
    }

    override fun equals(other: Any?): Boolean =
        this === other || (other is AzureOpenAIServiceVersion && value == other.value)

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = "AzureOpenAIServiceVersion{value=$value}"
}
