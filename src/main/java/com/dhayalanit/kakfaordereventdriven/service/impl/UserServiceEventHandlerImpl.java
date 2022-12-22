package com.dhayalanit.kakfaordereventdriven.service.impl;

import com.dhayalanit.kakfaordereventdriven.entity.PurchaseOrder;
import com.dhayalanit.kakfaordereventdriven.entity.User;
import com.dhayalanit.kakfaordereventdriven.repository.PurchaseOrderRepository;
import com.dhayalanit.kakfaordereventdriven.service.UserServiceEventHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserServiceEventHandlerImpl implements UserServiceEventHandler {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @KafkaListener(topics = "user-service-event")
    public void consume(String UserStr) {
        try {
            User user = OBJECT_MAPPER.readValue(UserStr, User.class);
            log.info("Dhayalan {}", user.toString());
            this.updateUser(user);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateUser(User user) {
       List<PurchaseOrder> userOrders = purchaseOrderRepository.findByUserId(user.getId());
       userOrders.forEach(p -> p.setUser(user));
        purchaseOrderRepository.saveAll(userOrders);
    }
}
