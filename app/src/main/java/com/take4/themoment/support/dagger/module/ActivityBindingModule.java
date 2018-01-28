package com.take4.themoment.support.dagger.module;

import com.take4.themoment.MainActivity;
import com.take4.themoment.account.LogInActivity;
import com.take4.themoment.entry.EntryActivity;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by jaehyunpark on 2018. 1. 3..
 */
@Module
public abstract class ActivityBindingModule {

	@ActivityScope
	@ContributesAndroidInjector(modules = EntryModule.class)
	abstract EntryActivity contributesEntryActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = MainModule.class)
	abstract MainActivity contributesMainActivity();

	@ActivityScope
	@ContributesAndroidInjector(modules = LoginModule.class)
	abstract LogInActivity contributesLoginActivity();
}
