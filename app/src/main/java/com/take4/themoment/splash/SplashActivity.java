package com.take4.themoment.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.take4.themoment.R;

/**
 * Created by jaehyunpark on 2017. 12. 26..
 */
public class SplashActivity extends AppCompatActivity {

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, SplashActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		delayTime();
	}

	public void delayTime() {
		Handler handler = new Handler();
		handler.postDelayed(() -> {
			setResult(Activity.RESULT_OK);
			finish();
		}, 2000);
	}
}
