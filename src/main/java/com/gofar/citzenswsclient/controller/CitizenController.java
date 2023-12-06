package com.gofar.citzenswsclient.controller;

import com.gofar.citzenswsclient.entity.Citizen;
import com.gofar.citzenswsclient.exception.CitizenNotFoundException;
import com.gofar.citzenswsclient.service.CitizenService;
import com.gofar.citzenswsclient.utils.CitizenDto;
import com.gofar.citzenswsclient.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/citizens")
@Slf4j
public class CitizenController {

    private final CitizenService citizenService;

    public CitizenController(@Autowired CitizenService citizenService) {
        this.citizenService = citizenService;
    }

    @GetMapping("/{cin}")
    /**
     * Retrieves a citizen data
     */
    public ResponseEntity<Response> getCitizen(@PathVariable("cin") String cin) throws CitizenNotFoundException {
        log.info("Get infos of citizen with cin {}", cin);
        Citizen citizen = citizenService.get(cin);
        Response response = Response.builder()
                .code(200)
                .message("Success")
                .data(citizen)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Response> search(@RequestBody CitizenDto dto) {
        log.info("Search citizens based on {}", dto);
        final List<Citizen> citizens = citizenService.search(dto);
        Response response = Response.builder()
                .code(200)
                .message("Citizens retrieve successfully")
                .data(citizens)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{cin}")
    public ResponseEntity<Response> update(@PathVariable("cin") String cin, @RequestBody CitizenDto dto) throws CitizenNotFoundException {
        log.info("Update citizen with cin {}", cin);
        final Citizen citizen = citizenService.update(cin, dto);
        Response response = Response.builder()
                .code(200)
                .message("Citizen updated successfully")
                .data(citizen)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response> listAll(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size
    ) {
        log.info("List all citizens");
        return new ResponseEntity<>(
                Response.builder()
                        .code(200)
                        .message("Citizens data retrieve successfully")
                        .data(citizenService.listAll(page, size).getContent())
                        .build(),
                HttpStatus.OK
        );
    }

    @GetMapping("/sync")
    public ResponseEntity<Response> synchronize(@RequestParam String cin) throws CitizenNotFoundException {
        log.info("Synchronize data of citizen with cin {}", cin);
        final Citizen citizen = citizenService.synchronize(cin);
        Response response = Response.builder()
                .code(200)
                .message("Citizen synchronized successfully")
                .data(citizen)
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/report")
    public ResponseEntity<Resource> generateReport() throws Exception {
        byte[]  reportData = citizenService.getRegistrationReport();
        ByteArrayResource resource = new ByteArrayResource(reportData);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(resource.contentLength())
                .header(HttpHeaders.CONTENT_DISPOSITION, ContentDisposition
                        .attachment().filename("citizens-report.pdf").build().toString())
                .body(resource);
    }

    @ExceptionHandler({CitizenNotFoundException.class})
    public ResponseEntity<Response> handleCitizenNotFoundException(CitizenNotFoundException e) {
        Response response = Response.builder()
                .message("Not found")
                .data(null)
                .code(404)
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
