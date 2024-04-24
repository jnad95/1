package com.adityaja.clients.notification;

public record NotificationRequest(String customerName,
                                  String customerEmail,
                                  String message) {
}
