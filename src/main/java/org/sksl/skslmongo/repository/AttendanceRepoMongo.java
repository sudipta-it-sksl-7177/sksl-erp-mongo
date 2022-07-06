package org.sksl.skslmongo.repository;

import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.sksl.skslmongo.mapper.LeaveApplicationMapper;
import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("attendanceMongo")
public class AttendanceRepoMongo implements AttendanceRepo {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public AttendanceRepoMongo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<LeaveApplRecord> selectLeaveApplication(LeaveApplPrintUx leaveApplPrintUx) {

        final FindIterable<Document> documents =
                mongoTemplate.getCollection("emp_leave").find();
        final List<Document> docs = new ArrayList<>();
        documents.forEach(docs::add);

        final List<LeaveApplRecord> records = LeaveApplicationMapper.mapDocumentAsPojo().apply(docs);

        return records.stream()
                .filter(elements ->
                        !StringUtils.hasLength(leaveApplPrintUx.projectCode().trim())
                                || elements.projectCode().equalsIgnoreCase(leaveApplPrintUx.projectCode()))
                .filter(elements ->
                        !StringUtils.hasLength(leaveApplPrintUx.reportYear().trim())
                                || elements.leaveYear().equalsIgnoreCase(leaveApplPrintUx.reportYear()))
                .filter(elements ->
                        !StringUtils.hasLength(leaveApplPrintUx.reportMonth().trim())
                                || elements.leaveMonth().equalsIgnoreCase(leaveApplPrintUx.reportMonth()))
                .filter(elements ->
                        !StringUtils.hasLength(leaveApplPrintUx.employeeCode().trim())
                                || elements.employeeCode().equalsIgnoreCase(leaveApplPrintUx.employeeCode()))
                .collect(Collectors.toList());

// TODO: 25-06-2022 Correct technique, but produces null. Needs to be updated with BsonDocumentMapper
//*****************************************************************************************************
//        final Criteria criteria = new Criteria();
//        if (StringUtils.hasLength(leaveApplPrintUx.projectCode().trim())) {
//            criteria.and("projcd").is(leaveApplPrintUx.projectCode().trim());
//        }
//        if (StringUtils.hasLength(leaveApplPrintUx.reportYear().trim())) {
//            criteria.and("lvyear").is(leaveApplPrintUx.reportYear().trim());
//            if (StringUtils.hasLength(leaveApplPrintUx.reportMonth().trim())) {
//                criteria.and("lvmonth").is(leaveApplPrintUx.reportMonth().trim());
//            }
//        }
//        if (StringUtils.hasLength(leaveApplPrintUx.employeeCode().trim())) {
//            criteria.and("emp_cd").is(leaveApplPrintUx.employeeCode().trim());
//        }
//
//        final Query query = new Query();
//        query.fields()
////                .include("projcd", "emp_cd", "leave_start", "leave_end")
//                .exclude("_id");
//        query.addCriteria(criteria);
//
////        final List<LeaveApplRecordMongo> docs =
////                mongoTemplate.find(query, LeaveApplRecordMongo.class, "emp_leave");
//
//        final List<LeaveApplRecordMongo> docs =
//                mongoTemplate.stream(query, LeaveApplRecordMongo.class, "emp_leave")
//                        .stream().toList();
//
//        final List<LeaveApplRecord> records = new ArrayList<>();
//        docs.forEach(doc -> records.add(
//                new LeaveApplRecord(
//                        doc.serialNumber(), doc.projectCode(), doc.leaveYear(), doc.leaveMonth(),
//                        doc.employeeCode(), doc.applicationNumber(), doc.finYear(), doc.employeeName(),
//                        doc.leaveType(), doc.startDate(), doc.endDate(), doc.noOfDays(),
//                        doc.goesTo(), doc.leaveReason(), doc.chargeBy(), doc.rejoinDate(),
//                        doc.departmentCode(), doc.designationCode(), doc.designationSubCode(), doc.employeeCategory(),
//                        doc.gradeCode(), doc.gender(), doc.locationCode(), doc.locationDesc(),
//                        doc.projectDesc(), doc.designationSubDesc(), doc.designationName(), doc.departmentName(),
//                        doc.gradeDetails(), doc.leaveFinal(), doc.userId()
//                )
//        ));
//        return records;
//*****************************************************************************************************

    }
}
