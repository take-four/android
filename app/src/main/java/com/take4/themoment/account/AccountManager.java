package com.take4.themoment.account;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.joda.time.DateTime;
import org.joda.time.Minutes;

import android.app.Activity;
import android.content.Intent;
import com.take4.themoment.AppComponentContainer;
import com.take4.themoment.api.HttpCallback;
import com.take4.themoment.auth.FirebaseAuthenticator;
import com.take4.themoment.model.User;
import com.take4.themoment.task.BaseHttpTask;
import com.take4.themoment.task.HttpTaskExecutor;
import com.take4.themoment.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
@Singleton
public class AccountManager {

	@Inject
	AccountPreference accountPreference;

	@Inject
	AccountManager() {
	}

	public static AccountManager getInstance() {
		return AppComponentContainer.get().getAccountManager();
	}

	public void startLoginActivityForResult(Activity activity, int requestCode) {
		Intent intent = LogInActivity.createIntent(activity);
		activity.startActivityForResult(intent, requestCode);
	}

	public boolean isSignedIn() {
		if (StringUtils.isEmpty(accountPreference.getUserIdToken())) {
			log.debug("There isn't user id token.");
			return false;
		}

		if (!hasUserIdTokenValidity()) {
			log.debug("User id token isn't validity.");
			return false;
		}

		try {
			requestAuthorizationToServer();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void requestAuthorizationToServer() throws Exception {
		HttpTaskExecutor httpTaskExecutor = new HttpTaskExecutor(callback);
		httpTaskExecutor.requestUserAuthorization();
	}

	private HttpCallback callback = new HttpCallback() {
		@Override
		public void onSuccess(BaseHttpTask baseHttpTask) {
			log.debug("Authorization is succeed.");
			User user = (User)baseHttpTask.getResult();
			if (user == null) {
				return;
			}
			accountPreference.putUserAccountId(user.getEmail());
			accountPreference.putUserName(user.getName());
		}

		@Override
		public void onFail(BaseHttpTask baseHttpTask, Exception e) {
			log.warn("Authorization is failed.");
			accountPreference.putUserAccountId(null);
			accountPreference.putUserName(null);
			requestSignOut();
		}
	};

	private boolean hasUserIdTokenValidity() {
		AccountPreference accountPreference =
			new AccountPreference(AppComponentContainer.get().getApplicationContext());

		String idTokenExpiration = accountPreference.getUserIdTokenExpiration();
		if (StringUtils.isEmpty(idTokenExpiration)) {
			return false;
		}

		DateTime idTokenExpirationTime = DateTime.parse(idTokenExpiration);
		if (idTokenExpirationTime == null) {
			return false;
		}

		int expirationDiffTime = Minutes.minutesBetween(idTokenExpirationTime, DateTime.now()).getMinutes();
		if (expirationDiffTime > 55) {
			FirebaseAuthenticator.requestUserIdToken();
		}
		return true;
	}

	private void requestSignOut() {

	}
}
