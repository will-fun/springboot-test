package com.salt.backend.repositories;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

import com.salt.backend.models.Konsumen;

@Repository
public interface KonsumenRepository extends DataTablesRepository<Konsumen, Integer> {

}