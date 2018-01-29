package com.take4.themoment.account;

import javax.inject.Inject;
import javax.inject.Singleton;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Singleton
public class AccountManager {

	@Inject
	AccountManager() {
	}

	public void startLoginActivityForResult(Activity activity, int requestCode) {
		Intent intent = LoginActivity.createIntent(activity);
		activity.startActivityForResult(intent, requestCode);
	}
}
