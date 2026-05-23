plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.assignment4"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.assignment4"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        isCoreLibraryDesugaringEnabled = true
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.1")

    // AWS Amplify
    implementation("com.amplifyframework:core:2.24.0")
    implementation("com.amplifyframework:aws-auth-cognito:2.24.0")
    implementation("com.amplifyframework:aws-api:2.24.0")
    implementation("com.amplifyframework:aws-datastore:2.24.0")

    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.1.5")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}