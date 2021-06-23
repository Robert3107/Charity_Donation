package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.repository.CategoryRepository;

import java.util.List;

@Controller
@RequestMapping("/form")
public class FormController {

    private final CategoryRepository categoryRepository;

    public FormController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/1")
    public String formStepOne(Model model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "form";
    }

    @PostMapping("/1")
    public String formStepOnePost(Model model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("categories", categoryList);
        return "form";
    }

}
