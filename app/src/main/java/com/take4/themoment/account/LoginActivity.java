package com.take4.themoment.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.take4.themoment.R;
import com.take4.themoment.auth.AccountRequestCode;
import com.take4.themoment.auth.FacebookAuthenticator;
import com.take4.themoment.auth.GoogleAuthenticator;
import com.take4.themoment.base.BaseActivity;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
public class LoginActivity extends BaseActivity {
	private GoogleAuthenticator googleAuthenticator;
	private FacebookAuthenticator facebookAuthenticator;

	@OnClick(R.id.btn_google_login)
	public void onClickGoogleLoginBtn() {
		showGoogleLogin();
	}

	@OnClick(R.id.btn_facebook_login)
	public void onClickFaceBookLoginBtn() {
		showFacebookLogin();
	}

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, LoginActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ButterKnife.bind(this);
	}

	private void showGoogleLogin() {
		googleAuthenticator = new GoogleAuthenticator(this);
		googleAuthenticator.signIn();
	}

	private void showFacebookLogin() {
		facebookAuthenticator = new FacebookAuthenticator(this);
		facebookAuthenticator.signIn();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != Activity.RESULT_OK) {
			log.debug("Login failed.");
			log.debug("requestCode : {}", requestCode);
			log.debug("resultCode : {}", resultCode);
			log.debug("data : {}", data);
			return;
		}

		if (requestCode == AccountRequestCode.EXTERNAL_ACCOUNT_GOOGLE.getCode()) {
			log.debug("Google login success");
			googleAuthenticator.onActivityResult(data);

		} else if (requestCode == AccountRequestCode.EXTERNAL_ACCOUNT_FACEBOOK.getCode()) {
			log.debug("Facebook login success");
			facebookAuthenticator.onActivityResult(requestCode, resultCode, data);
		}

		resultToActivity();
	}

	private void resultToActivity() {
		setResult(Activity.RESULT_OK);
		finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}
}
