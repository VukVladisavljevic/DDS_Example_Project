package main.java.com.articles_bounded_context.repositories;

import com.articles_bounded_context.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM article article" , nativeQuery = true)
    ArrayList<Article> getAll();
}
