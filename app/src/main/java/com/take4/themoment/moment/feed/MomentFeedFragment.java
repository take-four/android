package com.take4.themoment.moment.feed;

import android.os.Bundle;
import com.take4.themoment.base.BaseFragment;

/**
 * Created by jaehyunpark on 2018. 1. 30..
 */

public class MomentFeedFragment extends BaseFragment {
	private static final String ARGS_MOMENT_FEED_TYPE_NAME = "argsMomentFeedTypeName";

	public static MomentFeedFragment newInstance(MomentFeedType momentFeedType) {
		Bundle args = new Bundle();
		args.putString(ARGS_MOMENT_FEED_TYPE_NAME, momentFeedType.getName());

		MomentFeedFragment momentFeedFragment = new MomentFeedFragment();
		momentFeedFragment.setArguments(args);

		return momentFeedFragment;
	}
}
