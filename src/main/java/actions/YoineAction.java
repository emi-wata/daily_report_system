package actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import actions.views.EmployeeView;
import actions.views.ReportView;
import actions.views.YoineView;
import constants.AttributeConst;
import constants.ForwardConst;
import services.ReportService;
import services.YoineService;

public class YoineAction extends ActionBase {

    private YoineService service;
    private ReportService rService;

    @Override
    public void process() throws ServletException, IOException {

        service = new YoineService();
        rService = new ReportService();

        invoke();
        service.close();
        rService.close();
    }


    public void create() throws ServletException, IOException {

     // セッションからログイン中の従業員情報を取得
        EmployeeView ev = (EmployeeView) getSessionScope(AttributeConst.LOGIN_EMP);

        ReportView rv = rService.findOne(toNumber(getRequestParam(AttributeConst.REP_ID)));


        List<YoineView> yoines = service.getMineYoine(ev, rv);


        if(yoines.size() > 0) {
            service.removeInternal((yoines.get(0)));
        } else {

        service.createInternal(ev, rv);
        
        }



        redirect(ForwardConst.ACT_REP, ForwardConst.CMD_SHOW, toNumber(getRequestParam(AttributeConst.REP_ID)));




    }


}
