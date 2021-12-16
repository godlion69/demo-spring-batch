package vn.dls.bi.bard.domain.destination;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "osc_catalog_pre_report_diary")
public class OscCatalogPreReportDiary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_timestamp")
    private Long timestampFrom;

    @Column(name = "to_timestamp")
    private Long timestampTo;

    private Integer rendered;

    @Column(name = "last_success")
    private Long lastSuccess;

    @Column(name = "last_failure")
    private Long lastFailure;

    @Column(name = "refund_rendered")
    private Long refundRendered;

    @Column(name = "fulfill_rendered")
    private Long fulfillRendered;

    private Long reviewed;

    @Column(name = "refund_reviewed")
    private Long refundReviewed;

    @Column(name = "fulfill_reviewed")
    private Long fulfillReviewed;
}
