package com.take4.themoment.base;

import javax.inject.Inject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by jaehyunpark on 2018. 1. 30..
 */

public class BaseFragment extends Fragment implements HasSupportFragmentInjector {

	@Inject
	Lazy<FloatingLayerController> floatingLayerController;

	@Inject
	DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;

	@Override
	public AndroidInjector<Fragment> supportFragmentInjector() {
		return dispatchingFragmentInjector;
	}

	@Override
	public void onAttach(Context context) {
		AndroidSupportInjection.inject(this);
		super.onAttach(context);
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
		@Nullable Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		ButterKnife.bind(this, view);
		bindFloatingLayer(view);
		super.onViewCreated(view, savedInstanceState);
	}

	private void bindFloatingLayer(View view) {
		if (FloatingLayerController.hasFloatingLayer(view)) {
			floatingLayerController.get().bindView(view);
		}
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onStop() {
		super.onStop();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	public void setSupportActionBar(Toolbar toolbar) {
		if (getActivity() instanceof AppCompatActivity) {
			((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
		}
	}

	public Bundle getArgumentSafely() {
		if (getArguments() == null) {
			return Bundle.EMPTY;
		}

		return getArguments();
	}
}
