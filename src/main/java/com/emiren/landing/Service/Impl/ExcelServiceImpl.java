package com.emiren.landing.Service.Impl;

import com.emiren.landing.Repository.DataRepository;
import com.emiren.landing.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service

public class ExcelServiceImpl implements ExcelService {
    private DataRepository dataRepository;
//    private FileOutputStream file = new FileOutputStream(new File("contacts.xlsx"));
    private String filePath = "contacts.xlsx";
    private File file = new File(filePath);


    @Autowired
    public ExcelServiceImpl(DataRepository dataRepository) throws FileNotFoundException { this.dataRepository = dataRepository; }

    public boolean isCreated() throws IOException {
        return file.isFile() && file.exists();
    }

    @Override
    public void createExcelFile() {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToExcel() {
        try {
            FileOutputStream file = new FileOutputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}

// Controller -> timer
// this -> writing all data from table to Excel file

