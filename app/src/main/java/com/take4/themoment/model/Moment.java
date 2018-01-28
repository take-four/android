package com.take4.themoment.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaehyunpark on 2018. 1. 10..
 */

public class Moment {

	@SerializedName("cityId")
	String cityId;

	@SerializedName("createDate")
	int createDate;

	@SerializedName("description")
	String description;

	@SerializedName("id")
	int id;

	@SerializedName("photo")
	String photo;

	@SerializedName("placeId")
	String placeId;

	@SerializedName("user")
	User user;
}
