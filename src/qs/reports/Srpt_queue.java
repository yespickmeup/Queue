/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.reports;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import qs.util.DateType;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Srpt_queue {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final String status;
    public final List<field> fields;

    public Srpt_queue(String business_name, String address, String contact_no, String date, String status) {
        this.fields = new ArrayList();
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.status = status;
    }

    public static class field {

        String queue_no;
        String department_id;
        String department;
        String customer;
        String customer_id;
        String counter_no;
        String teller;
        String teller_id;
        String remarks;
        String status;
        String created_at;
        String updated_at;

        public field() {

        }

        public field(String queue_no, String department_id, String department, String customer, String customer_id, String counter_no, String teller, String teller_id, String remarks, String status, String created_at, String updated_at) {
            this.queue_no = queue_no;
            this.department_id = department_id;
            this.department = department;
            this.customer = customer;
            this.customer_id = customer_id;
            this.counter_no = counter_no;
            this.teller = teller;
            this.teller_id = teller_id;
            this.remarks = remarks;
            this.status = status;
            this.created_at = created_at;
            this.updated_at = updated_at;
        }

        public String getQueue_no() {
            return queue_no;
        }

        public void setQueue_no(String queue_no) {
            this.queue_no = queue_no;
        }

        public String getDepartment_id() {
            return department_id;
        }

        public void setDepartment_id(String department_id) {
            this.department_id = department_id;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }

        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCounter_no() {
            return counter_no;
        }

        public void setCounter_no(String counter_no) {
            this.counter_no = counter_no;
        }

        public String getTeller() {
            return teller;
        }

        public void setTeller(String teller) {
            this.teller = teller;
        }

        public String getTeller_id() {
            return teller_id;
        }

        public void setTeller_id(String teller_id) {
            this.teller_id = teller_id;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "");
        String address = System.getProperty("address", "");
        String contact_no = System.getProperty("contact_no", "");
        String date = DateType.slash.format(new Date());
        String status = "All";

        List<field> datas = Srpt_queue.ret_data("");
        Srpt_queue rpt = new Srpt_queue(business_name, address, contact_no, date, status);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_queue.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_queue.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_queue to, String jrxml) {

        return JasperUtil.getJasperViewer(
                compileJasper(jrxml),
                JasperUtil.setParameter(to),
                JasperUtil.makeDatasource(to.fields));
    }

    public static List<field> ret_data(String where) {
        List<field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",queue_no"
                    + ",department"
                    + ",department_id"
                    + ",customer"
                    + ",customer_id"
                    + ",counter_no"
                    + ",teller"
                    + ",teller_id"
                    + ",remarks"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from queues"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String queue_no = rs.getString(2);
                String department = rs.getString(3);
                String department_id = rs.getString(4);
                String customer = rs.getString(5);
                String customer_id = rs.getString(6);
                String counter_no = rs.getString(7);
                String teller = rs.getString(8);
                String teller_id = rs.getString(9);
                String remarks = rs.getString(10);
                int status = rs.getInt(11);
                String created_at = rs.getString(12);
                String updated_at = rs.getString(13);
                String created_by = rs.getString(14);
                String updated_by = rs.getString(15);
                Date d1 = new Date();
                Date d2 = new Date();
                try {
                    d1 = DateType.datetime.parse(created_at);
                    d2 = DateType.datetime.parse(updated_at);
                } catch (ParseException ex) {
                    Logger.getLogger(Srpt_queue.class.getName()).log(Level.SEVERE, null, ex);
                }
                created_at = DateType.convert_slash_datetime3(created_at);
                updated_at = DateType.convert_slash_datetime3(updated_at);

                long diff = d2.getTime() - d1.getTime();
                long diffSeconds = TimeUnit.MILLISECONDS.toSeconds(diff) % 60;
                long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff) % 60;
                long diffHours = TimeUnit.MILLISECONDS.toHours(diff);
                remarks = "" + diffHours + ":" + diffMinutes + ":" + diffSeconds;
                String state = "Queued";
                if (status == 1) {
                    state = "Finished";
                }
                if (status == 2) {
                    state = "Cancelled";
                }
                if (status == 3) {
                    state = "No Show";
                }

                field f = new field(queue_no, department_id, department, customer, customer_id, counter_no, teller, teller_id, remarks, state, created_at, updated_at);
                datas.add(f);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
