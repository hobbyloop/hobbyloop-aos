plugins {
    id("buildlogic.appmodule")
}

android {
    namespace = "com.hobbyloop.member"
}

dependencies {

    implementation(project(":feature:center"))
    implementation(project(":feature:center-detail"))
    implementation(project(":feature:home"))
    implementation(project(":feature:login"))
    implementation(project(":feature:my-page"))
    implementation(project(":feature:reservation"))
    implementation(project(":feature:sign-up"))
    implementation(project(":feature:schedule"))
}
