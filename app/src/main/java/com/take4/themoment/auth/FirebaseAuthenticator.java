package com.take4.themoment.auth;

import java.util.concurrent.Executors;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.take4.themoment.account.LoginEvent;
import com.take4.themoment.support.bus.EventBusProvider;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

@Slf4j
public abstract class FirebaseAuthenticator {
	abstract AuthCredential getAuthCredential();

	abstract void signIn(Activity activity);

	void requestJwtToken() {
		AuthCredential credential = getAuthCredential();
		FirebaseAuth.getInstance()
			.signInWithCredential(credential)
			.addOnCompleteListener(Executors.newSingleThreadExecutor(), task -> requestUserIdToken())
			.addOnFailureListener(Executors.newSingleThreadExecutor(), task -> log.debug("Authentication was Failed."));
	}

	public static void requestUserIdToken() {
		FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
		if (user != null) {
			user.getIdToken(true)
				.addOnCompleteListener(
					task -> {
						log.debug("FirebaseUtils user id token : {}", task.getResult().getToken());
						EventBusProvider.getInstance().post(new LoginEvent.LogInSucceed(task.getResult().getToken()));
					})
				.addOnFailureListener(
					exception ->
						EventBusProvider.getInstance().post(new LoginEvent.LoginInFailed(exception.toString())));
		}
	}
}
