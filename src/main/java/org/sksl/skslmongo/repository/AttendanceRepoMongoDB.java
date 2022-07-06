package org.sksl.skslmongo.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.sksl.skslmongo.mapper.LeaveApplicationMapper;
import org.sksl.skslmongo.record.LeaveApplRecord;
import org.sksl.skslmongo.ux.LeaveApplPrintUx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository("attendanceMongoDB")
public class AttendanceRepoMongoDB implements AttendanceRepo {

    private final MongoDatabase mongoDatabase;

    @Autowired
    public AttendanceRepoMongoDB(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
    }

    @Override
    public List<LeaveApplRecord> selectLeaveApplication(LeaveApplPrintUx leaveApplPrintUx) {

        final MongoCollection<Document> collection =
                mongoDatabase.getCollection("emp_leave");

        final List<Document> aggregate = new ArrayList<>();

        int index = -1;
        if (StringUtils.hasLength(leaveApplPrintUx.projectCode().trim())) {
            index += 1;
            aggregate.add(index, new Document("projcd", leaveApplPrintUx.projectCode().trim()));
        }
        if (StringUtils.hasLength(leaveApplPrintUx.reportYear().trim())) {
            index += 1;
            aggregate.add(index, new Document("lvyear", leaveApplPrintUx.reportYear().trim()));
            if (StringUtils.hasLength(leaveApplPrintUx.reportMonth().trim())) {
                index += 1;
                aggregate.add(index, new Document("lvmonth", leaveApplPrintUx.reportMonth().trim()));
            }
        }
        if (StringUtils.hasLength(leaveApplPrintUx.employeeCode().trim())) {
            index += 1;
            aggregate.add(index, new Document("emp_cd", leaveApplPrintUx.employeeCode().trim()));
        }

        final AggregateIterable<Document> aggregateDocs = collection.aggregate(aggregate);
        final List<Document> docs = new ArrayList<>();
        aggregateDocs.forEach(docs::add);

        return LeaveApplicationMapper.mapDocumentAsPojo().apply(docs);
    }
}
