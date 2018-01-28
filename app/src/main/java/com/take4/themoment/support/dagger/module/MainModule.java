package com.take4.themoment.support.dagger.module;

import android.app.Activity;
import com.take4.themoment.MainActivity;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

/**
 * Created by jaehyunpark on 2018. 1. 21..
 */

@Module
abstract class MainModule {
	@Binds
	@ActivityScope
	abstract Activity bindActivity(MainActivity activity);
}
