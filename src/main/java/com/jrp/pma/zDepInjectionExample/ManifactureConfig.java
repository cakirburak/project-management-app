package com.jrp.pma.zDepInjectionExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManifactureConfig {

	@Bean
	Car newCar() {

		Engine e = new Engine();
		Door d = new Door();
		Tire t = new Tire();

		return new Car(e, d, t);
	}
}
