package com.openai.models.files

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.Test

class FileNameMapperTest {
    @Test
    fun `getDefaultFilename returns all mapped default names`() {
        assertEquals(
            "training_data.jsonl",
            FileNameMapper.getDefaultFilename(FilePurpose.FINE_TUNE),
        )
        assertEquals("batch_data.jsonl", FileNameMapper.getDefaultFilename(FilePurpose.BATCH))
        assertEquals(
            "assistant_data.jsonl",
            FileNameMapper.getDefaultFilename(FilePurpose.ASSISTANTS),
        )
        assertEquals("vision_data.jsonl", FileNameMapper.getDefaultFilename(FilePurpose.VISION))
        assertEquals("user_data.jsonl", FileNameMapper.getDefaultFilename(FilePurpose.USER_DATA))
        assertEquals("evals_data.jsonl", FileNameMapper.getDefaultFilename(FilePurpose.EVALS))
        assertEquals("file.bin", FileNameMapper.getDefaultFilename(null))
    }

    @Test
    fun `isValidForPurpose accepts JSONL for fine-tune and batch only`() {
        assertTrue(FileNameMapper.isValidForPurpose("training.jsonl", FilePurpose.FINE_TUNE))
        assertTrue(FileNameMapper.isValidForPurpose("data.JSONL", FilePurpose.FINE_TUNE))
        assertTrue(FileNameMapper.isValidForPurpose("batch.jsonl", FilePurpose.BATCH))

        assertFalse(FileNameMapper.isValidForPurpose("training.txt", FilePurpose.FINE_TUNE))
        assertFalse(FileNameMapper.isValidForPurpose("data.csv", FilePurpose.FINE_TUNE))
        assertFalse(FileNameMapper.isValidForPurpose("batch.txt", FilePurpose.BATCH))
    }

    @Test
    fun `isValidForPurpose allows any filename for non-jsonl purposes`() {
        assertTrue(FileNameMapper.isValidForPurpose("anything.txt", FilePurpose.ASSISTANTS))
        assertTrue(FileNameMapper.isValidForPurpose("image.png", FilePurpose.VISION))
        assertTrue(FileNameMapper.isValidForPurpose("user_data.csv", FilePurpose.USER_DATA))
        assertTrue(FileNameMapper.isValidForPurpose("evals.json", FilePurpose.EVALS))
    }

    @Test
    fun `isValidForPurpose allows any filename when purpose is null`() {
        assertTrue(FileNameMapper.isValidForPurpose("anything.txt", null))
        assertTrue(FileNameMapper.isValidForPurpose("random.bin", null))
        assertTrue(FileNameMapper.isValidForPurpose("data.jsonl", null))
    }
}
