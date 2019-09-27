package com.example.demo4.domain.dao;

import com.example.demo4.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationDAO extends JpaRepository<Notification, Integer> {
}


