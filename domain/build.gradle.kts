plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
dependencies{
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")


    implementation ("androidx.paging:paging-common:3.3.2")

    implementation("javax.inject:javax.inject:1")
}