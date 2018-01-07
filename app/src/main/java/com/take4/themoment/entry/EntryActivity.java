package com.take4.themoment.entry;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.take4.themoment.R;
import com.take4.themoment.account.AccountManager;
import com.take4.themoment.account.LoginActivity;
import com.take4.themoment.base.BaseActivity;
import com.take4.themoment.splash.SplashActivity;
import com.take4.themoment.support.dagger.scope.ActivityScope;
import dagger.Binds;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EntryActivity extends BaseActivity {
	public static final int SPLASH_REQUEST_CODE = 1;
	public static final int LOGIN_REQUEST_CODE = 2;

	@Inject
	AccountManager accountManager;

	private boolean isSplashDone = false;
	private boolean accountReady = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);

		showSplashActivity();
	}

	private void showSplashActivity() {
		startActivityForResult(SplashActivity.createIntent(this), SPLASH_REQUEST_CODE);
	}

	private void moveToActivity() {
		// TODO: 2018. 1. 5. tutorial check
		if (!accountReady) {
			requestLoginIfNeed();
		}
	}

	private void requestLoginIfNeed() {
		accountManager.startLoginActivityForResult(this, LOGIN_REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != Activity.RESULT_OK) {
			log.debug("Request code : {}", requestCode);
			log.debug("Result code : {}", resultCode);
			log.debug("Data : {}", data);
			return;
		}

		switch (requestCode) {
			case SPLASH_REQUEST_CODE:
				isSplashDone = true;
				moveToActivity();
				break;

			case LOGIN_REQUEST_CODE:
				log.debug("Login Success");
				accountReady = true;
				moveToActivity();
				break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
