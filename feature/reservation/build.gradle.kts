plugins {
    id("buildlogic.featuremodule")
}

android {
    namespace = "com.hobbyloop.feature.reservation"
}

dependencies {
    implementation(project(":core:data"))
}
