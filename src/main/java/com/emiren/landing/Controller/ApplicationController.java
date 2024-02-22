package com.emiren.landing.Controller;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Model.Data;
import com.emiren.landing.Service.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ApplicationController {
    private DataService dataService;

    @Autowired
    public ApplicationController(DataService dataService){
        this.dataService = dataService;
    }

    @GetMapping("")
    public String main(){

        return "redirect:/new";
    }

    @GetMapping("/new")
    public String createDataForm(Model model){
        Data data = new Data();
        model.addAttribute("data", data);
        return "index";
    }

    @PostMapping("/new")
    public String saveData(@Valid @ModelAttribute("data") DataDTO dataDto, BindingResult result, Model model){
        if (result.hasErrors() && !dataService.isValidEmail(dataDto.getMail())){
            model.addAttribute("data", dataDto);
            return "index";
        }

        dataService.saveData(dataDto);
        return "index";
    }


}
