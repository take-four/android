package com.take4.themoment.support.dagger.module;

import android.app.Activity;
import com.take4.themoment.moment.feed.MomentWriteActivity;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Binds;
import dagger.Module;

/**
 * Created by jaehyunpark on 2018. 2. 26..
 */

@Module
abstract class MomentWriteModule {

	@Binds
	@ActivityScope
	abstract Activity bindActivity(MomentWriteActivity activity);
}
