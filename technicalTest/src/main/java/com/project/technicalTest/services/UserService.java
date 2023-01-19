package com.project.technicalTest.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.technicalTest.models.User;
import com.project.technicalTest.repository.UserRepository;

import exceptions.NotEligibleException;
import exceptions.RequiredFieldsException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserService implements IUserService {

	ArrayList<String> franceL = new ArrayList<String>(Arrays.asList("fr", "france"));

	@Autowired
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User createUser(User user) throws NotEligibleException {

		if (user != null && user.getUserName() != null && !user.getUserName().trim().isEmpty()
				&& user.getBirthdate() != null && user.getResidence() != null
				&& !user.getResidence().trim().isEmpty()) {
			LocalDate birthdate = user.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			if (Period.between(birthdate, LocalDate.now()).getYears() >= 18
					&& franceL.contains(user.getResidence().trim().toLowerCase())) {
				return userRepository.save(user);
			} else {
				throw new NotEligibleException("User " + user.getUserName() + " is not elligible for registering!");
			}
		} else {
			throw new RequiredFieldsException("Username, birthdate and country of residence are mandatory!");
		}

	}

	@Override
	public Optional<User> getUserById(Long id) {
		Optional<User> userDetails = userRepository.findById(id);
		return userDetails;
	}
}
