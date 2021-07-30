package platform

import platform.npm.Platform

private val platform = require<Platform>("platform")

internal fun detectOsInBrowser() = OperatingSystem(
    family = platform.os.family,
    version = platform.os.version ?: "Unknown"
)

internal fun detectRunnerInBrowser() = ExecutionEnvironment.Runner(
    name = platform.name,
    version = platform.version
)