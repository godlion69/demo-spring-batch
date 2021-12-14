package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.model.PreReportDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPreReportRepository {
    List<PreReportDto> getlistPreReport(List<Long> listMasterRecordId);
}
