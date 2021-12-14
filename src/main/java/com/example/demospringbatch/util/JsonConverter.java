package com.example.demospringbatch.util;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.Instant;

@Slf4j
public class JsonConverter {

    public static String getSrefUsernameFromClientInfo(String clientInfo) throws Exception {
        if (clientInfo == null || clientInfo.isEmpty() || "[]".equalsIgnoreCase(clientInfo)) {
            return null;
        }

        try {
            JSONObject obj = new JSONObject(clientInfo);

            if (!obj.has("DLS_SALE_REF")) {
                return null;
            }

            Object saleRefObj = obj.get("DLS_SALE_REF");

            if (saleRefObj == null || !saleRefObj.toString().startsWith("{")) {
                return null;
            }

            JSONObject saleRef = new JSONObject(saleRefObj.toString());
            String username = null;

            if (saleRef.has("username")) {
                username = saleRef.getString("username");
            }

            return username;
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getSrefUsernameFromClientInfo() Exception when parsing JSON: {}", Instant.now(), clientInfo);
            throw ex;
        }
    }

    public static int getDiscountAmountFromDiscountCodes(String discountCodes) throws Exception {
        if (discountCodes == null || discountCodes.isEmpty() || discountCodes.equalsIgnoreCase("[]")) {
            return 0;
        }

        try {
            JSONObject obj = new JSONObject(discountCodes);
            if (obj.keySet().isEmpty()) {
                return 0;
            }

            String key = obj.keySet().iterator().next();
            JSONObject discountObj = obj.getJSONObject(key);

            if (discountObj.has("discount_price")) {
                String priceStr = discountObj.get("discount_price").toString();
                return Integer.parseInt(priceStr);
            }
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getDiscountAmountFromDiscountCodes() Exception when parsing JSON: {}", Instant.now(), discountCodes);
            throw ex;
        }

        return 0;
    }

    public static String getVariantTitleFromOptions(String options) throws Exception {
        if (options == null || options.isEmpty()) {
            return null;
        }

        try {
            JSONArray arr = new JSONArray(options);

            for (int i = 0; i < arr.length(); i++) {
                String title = arr.getJSONObject(i).getString("title");
                String value = arr.getJSONObject(i).getString("value");

                if ("Product type".equalsIgnoreCase(title)) {
                    return value;
                }
            }
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getVariantTitleFromOptions() Exception when parsing JSON: {}", Instant.now(), options);
            throw ex;
        }

        return null;
    }

    public static String[] getPaymentMethodAccountFromJson(String paymentMethodAccount) throws Exception {
        if (paymentMethodAccount == null || paymentMethodAccount.isEmpty()) {
            return null;
        }

        String paymentMethod = "";
        String paymentAccount = "";

        try {
            JSONObject obj = new JSONObject(paymentMethodAccount);

            if (obj.has("key")) {
                paymentMethod = obj.getString("key");
            }

            if (obj.has("account")) {
                JSONObject accountObj = obj.getJSONObject("account");
                paymentAccount = accountObj.getString("title");
            }
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getPaymentMethodAccountFromJson() Exception when parsing JSON: {}", Instant.now(), paymentMethodAccount);
            throw ex;
        }

        return new String[]{paymentMethod, paymentAccount};
    }

//    /**
//     * Get Resend Attachment, Resend (YES/NO) and Resend Reason, Resend by Item.
//     *
//     * @param additionalData
//     * @param shopId
//     * @param threadId
//     * @return String[] list of result.
//     */
//    public static String[] getResendInfoFromJson(String additionalData, int shopId, String threadId) throws Exception {
//        if (additionalData == null || additionalData.isEmpty() || additionalData.equalsIgnoreCase("[]")) {
//            return new String[]{"", "NO", "", "", "", ""};
//        }
//
//        String resend = "YES";
//        String attachmentResend = "";
//        String reasonGroup = "";
//        String reason = "";
//        String reasonDetail = "";
//        String resendByItem = "";
//
//        try {
//            JSONObject obj = new JSONObject(additionalData);
//
//            if (!obj.has("resend")) {
//                return new String[]{"", "NO", "", "", "", ""};
//            }
//
//            JSONObject resendObj = obj.getJSONObject("resend");
//
//            if (!resendObj.has("item_id_duplicate")) {
//                return new String[]{"", "NO", "", "", "", ""};
//            }
//
//            resendByItem = resendObj.getLong("item_id_duplicate") + "";
//
//            if (resendObj.has("reason_group")) {
//                reasonGroup = resendObj.getString("reason_group");
//            }
//
//            if (resendObj.has("reason")) {
//                reason = resendObj.getString("reason");
//            }
//
//            if (resendObj.has("reason_detail")) {
//                reasonDetail = resendObj.getString("reason_detail");
//            }
//
//            String originItemAD = SourceItemDAO.getAdditionalDataOfAnItem(resendByItem, shopId, Constants.DATA_MODE_LIVE, threadId);
//
//            if ("".equalsIgnoreCase(originItemAD)) {
//                originItemAD = SourceItemDAO.getAdditionalDataOfAnItem(resendByItem, shopId, Constants.DATA_MODE_BACKUP, threadId);
//            }
//
//            attachmentResend = getAttachmentResendFromJson(originItemAD);
//
//        } catch (Exception ex) {
//            log.error("{}: JsonHelper.getResendInfoFromJson() Exception when parsing JSON: {}", Instant.now(), additionalData);
//            throw ex;
//        }
//
//        return new String[]{attachmentResend, resend, reason, resendByItem, reasonGroup, reasonDetail};
//    }

    public static boolean checkIsRensentItem(String additionalData) throws Exception {
        if (additionalData == null || additionalData.isEmpty() || additionalData.equalsIgnoreCase("[]")) {
            return false;
        }

        try {
            JSONObject obj = new JSONObject(additionalData);

            if (!obj.has("resend")) {
                return false;
            }

            JSONObject resendObj = obj.getJSONObject("resend");

            if (!resendObj.has("item_id_duplicate")) {
                return false;
            }
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getResendInfoFromJson() Exception when parsing JSON: {}", Instant.now(), additionalData);
            throw ex;
        }

        return true;
    }

    public static String getAttachmentResendFromJson(String additionalData) throws Exception {
        if (additionalData == null || additionalData.isEmpty() || additionalData.equalsIgnoreCase("[]")) {
            return "";
        }

        String attachmentResend = "";

        try {
            JSONObject obj = new JSONObject(additionalData);

            if (!obj.has("resend")) {
                return "";
            }

            JSONObject resendObj = obj.getJSONObject("resend");
            JSONArray attachArr;

            if (resendObj.has("attachment_image")) {
                attachArr = resendObj.getJSONArray("attachment_image");

                for (int i = 0; i < attachArr.length(); i++) {
                    JSONArray attachItems = attachArr.getJSONArray(i);

                    for (int j = 0; j < attachItems.length(); j++) {
                        String item = attachItems.getString(j);
                        attachmentResend += item + ",";
                    }
                }
            }

            if (resendObj.has("attachment_link")) {
                attachArr = resendObj.getJSONArray("attachment_link");

                for (int i = 0; i < attachArr.length(); i++) {
                    JSONArray attachItems = attachArr.getJSONArray(i);

                    for (int j = 0; j < attachItems.length(); j++) {
                        String item = attachItems.getString(j);
                        attachmentResend += item + ",";
                    }
                }
            }

        } catch (Exception ex) {
            log.error("{}: JsonHelper.getAttachmentResendFromJson() Exception when parsing JSON: {}", Instant.now(), additionalData);
            throw ex;
        }

        return attachmentResend;
    }

    public static String getRefundAttachmentInfoFromAdditionalData(String additionalData) throws Exception {
        if (additionalData == null || additionalData.isEmpty() || additionalData.equalsIgnoreCase("[]")) {
            return null;
        }

        String attachment = "";

        try {
            JSONObject obj = new JSONObject(additionalData);

            if (!obj.has("refund")) {
                return null;
            }

            JSONObject resendObj = obj.getJSONObject("refund");
            JSONArray attachArr = null;

            if (resendObj.has("attachment_image")) {
                attachArr = resendObj.getJSONArray("attachment_image");

                for (int i = 0; i < attachArr.length(); i++) {
                    JSONArray attachItems = attachArr.getJSONArray(i);

                    for (int j = 0; j < attachItems.length(); j++) {
                        String item = attachItems.getString(j);
                        attachment += item + ",";
                    }
                }
            }

            if (resendObj.has("attachment_link")) {
                attachArr = resendObj.getJSONArray("attachment_link");

                for (int i = 0; i < attachArr.length(); i++) {
                    JSONArray attachItems = attachArr.getJSONArray(i);

                    for (int j = 0; j < attachItems.length(); j++) {
                        String item = attachItems.getString(j);
                        attachment += item + ",";
                    }
                }
            }

        } catch (Exception ex) {
            log.error("{}: JsonHelper.getRefundAttachmentInfoFromAdditionalData() Exception when parsing JSON: {}", Instant.now(), additionalData);
            throw ex;
        }

        return attachment;
    }

    /**
     * Get first name, last name from full name.
     * First name is the first part util space character. Last name is the remaining.
     *
     * @param fullname the full name
     * @return String[] list of first name followed by the last name.
     */
    public static String[] splitCustomerNames(String fullname) {
        if (fullname == null) {
            return new String[]{"", ""};
        }

        fullname = fullname.trim();

        int i = fullname.indexOf(" ");
        if (i < 0) {
            return new String[]{fullname, ""};
        }

        String firstName = fullname.substring(0, i);
        String lastName = "";

        if (i + 1 < fullname.length()) {
            lastName = fullname.substring(i + 1);
        }

        return new String[]{firstName, lastName};
    }

    public static String getCancelReasonInforFromNote(String note) {
        if (note == null || note.isEmpty()) {
            return "";
        }

        if (!note.startsWith("{") && !note.startsWith("[")) {
            return note;
        }

        JSONObject obj = new JSONObject(note);

        if (obj.has("reason")) {
            String reason = obj.getString("reason");
            return reason;
        }

        return "";
    }

//    public static String[] getRefundReasonsForRefundRecordFromNote(String note, SinkRefundRecord r) {
//        if (note == null || note.isEmpty()) {
//            return new String[]{"", "", ""};
//        }
//
//        String reasonGroup = "";
//        String reason = "";
//        String reasonDetail = "";
//
//        if (!note.startsWith("{")) {
//            return new String[]{"", note, ""};
//        }
//
//        JSONObject obj = new JSONObject(note);
//
//        if (obj.has("group")) {
//            reasonGroup = obj.getString("group");
//        }
//
//        if (obj.has("reason")) {
//            reason = obj.getString("reason");
//        }
//
//        if (obj.has("detail")) {
//            reasonDetail = obj.getString("detail");
//        }
//
//        return new String[]{reasonGroup, reason, reasonDetail};
//    }

    public static int getDiscountValueFromItemDiscount(String itemDiscount) {
        if (itemDiscount == null || itemDiscount.isEmpty() || "[]".equalsIgnoreCase(itemDiscount.trim())) {
            return 0;
        }

        try {
            JSONObject obj = new JSONObject(itemDiscount);

            if (obj.has("discount_price")) {
                int discount_price = obj.getInt("discount_price");
                return discount_price;
            }
        } catch (Exception ex) {
            log.error("{}: JsonHelper.getDiscountValueFromItemDiscount() Exception when parsing JSON: {}", Instant.now(), itemDiscount);
        }

        return 0;
    }

    public static String getShippingModeFromShippingLine(String shippingLine) {
        if (shippingLine == null || shippingLine.isEmpty()) {
            return null;
        }

        try {
            JSONObject obj = new JSONObject(shippingLine);

            if (!obj.has("carrier")) {
                return null;
            }

            JSONObject carrier = obj.getJSONObject("carrier");

            if (carrier == null || !carrier.has("rates")) {
                return null;
            }

            JSONArray rates = carrier.getJSONArray("rates");

            if (rates == null || rates.length() <= 0) {
                return null;
            }

            JSONObject firstRate = rates.getJSONObject(0);
            String shippingMode = firstRate.getString("key");
            return shippingMode;

        } catch (Exception ex) {
            log.error("{}: JsonHelper.getDiscountValueFromItemDiscount() Exception when parsing JSON: {}", Instant.now(), shippingLine);
        }

        return null;
    }

//    public static void main (String [] args) throws Exception {
//        getResendInfoFromJson("{\"resend\":{\"attachment_image\":[[\"catalog\\/order\\/attachment\\/resend_refund\\/18.02.2021\\/100.J64KZ602ebc30a326f.1613675568.png\"]]}}");
//    }

    public static int getTipAmountFromCustomPriceData(String customPriceData) {
        if (customPriceData == null || customPriceData.isEmpty()) {
            return 0;
        }
        try {
            JSONObject jsonObject = new JSONObject(customPriceData);
            if (jsonObject != null) {
                return jsonObject.getInt("tip");
            } else {
                return 0;
            }
        } catch (JSONException err) {
            return 0;
        }
    }
}
