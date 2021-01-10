package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
@Transactional
public class ArticleService {

    private final ArticleDao articleDao;

    public void save(Article article) {
        articleDao.saveArticle(article);
    }

    public Article findById(long id) {
        return articleDao.findById(id);
    }

    public Article findByIdWithCategory(long id) {
        Article article = articleDao.findById(id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    public void update(Article article) {
        articleDao.update(article);
    }

    public void delete(Article article) {
        articleDao.delete(article);
    }

    public List<Article> getAll() {
        return articleDao.getAll();
    }

    public List<Article> getLastFive() {
        List<Article> articles=articleDao.getLastFive();
        articles.forEach(article -> Hibernate.initialize(article.getCategories()));
        return articles;
    }

    public List<Article> getAllWithCategories() {
        List<Article> articles = articleDao.getAll();
        articles.forEach(article -> Hibernate.initialize(article.getCategories()));
        return articles;
    }

    public List<Article> getByAuthors(Long id){
        return articleDao.getByAuthors(id);
    }

    public List<Article> getByCategory(Long id){
        return articleDao.getByCategory(id);
    }
}
