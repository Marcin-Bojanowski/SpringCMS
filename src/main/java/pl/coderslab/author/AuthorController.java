package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class AuthorController {
    private final AuthorService authorService;

    @RequestMapping("/author/add")
    @ResponseBody
    public String saveAuthor() {
        Author author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
        authorService.saveAuthor(author);
        return "dodano autora";
    }
    @RequestMapping("/author/get/{id}")
    @ResponseBody
    public String getAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        return author.toString();
    }

    @RequestMapping("/author/update/{id}")
    @ResponseBody
    public String updateAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        author.setFirstName("Juliusz");
        author.setLastName("Słowacki");
        authorService.update(author);
        return author.toString();
    }

    @RequestMapping("/author/delete/{id}")
    @ResponseBody
    public String deleteAuthor(@PathVariable long id) {
        Author author = authorService.findById(id);
        authorService.delete(author);
        return "deleted";
    }
}