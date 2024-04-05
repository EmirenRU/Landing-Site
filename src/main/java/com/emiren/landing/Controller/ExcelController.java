package com.emiren.landing.Controller;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Model.Data;
import com.emiren.landing.Repository.DataRepository;
import com.emiren.landing.Service.DataService;
import com.emiren.landing.Service.ExcelService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/excel/download")
public class ExcelController {
    private DataService dataService;
    private ExcelService excelService;

    @Autowired
    public ExcelController(DataService dataService, ExcelService excelService){
        this.dataService = dataService;
        this.excelService = excelService;
    }

    @GetMapping("")
    public void preparationToExtractDataToExcel(HttpServletResponse response) throws IOException {
        LocalTime localTime = LocalTime.now();
        Workbook workbook = excelService.extractDataToExcel();

        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        response.setHeader("Content-Disposition", "attachment; filename=\"data.xlsx\"");

        workbook.write(response.getOutputStream());
        workbook.close();
    }



}
