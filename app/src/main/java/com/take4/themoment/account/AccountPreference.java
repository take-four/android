package com.take4.themoment.account;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.joda.time.DateTime;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.take4.themoment.PreferenceType;
import com.take4.themoment.base.BasePreference;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Singleton
public class AccountPreference extends BasePreference {
	private static final String USER_ID_TOKEN = "user_id_token";
	private static final String USER_ID_TOKEN_EXPIRATION = "user_id_token_expiration";
	private static final String USER_ACCOUNT_ID = "user_account_id";
	private static final String HAS_ACTIVE_ACCOUNT = "has_active_account";
	private static final String USER_NAME = "user_name";

	@Inject
	public AccountPreference(Context context) {
		preferences = context.getSharedPreferences(
			PreferenceType.ACCOUNT_PREFERENCE.getName(), Context.MODE_PRIVATE);
	}

	public void putUserIdToken(String userIdToken) {
		putString(USER_ID_TOKEN, userIdToken);
	}

	public String getUserIdToken() {
		return getString(USER_ID_TOKEN);
	}

	public void putUserIdTokenExpiration(DateTime dateTime) {
		putString(USER_ID_TOKEN_EXPIRATION, dateTime.toString());
	}

	public String getUserIdTokenExpiration() {
		return getString(USER_ID_TOKEN_EXPIRATION);
	}

	public void putUserAccountId(String accountId) {
		putString(USER_ACCOUNT_ID, accountId);
	}

	public String getUserAccountId() {
		return getString(USER_ACCOUNT_ID);
	}

	public void putHasActiveAccount(boolean hasAccount) {
		putBoolean(HAS_ACTIVE_ACCOUNT, hasAccount);
	}

	public boolean getHasAcitveAccount() {
		return getBoolean(HAS_ACTIVE_ACCOUNT);
	}

	public void putUserName(String userName) {
		putString(USER_NAME, userName);
	}

	public String getUserName() {
		return getString(USER_NAME);
	}
}
