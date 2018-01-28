package com.take4.themoment;

import javax.inject.Singleton;

import com.google.gson.Gson;
import com.take4.themoment.account.AccountManager;
import com.take4.themoment.api.HttpApiClient;
import com.take4.themoment.support.bus.EventBusProvider;
import com.take4.themoment.support.dagger.module.ActivityBindingModule;
import com.take4.themoment.support.dagger.module.AppModule;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by jaehyunpark on 2017. 12. 26..
 */

@Singleton
@Component(modules = {
	AppModule.class,
	ActivityBindingModule.class,
	AndroidSupportInjectionModule.class})
public interface AppComponent {

	void inject(TheMomentApplication application);

	TheMomentApplication getTheMomentApplication();

	AccountManager getAccountManager();

	//network module
	HttpApiClient getHttpApiClient();

	//support module
	Gson getGson();

	EventBusProvider.EventBus getEventBus();
}

