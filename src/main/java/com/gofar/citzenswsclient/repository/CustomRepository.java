package com.gofar.citzenswsclient.repository;

import com.gofar.citzenswsclient.entity.Citizen;
import com.gofar.citzenswsclient.utils.CitizenDto;

import java.util.List;

public interface CustomRepository {

    Citizen updateCitizen(String cin, CitizenDto citizen);

    Citizen updateCitizen(Citizen citizen);

    List<Citizen> search(CitizenDto dto);
}
