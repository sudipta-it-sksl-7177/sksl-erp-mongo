package org.sksl.skslmongo.service;

import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.repository.AttendanceRepo;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepo attendanceRepo;

    @Autowired
    public AttendanceServiceImpl(
            @Qualifier("attendanceMongo") AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    @Override
    public List<LeaveApplRecord> selectLeaveApplication(LeaveApplPrintUx leaveApplPrintUx) {
        return attendanceRepo.selectLeaveApplication(leaveApplPrintUx);
    }
}
