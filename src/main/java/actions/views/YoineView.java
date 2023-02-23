package actions.views;

import java.time.LocalDateTime;

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

    private Integer yoineEmployeeId;

    private ReportView yoineReportId;

    private LocalDateTime createdAt;
}
