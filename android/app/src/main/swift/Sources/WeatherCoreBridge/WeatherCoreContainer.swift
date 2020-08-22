//
// Created by Andriy Druk on 06.08.2020.
//

import Foundation
import Swinject
import SwinjectAutoregistration
import WeatherCore

public class SwiftContainer {

	private let container: Container

	public init(basePath: String) {
		self.container = WeatherCoreContainer.createContainer(basePath: basePath)
	}

    public func resolve(delegate: WeatherRepositoryDelegate) -> WeatherRepository {
        return container.resolve(WeatherRepository.self, argument: delegate)!
    }

}