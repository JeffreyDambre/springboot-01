package com.example.demo4.ws;

import com.example.demo4.domain.model.Notification;
import com.example.demo4.domain.dao.NotificationDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "notification")
public class NotificationWS {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationWS.class);
    private  NotificationDAO notificationDAO;

    @Autowired
    public NotificationWS(NotificationDAO notificationDAO) {
          this.notificationDAO = notificationDAO;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{notificationId}")
    public Notification getNotification(@PathVariable int notificationId) {
        List<Notification> all = notificationDAO.findAll();
        all.forEach(n->LOGGER.info("{}", n));
        LOGGER.info("you requested notification with {}", notificationId);

        Optional<Notification> notification = notificationDAO.findById(notificationId);
        if (notification.isPresent()){
            return notification.get();
        }
        return null;
    }
}
