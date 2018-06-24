package main.java.com.purchase_bounded_context.domain_services;

import com.infrastructure.DTOs.PurchaseDTO;
import com.purchase_bounded_context.entities.Purchase;
import com.purchase_bounded_context.repositories.PurchaseRepository;
import com.purchase_bounded_context.entities.PurchasedArticle;
import com.user_bounded_context.entitites.Customer;
import com.articles_bounded_context.repositories.ArticleRepository;
import com.user_bounded_context.repositories.UserRepository;
import com.user_bounded_context.value_objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseDomainServiceImpl implements PurchaseDomainService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Purchase makePurchase(PurchaseDTO purchaseDTO) {
        ArrayList<PurchasedArticle> items = new ArrayList<>();

        for(int i = 0; i < purchaseDTO.getArticlesBought().size(); i++){
            Long itemID = purchaseDTO.getArticlesBought().get(i);
            Integer itemCount = purchaseDTO.getArticlesCount().get(i);

            PurchasedArticle newArticle = new PurchasedArticle(itemID, itemCount);
            items.add(newArticle);
        }

        Customer customer = userRepository.findCustomer(new Email(purchaseDTO.getUserEmail()));
        Purchase newPurchase = new Purchase(items, customer);

        Purchase retPurchase = purchaseRepository.save(newPurchase);
        return retPurchase;
    }
}
