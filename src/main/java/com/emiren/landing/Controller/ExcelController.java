package com.emiren.landing.Controller;

import com.emiren.landing.Model.Data;
import com.emiren.landing.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalTime;

@Controller
@RequestMapping("/excel/download")
public class ExcelController {

    private DataRepository dataRepository;

    @GetMapping("")
    public String preparationToExtractDataToExcel(){
        LocalTime localTime = LocalTime.now();


        return "";
    }

    @Autowired
    public ExcelController(DataRepository dataRepository){ this.dataRepository = dataRepository; }



}
