package com.take4.themoment.support.dagger.module;

import android.app.Activity;
import com.take4.themoment.entry.EntryActivity;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

/**
 * Created by jaehyunpark on 2018. 1. 8..
 */

@Module
abstract class EntryModule {
	@Binds
	@ActivityScope
	abstract Activity bindActivity(EntryActivity activity);
}
