package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_YIN)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Yoine {

    @Id
    @Column(name = JpaConst.YIN_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer yoineId;

    @Column(name = JpaConst.YIN_COL_EMP_ID, nullable = false)
    private Integer yoineEmployeeId;

    @ManyToOne
    @JoinColumn(name = JpaConst.YIN_COL_REP_ID, nullable = false)
    private Report yoineReportId;

    @Column(name = JpaConst.YIN_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

}