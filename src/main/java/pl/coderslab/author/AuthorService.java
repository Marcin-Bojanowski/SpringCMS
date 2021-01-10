package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.article.ArticleService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;
    public final ArticleService articleService;

    public void saveAuthor(Author author) {
        authorDao.saveAuthor(author);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void delete(Author author) {
        articleService.getByAuthors(author.getId())
                .forEach(article -> {
                    article.setAuthor(null);
                    articleService.update(article);
                });
        authorDao.delete(author);
    }

    public List<Author> getAll() {
        return authorDao.getAll();
    }


}