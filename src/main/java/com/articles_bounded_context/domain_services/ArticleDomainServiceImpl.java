package main.java.com.articles_bounded_context.domain_services;

import com.infrastructure.DTOs.ArticleDTO;
import com.articles_bounded_context.repositories.ArticleRepository;
import com.articles_bounded_context.entities.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleDomainServiceImpl implements ArticleDomainService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article addArticle(ArticleDTO articleDTO) {
        Article article = articleRepository.findOne(articleDTO.getId());

        if(article == null){
            Article newArticle = articleRepository.save(new Article(articleDTO.getTitle(),
                    articleDTO.getDescription(), articleDTO.getWriter(),
                    articleDTO.getPublishingYear(), articleDTO.getPrice(), articleDTO.getUnits()));

            return newArticle;
        }
        return null;

    }

    @Override
    public Article removeArticle(ArticleDTO articleDTO) {
        Article article = articleRepository.findOne(articleDTO.getId());

        if(article == null){
            return null;
        } else {
            articleRepository.delete(article.getId());

        }
        return null;

    }

    @Override
    public ArrayList<Article> getAll() {
        ArrayList<Article> returned = articleRepository.getAll();
        return returned;
    }
}
