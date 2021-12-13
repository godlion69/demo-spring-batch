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
@Table(name = "osc_catalog_order")
public class OscCatalogOrder implements Serializable {

    @Column(name = "master_record_id")
    @Id
    private Long masterRecordId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "shop_id")
    private Long shopId;

    private String code;

    @Column(name = "added_timestamp")
    private Long addedTimestamp;

    @Column(name = "client_info")
    private String clientInfo;

    @Column(name = "subtotal_price")
    private Long subtotalPrice;

    @Column(name = "discount_codes")
    private String discountCodes;

    @Column(name = "shipping_price")
    private Long shippingPrice;

    @Column(name = "shipping_line")
    private String shippingLine;

    @Column(name = "tax_price")
    private Long taxPrice;

    @Column(name = "total_price")
    private Long totalPrice;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "shipping_province")
    private String shippingProvince;

    @Column(name = "shipping_province_code")
    private String shippingProvinceCode;

    @Column(name = "shipping_country")
    private String shippingCountry;

    @Column(name = "shipping_country_code")
    private String shippingCountryCode;

    @Column(name = "cart_ukey")
    private String cartUkey;

    private String email;

    @Column(name = "shipping_full_name")
    private String shippingFullName;

    @Column(name = "shipping_address1")
    private String shippingAddress1;

    @Column(name = "shipping_address2")
    private String shippingAddress2;

    @Column(name = "shipping_zip")
    private String shippingZip;

    @Column(name = "modified_timestamp")
    private Long modifiedTimestamp;

}
