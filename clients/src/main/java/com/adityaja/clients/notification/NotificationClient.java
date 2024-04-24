package com.adityaja.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping(path = "api/v1/send-notification")
    NotificationResponse sendNotification(NotificationRequest notificationRequest);
}
