package com.emiren.landing.Service;

import java.io.IOException;

public interface ExcelService {

    public void writeToExcel();
    public boolean isCreated() throws IOException;
    public void createExcelFile();
}
