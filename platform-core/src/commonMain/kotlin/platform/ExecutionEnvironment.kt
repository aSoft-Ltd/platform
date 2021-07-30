package platform

import kotlinx.serialization.Serializable

@Serializable
open class ExecutionEnvironment(
    open val name: String,
    open val runner: Runner,
    open val os: OperatingSystem,
    val version: String
) {
    @Serializable
    class Runner(
        val name: String,
        val version: String
    )

    enum class Name {
        Android,
        Browser,
        iOS,
        JVM,
        Linux,
        MacOS,
        Node,
        TvOS,
        WatchOS,
        Windows,
        UNIX,
        Unknown,
    }
}