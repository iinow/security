package com.ha.init;

import org.springframework.stereotype.Component;

import com.ha.entity.UserModel;

@Component
public class DataInitializer {

	public void init() {
		UserModel user = new UserModel();
	}
}
