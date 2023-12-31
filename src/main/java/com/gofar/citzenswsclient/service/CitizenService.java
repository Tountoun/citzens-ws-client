package com.gofar.citzenswsclient.service;

import com.gofar.citzenswsclient.client.CitizensClient;
import com.gofar.citzenswsclient.entity.Citizen;
import com.gofar.citzenswsclient.exception.CitizenNotFoundException;
import com.gofar.citzenswsclient.repository.CitizenRepository;
import com.gofar.citzenswsclient.repository.CustomRepository;
import com.gofar.citzenswsclient.utils.CitizenDto;
import com.gofar.citzenswsclient.utils.MappingUtils;
import com.gofar.citzenswsclient.ws.GetCitizenInfoResponse;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CitizenService {

    private CitizensClient client;
    private final CitizenRepository citizenRepository;
    private CustomRepository customRepository;

    public CitizenService(@Autowired CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
    }
    public Citizen get(String cin) throws CitizenNotFoundException {
        Citizen citizen = null;
        Optional<Citizen> optionalCitizen = this.citizenRepository.findByCin(cin);
        if (optionalCitizen.isPresent()) {
            citizen = optionalCitizen.get();
        } else {
            GetCitizenInfoResponse infos = client.getCitizenInfoResponse(cin);
            if (Objects.isNull(infos.getData())) {
                throw new CitizenNotFoundException();
            }
            citizen = MappingUtils.citizenWsToCitizenEntity(infos.getData());
            citizenRepository.save(citizen);
        }

        return citizen;
    }

    /**
     * Synchronize the data of the citizen with the one from the web service
     *
     * @param cin the cin of the citizen
     * @return the synchronized data
     */
    public Citizen synchronize(String cin) throws CitizenNotFoundException {
        Optional<Citizen> optionalCitizen = this.citizenRepository.findByCin(cin);
        if (optionalCitizen.isEmpty()) {
            throw new CitizenNotFoundException("Citizen not present");
        }
        com.gofar.citzenswsclient.ws.Citizen citizenFromWs = client.getCitizenInfoResponse(cin).getData();
        Citizen citizen = MappingUtils.citizenWsToCitizenEntity(citizenFromWs);
        return customRepository.updateCitizen(citizen);
    }

    public Page<Citizen> listAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.citizenRepository.findAll(pageable);
    }

    public List<Citizen> search(CitizenDto dto) {
        return customRepository.search(dto);
    }

    public Citizen update(String cin, CitizenDto citizenDto) throws CitizenNotFoundException {
        if(!citizenRepository.existsByCin(cin)) {
            throw new CitizenNotFoundException("Citizen not found");
        }
        return customRepository.updateCitizen(cin, citizenDto);
    }

    public byte[] getRegistrationReport() throws Exception {
        File file = ResourceUtils.getFile("classpath:report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(citizenRepository.findAll());

        JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);

        return JasperExportManager.exportReportToPdf(print);
    }

    @Autowired
    public void setClient(CitizensClient client) {
        this.client = client;
    }

    @Autowired
    public void setCustomRepository(CustomRepository customRepository) {
        this.customRepository = customRepository;
    }
}
