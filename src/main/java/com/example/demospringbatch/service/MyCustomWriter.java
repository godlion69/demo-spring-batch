package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.destination.OscCatalogPreReport;
import com.example.demospringbatch.repository.destination.OscCatalogPreReportRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCustomWriter implements ItemWriter<OscCatalogPreReport> {

    @Autowired
    private OscCatalogPreReportRepository oscCatalogPreReportRepository;


    @Override
    public void write(List<? extends OscCatalogPreReport> items) throws Exception {
        for (OscCatalogPreReport data : items) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId() + " with orderCode " + data.getOrderCode() + " with productName " + data.getProductName());
            oscCatalogPreReportRepository.save(data);
        }
    }
}
