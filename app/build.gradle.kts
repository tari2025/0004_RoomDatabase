plugins {
    alias(libs.plugins.android.application)
    // HAPUS alias kotlin.android karena AGP 9 sudah punya Kotlin bawaan
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp") // JANGAN dikomentari, ini wajib untuk Room
}

android {
    namespace = "com.example.roomdata"
    compileSdk = 35 // Ubah dari { version = release(37) } karena SDK 37 belum stabil

    defaultConfig {
        applicationId = "com.example.roomdata"
        minSdk = 24
        targetSdk = 35 // Ubah dari 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // Ubah dari optimization { enable = false }
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(libs.bundles.room)
    ksp(libs.room.compiler)

    // Icons & Navigation
    implementation(libs.compose.icons)
    implementation(libs.navigation.compose)

    // ViewModel & Lifecycle Compose
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.runtime.compose)

    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}