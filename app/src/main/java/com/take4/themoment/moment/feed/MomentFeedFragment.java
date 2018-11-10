package com.take4.themoment.moment.feed;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.take4.themoment.R;
import com.take4.themoment.base.BaseFragment;
import com.take4.themoment.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 30..
 */

@Slf4j
public class MomentFeedFragment extends BaseFragment {
	private static final String ARGS_MOMENT_FEED_TYPE_NAME = "argsMomentFeedTypeName";

	@BindView(R.id.feed_all_tool_bar)
	Toolbar toolbar;

	private String momentFeedTypeName;

	public static MomentFeedFragment newInstance(MomentFeedType momentFeedType) {
		Bundle args = new Bundle();
		args.putString(ARGS_MOMENT_FEED_TYPE_NAME, momentFeedType.getName());

		MomentFeedFragment momentFeedFragment = new MomentFeedFragment();
		momentFeedFragment.setArguments(args);

		return momentFeedFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

		initArguments();
	}

	private void initArguments() {
		momentFeedTypeName = getArgumentSafely().getString(ARGS_MOMENT_FEED_TYPE_NAME);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_moment_feed_all, container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		initToolBar();
	}

	private void initToolBar() {
		toolbar.setTitle("");
		setSupportActionBar(toolbar);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		if (!StringUtils.isEmpty(momentFeedTypeName)) {
			inflater.inflate(MomentFeedType.find(momentFeedTypeName).getMenuId(), menu);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_add:
				startMomentWriteActivity();
				break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void startMomentWriteActivity() {
		if (getActivity() != null) {
			Intent intent = MomentWriteActivity.createIntent(getActivity());
			startActivity(intent);
		}
	}
}
