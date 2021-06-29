package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/donation")
public class DonationController {

    private final CategoryRepository categoryRepository;
    private final DonationRepository donationRepository;
    private final InstitutionRepository institutionRepository;


    @GetMapping("/create")
    public String createDonation(Model model) {

        List<Category> categoryList = categoryRepository.findAll();
        List<Institution> institutionList = institutionRepository.findAll();

        model.addAttribute("categories", categoryList);
        model.addAttribute("institutions", institutionList);
        model.addAttribute("donation", new Donation());

        return "form";
    }

    @PostMapping("/create")
    public String createDonationPost(@ModelAttribute @Valid Donation donation, BindingResult violations) {
        if (violations.hasErrors()) {
            return "errorform";
        }

        donationRepository.save(donation);
        return "form-confirmation";
    }

}

