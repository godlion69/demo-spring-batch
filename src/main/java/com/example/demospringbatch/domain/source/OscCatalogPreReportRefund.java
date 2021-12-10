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
@Table(name = "osc_catalog_pre_report_refund")
public class OscCatalogPreReportRefund implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(name = "store_id")
    private Long storeId;
//    @Column(name = "order_code")
    private String orderCode;
//    @Column(name = "order_date")
    private Long orderDate;
//    @Column(name = "product_name")
    private String productName;
}
