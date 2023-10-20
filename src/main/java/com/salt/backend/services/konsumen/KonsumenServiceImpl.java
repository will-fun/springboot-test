package com.salt.backend.services.konsumen;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.salt.backend.models.Konsumen;
import com.salt.backend.payloads.requests.KonsumenRequest;
import com.salt.backend.payloads.responses.Response;
import com.salt.backend.repositories.KonsumenRepository;

@Service
public class KonsumenServiceImpl implements KonsumenService {
    @Autowired
    private KonsumenRepository konsumenRepository;

    @Override
    public Response addKonsumen(KonsumenRequest request) {
        Konsumen konsumen = new Konsumen();

        konsumen.setNama(request.getNama());
        konsumen.setAlamat(request.getAlamat());
        konsumen.setKota(request.getKota());
        konsumen.setProvinsi(request.getProvinsi());
        konsumen.setStatus(request.getStatus());

        konsumen = konsumenRepository.save(konsumen);


        Response response = new Response();
        response.setStatus(HttpStatus.CREATED.value());
        response.setMessage("Data Konsumen berhasil dibuat.");
        response.setData(konsumen);

        return response;
    }

    @Override
    public Response getAllKonsumen() {
        List<Konsumen> listKonsumen = konsumenRepository.findAll();

        return new Response(HttpStatus.OK.value(), "sukses", listKonsumen);
    }

    @Override
    public Response getKonsumen(Integer id) {
        Konsumen konsumen = konsumenRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Data konsumen tidak ditemukan!");
        });

        return new Response(HttpStatus.OK.value(), "sukses", konsumen);
    }

    @Override
    public Response updateKonsumen(Integer id, KonsumenRequest request) {
        Konsumen konsumen = konsumenRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Data konsumen tidak ditemukan!");
        });

        konsumen.setNama(request.getNama());
        konsumen.setAlamat(request.getAlamat());
        konsumen.setKota(request.getKota());
        konsumen.setProvinsi(request.getProvinsi());
        konsumen.setStatus(request.getStatus());

        konsumen = konsumenRepository.save(konsumen);

        return new Response(HttpStatus.OK.value(), "Update data konsumen berhasil.", konsumen);
    }

    @Override
    public Response deleteKonsumen(Integer id) {
        Konsumen konsumen = konsumenRepository.findById(id).orElseThrow(() -> {
            throw new NoSuchElementException("Data konsumen tidak ditemukan!");
        });

        konsumenRepository.delete(konsumen);

        return new Response(HttpStatus.OK.value(), "Delete data konsumen berhasil.", konsumen);
    }

    @Override
    public Response datatableKonsumen(DataTablesInput input) {
        DataTablesOutput<Konsumen> datatable = konsumenRepository.findAll(input);

        return new Response(HttpStatus.OK.value(), "sukses", datatable);
    }
}
