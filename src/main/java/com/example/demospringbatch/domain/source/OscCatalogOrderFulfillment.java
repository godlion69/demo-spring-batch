package com.example.demospringbatch.domain.source;

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
@Table(name = "osc_catalog_order_fulfillment")
public class OscCatalogOrderFulfillment implements Serializable {
    @Id
    private Long id;

    @Column(name = "added_timestamp")
    private Long addedTimestamp;
}