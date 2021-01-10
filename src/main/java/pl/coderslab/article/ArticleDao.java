package pl.coderslab.article;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article) {

        article.setCreated();
        entityManager.persist(article);
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }



    public void update(Article article) {
        article.setUpdated();
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }
    public List<Article> getAll(){
        Query query=entityManager.createQuery("select a from Article a");
        return query.getResultList();
    }

    public List<Article> getLastFive(){
        Query query=entityManager.createQuery("select a from Article a order by a.created desc ");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public List<Article> getByAuthors(Long id){
        Query query=entityManager.createQuery("select a from Article a where a.author.id=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
    public List<Article> getByCategory(Long id){
        Query query=entityManager.createQuery("select a from Article a join fetch a.categories c where c.id=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }
}
