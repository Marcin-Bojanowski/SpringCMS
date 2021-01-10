package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.article.ArticleService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CategoryService {
    private final CategoryDao categoryDao;
    private final ArticleService articleService;

    public void save(Category category) {
        categoryDao.save(category);
    }

    public Category findById(long id) {
        return categoryDao.findById(id);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public void delete(Category category) {
        articleService.getByCategory(category.getId()).
                forEach(article -> {
                    article.getCategories().removeIf(category1 -> category1.getId() == category.getId());
                    articleService.update(article);
                });

        categoryDao.delete(category);
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
