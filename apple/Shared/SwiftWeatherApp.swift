//
//  SwiftWeatherApp.swift
//  Shared
//
//  Created by Andrius Shiaulis on 04.07.2020.
//

import SwiftUI
import WeatherCore
import Swinject

@main
struct SwiftWeatherApp: App, WeatherRepositoryDelegate {

    let container = WeatherCoreContainer.createContainer(basePath: Bundle.main.bundlePath)
    
    var repository: WeatherRepository?
    
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
    
    init() {
        // Example of WeatherCore usage
        repository = container.resolve(WeatherRepository.self, argument: self)
        repository?.searchLocations(query: "San")
    }
    
    func onSearchSuggestionChanged(locations: [Location]) {
        locations.forEach {
            NSLog($0.title)
        }
    }
    
    func onSavedLocationChanged(locations: [Location]) {
    
    }
    
    func onWeatherChanged(woeId: Int64, weather: Weather) {
        
    }
    
    func onError(errorDescription: String) {
        NSLog("Error: %s", errorDescription)
    }
}
