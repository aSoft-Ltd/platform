package platform

import platform.node.OS
import platform.node.process

external fun <T> require(name: String): T

private val os by lazy { require<OS>("os") }

internal fun detectOsInNode() = OperatingSystem(
    family = when (process.platform) {
        "darwin" -> ExecutionEnvironment.Name.MacOS
        "win32" -> ExecutionEnvironment.Name.Windows
        "linux" -> ExecutionEnvironment.Name.Linux
        "android" -> ExecutionEnvironment.Name.Android
        else -> ExecutionEnvironment.Name.Unknown
    }.name,
    version = os.release()
)

internal fun detectRunnerInNode() = ExecutionEnvironment.Runner(
    name = "v8",
    version = process.versions.v8
)