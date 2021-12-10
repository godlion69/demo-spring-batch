package com.example.demospringbatch.domain.source;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "osc_catalog_order_item")
public class OscCatalogOrderItem implements Serializable {

    @Column(name = "master_record_id")
    @Id
    private Long masterRecordId;

    @Column(name = "order_master_record_id")
    private Long orderMasterRecordId;

    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "other_quantity")
    private Long otherQuantity;

    private String options;
    private String vendor;
    private String title;
    private Long price;
    private Long quantity;
    private Long discount;
    @Column(name = "additional_data")
    private String additionalData;
}
