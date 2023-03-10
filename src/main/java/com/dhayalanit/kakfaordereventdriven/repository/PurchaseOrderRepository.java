package com.dhayalanit.kakfaordereventdriven.repository;

import com.dhayalanit.kakfaordereventdriven.entity.PurchaseOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, String> {

    @Query("{'user.id':?0}")
    List<PurchaseOrder> findByUserId(long userId);
}
