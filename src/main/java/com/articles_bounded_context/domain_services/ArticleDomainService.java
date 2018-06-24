package main.java.com.articles_bounded_context.domain_services;

import com.infrastructure.DTOs.ArticleDTO;
import com.articles_bounded_context.entities.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ArticleDomainService {

    Article addArticle(ArticleDTO articleDTO);

    Article removeArticle(ArticleDTO articleDTO);

    ArrayList<Article> getAll();

}
