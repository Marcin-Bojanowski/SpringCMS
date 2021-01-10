package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.author.AuthorService;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryService;

import java.util.ArrayList;


@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

//    @RequestMapping("/article/add")
//    @ResponseBody
//    public String saveArticle() {
//        Article article = new Article();
//        article.setTitle("przyrodniczy");
//        article.setContent("artykuł przyrodniczy");
//        article.setCreated();
//        article.setAuthor(authorService.findById(1));
//        article.addToCategories(categoryService.findById(1));
//        articleService.save(article);
//        return "Dodano artykuł";
//    }
//
//    @RequestMapping("/article/get/{id}")
//    @ResponseBody
//    public String getArticle(@PathVariable long id){
//        Article article=articleService.findById(id);
//        return article.toString();
//    }
//
//    @RequestMapping("article/update/{id}")
//    @ResponseBody
//    public String updateArticle(@PathVariable long id){
//        Article article=articleService.findById(id);
//        article.setTitle("ekonomiczny");
//        article.setUpdated();
//        articleService.update(article);
//        return article.toString();
//
//    }
//
//    @RequestMapping("article/delete/{id}")
//    @ResponseBody
//    public String deleteArticle(@PathVariable long id){
//        Article article=articleService.findById(id);
//        articleService.delete(article);
//        return "deleted";
//    }
}
