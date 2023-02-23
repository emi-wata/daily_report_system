package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Yoine;

public class YoineConverter {

    public static Yoine toModel(YoineView yv) {
        return new Yoine(
                yv.getYoineId(),
                yv.getYoineEmployeeId(),
                ReportConverter.toModel(yv.getYoineReportId()),
                yv.getCreatedAt());
    }

    public static YoineView toView(Yoine y) {

        if(y == null) {
            return null;
        }

        return new YoineView(
                y.getYoineId(),
                y.getYoineEmployeeId(),
                ReportConverter.toView(y.getYoineReportId()),
                y.getCreatedAt());
    }

    public static List<YoineView> toViewList(List<Yoine> list) {
        List<YoineView> yvs = new ArrayList<>();

        for (Yoine y : list) {
            yvs.add(toView(y));
        }

        return yvs;
    }

    public static void copyViewToModel(Yoine y, YoineView yv) {
        y.setYoineId(yv.getYoineId());
        y.setYoineEmployeeId(yv.getYoineEmployeeId());
        y.setYoineReportId(ReportConverter.toModel(yv.getYoineReportId()));
        y.setCreatedAt(yv.getCreatedAt());
    }

}
