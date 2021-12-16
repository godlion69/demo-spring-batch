package vn.dls.bi.bard.model;

import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

@Data
@Builder
public class CatalogPreReportReader implements Serializable {
    private Long orderMasterRecordId;
    private Long storeId;
    private String orderCode;
    private Long orderDate;
    private String productName;
    private String variantTitle;
    private String vendor;
    private String sref;
    private Long orderQuantity;
    private Long orderGrossSale;
    private Long orderDiscount;
    private Long orderShippingFee;
    private Long orderTaxAmount;
    private Long orderTaxPercent;
    private Long orderRevenue;
    private String paymentStatus;
    private String paymentMethod;
    private String paymentAccount;
    private String province;
    private String provinceCode;
    private String country;
    private String countryCode;
    private String cartUkey;
    private String email;
    private String attachmentResend;
    private String resend;
    private String invoiceNumber;
    private String customerFirstName;
    private String customerLastName;
    private String shippingAddress;
    private Long capturedDate;
    private Long cancelledDate;
    private String cancelReason;
    private String customerCancel;
    private Long resendDate;
    private Long resendOrderQuantity;
    private String resendReason;
    private Long isCaptured;
    private Long isCancelled;
    private Long isResent;
    private Long packSize;
    private Long totalQuantity;
    private String dataMode;
    private String supplier;
    private String resendByItem;
    private String orderDesk;
    private String resendReasonGroup;
    private String resendReasonDetail;
    private String shippingZip;
    private Long itemPrice;
    private String shippingMode;
    private Long orderTipAmount;
}
