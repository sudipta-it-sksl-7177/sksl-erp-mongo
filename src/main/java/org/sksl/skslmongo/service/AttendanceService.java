package org.sksl.skslmongo.service;

import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;

import java.util.List;

public interface AttendanceService {
    List<LeaveApplRecord> selectLeaveApplication(LeaveApplPrintUx leaveApplPrintUx);
}
