package com.dhayalanit.kakfaordereventdriven.service;

import com.dhayalanit.kakfaordereventdriven.entity.PurchaseOrder;

import java.util.List;

public interface PurchaseOrderService {
    List<PurchaseOrder> getPurchasedOrders();
    void createPurchasedOrder(PurchaseOrder purchaseOrder);
}
