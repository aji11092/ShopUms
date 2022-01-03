package com.ums.service;

public interface IRoleService<T> extends IService<T> {

	T findByName(String name);
}
