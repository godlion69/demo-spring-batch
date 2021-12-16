package vn.dls.bi.bard.repository.source;

import vn.dls.bi.bard.model.PreReportDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderPreReportRepository {
    List<PreReportDto> getlistPreReport(List<Long> listMasterRecordId);
}
