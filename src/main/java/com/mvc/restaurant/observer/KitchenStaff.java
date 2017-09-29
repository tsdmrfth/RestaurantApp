package com.mvc.restaurant.observer;

import java.util.Observable;
import java.util.Observer;

public class KitchenStaff implements Observer {

	@Override
	public void update(Observable arg0, Object arg1) {
		getUpdateInfo(arg1);
	}

	private void getUpdateInfo(Object arg1) {
		
	}

}
