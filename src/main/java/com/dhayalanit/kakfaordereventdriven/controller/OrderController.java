package com.dhayalanit.kakfaordereventdriven.controller;

import com.dhayalanit.kakfaordereventdriven.entity.PurchaseOrder;
import com.dhayalanit.kakfaordereventdriven.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping("/all")
    public List<PurchaseOrder> getAllOrders() {
        return purchaseOrderService.getPurchasedOrders();
    }

    @PostMapping("/create")
    public void createOrder(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.createPurchasedOrder(purchaseOrder);
    }

}
