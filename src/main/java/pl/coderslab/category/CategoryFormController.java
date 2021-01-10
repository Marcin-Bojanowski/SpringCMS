package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/category")
public class CategoryFormController {
    public final CategoryService categoryService;

    @GetMapping("/all")
    public String getAll(Model model){
        model.addAttribute("categories",categoryService.getAll());
        return "category/all";
    }

    @GetMapping("/form")
    public String addCategory(Model model){
        model.addAttribute("category",new Category());
        return "category/form";
    }

    @PostMapping("/form")
    public String saveCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "category/form";
        }
        categoryService.save(category);
        return "redirect:/category/all";
    }

    @GetMapping("/edit")
    public String editCategory(@RequestParam long id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "category/form";
    }

    @PostMapping("/edit")
    public String updateCategory(@Valid Category category, BindingResult result){
        if (result.hasErrors()){
            return "category/form";
        }
        categoryService.update(category);
        return "redirect:/category/all";
    }

    @GetMapping("/delete")
    public String deleteCategory(@RequestParam long id){
        categoryService.delete(categoryService.findById(id));
        return "redirect:/category/all";
    }
}
