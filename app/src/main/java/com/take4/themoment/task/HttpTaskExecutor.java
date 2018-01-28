package com.take4.themoment.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.take4.themoment.api.HttpApiLibrary;
import com.take4.themoment.api.HttpCallback;

/**
 * Created by jaehyunpark on 2018. 1. 11..
 */

public class HttpTaskExecutor {
	private HttpApiLibrary apiLibrary;
	private HttpCallback callback;

	private ExecutorService taskExecutor;

	public HttpTaskExecutor(HttpCallback callback) {
		this.apiLibrary = new HttpApiLibrary();
		this.callback = callback;

		if (taskExecutor == null) {
			taskExecutor = Executors.newFixedThreadPool(3);
		}
	}

	public void requestUserAuthorization() throws Exception {
		taskExecutor.execute(new AuthorizationTask(apiLibrary, callback));
	}
}
