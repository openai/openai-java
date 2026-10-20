#!/usr/bin/env bash
set -euo pipefail

# Run from the verified release checkout. It may predate the split test compilers.
available_tasks="$(./gradlew :openai-java-core:tasks --all --console=plain)"
skip_optional_compilers=()
for task in compileBetaModelTestKotlin compileAdminModelTestKotlin; do
  if grep -Eq "^${task}([[:space:]]|$)" <<< "$available_tasks"; then
    skip_optional_compilers+=(-x ":openai-java-core:$task")
  fi
done

# Classes were compiled before switching to GraalVM. Only run the tracing tests.
./gradlew :openai-java-core:test \
  -x compileJava -x compileTestJava -x compileKotlin -x compileTestKotlin \
  "${skip_optional_compilers[@]}" -PgraalvmAgent
