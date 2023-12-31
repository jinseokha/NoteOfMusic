import Versions.NAV_VERSION
import Versions.ROOM_VERSION

/**
 * @author Ha Jin Seok
 * @created 2023-08-25
 * @desc
 */

object Versions {
    const val NAV_VERSION = "2.5.3"
    const val ROOM_VERSION = "2.4.2"
}

object Kotlin {
    const val SDK = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.5.21"
}

object AndroidX {
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.0-rc01"
    const val APP_COMPAT = "androidx.appcompat:appcompat:1.6.1"
}

object KTX {
    const val CORE = "androidx.core:core-ktx:1.9.0"
    const val LIFE_CYCLE = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
}

object Google {
    const val MATERIAL = "com.google.android.material:material:1.9.0"
}

object NavComponent {
    const val NAVIGATION_FRAGMENT = "androidx.navigation:navigation-fragment-ktx:$NAV_VERSION"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:$NAV_VERSION"
    const val NAVIGATION_DYNAMIC_FEATURES_FRAGMENT = "androidx.navigation:navigation-dynamic-features-fragment:$NAV_VERSION"
    const val NAVIGATION_TESTING = "androidx.navigation:navigation-testing:$NAV_VERSION"
}

object DaggerHilt {
    const val DAGGER_HILT = "com.google.dagger:hilt-android:2.44"
    const val DAGGER_HILT_COMPILER = "com.google.dagger:hilt-android-compiler:2.44"
    const val DAGGER_HILT_ANDROIDX_COMPILER = "androidx.hilt:hilt-compiler:1.0.0"
}

object Retrofit {
    const val RETROFIT = "com.squareup.retrofit2:retrofit:2.9.0"
    const val CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:2.9.0"
    const val CONVERTER_JAXB = "com.squareup.retrofit2:converter-jaxb:2.9.0"
    const val XMLConverter = "com.squareup.retrofit2:converter-simplexml:2.2.0"
}

object OkHttp {
    const val OKHTTP = "com.squareup.okhttp3:okhttp:4.9.1"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:4.9.1"
}

object Room {
    const val ROOM_RUNTIME = "androidx.room:room-runtime:$ROOM_VERSION"
    const val ROOM_COMPILER = "androidx.room:room-compiler:$ROOM_VERSION"
    const val ROOM_KTX  = "androidx.room:room-ktx:$ROOM_VERSION"
}

object BottomBar{
    const val EXPANDABLE_BOTTOM_BAR = "com.github.st235:expandablebottombar:1.5.3"
}

object Glide{
    const val GLIDE_GLIDE = "com.github.bumptech.glide:glide:4.12.0"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:4.12.0"
}

object SimpleRatingBar{
    const val SIMPLE_RATING_BAR = "com.github.ome450901:SimpleRatingBar:1.5.1"
}

object SeekbarRangedView{
    const val SEEK_BAR_RANGED_VIEW = "com.github.guilhe:seekbar-ranged-view:3.0.0"
}

object Firebase{
    const val FIREBASE_FIRESTORE = "com.google.firebase:firebase-firestore-ktx:24.1.2"
}

object Biometric{
    const val BIOMETRIC = "androidx.biometric:biometric:1.2.0-alpha04"
}

object RoomBackup{
    const val ROOM_BACKUP = "de.raphaelebner:roomdatabasebackup:1.0.0-beta10"
}