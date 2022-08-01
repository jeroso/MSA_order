package dev.practice.order.domain.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


public interface NotificationService {
    void sendEmail(String email, String title, String description);

    void sendKakao(String phoneNo, String description);

    void sendSms(String phoneNo, String description);
}
