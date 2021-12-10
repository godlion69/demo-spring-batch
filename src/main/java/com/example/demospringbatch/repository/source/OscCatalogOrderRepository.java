package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.OscCatalogOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OscCatalogOrderRepository extends JpaRepository<OscCatalogOrder, Long> {
}
