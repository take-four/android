package com.take4.themoment.moment.mine;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.take4.themoment.R;
import com.take4.themoment.base.BaseFragment;

/**
 * Created by jaehyunpark on 2018. 2. 13..
 */

public class MyMomentFragment extends BaseFragment {

	public static MyMomentFragment newInstance() {
		MyMomentFragment myMomentFragment = new MyMomentFragment();
		return myMomentFragment;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_my_moment, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
}
