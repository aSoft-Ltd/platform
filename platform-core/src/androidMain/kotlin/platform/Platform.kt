package platform

import android.os.Build

actual object Platform : ExecutionEnvironment(
    name = Name.Android.name,
    runner = Runner(
        name = "ART",
        version = Build.VERSION.RELEASE
    ),
    os = OperatingSystem(
        family = Name.Android.name,
        version = Build.VERSION.RELEASE
    ),
    version = Build.VERSION.RELEASE
)