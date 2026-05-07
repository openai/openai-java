package com.openai.models.files

/**
 * Centralized mapping for default filenames based on file purpose.
 *
 * Single source of truth for determining appropriate default filenames when users upload files
 * without explicitly specifying a name.
 *
 * When OpenAI adds new [FilePurpose] values or changes file format requirements, update the mapping
 * in this class. All consumers automatically pick up changes.
 */
object FileNameMapper {

    /**
     * Returns the default filename for the given purpose.
     *
     * @param purpose The purpose of the file, or null for generic fallback
     * @return A purpose-appropriate default filename
     */
    fun getDefaultFilename(purpose: FilePurpose?): String {
        return when (purpose) {
            FilePurpose.FINE_TUNE -> "training_data.jsonl"
            FilePurpose.BATCH -> "batch_data.jsonl"
            FilePurpose.ASSISTANTS -> "assistant_data.jsonl"
            FilePurpose.VISION -> "vision_data.jsonl"
            FilePurpose.USER_DATA -> "user_data.jsonl"
            FilePurpose.EVALS -> "evals_data.jsonl"
            else -> "file.bin"
        }
    }

    /**
     * Checks if a filename is valid for the given purpose.
     *
     * @param filename The filename to validate
     * @param purpose The purpose of the file, or null to allow any filename
     * @return true if the filename is valid for this purpose
     */
    fun isValidForPurpose(filename: String, purpose: FilePurpose?): Boolean {
        return purpose == null ||
            when (purpose) {
                FilePurpose.FINE_TUNE,
                FilePurpose.BATCH -> filename.endsWith(".jsonl", ignoreCase = true)

                else -> true
            }
    }
}
