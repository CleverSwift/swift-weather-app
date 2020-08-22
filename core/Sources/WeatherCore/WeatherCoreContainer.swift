//
// Created by Andriy Druk on 20.04.2020.
//

import Foundation
import Swinject
import SwinjectAutoregistration

public class WeatherCoreContainer {

	public static func createContainer(basePath: String) -> Container {
		let container = Container()
		container.register(WeatherProvider.self) { _ in MetaWeatherProvider() }
		container.register(WeatherDatabase.self) { _ in JSONStorage(basePath: basePath) }
		container.autoregister(WeatherRepository.self, argument: WeatherRepositoryDelegate.self, initializer: WeatherRepository.init)
		return container
	}

}