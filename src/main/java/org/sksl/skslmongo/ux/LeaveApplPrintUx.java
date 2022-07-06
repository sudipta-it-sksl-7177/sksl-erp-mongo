package org.sksl.skslmongo.ux;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Size;

public record LeaveApplPrintUx(String projectCode, String reportYear, String reportMonth,
                               @JsonIgnore String employeeCode, int applicationNumber) {
    public LeaveApplPrintUx(
            @Size(max = 3, message = "Project Code Must Be Within 2 To 3 Character Long Or Blank") @JsonProperty("projectCode") String projectCode,
            @Size(max = 4, message = "Report Year Must Be 4 Character Long Or Blank") @JsonProperty("reportYear") String reportYear,
            @Size(max = 2, message = "Report Month Must Be 2 Character Long Or Blank") @JsonProperty("reportMonth") String reportMonth,
            @Size(max = 5, message = "Employee Code Must Be Within 4 To 5 Character Long Or Blank") @JsonProperty("employeeCode") String employeeCode,
            @Range(min = 0, max = 9999, message = "Application Number Must Be Within 9999 Or Zero") @JsonProperty("applicationNumber") int applicationNumber) {
        this.projectCode = projectCode;
        this.reportYear = reportYear;
        this.reportMonth = reportMonth;
        this.employeeCode = employeeCode;
        this.applicationNumber = applicationNumber;
    }

    @Override
    public String employeeCode() {
        return employeeCode;
    }
}
