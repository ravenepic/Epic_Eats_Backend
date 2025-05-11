package com.epic.eats.portal.services.impl;

import com.epic.eats.portal.dtos.OrderDTO;
import com.epic.eats.portal.entities.PaymentEntity;
import com.epic.eats.portal.entities.PaymentStatus;
import com.epic.eats.portal.kafka.PaymentServiceKafkaPublisher;
import com.epic.eats.portal.repositories.PaymentRepository;
import com.epic.eats.portal.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentServiceKafkaPublisher paymentServiceKafkaPublisher;

    @Override
    public void processPayment(OrderDTO orderDTO) {
        PaymentEntity paymentEntity = PaymentEntity.builder()
                .paymentStatus(PaymentStatus.PAYMENT_SUCCESS)
                .transactionId(orderDTO.getTransactionId())
                .username(orderDTO.getUsername())
                .txnDateAndTime(LocalDateTime.now())
                .build();
        this.paymentRepository.save(paymentEntity);
        this.paymentServiceKafkaPublisher.publishOrderDetailsToOrdersTopic(orderDTO);
    }
}
