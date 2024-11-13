import com.diffplug.gradle.spotless.SpotlessPlugin
import io.gitlab.arturbosch.detekt.DetektPlugin


plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.spotless)
}
detekt {
    config = files("/Users/softsuave/freeProjects/composeCICDProject/datekt.yml")
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