package pl.coderslab.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    @RequestMapping("/category/add")
    @ResponseBody
    public String saveCategory(){
        Category category=new Category();
        category.setName("popularno-naukowy");
        category.setDescription("description");
        categoryService.save(category);
        return category.toString();
    }

    @RequestMapping("/category/get/{id}")
    @ResponseBody
    public String getCategory(@PathVariable long id){
        Category category=categoryService.findById(id);
        return category.toString();
    }

    @RequestMapping("/category/update/{id}")
    @ResponseBody
    public String updateCategory(@PathVariable long id){
        Category category=categoryService.findById(id);
        category.setName("naukowy");
        categoryService.update(category);
        return category.toString();
    }

    @RequestMapping("category/delete/{id}")
    @ResponseBody
    public String deleteCategory(@PathVariable long id){
        Category category=categoryService.findById(id);
        categoryService.delete(category);
        return "deleted";
    }
}
