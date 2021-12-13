package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.OscCatalogOrderTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OscCatalogOrderTransactionRepository extends JpaRepository<OscCatalogOrderTransaction, Long> {
}
