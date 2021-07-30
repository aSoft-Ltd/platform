package platform

import kotlinx.serialization.Serializable

@Serializable
class OperatingSystem(
    val family: String,
    val version: String
)