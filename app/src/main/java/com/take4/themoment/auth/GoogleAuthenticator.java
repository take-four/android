package com.take4.themoment.auth;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.GoogleAuthProvider;
import com.take4.themoment.AppComponentContainer;
import com.take4.themoment.R;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
public class GoogleAuthenticator extends FirebaseAuthenticator {
	private GoogleApiClient googleApiClient;
	private String idToken;

	@Override
	public void signIn(Activity activity) {
		initGoogleApiClient(activity);
		Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
		activity.startActivityForResult(signInIntent, AccountRequestCode.EXTERNAL_ACCOUNT_GOOGLE.getCode());
	}

	private void initGoogleApiClient(Activity activity) {
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
			requestJwtToken();
		}
		cleanUp();
	}

	@Override
	AuthCredential getAuthCredential() {
		if (idToken == null) {
			log.debug("Couldn't get google id token.");
			return null;
		}
		return GoogleAuthProvider.getCredential(idToken, null);
	}

	private void cleanUp() {
		if (googleApiClient.isConnected()) {
			Auth.GoogleSignInApi.signOut(googleApiClient);
		}
		googleApiClient.disconnect();
	}

	private String getClientId() {
		return AppComponentContainer.get().getApplicationContext().getString(R.string.default_web_client_id);
	}
}
