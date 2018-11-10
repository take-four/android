package com.take4.themoment.moment.feed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.take4.themoment.account.LoginActivity;
import com.take4.themoment.base.BaseActivity;

/**
 * Created by jaehyunpark on 2018. 2. 12..
 */

public class MomentWriteActivity extends BaseActivity {

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, MomentWriteActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
	public void onBackPressed() {
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
