package main.java.com.purchase_bounded_context;

import com.infrastructure.DTOs.PurchaseDTO;
import com.purchase_bounded_context.domain_services.PurchaseDomainService;
import com.purchase_bounded_context.entities.Purchase;
import com.user_bounded_context.domain_services.UserDomainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value= "api")
public class PurchaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserDomainService userService;

    @Autowired
    private PurchaseDomainService purchaseDomainService;

    @RequestMapping(value = "/purchase",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Purchase> purchase(@RequestBody PurchaseDTO purchaseDTO) {

        logger.info("> make purchase");

        Purchase retPurchase = purchaseDomainService.makePurchase(purchaseDTO);

        if (retPurchase == null) {
            System.out.println(" Purchase not created");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        logger.info("< purchase made");
        System.out.println("purchase successfully created");

        return new ResponseEntity<>(retPurchase, HttpStatus.OK);
    }
}
