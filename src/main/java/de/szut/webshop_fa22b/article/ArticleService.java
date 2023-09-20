package de.szut.webshop_fa22b.article;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Collection<ArticleEntity> getArticles() {
        // darf der das?
        // enterne aus dem Ergeniss die Artikel die nicht mehr lieferbar sind
        return articleRepository.findAll();
    }
}
