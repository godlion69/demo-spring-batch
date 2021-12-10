package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.source.OscCatalogPreReportRefund;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OscCatalogPreReportRefundRowMapper implements RowMapper<OscCatalogPreReportRefund> {
    @Override
    public OscCatalogPreReportRefund mapRow(ResultSet rs, int rowNum) throws SQLException {
        return OscCatalogPreReportRefund.builder()
                .id(rs.getLong("id"))
                .storeId(rs.getLong("store_id"))
                .orderCode(rs.getString("order_code"))
                .orderDate(rs.getLong("order_date"))
                .productName(rs.getString("product_name"))
                .build();
    }
}
