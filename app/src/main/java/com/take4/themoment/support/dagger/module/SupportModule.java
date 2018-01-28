package com.take4.themoment.support.dagger.module;

import javax.inject.Singleton;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.take4.themoment.support.bus.EventBusProvider;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jaehyunpark on 2018. 1. 11..
 */

@Module
public class SupportModule {

	@Singleton
	@Provides
	Gson provideGson() {
		return new GsonBuilder().create();
	}

	@Singleton
	@Provides
	EventBusProvider.EventBus provideEventBus() {
		return new EventBusProvider.EventBus();
	}
}
