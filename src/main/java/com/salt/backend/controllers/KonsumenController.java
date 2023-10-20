package com.salt.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.salt.backend.payloads.requests.KonsumenRequest;
import com.salt.backend.payloads.responses.Response;
import com.salt.backend.services.konsumen.KonsumenService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/konsumen")
@CrossOrigin(origins="*")
public class KonsumenController {
    @Autowired
    private KonsumenService konsumenService;

    @RequestMapping(value = "/datatable", method = RequestMethod.POST)
    public ResponseEntity<?> datatableKonsumen(@Valid @RequestBody DataTablesInput input) {
        Response response = konsumenService.datatableKonsumen(input);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping
    public ResponseEntity<?> addKonsumen(@RequestBody KonsumenRequest request) {
        try {
            Response response = konsumenService.addKonsumen(request);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllKonsumen() {
        try {
            Response response = konsumenService.getAllKonsumen();
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getKonsumen(@PathVariable("id") Integer id) {
        try {
            Response response = konsumenService.getKonsumen(id);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateKonsumen(@PathVariable("id") Integer id, @RequestBody KonsumenRequest request) {
        try {
            Response response = konsumenService.updateKonsumen(id, request);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteKonsumen(@PathVariable("id") Integer id) {
        try {
            Response response = konsumenService.deleteKonsumen(id);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}