package com.project.technicalTest.services;

import java.util.List;
import java.util.Optional;

import com.project.technicalTest.models.User;

public interface IUserService {
	public List<User> getUsers();

	public User createUser(User user);

	public Optional<User> getUserById(Long id);

}
