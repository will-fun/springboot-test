package com.salt.backend.services.konsumen;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;

import com.salt.backend.payloads.requests.KonsumenRequest;
import com.salt.backend.payloads.responses.Response;

public interface KonsumenService {
    Response addKonsumen(KonsumenRequest request);
    Response getAllKonsumen();
    Response getKonsumen(Integer id);
    Response updateKonsumen(Integer id, KonsumenRequest request);
    Response deleteKonsumen(Integer id);
    Response datatableKonsumen(DataTablesInput input);
}
