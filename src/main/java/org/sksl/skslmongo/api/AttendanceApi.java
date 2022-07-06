package org.sksl.skslmongo.api;

import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.service.AttendanceService;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("hr/")
public class AttendanceApi {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceApi(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @PostMapping("leave/application/pre")
    public List<LeaveApplRecord> leaveApplicationPre(
            @Valid @NotNull @RequestBody LeaveApplPrintUx leaveApplPrintUx) {
        return attendanceService.selectLeaveApplication(leaveApplPrintUx);
    }
}
