package com.emiren.landing.Service.Impl;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Mapper.DataMapper;
import com.emiren.landing.Repository.DataRepository;
import com.emiren.landing.Service.DataService;
import com.emiren.landing.Service.ExcelService;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ExcelServiceImpl implements ExcelService {
    private DataService dataService;


    @Autowired
    public ExcelServiceImpl(DataService dataService) throws FileNotFoundException {
        this.dataService = dataService;
    }

    @Override
    public Workbook extractDataToExcel() {

        String[] headers = new String[] {"Id", "Name", "Phone Number", "Mail", "Message"};

        List<DataDTO> data = dataService.getAllData();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data");

        createHeaderRow(workbook, sheet, headers);

        for (int i = 0; i < data.size(); i++){
            int rowIndex = i+1;
            createNewRow(workbook, sheet, rowIndex, data.get(i), headers);
        }

        for (int i = 0; i < headers.length; i++){
            sheet.autoSizeColumn(i);
        }
        return workbook;
    }

    private void createNewRow(Workbook workbook, Sheet sheet, int rowIndex, DataDTO data, String[] headers) {
        Row row = sheet.createRow(rowIndex);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

//        PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(data, P);
//        Method getter = pd.getReadMethod();

//        for (int i = 0; i < headers.length; i++){
//            Cell cell = row.createCell(i);
//        }

        Cell cell = row.createCell(0);
        cell.setCellValue(data.getId());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(1);
        cell.setCellValue(data.getName());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(2);
        cell.setCellValue(data.getNumber());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(3);
        cell.setCellValue(data.getMail());
        cell.setCellStyle(cellStyle);

        cell = row.createCell(4);
        cell.setCellValue(data.getMessage());
        cell.setCellStyle(cellStyle);



    }

    private void createHeaderRow(Workbook workbook, Sheet sheet, String[] headers) {
        Row headerRow = sheet.createRow(0);
        CellStyle headerCellStyle = workbook.createCellStyle();

        headerCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerCellStyle.setBorderTop(BorderStyle.THIN);
        headerCellStyle.setTopBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderRight(BorderStyle.THIN);
        headerCellStyle.setRightBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderBottom(BorderStyle.THIN);
        headerCellStyle.setBottomBorderColor(IndexedColors.BLACK.index);
        headerCellStyle.setBorderLeft(BorderStyle.THIN);
        headerCellStyle.setLeftBorderColor(IndexedColors.BLACK.index);

        for(int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerCellStyle);
        }
    }
}
