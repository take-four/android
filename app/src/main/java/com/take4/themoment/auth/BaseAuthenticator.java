package com.take4.themoment.auth;

import java.util.concurrent.Executors;

import android.util.Log;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

public abstract class BaseAuthenticator {
	private static final String TAG = BaseAuthenticator.class.getSimpleName();

	abstract AuthCredential getAuthCredential();

	abstract void signIn();

	public void authorizeFromFirebase() {
		FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
		firebaseAuth.signInWithCredential(getAuthCredential())
			.addOnCompleteListener(Executors.newSingleThreadExecutor(), task -> {
				if (task.isSuccessful()) {
					FirebaseUser user = firebaseAuth.getCurrentUser();
					Log.d(TAG, "signInWithCredential:success", task.getException());
					Log.d(TAG, "User uid : " + user.getUid());
					Log.d(TAG, "User display name : " + user.getDisplayName());
					Log.d(TAG, "User id token : " + user.getIdToken(true));
				} else {
					// If sign in fails, display a message to the user.
					Log.d(TAG, "signInWithCredential:failure", task.getException());
				}
			});
	}
}
