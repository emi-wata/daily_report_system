package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = JpaConst.TABLE_YIN)
@NamedQueries({
    @NamedQuery(
            name = JpaConst.Q_YIN_GET_ALL_MINE,
            query = JpaConst.Q_YIN_GET_ALL_MINE_DEF),
    @NamedQuery(
            name = JpaConst.Q_YIN_COUNT_ALL_MINE,
            query = JpaConst.Q_YIN_COUNT_ALL_MINE_DEF),
})
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

    @ManyToOne
    @JoinColumn(name = JpaConst.YIN_COL_EMP_ID, nullable = false)
    private Employee yoineEmployee;

    @ManyToOne
    @JoinColumn(name = JpaConst.YIN_COL_REP_ID, nullable = false)
    private Report yoineReport;

}