package com.openai.compatibility

import com.openai.models.audio.AudioModel
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.translations.TranslationCreateParams
import com.openai.models.containers.files.FileCreateParams as ContainerFileCreateParams
import com.openai.models.files.FileCreateParams
import com.openai.models.files.FilePurpose
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.uploads.parts.PartCreateParams
import com.openai.models.videos.VideoCreateCharacterParams
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoEditParams
import com.openai.models.videos.VideoExtendParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoSeconds
import java.io.InputStream

internal object MultipartCompatibility {
    fun transcription(stream: InputStream): TranscriptionCreateParams =
        TranscriptionCreateParams.builder().file(stream).model(AudioModel.GPT_4O_TRANSCRIBE).build()

    fun translation(stream: InputStream): TranslationCreateParams =
        TranslationCreateParams.builder().file(stream).model(AudioModel.WHISPER_1).build()

    fun containerFile(stream: InputStream): ContainerFileCreateParams =
        ContainerFileCreateParams.builder().containerId("container").file(stream).build()

    fun file(stream: InputStream): FileCreateParams =
        FileCreateParams.builder().file(stream).purpose(FilePurpose.ASSISTANTS).build()

    fun imageVariation(stream: InputStream): ImageCreateVariationParams =
        ImageCreateVariationParams.builder().image(stream).build()

    fun imageEdit(stream: InputStream): ImageEditParams =
        ImageEditParams.builder().image(stream).prompt("prompt").build()

    fun imageEditUnion(stream: InputStream): ImageEditParams.Image =
        ImageEditParams.Image.ofInputStream(stream)

    fun imageEditUnionList(streams: List<InputStream>): ImageEditParams.Image =
        ImageEditParams.Image.ofInputStreams(streams)

    fun skill(streams: List<InputStream>): SkillCreateParams =
        SkillCreateParams.builder().filesOfInputStreams(streams).build()

    fun skillUnion(streams: List<InputStream>): SkillCreateParams.Files =
        SkillCreateParams.Files.ofInputStreams(streams)

    fun skillVersion(streams: List<InputStream>): VersionCreateParams =
        VersionCreateParams.builder().skillId("skill").filesOfInputStreams(streams).build()

    fun skillVersionUnion(streams: List<InputStream>): VersionCreateParams.Files =
        VersionCreateParams.Files.ofInputStreams(streams)

    fun uploadPart(stream: InputStream): PartCreateParams =
        PartCreateParams.builder().uploadId("upload").data(stream).build()

    fun videoCharacter(stream: InputStream): VideoCreateCharacterParams =
        VideoCreateCharacterParams.builder().name("name").video(stream).build()

    fun videoCreate(stream: InputStream): VideoCreateParams =
        VideoCreateParams.builder().prompt("prompt").inputReference(stream).build()

    fun videoCreateUnion(stream: InputStream): VideoCreateParams.InputReference =
        VideoCreateParams.InputReference.ofStream(stream)

    fun videoEdit(stream: InputStream): VideoEditParams =
        VideoEditParams.builder().prompt("prompt").video(stream).build()

    fun videoEditUnion(stream: InputStream): VideoEditParams.Video =
        VideoEditParams.Video.ofInputStream(stream)

    fun videoExtend(stream: InputStream): VideoExtendParams =
        VideoExtendParams.builder().prompt("prompt").seconds(VideoSeconds._4).video(stream).build()

    fun videoExtendUnion(stream: InputStream): VideoExtendParams.Video =
        VideoExtendParams.Video.ofInputStream(stream)

    fun videoRemix(): VideoRemixParams =
        VideoRemixParams.builder().videoId("video").prompt("prompt").build()
}
