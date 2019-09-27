package com.example.demo4;

import com.example.demo4.domain.dao.NotificationDAO;
import com.example.demo4.domain.model.Notification;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo4ApplicationTests {

	@Autowired
	private NotificationDAO notificationDAO;

	@Test
	public void contextLoads() {
		Optional<Notification> notification = notificationDAO.findById(1);
		Assertions.assertThat(notification).isNotNull();

		notification = notificationDAO.findById(0);
		Assertions.assertThat(notification).isNull();

		notification = notificationDAO.findById(3);
		Assertions.assertThat(notification).isNull();
	}

}
