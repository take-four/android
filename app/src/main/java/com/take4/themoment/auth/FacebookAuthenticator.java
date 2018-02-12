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
public class FacebookAuthenticator {
	private static final String EMAIL = "email";
	private static final String PERMISSION_PUBLIC_PROFILE = "public_profile";

	private String accessToken;

	private CallbackManager callbackManager;

	private FacebookCallback<LoginResult> facebookCallback = new FacebookCallback<LoginResult>() {
		@Override
		public void onSuccess(LoginResult loginResult) {
			accessToken = loginResult.getAccessToken().getToken();
			FirebaseAuthUtils.requestJwtToken(getAuthCredential());
		}

		@Override
		public void onCancel() {
			log.debug("facebook:onCancel :");
		}

		@Override
		public void onError(FacebookException error) {
			log.debug("facebook:onError", error);
		}
	};

	public void signIn(Activity activity) {
		callbackManager = CallbackManager.Factory.create();
		LoginButton loginButton = activity.findViewById(R.id.btn_facebook_login);
		loginButton.setReadPermissions(EMAIL, PERMISSION_PUBLIC_PROFILE);
		loginButton.registerCallback(callbackManager, facebookCallback);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}

	private AuthCredential getAuthCredential() {
		if (accessToken == null) {
			log.debug("Couldn't get access token.");
			return null;
		}
		return FacebookAuthProvider.getCredential(accessToken);
	}
}
