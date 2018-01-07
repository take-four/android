package com.take4.themoment;

import javax.inject.Singleton;

import com.take4.themoment.account.AccountManager;
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
}

