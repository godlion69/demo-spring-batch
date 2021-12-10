package com.example.demospringbatch.service;


import com.example.demospringbatch.domain.destination.CvCatalogPreReportRefund;
import com.example.demospringbatch.domain.source.OscCatalogPreReportRefund;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyCustomProcessor implements ItemProcessor<OscCatalogPreReportRefund, CvCatalogPreReportRefund> {

    @Override
    public CvCatalogPreReportRefund process(OscCatalogPreReportRefund item) throws Exception {
        System.out.println("Batch processor: Processing data: " + item);
        return CvCatalogPreReportRefund.builder()
                .id(item.getId())
                .storeId(item.getStoreId())
                .orderCode(item.getOrderCode())
                .orderDate(item.getOrderDate())
                .productName(item.getProductName())
                .build();
    }
}
