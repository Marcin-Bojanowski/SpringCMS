package pl.coderslab.author;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/author")
public class AuthorFormController {
    public final AuthorService authorService;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("authors", authorService.getAll());
        return "author/all";
    }

    @GetMapping("/form")
    public String addAuthor(Model model){
        model.addAttribute("author", new Author());
        return "author/form";
    }

    @PostMapping("/form")
    public String saveAuthor(@Valid Author author, BindingResult result){
        if (result.hasErrors()){
            return "author/form";
        }
        authorService.saveAuthor(author);
        return "redirect:/author/all";
    }

    @GetMapping ("/edit")
    public String editAuthor(@RequestParam long id, Model model ){
        model.addAttribute("author", authorService.findById(id));
        return "author/form";
    }

    @PostMapping("/edit")
    public String updateAuthor(@Valid Author author, BindingResult result){
        if (result.hasErrors()){
            return "author/form";
        }
        authorService.update(author);
        return "redirect:/author/all";
    }

    @GetMapping("/delete")
    public String deleteAuthor(@RequestParam long id){
        authorService.delete(authorService.findById(id));
     return "redirect:/author/all";
    }
}
