package com.example.assigment.loadData;

import com.example.assigment.StreetStatus;
import com.example.assigment.entity.District;
import com.example.assigment.entity.Street;
import com.example.assigment.repository.DistrictRepository;
import com.example.assigment.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner {
    @Autowired
    StreetRepository streetRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public void run(String... args) throws Exception {
            loadDistrict();
            loadStreet();
    }

    private void loadDistrict(){
        if (districtRepository.count() == 0){
            District district1 = new District("Hoang Mai");
            District district2 = new District("Thuong Tin");
            District district3 = new District("Thanh Xuan");
            District district4 = new District("Ba Dinh");
            District district5 = new District("Thanh Tri");
            districtRepository.save(district1);
            districtRepository.save(district2);
            districtRepository.save(district3);
            districtRepository.save(district4);
            districtRepository.save(district5);
        }
        System.out.println(districtRepository.count());
    }
    private void loadStreet(){
        if (streetRepository.count() == 0){
            Street street1 = new Street("Street 1", LocalDate.now(),"Street 1", StreetStatus.USING,1);
            Street street2 = new Street("Street 2", LocalDate.now(),"Street 2", StreetStatus.UNDER_CONSTRUCTION,1);
            Street street3 = new Street("Street 3", LocalDate.now(),"Street 3", StreetStatus.FIX,2);
            Street street4 = new Street("Street 4", LocalDate.now(),"Street 4", StreetStatus.USING,2);
            Street street5 = new Street("Street 5", LocalDate.now(),"Street 5", StreetStatus.UNDER_CONSTRUCTION,3);
            Street street6 = new Street("Street 6", LocalDate.now(),"Street 6", StreetStatus.FIX,3);
            Street street7 = new Street("Street 7", LocalDate.now(),"Street 7", StreetStatus.USING,4);
            Street street8 = new Street("Street 8", LocalDate.now(),"Street 8", StreetStatus.USING,4);
            Street street9 = new Street("Street 9", LocalDate.now(),"Street 9", StreetStatus.USING,5);
            Street street10 = new Street("Street 10", LocalDate.now(),"Street 10", StreetStatus.USING,5);
            streetRepository.save(street1);
            streetRepository.save(street2);
            streetRepository.save(street3);
            streetRepository.save(street4);
            streetRepository.save(street5);
            streetRepository.save(street6);
            streetRepository.save(street7);
            streetRepository.save(street8);
            streetRepository.save(street9);
            streetRepository.save(street10);
        }
        System.out.println(streetRepository.count());
    }
}
