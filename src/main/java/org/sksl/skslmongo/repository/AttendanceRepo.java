package org.sksl.skslmongo.repository;

import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;

import java.util.List;

public interface AttendanceRepo {
    List<LeaveApplRecord> selectLeaveApplication(LeaveApplPrintUx leaveApplPrintUx);
}
