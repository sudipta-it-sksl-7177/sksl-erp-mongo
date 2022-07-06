package org.sksl.skslmongo.record;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Date;

public record LeaveApplRecordMongo(
        @BsonProperty(value = "slno")
        int serialNumber,
        @BsonProperty(value = "projcd")
        String projectCode,
        @BsonProperty(value = "lvyear")
        String leaveYear,
        @BsonProperty(value = "lvmonth")
        String leaveMonth,
        @BsonProperty(value = "emp_cd")
        String employeeCode,
        @BsonProperty(value = "appl_no")
        int applicationNumber,
        @BsonProperty(value = "finyear")
        String finYear,
        @BsonProperty(value = "emp_name")
        String employeeName,
        @BsonProperty(value = "leave_type")
        String leaveType,
        @BsonProperty(value = "leave_start")
        Date startDate,
        @BsonProperty(value = "leave_end")
        Date endDate,
        @BsonProperty(value = "no_of_days")
        int noOfDays,
        @BsonProperty(value = "go_to")
        String goesTo,
        @BsonProperty(value = "reasons")
        String leaveReason,
        @BsonProperty(value = "charge_by")
        String chargeBy,
        @BsonProperty(value = "rejoin_date")
        Date rejoinDate,
        @BsonProperty(value = "dept_code")
        String departmentCode,
        @BsonProperty(value = "desg_code")
        String designationCode,
        @BsonProperty(value = "desg_subcd")
        String designationSubCode,
        @BsonProperty(value = "emp_cate")
        String employeeCategory,
        @BsonProperty(value = "grade_code")
        String gradeCode,
        @BsonProperty(value = "sex")
        String gender,
        @BsonProperty(value = "location")
        String locationCode,
        @BsonProperty(value = "location_desc")
        String locationDesc,
        @BsonProperty(value = "projdesc")
        String projectDesc,
        @BsonProperty(value = "desgsub_desc")
        String designationSubDesc,
        @BsonProperty(value = "desg_name")
        String designationName,
        @BsonProperty(value = "dept_name")
        String departmentName,
        @BsonProperty(value = "grade_details")
        String gradeDetails,
        @BsonProperty(value = "final")
        String leaveFinal,
        @BsonProperty(value = "user_id")
        String userId) {
}
