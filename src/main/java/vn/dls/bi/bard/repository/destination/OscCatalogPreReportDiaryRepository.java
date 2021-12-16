package vn.dls.bi.bard.repository.destination;

import vn.dls.bi.bard.domain.destination.OscCatalogPreReportDiary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.Set;

public interface OscCatalogPreReportDiaryRepository extends JpaRepository<OscCatalogPreReportDiary, Long> {

    @Query(value = "SELECT d from OscCatalogPreReportDiary d " +
            "where (d.rendered is null or d.rendered < 0) and d.timestampTo <= :timestampTo " +
            "ORDER BY d.timestampFrom DESC")
    List<OscCatalogPreReportDiary> getDiaryByTime(@Param("timestampTo") Long timestampTo, Pageable pageable);

    List<OscCatalogPreReportDiary> findByIdIn(Set<Long> ids);
}
