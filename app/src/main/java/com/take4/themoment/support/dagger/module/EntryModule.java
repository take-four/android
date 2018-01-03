package com.take4.themoment.support.dagger.module;

import com.take4.themoment.splash.SplashController;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by jaehyunpark on 2018. 1. 3..
 */
@Module
public class EntryModule {

	@ActivityScope
	@Provides
	SplashController provideSplashController() {
		return new SplashController();
	}
}
