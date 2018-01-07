package com.take4.themoment.auth;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
public class GoogleAuthenticator extends BaseAuthenticator {

	private final Activity activity;

	private GoogleApiClient googleApiClient;

	private String idToken;

	public GoogleAuthenticator(Activity activity) {
		this.activity = activity;

		initGoogleApiClient();
	}

	private void initGoogleApiClient() {
		googleApiClient = new GoogleApiClient.Builder(activity)
			.addApi(Auth.GOOGLE_SIGN_IN_API, initGoogleSignInOption())
			.build();
	}

	private GoogleSignInOptions initGoogleSignInOption() {
		return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
			.requestIdToken(getClientId())
			.requestEmail()
			.build();
	}

	@Override
	public void signIn() {
		Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
		activity.startActivityForResult(signInIntent, AccountRequestCode.EXTERNAL_ACCOUNT_GOOGLE.getCode());
	}

	public void onActivityResult(Intent data) {
		GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
		handleSignInResult(result);
	}

	private void handleSignInResult(GoogleSignInResult result) {
		GoogleSignInAccount account = result.getSignInAccount();

		if (account == null) {
			return;
		}

		if (!result.isSuccess()) {
			// TODO: 2018. 1. 6. error 처리
		} else {
			idToken = account.getIdToken();
			authorizeFromFirebase();
		}
		cleanUp();
	}

	@Override
	AuthCredential getAuthCredential() {
		if (idToken == null) {
			log.debug("Couldn't get id token.");
			return null;
		}
		return FacebookAuthProvider.getCredential(idToken);
	}

	private void cleanUp() {
		if (googleApiClient.isConnected()) {
			Auth.GoogleSignInApi.signOut(googleApiClient);
		}
		googleApiClient.disconnect();
	}

	private String getClientId() {
		return AccountClientInfo.GOOGLE_SERVER_CLIENT_ID;
	}
}
