package com.adityaja.notification;

import com.adityaja.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final String SENDER = "adityaja@amazon.com";

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .customerName(notificationRequest.customerName())
                        .customerEmail(notificationRequest.customerEmail())
                        .message(notificationRequest.message())
                        .sender(SENDER)
                        .sentAt(LocalDateTime.now())
                        .build());
    }
}
