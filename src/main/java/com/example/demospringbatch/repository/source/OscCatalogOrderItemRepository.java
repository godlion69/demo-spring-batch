package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.OscCatalogOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OscCatalogOrderItemRepository extends JpaRepository<OscCatalogOrderItem, Long> {
}
