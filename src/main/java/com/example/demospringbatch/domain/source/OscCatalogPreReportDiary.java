package com.example.demospringbatch.domain.source;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "osc_catalog_pre_report_diary")
public class OscCatalogPreReportDiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_timestamp")
    private Long timestampFrom;

    @Column(name = "to_timestamp")
    private Long timestampTo;

    private Long rendered;

    @Column(name = "last_success")
    private Long lastSuccess;

    @Column(name = "last_failure")
    private Long lastFailure;

    @Column(name = "refund_rendered")
    private Long refundRendered;

    @Column(name = "fulfill_rendered")
    private Long fulfillRendered;

    private Long reviewed;

    @Column(name = "refund_reviewed")
    private Long refundReviewed;

    @Column(name = "fulfill_reviewed")
    private Long fulfillReviewed;
}
