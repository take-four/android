package com.take4.themoment.support.dagger.module;

import com.take4.themoment.base.BaseFragment;
import com.take4.themoment.support.dagger.scope.FragmentScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jaehyunpark on 2018. 2. 26..
 */

@Module
public abstract class BaseActivityModule {

	@FragmentScope
	@ContributesAndroidInjector
	abstract BaseFragment contributesBaseFragment();
}
