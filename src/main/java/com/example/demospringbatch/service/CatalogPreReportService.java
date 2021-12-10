package com.example.demospringbatch.service;

import com.example.demospringbatch.repository.source.OscCatalogOrderItemRepository;
import com.example.demospringbatch.repository.source.OscCatalogOrderRepository;
import com.example.demospringbatch.repository.source.OscCatalogPreReportDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CatalogPreReportService {

    private final OscCatalogPreReportDiaryRepository catalogPreReportDiaryRepository;
    private final OscCatalogOrderRepository catalogOrderRepository;
    private final OscCatalogOrderItemRepository catalogOrderItemRepository;


}
