package com.take4.themoment.api;

import java.util.List;

import com.take4.themoment.model.Moment;
import com.take4.themoment.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by jaehyunpark on 2018. 1. 10..
 */

public interface HttpApi {

	@POST("users")
	Call<User> getUser();

	@GET("moments")
	Call<List<Moment>> getMoments(
		@Query("userId") int userId,
		@Query("latitude") long latitude,
		@Query("longitude") long longitude);
}
