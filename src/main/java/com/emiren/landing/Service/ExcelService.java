package com.emiren.landing.Service;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface ExcelService {
    public Workbook extractDataToExcel();

}
