package com.example.demospringbatch.domain.destination;

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
@Table(name = "osc_catalog_pre_report")
public class OscCatalogPreReport implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_master_record_id")
    private Long orderMasterRecordId;

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_date")
    private Long orderDate;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "variant_title")
    private String variantTitle;

    private String vendor;
    private String sref;

    @Column(name = "order_quantity")
    private Long orderQuantity;

    @Column(name = "order_gross_sale")
    private Long orderGrossSale;

    @Column(name = "order_discount")
    private Long orderDiscount;

    @Column(name = "order_shipping_fee")
    private Long orderShippingFee;

    @Column(name = "order_tax_amount")
    private Long orderTaxAmount;

    @Column(name = "order_tax_percent")
    private Long orderTaxPercent;

    @Column(name = "order_revenue")
    private Long orderRevenue;

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

    @Column(name = "attachment_resend")
    private String attachmentResend;

    private String resend;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "customer_first_name")
    private String customerFirstName;

    @Column(name = "customer_last_name")
    private String customerLastName;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "captured_date")
    private Long capturedDate;

    @Column(name = "cancelled_date")
    private Long cancelledDate;

    @Column(name = "cancel_reason")
    private String cancelReason;

    @Column(name = "customer_cancel")
    private String customerCancel;

    @Column(name = "resend_date")
    private Long resendDate;

    @Column(name = "resend_order_quantity")
    private Long resendOrderQuantity;

    @Column(name = "resend_reason")
    private String resendReason;

    @Column(name = "is_captured")
    private Long isCaptured;

    @Column(name = "is_cancelled")
    private Long isCancelled;

    @Column(name = "is_resent")
    private Long isResent;

    @Column(name = "pack_size")
    private Long packSize;

    @Column(name = "total_quantity")
    private Long totalQuantity;

    @Column(name = "data_mode")
    private String dataMode;

    private String supplier;

    @Column(name = "resend_by_item")
    private String resendByItem;

    @Column(name = "orderdesk")
    private String orderDesk;

    @Column(name = "resend_reason_group")
    private String resendReasonGroup;

    @Column(name = "resend_reason_detail")
    private String resendReasonDetail;

    @Column(name = "shipping_zip")
    private String shippingZip;

    @Column(name = "item_price")
    private Long itemPrice;

    @Column(name = "shipping_mode")
    private String shippingMode;

    @Column(name = "order_tip_amount")
    private Long orderTipAmount;

}
