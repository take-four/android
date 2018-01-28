package com.take4.themoment.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.take4.themoment.R;
import dagger.android.AndroidInjection;

/**
 * Created by jaehyunpark on 2017. 12. 26..
 */
public class BaseActivity extends AppCompatActivity {
	private static final int intervalMs = 2000;

	private long backKeyPressedTime = 0;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		AndroidInjection.inject(this);
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		super.onStart();
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
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onBackPressed() {
		if (System.currentTimeMillis() > backKeyPressedTime + intervalMs) {
			backKeyPressedTime = System.currentTimeMillis();
			Toast.makeText(getApplication(), getString(R.string.back_to_exit),Toast.LENGTH_SHORT).show();
			return;
		}

		if (System.currentTimeMillis() <= backKeyPressedTime + intervalMs) {
			finish();
		}
		super.onBackPressed();
	}
}
