package com.ums.service;

import org.springframework.http.ResponseEntity;

import com.ums.model.User;

public interface UserResourceService {

	ResponseEntity<String> register(User user);

	ResponseEntity<String> authenticate(User user);
}
