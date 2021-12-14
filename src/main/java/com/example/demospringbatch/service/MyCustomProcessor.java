package com.example.demospringbatch.service;



import com.example.demospringbatch.domain.destination.OscCatalogPreReport;
import com.example.demospringbatch.model.PreReportDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;


@Component
public class MyCustomProcessor implements ItemProcessor<PreReportDto , OscCatalogPreReport> {

    @Override
    public OscCatalogPreReport process(PreReportDto item) throws Exception {
        System.out.println("Batch processor: Processing data: " + item);
        return OscCatalogPreReport.builder()
                .orderMasterRecordId(item.getOrderMasterRecordId())
                .storeId(item.getStoreId())
                .orderCode(item.getOrderCode())
                .orderDate(item.getOrderDate())
                .productName(item.getProductName())
                .build();
    }
}
