package com.example.tourschedulerapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmailService {
    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.chat-id}")
    private String chatId;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendNotification(String message) {
        try {
            String url = String.format("https://api.telegram.org/bot%s/sendMessage", botToken);
            Map<String, String> params = new HashMap<>();
            params.put("chat_id", chatId);
            params.put("text", message);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> request = new HttpEntity<>(params, headers);
            restTemplate.postForEntity(url, request, String.class);
        } catch (Exception e) {
            System.err.println("Ошибка при отправке сообщения в Telegram: " + e.getMessage());
        }
    }

}
