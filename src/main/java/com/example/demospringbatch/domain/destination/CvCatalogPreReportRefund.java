package com.example.demospringbatch.domain.destination;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv_catalog_pre_report_refund")
public class CvCatalogPreReportRefund implements Serializable {

    @Id
    private Long id;

    @Column(name = "order_master_record_id")
    private Long orderMasterRecordId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_date")
    private Long orderDate;

    @Column(name = "refund_date")
    private Long refundDate;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "variant_title")
    private String variantTitle;

    private String vendor;
    private String sref;

    @Column(name = "refunded_quantity")
    private Long refundedQuantity;

    @Column(name = "refunded_amount")
    private Long refundedAmount;

    @Column(name = "refunded_tax_amount")
    private Long refundedTaxAmount;

    @Column(name = "refunded_tax_percent")
    private Long refundedTaxPercent;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_account")
    private String paymentAccount;

    private String province;

    @Column(name = "province_code")
    private String provinceCode;

    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "cart_ukey")
    private String cartUkey;

    private String email;

    @Column(name = "refund_reason_group")
    private String refundReasonGroup;

    @Column(name = "refund_reason")
    private String refundReason;

    @Column(name = "refund_reason_detail")
    private String refundReasonDetail;

    private String attachment;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "creadit_memo_number")
    private String creditMemoNumber;

    private String supplier;

    @Column(name = "pack_size")
    private Long packSize;

    @Column(name = "total_refunded_quantity")
    private Long totalRefundedQuantity;

    @Column(name = "order_revenue")
    private Long orderRevenue;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "orderdesk")
    private String orderDesk;

    @Column(name = "shipping_zip")
    private String shippingZip;

    @Column(name = "shipping_mode")
    private String shippingMode;

    @Column(name = "order_tip_amount")
    private Long orderTipAmount;

}
