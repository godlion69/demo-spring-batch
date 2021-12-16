package vn.dls.bi.bard.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class PreReportItemReaderView implements Serializable {
    private Long diaryId;
    private List<PreReportDto> listPreReportDto;
}
