package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.OscCatalogOrder;
import com.example.demospringbatch.model.PreReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface OscCatalogOrderRepository extends JpaRepository<OscCatalogOrder, Long> {

    @Query(value = "select master_record_id as A from osc_catalog_order " +
            "where (added_timestamp >= :timestampFrom and added_timestamp <= :timestampTo) or (modified_timestamp >= :timestampFrom and modified_timestamp <= :timestampTo) " +
            "union " +
            "select order_master_record_id as A from osc_catalog_order_item " +
            "where (added_timestamp >= :timestampFrom and added_timestamp <= :timestampTo) or (modified_timestamp >= :timestampFrom and modified_timestamp <= :timestampTo) " +
            "union " +
            "select order_master_record_id as A from osc_catalog_order_transaction " +
            "where (added_timestamp >= :timestampFrom and added_timestamp <= :timestampTo) " +
            "union " +
            "select order_master_record_id as A from osc_catalog_order_fulfillment " +
            "where (added_timestamp >= :timestampFrom and added_timestamp <= :timestampTo) or (modified_timestamp >= :timestampFrom and modified_timestamp <= :timestampTo)"
    ,nativeQuery = true)
    List<Long> getMasterRecordIdsByTime(@Param("timestampFrom") Long timestampFrom, @Param("timestampTo") Long timestampTo);


//    @Query(value = "select od.master_record_id as orderMasterRecordId, " +
//            "it.shop_id as storeId, " +
//            "od.code as orderCode, " +
//            "od.added_timestamp as orderDate, " +
//            "it.added_timestamp as itemDate, it.title as productName " +
//            "from osc_catalog_order od join osc_catalog_order_item it on od.master_record_id = it.order_master_record_id " +
//            "where od.master_record_id in :listMasterRecordId", nativeQuery = true)
//    List<PreReportDto> getListDataFromOrderAndItem(@Param("listMasterRecordId") List<Long> listMasterRecordId);
}
