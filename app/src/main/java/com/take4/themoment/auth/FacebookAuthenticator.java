package com.take4.themoment.auth;

import android.app.Activity;
import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.take4.themoment.R;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 7..
 */

@Slf4j
public class FacebookAuthenticator extends BaseAuthenticator {

	private final Activity activity;
	private String accessToken;

	private CallbackManager mCallbackManager;

	public FacebookAuthenticator(Activity activity) {
		this.activity = activity;
	}

	@Override
	public void signIn() {
		mCallbackManager = CallbackManager.Factory.create();
		LoginButton loginButton = activity.findViewById(R.id.btn_facebook_login);
		loginButton.setReadPermissions("email", "public_profile");
		loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
			@Override
			public void onSuccess(LoginResult loginResult) {
				log.debug("facebook:onSuccess : {}", loginResult);
				accessToken = loginResult.getAccessToken().getToken();
				authorizeFromFirebase();
			}

			@Override
			public void onCancel() {
				log.debug("facebook:onCancel :");
			}

			@Override
			public void onError(FacebookException error) {
				log.debug("facebook:onError", error);
			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		mCallbackManager.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	AuthCredential getAuthCredential() {
		if (accessToken == null) {
			log.debug("Couldn't get access token.");
			return null;
		}
		return FacebookAuthProvider.getCredential(accessToken);
	}
}
