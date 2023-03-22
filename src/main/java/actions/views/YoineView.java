package actions.views;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YoineView {

    private Integer yoineId;

    private EmployeeView yoineEmployee;

    private ReportView yoineReport;

}
