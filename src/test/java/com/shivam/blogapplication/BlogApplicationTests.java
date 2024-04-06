package com.shivam.blogapplication;

import com.shivam.blogapplication.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
	private UserRepo userRepo;
	@Test
	void contextLoads() {
	}
	@Test
	public void repoTest(){

		//using reflection api to get class and package name

		String className = userRepo.getClass().getName();
		String packageName = userRepo.getClass().getPackageName();
		System.out.println(className+"#==#"+packageName);

	}

}
