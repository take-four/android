package com.take4.themoment.support.dagger.module;

import javax.inject.Singleton;

import android.app.Application;
import android.content.Context;
import com.take4.themoment.TheMomentApplication;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jaehyunpark on 2017. 12. 26..
 */
@Module(includes = ActivityBindingModule.class)
public class AppModule {

	private TheMomentApplication application;

	public AppModule(TheMomentApplication application) {
		this.application = application;
	}

	@Singleton
	@Provides
	TheMomentApplication provideTheMomentApplication() {
		return this.application;
	}

	@Singleton
	@Provides
	Application provideApplication() {
		return this.application;
	}

	@Singleton
	@Provides
	Context provideApplicationContext() {
		return this.application;
	}
}
