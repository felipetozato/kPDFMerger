class Dependencies {

    object Kotlin {
        const val version = "1.5.31"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.5.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object AndroidX {
        object Compose {

        }
    }

    object Apache {
        const val pdfBox = "org.apache.pdfbox:pdfbox:2.0.21"
    }

    object Koin {
        private const val version = "3.0.1"
        const val core = "io.insert-koin:koin-core:$version"
        const val test = "io.insert-koin:koin-test:$version"
    }

    object Test {
        object JUnit {
            private const val version = "5.8.1"
            const val jupter = "org.junit.jupiter:junit-jupiter"
            const val bom = "org.junit:junit-bom:$version"
        }

        object CommonsIO {
            const val commonsIO = "commons-io:commons-io:2.5"
        }
    }

}