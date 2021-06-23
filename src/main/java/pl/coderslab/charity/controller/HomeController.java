package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;


@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionRepository institutionRepository;
    private final DonationRepository donationRepository;

    public HomeController(InstitutionRepository institutionRepository, DonationRepository donationRepository) {
        this.institutionRepository = institutionRepository;
        this.donationRepository = donationRepository;
    }

    @GetMapping("")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionRepository.findAll());
        model.addAttribute("amountBags", donationRepository.countAllDonatedSacks());
        model.addAttribute("amountDonation", donationRepository.count());
        return "index";
    }

}
