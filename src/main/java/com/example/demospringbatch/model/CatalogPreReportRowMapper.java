package com.example.demospringbatch.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CatalogPreReportRowMapper implements RowMapper<CatalogPreReportReader> {
    @Override
    public CatalogPreReportReader mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CatalogPreReportReader.builder()
                .orderMasterRecordId(rs.getLong("order_master_record_id"))
                .storeId(rs.getLong("store_id"))
                .orderCode(rs.getString("order_code"))
                .orderDate(rs.getLong("order_date"))
                .productName(rs.getString("product_name"))
                .variantTitle(rs.getString("variant_title"))
                .vendor(rs.getString("vendor"))
                .sref(rs.getString("sref"))
                .orderQuantity(rs.getLong("order_quantity"))
                .orderGrossSale(rs.getLong("order_gross_sale"))
                .orderDiscount(rs.getLong("order_discount"))
                .orderShippingFee(rs.getLong("order_shipping_fee"))
                .orderTaxAmount(rs.getLong("order_tax_amount"))
                .orderTaxPercent(rs.getLong("order_tax_percent"))
                .orderRevenue(rs.getLong("order_revenue"))
                .paymentStatus(rs.getString("payment_status"))
                .paymentMethod(rs.getString("payment_method"))
                .paymentAccount(rs.getString("payment_account"))
                .province(rs.getString("province"))
                .provinceCode(rs.getString("province_code"))
                .country(rs.getString("country"))
                .countryCode(rs.getString("country_code"))
                .province(rs.getString("province"))
                .province(rs.getString("province"))
                .province(rs.getString("province"))
                .province(rs.getString("province"))
                .province(rs.getString("province"))
                .province(rs.getString("province"))
                .build();
    }
}
