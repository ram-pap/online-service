package com.springboot.example.state;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.stereotype.Component;


public class MyReadynessStateExample {
	
	public void onStateChange(AvailabilityChangeEvent<ReadinessState> event) {
		
		switch(event.getState()) {
		
		case ACCEPTING_TRAFFIC:
			System.out.println("Accepting Trafic");
		case REFUSING_TRAFFIC:
			System.out.println("Refusing traffic");
		}
		
	}

}
