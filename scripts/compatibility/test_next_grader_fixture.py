import os
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch

import next_grader_fixture as policy


ROOT = Path(__file__).resolve().parents[2]
CORE = Path("openai-java-core")
ARCHIVE = CORE / "build/api-compatibility-source"


# Frozen Kotlin callers from the pre-migration Git blobs. Each test verifies
# the preimage and postimage hashes around the real archived fixture patch.
MULTI_GRADER_FIXTURE = b'''// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.graders.gradermodels

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MultiGraderTest {

    @Test
    fun createAndRoundtrip() {
        val multiGrader =
            MultiGrader.builder()
                .calculateOutput("calculate_output")
                .graders(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
                .name("name")
                .build()

        assertThat(multiGrader.calculateOutput()).contains("calculate_output")
        assertThat(multiGrader.graders())
            .contains(
                MultiGrader.Graders.ofStringCheckGrader(
                    StringCheckGrader.builder()
                        .input("input")
                        .name("name")
                        .operation(StringCheckGrader.Operation.EQ)
                        .reference("reference")
                        .build()
                )
            )
        assertThat(multiGrader.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedMultiGrader =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(multiGrader),
                jacksonTypeRef<MultiGrader>(),
            )

        assertThat(roundtrippedMultiGrader).isEqualTo(multiGrader)
    }
}
'''

TOKEN_USAGE_FIXTURE = b'''// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.finetuning.alpha.graders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GraderRunResponseTest {

    @Test
    fun createAndRoundtrip() {
        val graderRunResponse =
            GraderRunResponse.builder()
                .metadata(
                    GraderRunResponse.Metadata.builder()
                        .errors(
                            GraderRunResponse.Metadata.Errors.builder()
                                .formulaParseError(true)
                                .invalidVariableError(true)
                                .modelGraderParseError(true)
                                .modelGraderRefusalError(true)
                                .modelGraderServerError(true)
                                .modelGraderServerErrorDetails("model_grader_server_error_details")
                                .otherError(true)
                                .pythonGraderRuntimeError(true)
                                .pythonGraderRuntimeErrorDetails(
                                    "python_grader_runtime_error_details"
                                )
                                .pythonGraderServerError(true)
                                .pythonGraderServerErrorType("python_grader_server_error_type")
                                .sampleParseError(true)
                                .truncatedObservationError(true)
                                .unresponsiveRewardError(true)
                                .build()
                        )
                        .executionTime(0.0)
                        .name("name")
                        .sampledModelName("sampled_model_name")
                        .scores(
                            GraderRunResponse.Metadata.Scores.builder()
                                .putAdditionalProperty("foo", JsonValue.from("bar"))
                                .build()
                        )
                        .tokenUsage(0L)
                        .type("type")
                        .build()
                )
                .modelGraderTokenUsagePerModel(
                    GraderRunResponse.ModelGraderTokenUsagePerModel.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .reward(0.0)
                .subRewards(
                    GraderRunResponse.SubRewards.builder()
                        .putAdditionalProperty("foo", JsonValue.from("bar"))
                        .build()
                )
                .build()

        assertThat(graderRunResponse.metadata())
            .contains(
                GraderRunResponse.Metadata.builder()
                    .errors(
                        GraderRunResponse.Metadata.Errors.builder()
                            .formulaParseError(true)
                            .invalidVariableError(true)
                            .modelGraderParseError(true)
                            .modelGraderRefusalError(true)
                            .modelGraderServerError(true)
                            .modelGraderServerErrorDetails("model_grader_server_error_details")
                            .otherError(true)
                            .pythonGraderRuntimeError(true)
                            .pythonGraderRuntimeErrorDetails("python_grader_runtime_error_details")
                            .pythonGraderServerError(true)
                            .pythonGraderServerErrorType("python_grader_server_error_type")
                            .sampleParseError(true)
                            .truncatedObservationError(true)
                            .unresponsiveRewardError(true)
                            .build()
                    )
                    .executionTime(0.0)
                    .name("name")
                    .sampledModelName("sampled_model_name")
                    .scores(
                        GraderRunResponse.Metadata.Scores.builder()
                            .putAdditionalProperty("foo", JsonValue.from("bar"))
                            .build()
                    )
                    .tokenUsage(0L)
                    .type("type")
                    .build()
            )
        assertThat(graderRunResponse.modelGraderTokenUsagePerModel())
            .contains(
                GraderRunResponse.ModelGraderTokenUsagePerModel.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )
        assertThat(graderRunResponse.reward()).contains(0.0)
        assertThat(graderRunResponse.subRewards())
            .contains(
                GraderRunResponse.SubRewards.builder()
                    .putAdditionalProperty("foo", JsonValue.from("bar"))
                    .build()
            )

        val jsonMapper = jsonMapper()

        val roundtrippedGraderRunResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(graderRunResponse),
                jacksonTypeRef<GraderRunResponse>(),
            )

        assertThat(roundtrippedGraderRunResponse).isEqualTo(graderRunResponse)
    }
}
'''


class GraderFixtureTest(unittest.TestCase):
    def setUp(self):
        temp = tempfile.TemporaryDirectory()
        self.addCleanup(temp.cleanup)
        self.addCleanup(os.chdir, Path.cwd())
        os.chdir(temp.name)
        event = patch.dict(os.environ, GITHUB_EVENT_NAME="pull_request", GITHUB_BASE_REF="next")
        event.start()
        self.addCleanup(event.stop)

    def exercise_transition(self, name, patch_name, old_model, new_model, old_fixture, old_test, new_test):
        model = CORE / f"src/main/kotlin/com/openai/models/{name}.kt"
        test = CORE / f"src/test/kotlin/com/openai/models/{name}Test.kt"
        patch_path = Path("scripts/compatibility") / patch_name
        git = policy.git
        git("init", "-q")
        for path in (model, test, patch_path):
            path.parent.mkdir(parents=True, exist_ok=True)
        patch_path.write_bytes((ROOT / patch_path).read_bytes())
        test.write_bytes(old_fixture)
        self.assertEqual(git("hash-object", test).decode().strip(), old_test)
        model.write_text("old grader model")
        git("add", "--", model, test, patch_path)
        git("-c", "user.name=Test", "-c", "user.email=test@example.com", "commit", "-qm", "Base")

        staged = ARCHIVE / test
        proposed = ARCHIVE / "proposed" / test
        for path in (staged, proposed):
            path.parent.mkdir(parents=True)
            path.write_bytes(old_fixture)
        neighbor = staged.with_name("UnrelatedTest.kt")
        neighbor.write_bytes(old_fixture)
        patch_path.write_text("only the committed patch should be used")
        test.write_text("tracked caller")

        # A shallow checkout need not contain both SDK model revisions. Stand in
        # only for those large blobs' identities. Git reads the real fixture and
        # patch from the isolated base commit and applies the patch to the archive.
        identities = {git("hash-object", model): old_model}
        model.write_text("keyed or structured grader model")
        identities[git("hash-object", model)] = new_model

        def model_ids(*args):
            result = git(*args)
            if args in (("hash-object", "--no-filters", model), ("rev-parse", f"HEAD:{model}")):
                if result in identities:
                    return (identities[result] + "\n").encode()
            return result

        with patch.object(policy, "git", model_ids):
            model.write_text("unrelated model")
            policy.migrate("HEAD")
            self.assertEqual(staged.read_bytes(), old_fixture)
            model.write_text("keyed or structured grader model")
            policy.migrate("HEAD")
        self.assertEqual(git("hash-object", staged).decode().strip(), new_test)
        self.assertEqual(neighbor.read_bytes(), old_fixture)
        self.assertEqual(proposed.read_bytes(), old_fixture)
        self.assertEqual(test.read_text(), "tracked caller")
        self.assertEqual(model.read_text(), "keyed or structured grader model")

    def test_keyed_multi_grader(self):
        self.exercise_transition(
            "graders/gradermodels/MultiGrader", "next-multi-grader-map.patch",
            "5a637206a1f9363d3643852ca92a0e5c91b7800d", "b05d6b55c8f58d72afc5fbba85741fea6c07df42",
            MULTI_GRADER_FIXTURE, "69678a4e8207401bc0070520a8abb3ac4b502667", "0487b66bf309cdcde6ced61f5da204c7dca0236d",
        )

    def test_structured_token_usage(self):
        self.exercise_transition(
            "finetuning/alpha/graders/GraderRunResponse", "next-grader-token-usage.patch",
            "ade599846c7d6ab6a68a381d8c9a4c23a45065ee", "2d2f23333596399f6a81c82f5fff43096ab805fa",
            TOKEN_USAGE_FIXTURE, "121d551ceecec07af8b732c4bb381ada565798af", "e8557403f71729ec0f52548419d1fe4437aeb9ce",
        )
