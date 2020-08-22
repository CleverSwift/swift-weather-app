package com.readdle.weather.core

import com.readdle.codegen.anotation.SwiftFunc
import com.readdle.codegen.anotation.SwiftReference

@SwiftReference
class SwiftContainer private constructor() {

    // Swift JNI private native pointer
    private val nativePointer = 0L

    // Swift JNI release method
    external fun release()

    @SwiftFunc("resolve(delegate:)")
	external fun resolve(delegate: WeatherRepositoryDelegateAndroid): WeatherRepository

    companion object {
        @JvmStatic @SwiftFunc("init(basePath:)")
		external fun init(basePath: String): SwiftContainer
    }

}