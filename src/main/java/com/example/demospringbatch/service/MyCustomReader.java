package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.source.Staff;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class MyCustomReader extends JdbcCursorItemReader<Staff> implements ItemReader<Staff> {

    public MyCustomReader(@Qualifier("sourceDataSource") DataSource sourceDataSource) {
        setDataSource(sourceDataSource);
        setSql("SELECT id, name, department FROM staff");
        setFetchSize(100);
        setRowMapper(new OscCatalogPreReportRefundRowMapper());
    }
}
