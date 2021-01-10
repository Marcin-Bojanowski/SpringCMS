package pl.coderslab.home;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.article.ArticleService;

@RequiredArgsConstructor
@Controller
public class HomePageController {

    public final ArticleService articleService;

    @GetMapping("/")
    public String getLastFive(Model model){
        model.addAttribute("lastFive",articleService.getLastFive());
        return "home/home";
    }
}
