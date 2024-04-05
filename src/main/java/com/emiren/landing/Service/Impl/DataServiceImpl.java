package com.emiren.landing.Service.Impl;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Mapper.DataMapper;
import com.emiren.landing.Model.Data;
import com.emiren.landing.Repository.DataRepository;
import com.emiren.landing.Service.DataService;
import jakarta.validation.metadata.PropertyDescriptor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import static com.emiren.landing.Mapper.DataMapper.mapToData;

@Service
public class DataServiceImpl implements DataService {
    private DataRepository dataRepository;
    @Autowired
    public DataServiceImpl(DataRepository dataRepository){ this.dataRepository = dataRepository; }

    @Override
    public boolean isValidPhoneNumber(String phoneNumber){
        return phoneNumber.matches("\\+7|8[0-9]{10}");
    }

    @Override
    public boolean isValidEmail(String email) {
        return email.matches("[a-z0-9]+@[a-z]+\\.[a-z]{2,}");
    }

    @Override
    public Data saveData(DataDTO dataDto) {
        Data data = mapToData(dataDto);
        return dataRepository.save(data);
    }

    @Override
    public List<DataDTO> getAllData() {
        return dataRepository.findAll()
                .stream()
                .map(DataMapper::mapToDataDto)
                .collect(Collectors.toList());
    }
}
