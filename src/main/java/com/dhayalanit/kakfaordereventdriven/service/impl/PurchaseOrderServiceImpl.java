package com.dhayalanit.kakfaordereventdriven.service.impl;

import com.dhayalanit.kakfaordereventdriven.entity.PurchaseOrder;
import com.dhayalanit.kakfaordereventdriven.repository.PurchaseOrderRepository;
import com.dhayalanit.kakfaordereventdriven.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getPurchasedOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void createPurchasedOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
    }
}
