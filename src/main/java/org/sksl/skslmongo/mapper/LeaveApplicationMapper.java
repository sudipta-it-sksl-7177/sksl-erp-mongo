package org.sksl.skslmongo.mapper;

import org.bson.Document;
import org.sksl.skslmongo.record.LeaveApplRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface LeaveApplicationMapper extends Function<List<Document>, List<LeaveApplRecord>> {
    static LeaveApplicationMapper mapDocumentAsPojo() {
        return docs -> {
            List<LeaveApplRecord> records = new ArrayList<>();
            docs.forEach(doc -> records.add(
                    new LeaveApplRecord(
                            doc.getInteger("slno", 1),
                            doc.getString("projcd"),
                            doc.getString("lvyear"),
                            doc.getString("lvmonth"),
                            doc.getString("emp_cd"),
                            doc.getInteger("appl_no", 1),
                            doc.getString("finyear"),
                            doc.getString("emp_name"),
                            doc.getString("leave_type"),
                            doc.getDate("leave_start"),
                            doc.getDate("leave_end"),
                            doc.getInteger("no_of_days", 1),
                            doc.getString("go_to"),
                            doc.getString("reasons"),
                            doc.getString("charge_by"),
                            doc.getDate("rejoin_date"),
                            doc.getString("dept_code"),
                            doc.getString("desg_code"),
                            doc.getString("desg_subcd"),
                            doc.getString("emp_cate"),
                            doc.getString("grade_code"),
                            doc.getString("sex"),
                            doc.getString("location"),
                            doc.getString("location_desc"),
                            doc.getString("projdesc"),
                            doc.getString("desgsub_desc"),
                            doc.getString("desg_name"),
                            doc.getString("dept_name"),
                            doc.getString("grade_details"),
                            doc.getString("final"),
                            doc.getString("user_id")
                    )
            ));
            return records;
        };
    }
}
