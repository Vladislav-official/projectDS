package com.devglan.userportal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPortalApplicationTests {

	@Autowired
	UserService userService;

	@Test
	public void contextLoads() {
		User user = new User();
		user.setFirstName("firstname");
		user.setLastName("lastname");
		user.setEmail("email");

		Assert.assertEquals(userService.create(user), user);
	}

	@Test
	public void contextEdit() {
		User user = new User();
		user.setFirstName("firstname");
		user.setLastName("lastname");
		user.setEmail("email");

		Assert.assertEquals(userService.update(user), user);
	}

}
