package vn.dls.bi.bard.service;

import vn.dls.bi.bard.domain.destination.OscCatalogPreReport;
import vn.dls.bi.bard.domain.destination.OscCatalogPreReportDiary;
import vn.dls.bi.bard.model.PreReportDto;
import vn.dls.bi.bard.model.PreReportItemReaderView;
import vn.dls.bi.bard.repository.destination.OscCatalogPreReportRepository;
import vn.dls.bi.bard.repository.destination.OscCatalogPreReportDiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class PreReportItemWriter implements ItemWriter<PreReportItemReaderView> {

    private final OscCatalogPreReportRepository oscCatalogPreReportRepository;
    private final OscCatalogPreReportDiaryRepository oscCatalogPreReportDiaryRepository;


    @Override
    public void write(List<? extends PreReportItemReaderView> items) throws Exception {
        Long updateTime = Calendar.getInstance().getTimeInMillis() / 1000;
        List<OscCatalogPreReportDiary> listSaveDiary = new ArrayList<>();
        List<OscCatalogPreReport> listCatalogPreReport = new ArrayList<>();
        Long count = 0L;
        for (PreReportItemReaderView data : items) {
            if (data.getListPreReportDto().size() > 0) {
                List<PreReportDto> list = data.getListPreReportDto();
                List<OscCatalogPreReport> listSavePreReport = new ArrayList<>();
                list.forEach(preReport -> {
                    OscCatalogPreReport catalogPreReport = OscCatalogPreReport.builder()
                            .orderMasterRecordId(preReport.getOrderMasterRecordId())
                            .storeId(preReport.getStoreId())
                            .orderCode(preReport.getOrderCode())
                            .orderDate(preReport.getOrderDate())
                            .productName(preReport.getProductName())
//                            .variantTitle(preReport.getva)
                            .vendor(preReport.getVendor())
//                            .sref(preReport.getva)
                            .orderQuantity(preReport.getOrderQuantity())
                            .orderGrossSale(preReport.getOrderGrossSale())
//                            .orderDiscount(preReport.getorde)
                            .orderShippingFee(preReport.getOrderShippingFee())
                            .orderTaxAmount(preReport.getOrderTaxAmount())
//                            .orderTaxPercent(preReport.getOrderTaxAmount())
                            .orderRevenue(preReport.getOrderRevenue())
                            .paymentStatus(preReport.getPaymentStatus())
//                            .paymentAccount(preReport.getpaymentAccount())
                            .province(preReport.getProvince())
                            .provinceCode(preReport.getProvinceCode())
                            .country(preReport.getCountry())
                            .countryCode(preReport.getCountryCode())
                            .cartUkey(preReport.getCartUkey())
                            .email(preReport.getEmail())
//                            .attachmentResend(preReport.attachmentResend())
//                            .resend(preReport.getresend())
//                            .invoiceNumber(preReport.getinvoiceNumber())
//                            .customerFirstName(preReport.getCustomerFirstName())
//                            .customerLastName(preReport.getCustomerLastName())
//                            .shippingAddress(preReport.getShippingAddress1())
//                            .capturedDate(preReport.getCapturedDate())
//                            .cancelledDate(preReport.getcancelledDate())
//                            .cancelReason(preReport.cancelReason())
//                            .customerCancel(preReport.customerCancel())
//                            .resendDate(preReport.resendDate())
//                            .resendOrderQuantity(preReport.resendOrderQuantity())
//                            .resendReason(preReport.resendReason())
//                            .isCaptured(preReport.isCaptured())
//                            .isCancelled(preReport.isCancelled())
//                            .isResent(preReport.isResent())
                            .packSize(preReport.getPackSize())
//                            .totalQuantity(preReport.totalQuantity())
//                            .dataMode(preReport.dataMode())
//                            .supplier(preReport.supplier())
//                            .resendByItem(preReport.resendByItem())
//                            .orderDesk(preReport.orderDesk())
//                            .resendReasonGroup(preReport.resendReasonGroup())
                            .shippingZip(preReport.getShippingZip())
//                            .resendByItem(preReport.resendByItem())
                            .itemPrice(preReport.getItemPrice())
//                            .shippingMode(preReport.shippingMode())
                            .orderTipAmount(preReport.getOrderTipAmount())
                            .build();
                    listSavePreReport.add(catalogPreReport);
                });
                oscCatalogPreReportRepository.saveAll(listSavePreReport);
//                listDiaryId.add(data.getDiaryId());
                var diaryOpt = oscCatalogPreReportDiaryRepository.findById(data.getDiaryId());
                if (diaryOpt.isPresent()) {
                    var diary = diaryOpt.get();
                    diary.setRendered(listSavePreReport.size());
                    diary.setLastFailure(updateTime);
                    listSaveDiary.add(diary);
                }
            }
        }

        if (listSaveDiary.size() > 0)
            oscCatalogPreReportDiaryRepository.saveAll(listSaveDiary);
    }
}
