package com.take4.themoment.account;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import com.take4.themoment.PreferenceType;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

public class AccountPreference {

	private static final String HAS_ACTIVE_ACCOUNT = "has_active_account";
	private static final String USER_ACCOUNT_ID = "user_account_id";

	private final SharedPreferences preferences;

	AccountPreference(Context context) {
		this.preferences = context.getSharedPreferences(
			PreferenceType.ACCOUNT_PREFERENCE.getName(), Context.MODE_PRIVATE);
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

	public void putInt(@NonNull String key, int value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	public int getInt(@NonNull String key) {
		return preferences.getInt(key, 0);
	}

	public void putString(@NonNull String key, String value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.apply();
	}

	public String getString(@NonNull String key) {
		return preferences.getString(key, "");
	}

	public void putBoolean(@NonNull String key, boolean value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.apply();
	}

	public boolean getBoolean(@NonNull String key) {
		return preferences.getBoolean(key, false);
	}
}
