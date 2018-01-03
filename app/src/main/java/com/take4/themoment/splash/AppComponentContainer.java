package com.take4.themoment.splash;

import com.take4.themoment.support.dagger.component.AppComponent;

/**
 * Created by jaehyunpark on 2017. 12. 27..
 */

public class AppComponentContainer {
	private AppComponent component;

	private static AppComponentContainer instance = new AppComponentContainer();

	private AppComponentContainer() {
	}

	public static AppComponentContainer get() {
		return instance;
	}

	public void init(AppComponent component) {
		this.component = component;
	}
}
