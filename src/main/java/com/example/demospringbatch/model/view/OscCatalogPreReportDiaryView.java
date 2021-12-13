package com.example.demospringbatch.model.view;

import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class OscCatalogPreReportDiaryView implements Serializable {

    private Long id;
    private Long timestampFrom;
    private Long timestampTo;
}
