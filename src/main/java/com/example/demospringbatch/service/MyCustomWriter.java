package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.destination.CvCatalogPreReportRefund;
import com.example.demospringbatch.repository.destination.CvCatalogPreReportRefundRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyCustomWriter implements ItemWriter<CvCatalogPreReportRefund> {

    @Autowired
    private CvCatalogPreReportRefundRepository cvCatalogPreReportRefundRepository;


    @Override
    public void write(List<? extends CvCatalogPreReportRefund> items) throws Exception {
        for (CvCatalogPreReportRefund data : items) {
            System.out.println("MyCustomWriter    : Writing data    : " + data.getId() + " with orderCode " + data.getOrderCode() + " with productName " + data.getProductName());
            cvCatalogPreReportRefundRepository.save(data);
        }
    }
}
