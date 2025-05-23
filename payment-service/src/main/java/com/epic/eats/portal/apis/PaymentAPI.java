package com.epic.eats.portal.apis;

import com.epic.eats.portal.dtos.OrderDTO;
import com.epic.eats.portal.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentAPI {

    private final PaymentService paymentService;

    @PostMapping
    public void createPayment(@RequestBody OrderDTO orderDTO){
        log.info("Entered into PaymentAPI with data : "+orderDTO);
        this.paymentService.processPayment(orderDTO);
    }

}
