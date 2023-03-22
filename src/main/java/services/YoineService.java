package services;

import java.util.List;

import actions.views.EmployeeConverter;
import actions.views.EmployeeView;
import actions.views.ReportConverter;
import actions.views.ReportView;
import actions.views.YoineConverter;
import actions.views.YoineView;
import constants.JpaConst;
import models.Yoine;

public class YoineService extends ServiceBase {

    // 指定した社員番号と日報idを取得しYoineViewのリストで返却する
    public List<YoineView> getMineYoine(EmployeeView code, ReportView id) {

        List<Yoine> yoines = em.createNamedQuery(JpaConst.Q_YIN_GET_ALL_MINE, Yoine.class)
                .setParameter(JpaConst.JPQL_PARM_EMPLOYEE, EmployeeConverter.toModel(code))
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(id))
                .getResultList();
        return YoineConverter.toViewList(yoines);
    }

    // 指定した日報がいいねされた件数を取得し返却する
    public long countAllMine(ReportView report) {

        long yoineCount = (long) em.createNamedQuery(JpaConst.Q_YIN_COUNT_ALL_MINE, Long.class)
                .setParameter(JpaConst.JPQL_PARM_REPORT, ReportConverter.toModel(report))
                .getSingleResult();

        return yoineCount;
    }


    // いいねテーブルのデータの件数を取得し返却する
    public long countAll() {
        long yoines_count = (long) em.createNamedQuery(JpaConst.Q_YIN_COUNT, long.class)
                .getSingleResult();

        return yoines_count;
    }

    // reportIdを条件に取得したデータをYoineViewのインスタンスで返却する
    public YoineView findOne(int yoineReport) {
        return YoineConverter.toView(findOneInternal(yoineReport));
    }

    // いいねが押されたデータを１件作成し、いいねテーブルに返却する
    public List<String> create(EmployeeView ev, ReportView rv){
        createInternal(ev, rv);
        List<String> yoine_id = null;
        return yoine_id;
    }

    // reportIdを条件にデータを1件取得する
    public Yoine findOneInternal(int yoineReport) {
        return em.find(Yoine.class, yoineReport);
    }

    // いいねデータを1件登録する
    public void createInternal(EmployeeView ev, ReportView rv) {
        Yoine yoine = new Yoine(null, EmployeeConverter.toModel(ev), ReportConverter.toModel(rv));

        em.getTransaction().begin();
        em.persist(yoine);
        em.getTransaction().commit();
    }

    // いいねデータを1件削除する
    public void removeInternal(YoineView yv) {
        Yoine yoine = em.find(Yoine.class, yv.getYoineId());
        em.getTransaction().begin();
        em.remove(yoine);
        em.getTransaction().commit();
    }




}
