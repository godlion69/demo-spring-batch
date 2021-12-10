package com.example.demospringbatch.repository.source;

import com.example.demospringbatch.domain.source.OscCatalogPreReportDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface OscCatalogPreReportDiaryRepository extends JpaRepository<OscCatalogPreReportDiary, Long> {

    @Query("SELECT d from OscCatalogPreReportDiary d " +
            "where (d.rendered is null or d.rendered < 0) and d.timestampTo <= :timestampTo " +
            "ORDER BY d.timestampFrom DESC")
    Collection<OscCatalogPreReportDiary> getDiaryByTime(@Param("timestampTo") Long timestampTo);
}
