plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.devseok.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation (KTX.CORE)
    implementation (AndroidX.APP_COMPAT)
    implementation (Google.MATERIAL)
    implementation (AndroidX.CONSTRAINT_LAYOUT)

    // Navigation
    implementation (NavComponent.NAVIGATION_FRAGMENT)
    implementation (NavComponent.NAVIGATION_UI)
    implementation (NavComponent.NAVIGATION_DYNAMIC_FEATURES_FRAGMENT)
    androidTestImplementation (NavComponent.NAVIGATION_TESTING)


    // Dagger Hilt
    implementation (DaggerHilt.DAGGER_HILT)
    kapt(DaggerHilt.DAGGER_HILT_COMPILER)
    kapt(DaggerHilt.DAGGER_HILT_ANDROIDX_COMPILER)

    // Custom BottomBar
    implementation (BottomBar.EXPANDABLE_BOTTOM_BAR)

    // Glide
    implementation (Glide.GLIDE_GLIDE)
    kapt(Glide.GLIDE_COMPILER)

    // lifeCycle
    implementation (KTX.LIFE_CYCLE)

    // SimpleRatingBar
    implementation (SimpleRatingBar.SIMPLE_RATING_BAR)

    // SeekbarRangedView
    implementation (SeekbarRangedView.SEEK_BAR_RANGED_VIEW)

    // Firebase
    implementation (Firebase.FIREBASE_FIRESTORE)

    // Biometric
    implementation (Biometric.BIOMETRIC)

    // Room
    implementation (Room.ROOM_RUNTIME)
    kapt(Room.ROOM_COMPILER)
    implementation (Room.ROOM_KTX)

    // Room Database Backup
    implementation (RoomBackup.ROOM_BACKUP)

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}