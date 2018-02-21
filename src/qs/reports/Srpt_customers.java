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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.JasperUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import qs.util.MyConnection;
import synsoftech.util.DateType;

/**
 *
 * @author Guinness
 */
public class Srpt_customers {

    public final String business_name;
    public final String address;
    public final String contact_no;
    public final String date;
    public final List<field> fields;

    public Srpt_customers(String business_name, String address, String contact_no, String date) {
        this.business_name = business_name;
        this.address = address;
        this.contact_no = contact_no;
        this.date = date;
        this.fields = new ArrayList();
    }

    public static class field {

        String customer_no;
        String name;
        String bday;
        String gender;
        String address;
        String contact_no;

        public field() {
        }

        public field(String customer_no, String name, String bday, String gender, String address, String contact_no) {
            this.customer_no = customer_no;
            this.name = name;
            this.bday = bday;
            this.gender = gender;
            this.address = address;
            this.contact_no = contact_no;
        }

        public String getCustomer_no() {
            return customer_no;
        }

        public void setCustomer_no(String customer_no) {
            this.customer_no = customer_no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getBday() {
            return bday;
        }

        public void setBday(String bday) {
            this.bday = bday;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact_no() {
            return contact_no;
        }

        public void setContact_no(String contact_no) {
            this.contact_no = contact_no;
        }
    }

    public static void main(String[] args) {
        String business_name = System.getProperty("business_name", "");
        String address = System.getProperty("address", "");
        String contact_no = System.getProperty("contact_no", "");
        String date = DateType.slash.format(new Date());

        List<field> datas = ret_data(" order by lname asc ");
        Srpt_customers rpt = new Srpt_customers(business_name, address, contact_no, date);
        rpt.fields.addAll(datas);
        String jrxml = "rpt_customers.jrxml";
        JRViewer viewer = get_viewer(rpt, jrxml);
        JFrame f = Application.launchMainFrame3(viewer, "Sample", true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JasperReport compileJasper(String jrxml) {
        try {

            InputStream is = Srpt_customers.class.getResourceAsStream(jrxml);
            JasperReport jasper = JasperCompileManager.compileReport(is);

            return jasper;
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public static JRViewer get_viewer(Srpt_customers to, String jrxml) {

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
                    + ",customer_no"
                    + ",fname"
                    + ",mi"
                    + ",lname"
                    + ",sname"
                    + ",bday"
                    + ",gender"
                    + ",occupation"
                    + ",address"
                    + ",barangay"
                    + ",city"
                    + ",province"
                    + ",contact_no"
                    + ",email_address"
                    + ",status"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from customers"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String customer_no = rs.getString(2);
                String fname = rs.getString(3);
                String mi = rs.getString(4);
                String lname = rs.getString(5);
                String sname = rs.getString(6);
                String bday = rs.getString(7);
                int gender = rs.getInt(8);
                String occupation = rs.getString(9);
                String address = rs.getString(10);
                String barangay = rs.getString(11);
                String city = rs.getString(12);
                String province = rs.getString(13);
                String contact_no = rs.getString(14);
                String email_address = rs.getString(15);
                int status = rs.getInt(16);
                String created_at = rs.getString(17);
                String updated_at = rs.getString(18);
                String created_by = rs.getString(19);
                String updated_by = rs.getString(20);
                String name=lname + ", "+fname + " "+mi;
                String gen="Male";
                if(gender==0){
                    gen="Female";
                }
                bday=DateType.convert_slash_datetime2(bday);
                field f = new field(customer_no, name, bday, gen, address, contact_no);
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
