package com.example.demospringbatch.service;

import com.example.demospringbatch.model.PreReportDto;
import com.example.demospringbatch.repository.source.OscCatalogOrderItemRepository;
import com.example.demospringbatch.repository.source.OscCatalogOrderRepository;
import com.example.demospringbatch.repository.source.OscCatalogPreReportDiaryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CatalogPreReportService {

    private final OscCatalogPreReportDiaryRepository catalogPreReportDiaryRepository;
    private final OscCatalogOrderRepository catalogOrderRepository;
    private final OscCatalogOrderItemRepository catalogOrderItemRepository;

    public List<PreReportDto> getCatalogPreReport() {
        Long currentTime = Calendar.getInstance().getTimeInMillis() / 1000;
        List<PreReportDto> listPreReport = new ArrayList<>();
        // Get list of catalog pre report diary in current
        var listDiary = catalogPreReportDiaryRepository.getDiaryByTime(currentTime, PageRequest.of(0, 20));
        if (!listDiary.isEmpty()) {
            listDiary.forEach(diary -> {
                // Get list master record id from conditional by time
                List<Long> listMasterRecordId = catalogOrderRepository.getMasterRecordIdsByTime(diary.getTimestampFrom(), diary.getTimestampTo());
                var listDataFromOrderAndItem = catalogOrderRepository.getListDataFromOrderAndItem(listMasterRecordId);
                listPreReport.addAll(listDataFromOrderAndItem);
            });
        }
        return listPreReport;
    }
}
