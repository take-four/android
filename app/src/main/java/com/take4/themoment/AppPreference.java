package com.take4.themoment;

import javax.inject.Inject;
import javax.inject.Singleton;

import android.content.Context;
import com.take4.themoment.base.BasePreference;

/**
 * Created by jaehyunpark on 2018. 2. 11..
 */

@Singleton
public class AppPreference extends BasePreference {
	private static final String ACTIVE_NAVIGATION_ITEM_ID = "active_navigation_item_id";

	@Inject
	public AppPreference(Context context) {
		preferences = context.getSharedPreferences(
			PreferenceType.APP_PREFERENCE.getName(), Context.MODE_PRIVATE);
	}

	public void setActiveNavigationItemId(String id) {
		putString(ACTIVE_NAVIGATION_ITEM_ID, id);
	}

	public String getActiveNavigationItemId() {
		return getString(ACTIVE_NAVIGATION_ITEM_ID);
	}
}
