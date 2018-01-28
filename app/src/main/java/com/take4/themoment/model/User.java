package com.take4.themoment.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * Created by jaehyunpark on 2018. 1. 11..
 */

@Data
public class User {

	@SerializedName("email")
	String email;

	@SerializedName("id")
	String id;

	@SerializedName("name")
	String name;
}
