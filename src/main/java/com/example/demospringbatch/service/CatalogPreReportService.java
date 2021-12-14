package com.example.demospringbatch.service;

import com.example.demospringbatch.model.PreReportItemReaderView;
import com.example.demospringbatch.repository.source.OrderPreReportRepository;
import com.example.demospringbatch.repository.source.OscCatalogOrderRepository;
import com.example.demospringbatch.repository.destination.OscCatalogPreReportDiaryRepository;
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
    private final OrderPreReportRepository orderPreReportRepository;

    public List<PreReportItemReaderView> getCatalogPreReport() {
        Long currentTime = Calendar.getInstance().getTimeInMillis() / 1000;
        List<PreReportItemReaderView> listResult = new ArrayList<>();
        // Get list of catalog pre report diary in current
        log.info("Get list diary at time: {}", Calendar.getInstance().getTime());
        var listDiary = catalogPreReportDiaryRepository.getDiaryByTime(currentTime, PageRequest.of(0, 10));
        if (!listDiary.isEmpty()) {
            listDiary.forEach(diary -> {
                // Get list master record id from conditional by time
                log.info("Get list master record id by diary: {}", diary.getId());
                List<Long> listMasterRecordId = catalogOrderRepository.getMasterRecordIdsByTime(diary.getTimestampFrom(), diary.getTimestampTo());
                if (listMasterRecordId.size() > 0) {
                    log.info("Get list data by list master record id");
                    var listDataFromOrderAndItem = orderPreReportRepository.getlistPreReport(listMasterRecordId);
                    if (listDataFromOrderAndItem.size() > 0) {
                        PreReportItemReaderView preReportItemReaderView = PreReportItemReaderView.builder()
                                .diaryId(diary.getId())
                                .listPreReportDto(listDataFromOrderAndItem)
                                .build();
                        listResult.add(preReportItemReaderView);
                    }
                }
            });
        }
        return listResult;
    }
}
