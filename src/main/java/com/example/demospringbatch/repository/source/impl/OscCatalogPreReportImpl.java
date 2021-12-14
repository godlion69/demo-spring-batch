package com.example.demospringbatch.repository.source.impl;

import com.example.demospringbatch.model.PreReportDto;
import com.example.demospringbatch.repository.source.OrderPreReportRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OscCatalogPreReportImpl implements OrderPreReportRepository {

    @Autowired
    @Qualifier("sourceEntityManagerFactory")
    private EntityManager entityManager;

    @Override
    public List<PreReportDto> getlistPreReport(List<Long> listMasterRecordId) {
        List<PreReportDto> listResult = new ArrayList<>();
        String query = "select od.master_record_id as orderMasterRecordId, " + //0
                "od.shop_id as storeId, " + //1
                "od.code as orderCode, " + //2
                "od.added_timestamp as orderDate, " + //3
                "it.added_timestamp as itemDate, " + //5
                "it.title as productName, " + //5
                "it.item_id as itemId, " + //6
                "it.options, " + //7
                "it.vendor as vendor, " + //8
                "od.client_info as clientInfo, " + //9
                "it.price * it.quantity as itemPrice, " + //10
                "it.quantity as orderQuantity, " + //11
                "it.discount as itemDiscount, " + //12
                "od.subtotal_price as orderGrossSale, " + //13
                "od.discount_codes as discountCodes, " + //14
                "od.shipping_price as orderShippingFee, " + //15
                "od.shipping_line as orderShippingLine, " + //16
                "od.tax_price as orderTaxAmount, " + //17
                "it.other_quantity as packSize, " + //18
                "od.total_price as orderRevenue, " + //19
                "od.payment_status as paymentStatus, " + //20
                "od.payment_method as paymentMethod, " + //21
                "od.shipping_province as province, " + //22
                "od.shipping_province_code as provinceCode, " + //23
                "od.shipping_country as country, " + //24
                "od.shipping_country_code as countryCode, " + //25
                "od.cart_ukey as cartUkey, " + //26
                "od.email, " + //27
                "it.additional_data as additionalData, " + //28
                "od.shipping_full_name as customerFullName, " + //29
                "od.shipping_address1 as shippingAddress1, " + //30
                "od.shipping_address2 as shippingAddress2, " + //31
                "od.shipping_zip as shippingZip, " + //32
                "od.custom_price_data as customPriceData " + //33
                "from osc_catalog_order od join osc_catalog_order_item it on od.master_record_id = it.order_master_record_id " +
                "where od.master_record_id in :listMasterRecordId";
        var nativeQuery = entityManager.createNativeQuery(query);
        nativeQuery.setParameter("listMasterRecordId", listMasterRecordId);

        List<Object[]> queryResult = nativeQuery.getResultList();
        for (Object[] result: queryResult) {
            var preReportDto = PreReportDto.builder()
                    .orderMasterRecordId(Long.parseLong(result[0].toString()))
                    .storeId(Long.parseLong(result[1].toString()))
                    .orderCode(result[2].toString())
                    .orderDate(Long.parseLong(result[3].toString()))
                    .itemDate(Long.parseLong(result[4].toString()))
                    .productName(result[5].toString())
                    .itemId(Long.parseLong(result[6].toString()))
                    .options(result[7].toString())
                    .vendor(result[8].toString())
                    .clientInfo(result[9].toString())
                    .itemPrice(Long.parseLong(result[10].toString()))
                    .orderQuantity(Long.parseLong(result[11].toString()))
                    .itemDiscount(result[12].toString())
                    .orderGrossSale(Long.parseLong(result[13].toString()))
                    .discountCodes(result[14].toString())
                    .orderShippingFee(Long.parseLong(result[15].toString()))
                    .orderShippingLine(result[16].toString())
                    .orderTaxAmount(Long.parseLong(result[17].toString()))
                    .packSize(Long.parseLong(result[18].toString()))
                    .orderRevenue(Long.parseLong(result[19].toString()))
                    .paymentStatus(result[20].toString())
                    .paymentMethod(result[21].toString())
                    .province(result[22].toString())
                    .provinceCode(result[23].toString())
                    .country(result[24].toString())
                    .countryCode(result[25].toString())
                    .cartUkey(result[26].toString())
                    .email(result[27].toString())
                    .additionalData(result[28].toString())
                    .customerFullName(result[29].toString())
                    .shippingAddress1(result[30].toString())
                    .shippingAddress2(result[31].toString())
                    .shippingZip(result[32].toString())
                    .orderTipAmount(getTipAmountFromCustomPriceData(result[33].toString()))
                    .build();
            listResult.add(preReportDto);
        }
        return listResult;
    }

    public static Long getTipAmountFromCustomPriceData(String customPriceData) {
        if (customPriceData == null || customPriceData.isEmpty()) {
            return 0L;
        }
        try {
            JSONObject jsonObject = new JSONObject(customPriceData);
            return jsonObject.getLong("tip");
        } catch (JSONException err){
            return 0L;
        }
    }
}
