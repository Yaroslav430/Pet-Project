plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id ("kotlin-kapt")
    id ("kotlin-parcelize")
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    flavorDimensions += "version"
    productFlavors{
        create("basic"){
            dimension = "version"
            applicationIdSuffix = ".basic"
            versionNameSuffix = "-basic"
        }
        create("pro"){
            dimension = "version"
            applicationIdSuffix = ".pro"
            versionNameSuffix = "-pro"
        }

    }
    sourceSets {
        getByName("basic") {
            java {
                srcDirs("src\\basic\\java", "src\\basic\\java")
            }
        }
        getByName("pro") {
            java {
                srcDirs("src\\pro\\java", "src\\pro\\java")
            }
        }
    }

}

dependencies {

    implementation (libs.kotlin.stdlib)
    implementation (libs.androidx.core.ktx.v131)
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.constraintlayout)
    implementation (libs.androidx.cardview)
    implementation (libs.androidx.legacy.support.v4)
    implementation (libs.androidx.fragment.ktx)
    implementation(project(":remote_module"))
    implementation(libs.androidx.lifecycle.viewmodel.android)
    implementation(libs.firebase.config)

    //Tests
    testImplementation (libs.junit)
    testImplementation (libs.hamcrest.library)
    androidTestImplementation (libs.androidx.junit)
    androidTestImplementation (libs.androidx.espresso.core)
    androidTestImplementation (libs.espresso.contrib)

    //MaterialDesign
    implementation (libs.material)

    //Coordinator layout
    implementation (libs.androidx.coordinatorlayout)

    //Glide
    implementation (libs.glide)
    annotationProcessor (libs.compiler)

    //Dagger
    implementation (libs.dagger)
    kapt (libs.dagger.compiler)

    //Room
    implementation (libs.androidx.room.runtime)
    implementation (libs.androidx.room.rxjava3)
    kapt (libs.androidx.room.compiler)

    //Coroutines
    implementation (libs.kotlinx.coroutines.core)
    implementation (libs.kotlinx.coroutines.android)

    //RxJava
    implementation (libs.rxandroid)
    implementation (libs.rxjava)
    implementation (libs.rxkotlin)
}