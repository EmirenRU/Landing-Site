package com.emiren.landing.Service.Impl;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Model.Data;
import com.emiren.landing.Repository.DataRepository;
import com.emiren.landing.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.emiren.landing.mapper.DataMapper.mapToData;

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
    public void extractDataToExcel() {

    }
}
