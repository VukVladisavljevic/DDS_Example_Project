package main.java.com.purchase_bounded_context.domain_services;

import com.infrastructure.DTOs.PurchaseDTO;
import com.purchase_bounded_context.entities.Purchase;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseDomainService {

    Purchase makePurchase(PurchaseDTO purchaseDTO);
}
