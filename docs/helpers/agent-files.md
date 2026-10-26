# Files for hosted Agents

Use application-owned files and source directories that remain stable during preparation; these path helpers do not sandbox arbitrary user-supplied paths or hostile filesystem writers. The uploaded contents may come from users.

Prepare selected files before creating a hosted session; the returned `files()` are ordinary API inputs. Keep `uploadedFileIds()` for explicit cleanup with the Files API, including IDs exposed by `AgentFilePreparationException` after a partial failure.

```java
import com.openai.helpers.beta.agents.AgentEnvironmentFiles;
import com.openai.helpers.beta.agents.AgentArtifactDownloads;
import com.openai.services.beta.agents.AgentTurnResults;
import com.openai.models.beta.agents.EnvironmentParam;
import com.openai.models.beta.agents.sessions.SessionCreateParams;
import java.nio.file.Paths;
import java.util.Collections;

var prepared = AgentEnvironmentFiles.prepare(client,
    Collections.singletonMap("/workspace/source.pdf", Paths.get("source.pdf")));
var params = SessionCreateParams.builder()
    .agent(SessionCreateParams.Agent.builder().model("gpt-6-astra").build())
    .environment(EnvironmentParam.OpenAIHosted.builder().files(prepared.files()).build())
    .input("Read /workspace/source.pdf and write /workspace/outputs/report.md.")
    .build();
try (var stream = client.beta().agents().sessions().createStreaming(params)) {
    var result = AgentTurnResults.getFinalResult(stream);
    AgentArtifactDownloads.forResult(client.beta().agents().sessions().artifacts(), result)
        .download("/workspace/outputs/report.md", Paths.get("downloaded-report.md"));
}
```

Use explicit include globs for directories, or upload into an existing environment; overloads accepting `client.async()` return `CompletableFuture`.

```java
var docs = AgentEnvironmentFiles.prepareDirectory(client, Paths.get("docs"),
    "/workspace/docs", java.util.Arrays.asList("*.md", "**/*.md"));
var staged = AgentEnvironmentFiles.upload(client, environmentId,
    Paths.get("update.csv"), "/workspace/update.csv");
```

For simplicity, directory selection uses JDK walking and glob matching instead of custom glob pruning; it may traverse unrelated readable directories. Discovery errors below the source root are skipped; root access, selected-file validation, and upload failures still fail the operation.

Artifact content can be read in memory, or streamed to an application-owned, safe destination path. Both modes select the exact result turn and path; async service overloads return `CompletableFuture`.

```java
var artifacts = AgentArtifactDownloads.forResult(
    client.beta().agents().sessions().artifacts(), result);
try (var response = artifacts.content("/workspace/outputs/report.md")) {
    byte[] report = response.body().readAllBytes();
}
artifacts.download("/workspace/outputs/report.md", Paths.get("downloaded-report.md"));
```
