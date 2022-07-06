package org.sksl.skslmongo.record;

import java.util.Date;

//@Document("emp_leave")
public record LeaveApplRecord(
        int serialNumber, String projectCode, String leaveYear, String leaveMonth, String employeeCode,
        int applicationNumber, String finYear, String employeeName, String leaveType,
        Date startDate, Date endDate, int noOfDays, String goesTo, String leaveReason,
        String chargeBy, Date rejoinDate, String departmentCode, String designationCode,
        String designationSubCode, String employeeCategory, String gradeCode, String gender,
        String locationCode, String locationDesc, String projectDesc, String designationSubDesc,
        String designationName, String departmentName, String gradeDetails, String leaveFinal,
        String userId) {
}
