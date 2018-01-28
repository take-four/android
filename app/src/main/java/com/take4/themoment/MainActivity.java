package com.take4.themoment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.take4.themoment.base.BaseActivity;

/**
 * Created by jaehyunpark on 2018. 1. 21..
 */

public class MainActivity extends BaseActivity {

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, MainActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
}
