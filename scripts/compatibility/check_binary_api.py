#!/usr/bin/env python3
"""Conservative declared JVM API comparison. See README.md for scope and limits."""

import argparse
from dataclasses import dataclass
from pathlib import Path
import sys
import zipfile

PUBLIC, PRIVATE, PROTECTED = 0x0001, 0x0002, 0x0004
STATIC, FINAL, INTERFACE, ABSTRACT = 0x0008, 0x0010, 0x0200, 0x0400


class Reader:
    def __init__(self, data):
        self.data = data
        self.pos = 0

    def take(self, size):
        end = self.pos + size
        if end > len(self.data):
            raise ValueError("truncated class file")
        result = self.data[self.pos : end]
        self.pos = end
        return result

    def number(self, size):
        return int.from_bytes(self.take(size), "big")


@dataclass
class ClassApi:
    flags: int
    version: tuple
    superclass: str
    interfaces: tuple
    fields: dict
    methods: dict


def visibility(flags):
    return 2 if flags & PUBLIC else 1 if flags & PROTECTED else 0


def parse_class(data):
    reader = Reader(data)
    if reader.take(4) != b"\xca\xfe\xba\xbe":
        raise ValueError("invalid class file magic")
    minor, major = reader.number(2), reader.number(2)
    pool = [None] * reader.number(2)
    index = 1
    while index < len(pool):
        tag = reader.number(1)
        if tag == 1:
            # Class/member names and descriptors are ASCII for this SDK. Modified
            # UTF-8 string constants may contain NUL/surrogates, so preserve bytes.
            pool[index] = reader.take(reader.number(2))
        elif tag == 7:
            pool[index] = reader.number(2)
        elif tag in (3, 4, 9, 10, 11, 12, 17, 18):
            reader.take(4)
        elif tag in (5, 6):
            reader.take(8)
            index += 1
        elif tag in (8, 16, 19, 20):
            reader.take(2)
        elif tag == 15:
            reader.take(3)
        else:
            raise ValueError(f"unsupported constant pool tag {tag}")
        index += 1

    def utf8(index):
        value = pool[index]
        if not isinstance(value, bytes):
            raise ValueError("invalid UTF-8 constant reference")
        return value.decode("utf-8")

    def class_name(index):
        return utf8(pool[index]) if index else ""

    def attributes():
        result = []
        for _ in range(reader.number(2)):
            name = utf8(reader.number(2))
            result.append((name, reader.take(reader.number(4))))
        return result

    def members():
        result = {}
        for _ in range(reader.number(2)):
            flags = reader.number(2)
            key = (utf8(reader.number(2)), utf8(reader.number(2)))
            attributes()
            if visibility(flags):
                if key in result:
                    raise ValueError("duplicate declared member")
                result[key] = flags
        return result

    flags = reader.number(2)
    this_class = reader.number(2)
    name = class_name(this_class)
    superclass = class_name(reader.number(2))
    interfaces = tuple(class_name(reader.number(2)) for _ in range(reader.number(2)))
    fields, methods = members(), members()
    for attribute_name, value in attributes():
        if attribute_name == "InnerClasses":
            nested = Reader(value)
            for _ in range(nested.number(2)):
                inner = nested.number(2)
                nested.take(4)  # outer class and inner simple name
                inner_flags = nested.number(2)
                if inner == this_class:
                    # Protected nested classes have no ACC_PROTECTED in the
                    # class header; their actual access lives in InnerClasses.
                    flags = inner_flags
    if reader.pos != len(data):
        raise ValueError("trailing class file data")
    return name, ClassApi(
        flags, (major, minor), superclass, interfaces, fields, methods
    )


def read_jar(path):
    classes = {}
    with zipfile.ZipFile(path) as archive:
        names = archive.namelist()
        if len(names) != len(set(names)):
            raise ValueError(f"{path}: duplicate JAR entries")
        for name in names:
            if not name.endswith(".class"):
                continue
            if name.startswith("META-INF/versions/") or name == "module-info.class":
                raise ValueError(
                    f"{path}: multi-release/modular JARs are not supported"
                )
            class_name, api = parse_class(archive.read(name))
            if name != class_name + ".class":
                raise ValueError(f"{path}: class name does not match entry {name}")
            if visibility(api.flags):
                classes[class_name] = api
    if not classes:
        raise ValueError(f"{path}: no public/protected classes found")
    return classes


def compare(old, new):
    issues = []
    for name, before in sorted(old.items()):
        after = new.get(name)
        if after is None:
            issues.append(f"{name}: exported class removed or inaccessible")
            continue
        if visibility(after.flags) < visibility(before.flags):
            issues.append(f"{name}: class visibility narrowed")
        if after.version > before.version:
            issues.append(
                f"{name}: class file version increased {before.version} -> {after.version}"
            )
        if bool(before.flags & INTERFACE) != bool(after.flags & INTERFACE):
            issues.append(f"{name}: class/interface kind changed")
        if before.superclass != after.superclass or set(before.interfaces) - set(
            after.interfaces
        ):
            issues.append(f"{name}: superclass changed or direct interface removed")
        for flag, label in (
            (FINAL, "final"),
            (ABSTRACT, "abstract"),
            (STATIC, "static"),
        ):
            if bool(before.flags & flag) != bool(after.flags & flag):
                issues.append(f"{name}: class {label} modifier changed")
        for kind in ("fields", "methods"):
            old_members, new_members = getattr(before, kind), getattr(after, kind)
            for key, old_flags in sorted(old_members.items()):
                target = f"{name}#{key[0]} {key[1]}"
                new_flags = new_members.get(key)
                if new_flags is None:
                    issues.append(
                        f"{target}: {kind[:-1]} removed, inaccessible, or descriptor changed"
                    )
                    continue
                if visibility(new_flags) < visibility(old_flags):
                    issues.append(f"{target}: visibility narrowed")
                if bool(old_flags & STATIC) != bool(new_flags & STATIC):
                    issues.append(f"{target}: static/instance changed")
                for flag, label in ((FINAL, "final"), (ABSTRACT, "abstract")):
                    if new_flags & flag and not old_flags & flag:
                        issues.append(f"{target}: became {label}")
            if kind == "methods":
                for key in sorted(new_members.keys() - old_members.keys()):
                    if new_members[key] & ABSTRACT:
                        issues.append(
                            f"{name}#{key[0]} {key[1]}: abstract method added"
                        )
    return issues


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("old_jar", type=Path)
    parser.add_argument("new_jar", type=Path)
    args = parser.parse_args()
    try:
        old, new = read_jar(args.old_jar), read_jar(args.new_jar)
        issues = compare(old, new)
    except (OSError, ValueError, IndexError, TypeError, zipfile.BadZipFile) as error:
        print(f"Cannot compare JARs: {error}", file=sys.stderr)
        return 2
    for issue in issues:
        print(issue)
    print(
        f"Compared {len(old)} baseline exported classes; {len(issues)} potential incompatibilities."
    )
    return 1 if issues else 0


if __name__ == "__main__":
    sys.exit(main())
