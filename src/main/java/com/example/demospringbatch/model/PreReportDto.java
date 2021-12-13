package com.example.demospringbatch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PreReportDto implements Serializable {
    private Long orderMasterRecordId;
    private Long storeId;
    private String orderCode;
    private Long orderDate;
    private String productName;
}
