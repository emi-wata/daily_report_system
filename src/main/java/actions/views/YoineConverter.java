package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Yoine;

public class YoineConverter {

    public static Yoine toModel(YoineView yv) {
        return new Yoine(
                yv.getYoineId(),
                EmployeeConverter.toModel(yv.getYoineEmployee()),
                ReportConverter.toModel(yv.getYoineReport()));
    }

    public static YoineView toView(Yoine y) {

        if(y == null) {
            return null;
        }

        return new YoineView(
                y.getYoineId(),
                EmployeeConverter.toView(y.getYoineEmployee()),
                ReportConverter.toView(y.getYoineReport()));    }

    public static List<YoineView> toViewList(List<Yoine> list) {
        List<YoineView> yvs = new ArrayList<>();

        for (Yoine y : list) {
            yvs.add(toView(y));
        }

        return yvs;
    }

    public static void copyViewToModel(Yoine y, YoineView yv) {
        y.setYoineId(yv.getYoineId());
        y.setYoineEmployee(EmployeeConverter.toModel(yv.getYoineEmployee()));
        y.setYoineReport(ReportConverter.toModel(yv.getYoineReport()));
    }

}
