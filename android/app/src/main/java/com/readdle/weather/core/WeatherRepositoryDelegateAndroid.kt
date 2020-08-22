package com.readdle.weather.core

import com.readdle.codegen.anotation.SwiftCallbackFunc
import com.readdle.codegen.anotation.SwiftDelegate

@SwiftDelegate(protocols = ["WeatherRepositoryDelegate"])
interface WeatherRepositoryDelegateAndroid {

    @SwiftCallbackFunc("onSearchSuggestionChanged(locations:)")
	fun onSearchSuggestionChanged(locations: ArrayList<Location>)

	@SwiftCallbackFunc("onSavedLocationChanged(locations:)")
	fun onSavedLocationChanged(locations: ArrayList<Location>)

	@SwiftCallbackFunc("onWeatherChanged(woeId:weather:)")
	fun onWeatherChanged(woeId: Long, weather: Weather)

	@SwiftCallbackFunc("onError(errorDescription:)")
	fun onError(errorDescription: String)

}