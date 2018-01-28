package com.take4.themoment.api;

import java.util.List;

import android.util.Log;
import com.take4.themoment.AppComponentContainer;
import com.take4.themoment.model.Moment;
import com.take4.themoment.model.User;
import com.take4.themoment.task.SyncExecutor;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jaehyunpark on 2018. 1. 15..
 */

public class HttpApiLibrary {

	private HttpApiClient apiClient;

	public HttpApiLibrary() {
		this.apiClient = AppComponentContainer.get().getHttpApiClient();
	}

	public User getUser() throws Exception {
		Call<User> call = apiClient.getUser();

		SyncExecutor<User> executor = new SyncExecutor<>();
		Response<User> callResponse = executor.execute(call);
		User user = callResponse.body();
		if(user == null) {
			return null;
		}
		return user;
	}

	public Call<List<Moment>> getMoments(int userId, long latitude, long longitude) {
		return null;
	}
}
