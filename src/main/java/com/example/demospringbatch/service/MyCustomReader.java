package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.source.OscCatalogPreReportRefund;
import com.example.demospringbatch.model.CatalogPreReportReader;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@RequiredArgsConstructor
public class MyCustomReader {

    public MyCustomReader(@Qualifier("sourceDataSource") DataSource sourceDataSource) {
//        setDataSource(sourceDataSource);
//        setSql("SELECT id, store_id, order_code, order_date, product_name FROM osc_catalog_pre_report_refund");
//        setFetchSize(10);
//        setRowMapper(new OscCatalogPreReportRefundRowMapper());
    }
//
//    @Bean
//    public ItemReader<CatalogPreReportReader>
}
