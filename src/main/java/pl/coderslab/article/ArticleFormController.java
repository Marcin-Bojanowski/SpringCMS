package pl.coderslab.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryService;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/article")
public class ArticleFormController {
    public final ArticleService articleService;
    public final CategoryService categoryService;
    public final AuthorService authorService;
    private Timestamp created;

    @ModelAttribute("authors")
    public List<Author> getAllAuthors() {
        return authorService.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/form")
    public String addArticle(Model model) {
        model.addAttribute("article", new Article());
        return "article/form";
    }

    @PostMapping("/form")
    public String saveArticle(@Valid Article article, BindingResult result) {
        if (result.hasErrors()){
            return "article/form";
        }
        articleService.save(article);
        return "redirect:/article/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("articles", articleService.getAllWithCategories());
        return "article/all";
    }

    @GetMapping("/edit")
    public String editArticle(@RequestParam long id, Model model) {
        Article article=articleService.findByIdWithCategory(id);
        created=article.getCreated();
        model.addAttribute("article", article);
        return "article/form";
    }

    @PostMapping("/edit")
    public String updateArticle(@Valid Article article, BindingResult result) {
        if (result.hasErrors()){
            return "article/form";
        }
        article.setCreated(created);
        articleService.update(article);
        return "redirect:/article/all";


    }

    @GetMapping("/delete")
    public String deleteArticle(@RequestParam long id) {
        articleService.delete(articleService.findByIdWithCategory(id));
        return "redirect:/article/all";
    }
}
