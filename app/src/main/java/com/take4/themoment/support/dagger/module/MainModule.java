package com.take4.themoment.support.dagger.module;

import android.app.Activity;
import android.support.v4.app.Fragment;
import com.take4.themoment.MainActivity;
import com.take4.themoment.moment.feed.MomentFeedFragment;
import com.take4.themoment.support.dagger.module.fragment.MomentFeedModule;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import com.take4.themoment.support.dagger.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jaehyunpark on 2018. 1. 21..
 */

@Module
abstract class MainModule {
	@Binds
	@ActivityScope
	abstract Activity bindActivity(MainActivity activity);

	@FragmentScope
	@ContributesAndroidInjector(modules = MomentFeedModule.class)
	abstract MomentFeedFragment contributesMomentFeedFragment();
}
