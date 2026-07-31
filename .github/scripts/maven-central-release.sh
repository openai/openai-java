#!/usr/bin/env bash

set -euo pipefail

readonly MAVEN_CENTRAL_BASE_URL="https://repo.maven.apache.org/maven2/com/openai"

artifacts=()
present_files=()
missing_files=()
transient_errors=()

usage() {
  echo "Usage: $0 check <version> <artifact-id,...> | wait <version> <artifact-id,...> [attempts] [interval-seconds]" >&2
  exit 2
}

validate_inputs() {
  local version=$1
  local artifacts_csv=$2

  if [[ ! "$version" =~ ^[0-9]+\.[0-9]+\.[0-9]+(-[0-9A-Za-z.-]+)?$ ]]; then
    echo "::error title=Invalid Maven version::$version is not a supported release version"
    exit 1
  fi
  if [[ -z "$artifacts_csv" ]]; then
    echo "::error title=No publications::Expected at least one Maven artifact"
    exit 1
  fi

  IFS=, read -r -a artifacts <<< "$artifacts_csv"
  for artifact in "${artifacts[@]}"; do
    if [[ ! "$artifact" =~ ^[0-9A-Za-z._-]+$ ]]; then
      echo "::error title=Invalid artifact ID::$artifact is not safe to publish"
      exit 1
    fi
  done
}

probe_release() {
  local version=$1
  local artifact
  local extension
  local file
  local status
  local url

  present_files=()
  missing_files=()
  transient_errors=()

  for artifact in "${artifacts[@]}"; do
    for extension in pom jar; do
      file="$artifact-$version.$extension"
      url="$MAVEN_CENTRAL_BASE_URL/$artifact/$version/$file"
      if ! status="$(
        curl \
          --silent \
          --show-error \
          --head \
          --location \
          --connect-timeout 10 \
          --max-time 30 \
          --retry 2 \
          --retry-all-errors \
          --retry-max-time 30 \
          --output /dev/null \
          --write-out '%{http_code}' \
          "$url"
      )"; then
        transient_errors+=("$file (request failed)")
        continue
      fi
      case "$status" in
        200) present_files+=("$file") ;;
        404) missing_files+=("$file") ;;
        *) transient_errors+=("$file (HTTP $status)") ;;
      esac
    done
  done
}

check_release() {
  local version=$1
  local expected_file_count

  probe_release "$version"
  expected_file_count=$((${#artifacts[@]} * 2))

  if [[ "${#transient_errors[@]}" -ne 0 ]]; then
    echo "::error title=Maven Central unavailable::${transient_errors[*]}"
    exit 1
  fi
  if [[ "${#present_files[@]}" -eq 0 ]]; then
    echo "already_published=false" >> "$GITHUB_OUTPUT"
  elif [[ "${#present_files[@]}" -eq "$expected_file_count" ]]; then
    echo "All release artifacts are already public; publication will be skipped"
    echo "already_published=true" >> "$GITHUB_OUTPUT"
  else
    echo "::error title=Partial Maven Central release::Found ${present_files[*]}; immutable releases cannot be overwritten"
    exit 1
  fi
}

wait_for_release() {
  local version=$1
  local max_attempts=$2
  local interval_seconds=$3
  local attempt

  if [[ ! "$max_attempts" =~ ^[1-9][0-9]*$ || ! "$interval_seconds" =~ ^[0-9]+$ ]]; then
    usage
  fi

  for ((attempt = 1; attempt <= max_attempts; attempt++)); do
    probe_release "$version"
    if [[ "${#missing_files[@]}" -eq 0 && "${#transient_errors[@]}" -eq 0 ]]; then
      echo "Maven Central serves every $version POM and JAR: ${artifacts[*]}"
      return
    fi

    echo "Maven Central verification attempt $attempt/$max_attempts"
    if [[ "${#missing_files[@]}" -ne 0 ]]; then
      echo "Missing: ${missing_files[*]}"
    fi
    if [[ "${#transient_errors[@]}" -ne 0 ]]; then
      echo "Transient errors: ${transient_errors[*]}"
    fi
    if [[ "$attempt" -lt "$max_attempts" ]]; then
      sleep "$interval_seconds"
    fi
  done

  echo "::error title=Maven Central publication not visible::Upload completed, but $version was not fully consumable in time; inspect Central Portal before retrying"
  exit 1
}

if [[ "$#" -lt 3 ]]; then
  usage
fi

readonly command_name=$1
readonly release_version=$2
readonly artifact_list=$3
validate_inputs "$release_version" "$artifact_list"

case "$command_name" in
  check)
    if [[ "$#" -ne 3 || -z "${GITHUB_OUTPUT:-}" ]]; then
      usage
    fi
    check_release "$release_version"
    ;;
  wait)
    if [[ "$#" -gt 5 ]]; then
      usage
    fi
    wait_for_release "$release_version" "${4:-31}" "${5:-60}"
    ;;
  *)
    usage
    ;;
esac
