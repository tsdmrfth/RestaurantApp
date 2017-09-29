package com.mvc.restaurant.observer;

import java.util.Observable;

public class Waiter extends Observable {

	public void sendOrder(String order) {
		setChanged();
		notifyObservers(order);
	}
}
