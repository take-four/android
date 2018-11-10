package com.take4.themoment;

import javax.inject.Inject;

import net.danlew.android.joda.JodaTimeAndroid;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.Fragment;
import com.facebook.stetho.Stetho;
import com.take4.themoment.support.dagger.module.AppModule;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by jaehyunpark on 2018. 1. 3..
 */
public class TheMomentApplication extends MultiDexApplication
	implements HasActivityInjector, HasSupportFragmentInjector {

	private AppComponent component;

	@Inject
	DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

	@Inject
	DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

	@Override
	public AndroidInjector<Activity> activityInjector() {
		return dispatchingActivityInjector;
	}

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector() {
		return dispatchingFragmentInjector;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		initApplicationComponent();

		inject();

		initAppComponentContainer();

		Stetho.initializeWithDefaults(this);

		JodaTimeAndroid.init(this);
	}

	private void initApplicationComponent() {
		component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
	}

	private void inject() {
		component.inject(this);
	}

	private void initAppComponentContainer() {
		AppComponentContainer.get().init(component);
	}
}
