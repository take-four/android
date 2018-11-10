package com.take4.themoment.support.dagger.module.fragment;

import android.support.v4.app.Fragment;
import com.take4.themoment.moment.feed.MomentFeedFragment;
import com.take4.themoment.support.dagger.scope.FragmentScope;
import dagger.Binds;
import dagger.Module;

/**
 * Created by jaehyunpark on 2018. 2. 26..
 */

@Module
public abstract class MomentFeedModule {
	@Binds
	@FragmentScope
	abstract Fragment bindFragment(MomentFeedFragment fragment);
}
