package com.example.demospringbatch.service;

import com.example.demospringbatch.domain.source.Staff;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OscCatalogPreReportRefundRowMapper implements RowMapper<Staff> {
    @Override
    public Staff mapRow(ResultSet rs, int rowNum) throws SQLException {
        var result = new Staff();
        result.setId(rs.getLong("id"));
        result.setName(rs.getString("name"));
        result.setDepartment(rs.getString("department"));
        return result;
    }
}
