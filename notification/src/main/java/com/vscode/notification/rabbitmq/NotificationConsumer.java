package com.vscode.notification.rabbitmq;

import com.vscode.clients.notification.NotificationRequest;
import com.vscode.notification.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.management.Notification;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;
    @RabbitListener(queues="${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed {} from queue",notificationRequest);
        notificationService.send(notificationRequest);
    }
}
