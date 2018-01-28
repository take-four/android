package com.take4.themoment.api;

import java.util.List;

import com.take4.themoment.model.Moment;
import com.take4.themoment.model.User;
import retrofit2.Call;

/**
 * Created by jaehyunpark on 2018. 1. 10..
 */

public class HttpApiClient {

	private HttpApi api;

	public HttpApiClient(HttpApi api) {
		this.api = api;
	}

	public Call<User> getUser() {
		return api.getUser();
	}

	public Call<List<Moment>> getMoments(int userId, long latitude, long longitude) {
		return api.getMoments(userId, latitude, longitude);
	}
}
