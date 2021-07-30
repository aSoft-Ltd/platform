package platform

private val browserCheckFunction = Function("try {return this===window;}catch(e){ return false;}")
private val nodeCheckFunction = Function("try {return this===global;}catch(e){return false;}")

val isBrowser: Boolean = browserCheckFunction.asDynamic()()
val isNode: Boolean = nodeCheckFunction.asDynamic()()

actual object Platform : ExecutionEnvironment(
    name = when {
        isBrowser -> Name.Browser.name
        isNode -> Name.Node.name
        else -> "Javascript"
    },
    runner = when {
        isBrowser -> detectRunnerInBrowser()
        isNode -> detectRunnerInNode()
        else -> Runner("Unknown", "Unknown")
    },
    os = when {
        isBrowser -> detectOsInBrowser()
        isNode -> detectOsInNode()
        else -> OperatingSystem("Unknown", "Unknown")
    }
)

