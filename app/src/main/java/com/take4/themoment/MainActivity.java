package com.take4.themoment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.take4.themoment.base.BaseActivity;
import com.take4.themoment.navigation.NavigationController;

/**
 * Created by jaehyunpark on 2018. 1. 21..
 */

public class MainActivity extends BaseActivity {

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, MainActivity.class);
		return intent;
	}

	private NavigationController navigationController;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		navigationController = new NavigationController(this);
		navigationController.showTabBar();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
		super.onSaveInstanceState(outState, outPersistentState);
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
