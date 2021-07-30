package platform.npm

external interface Platform {
    val name: String
    val description: String
    val manufacturer: String
    val version: String
    val os: OS
    val product: String
}

external interface OS {
    val architecture: String
    val family: String
    val version: String?
}