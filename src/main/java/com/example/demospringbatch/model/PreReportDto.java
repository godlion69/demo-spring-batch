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
    private Long itemDate;
    private String productName;
    private Long itemId;
    private String options;
    private String vendor;
    private String clientInfo;
    private Long itemPrice;
    private Long orderQuantity;
    private String itemDiscount;
    private Long orderGrossSale;
    private String discountCodes;
    private Long orderShippingFee;
    private String orderShippingLine;
    private Long orderTaxAmount;
    private Long packSize;
    private Long orderRevenue;
    private String paymentStatus;
    private String paymentMethod;
    private String province;
    private String provinceCode;
    private String country;
    private String countryCode;
    private String cartUkey;
    private String email;
    private String additionalData;
    private String customerFullName;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZip;
    private Long orderTipAmount;
    private Long diaryId;
}
