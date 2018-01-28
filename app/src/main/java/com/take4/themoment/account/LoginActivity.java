package com.take4.themoment.account;

import javax.inject.Inject;

import org.joda.time.DateTime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.android.gms.common.SignInButton;
import com.squareup.otto.Subscribe;
import com.take4.themoment.R;
import com.take4.themoment.auth.AccountRequestCode;
import com.take4.themoment.auth.FacebookAuthenticator;
import com.take4.themoment.auth.GoogleAuthenticator;
import com.take4.themoment.base.BaseActivity;
import com.take4.themoment.support.bus.EventBusProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
public class LoginActivity extends BaseActivity {
	private Subscriber subscriber = new Subscriber();

	@Inject
	AccountPreference accountPreference;

	@BindView(R.id.btn_google_login)
	SignInButton googleLoginButton;

	@OnClick(R.id.btn_google_login)
	public void onClickGoogleLoginBtn() {
		showGoogleLogin();
	}

	@OnClick(R.id.btn_facebook_login)
	public void onClickFaceBookLoginBtn() {
		showFacebookLogin();
	}

	private GoogleAuthenticator googleAuthenticator;
	private FacebookAuthenticator facebookAuthenticator;

	public static Intent createIntent(@NonNull Activity activity) {
		Intent intent = new Intent(activity, LoginActivity.class);
		return intent;
	}

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		EventBusProvider.registerSafely(subscriber);

		ButterKnife.bind(this);

		initGoogleLoginButton();
	}

	private void initGoogleLoginButton() {
		TextView textView = (TextView)googleLoginButton.getChildAt(0);
		textView.setText(getString(R.string.google_login_text));
		textView.setPadding(0, 0, 1, 0);
		textView.setTextSize(getResources().getDimension(R.dimen.login_text_size));
		textView.setTextColor(ContextCompat.getColor(getApplication(), R.color.black));
	}

	private void showGoogleLogin() {
		googleAuthenticator = new GoogleAuthenticator();
		googleAuthenticator.signIn(this);
	}

	private void showFacebookLogin() {
		facebookAuthenticator = new FacebookAuthenticator();
		facebookAuthenticator.signIn(this);
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
	}

	private void saveIdTokenAndExpiration(String userIdToken) {
		accountPreference.putUserIdToken(userIdToken);
		accountPreference.putUserIdTokenExpiration(DateTime.now());
	}

	private void resultToActivity() {
		setResult(Activity.RESULT_OK);
		finish();
	}

	@Override
	public void onBackPressed() {
	}

	@Override
	protected void onDestroy() {
		EventBusProvider.unregisterSafely(subscriber);
		super.onDestroy();
	}

	class Subscriber {
		@Subscribe
		public void onReceiveLoginInSucceed(LoginEvent.LogInSucceed event) {
			log.debug("LoginActivity#onReceiveLoginInSucceed");
			saveIdTokenAndExpiration(event.getUserIdToken());
			resultToActivity();
		}
	}
}
