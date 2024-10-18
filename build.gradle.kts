// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
   id ("com.google.devtools.ksp") version "1.9.20-1.0.14" apply false
    id ("com.google.dagger.hilt.android") version "2.48" apply false
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"

}