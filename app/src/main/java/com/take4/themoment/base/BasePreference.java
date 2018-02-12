package com.take4.themoment.base;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * Created by jaehyunpark on 2018. 2. 11..
 */

public class BasePreference {

	protected SharedPreferences preferences;

	protected void putInt(@NonNull String key, int value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putInt(key, value);
		editor.apply();
	}

	protected int getInt(@NonNull String key) {
		return preferences.getInt(key, 0);
	}

	protected void putString(@NonNull String key, String value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString(key, value);
		editor.apply();
	}

	protected String getString(@NonNull String key) {
		return preferences.getString(key, "");
	}

	protected void putBoolean(@NonNull String key, boolean value) {
		SharedPreferences.Editor editor = preferences.edit();
		editor.putBoolean(key, value);
		editor.apply();
	}

	protected boolean getBoolean(@NonNull String key) {
		return preferences.getBoolean(key, false);
	}
}
