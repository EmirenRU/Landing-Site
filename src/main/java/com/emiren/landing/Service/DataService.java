package com.emiren.landing.Service;

import com.emiren.landing.Dto.DataDTO;
import com.emiren.landing.Model.Data;
import org.springframework.stereotype.Service;


public interface DataService {
    public boolean isValidPhoneNumber(String phoneNumber);
    public boolean isValidEmail(String email);


    Data saveData(DataDTO dataDto);

    void extractDataToExcel();

}
