package com.take4.themoment.api;

import java.io.IOException;

import com.take4.themoment.AppComponentContainer;
import com.take4.themoment.account.AccountPreference;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jaehyunpark on 2018. 1. 11..
 */

public class HttpInterceptor implements Interceptor {
	private static final String ID_TOKEN = "Authorization";

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request originalRequest = chain.request();
		Request requestWithUserAgent = originalRequest.newBuilder()
			.addHeader(ID_TOKEN, getIdToken())
			.build();

		return chain.proceed(requestWithUserAgent);
	}

	private String getIdToken() {
		AccountPreference accountPreference =
			new AccountPreference(AppComponentContainer.get().getApplicationContext());
		return accountPreference.getUserIdToken();
	}
}
