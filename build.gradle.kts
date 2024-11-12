import com.diffplug.gradle.spotless.SpotlessPlugin
import io.gitlab.arturbosch.detekt.DetektPlugin
import org.jetbrains.kotlin.builtins.StandardNames.FqNames.target
import org.jetbrains.kotlin.js.translate.context.Namer.kotlin

// Top-level build file where you can add configuration options common to all sub-projects/modules.



plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
}

configure(subprojects) {
    apply<DetektPlugin>()
    apply<SpotlessPlugin>()

    spotless {
        kotlin {
            target("**/*.kt")
            ktlint("0.43.2")
        }
    }
}