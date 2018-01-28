package com.take4.themoment;

import android.content.Context;
import com.take4.themoment.account.AccountManager;
import com.take4.themoment.api.HttpApiClient;
import com.take4.themoment.support.bus.EventBusProvider;

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

	void init(AppComponent component) {
		this.component = component;
	}

	public Context getApplicationContext() {
		return component.getTheMomentApplication();
	}

	public AccountManager getAccountManager() {
		return component.getAccountManager();
	}

	public HttpApiClient getHttpApiClient() {
		return component.getHttpApiClient();
	}

	public EventBusProvider.EventBus getEventBus() {
		return component.getEventBus();
	}
}
