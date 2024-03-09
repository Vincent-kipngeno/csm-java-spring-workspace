package tech.csm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.csm.model.Crop;
import tech.csm.model.Season;

import java.util.ArrayList;

@Controller
public class InsuranceController {

    @GetMapping("/getInsuranceForm")
    public String displayInsuranceForm(Model model) {
        model.addAttribute("seasons", new ArrayList<Season>());
        return "insuranceform"; // Name of your JSP file
    }
}

