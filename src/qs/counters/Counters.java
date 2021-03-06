/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.counters;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.counter_departments.Counter_departments;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Counters {

    public static class to_counters {

        public final int id;
        public final String counter;
        public final String department;
        public final String department_id;
        public final String ip_address;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;
        public final int status;
        public final String shortcut;
        public final int login;

        public to_counters(int id, String counter, String department, String department_id, String ip_address, String created_at, String updated_at, String created_by, String updated_by, int status, String shortcut, int login) {
            this.id = id;
            this.counter = counter;
            this.department = department;
            this.department_id = department_id;
            this.ip_address = ip_address;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.status = status;
            this.shortcut = shortcut;
            this.login = login;
        }
    }

    public static void add_data(to_counters to_counters, List<Counter_departments.to_counter_departments> counter_departments) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into counters("
                    + "counter"
                    + ",department"
                    + ",department_id"
                    + ",ip_address"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ",shortcut"
                    + ",login"
                    + ")values("
                    + ":counter"
                    + ",:department"
                    + ",:department_id"
                    + ",:ip_address"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:status"
                    + ",:shortcut"
                    + ",:login"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter", to_counters.counter)
                    .setString("department", to_counters.department)
                    .setString("department_id", to_counters.department_id)
                    .setString("ip_address", to_counters.ip_address)
                    .setString("created_at", to_counters.created_at)
                    .setString("updated_at", to_counters.updated_at)
                    .setString("created_by", to_counters.created_by)
                    .setString("updated_by", to_counters.updated_by)
                    .setNumber("status", to_counters.status)
                    .setString("shortcut", to_counters.shortcut)
                    .setNumber("login", to_counters.login)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            int id = 0;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }

            PreparedStatement stmt2 = conn.prepareStatement("");
            for (Counter_departments.to_counter_departments to_counter_departments : counter_departments) {
                String s2 = "insert into counter_departments("
                        + "counter_id"
                        + ",counter"
                        + ",department_id"
                        + ",department"
                        + ",created_at"
                        + ",updated_at"
                        + ",status"
                        + ",priority"
                        + ")values("
                        + ":counter_id"
                        + ",:counter"
                        + ",:department_id"
                        + ",:department"
                        + ",:created_at"
                        + ",:updated_at"
                        + ",:status"
                        + ",:priority"
                        + ")";

                s2 = SqlStringUtil.parse(s2)
                        .setNumber("counter_id", id)
                        .setString("counter", to_counters.counter)
                        .setString("department_id", to_counter_departments.department_id)
                        .setString("department", to_counter_departments.department)
                        .setString("created_at", to_counter_departments.created_at)
                        .setString("updated_at", to_counter_departments.updated_at)
                        .setNumber("status", to_counter_departments.status)
                        .setNumber("priority", to_counter_departments.priority)
                        .ok();
                stmt2.addBatch(s2);
            }
            stmt2.executeBatch();

            Lg.s(Counters.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_counters to_counters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update counters set "
                    + "counter= :counter "
                    + ",department= :department "
                    + ",department_id= :department_id "
                    + ",ip_address= :ip_address "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",status= :status "
                    + ",shortcut= :shortcut"
                    + ",login= :login"
                    + " where id='" + to_counters.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("counter", to_counters.counter)
                    .setString("department", to_counters.department)
                    .setString("department_id", to_counters.department_id)
                    .setString("ip_address", to_counters.ip_address)
                    .setString("created_at", to_counters.created_at)
                    .setString("updated_at", to_counters.updated_at)
                    .setString("created_by", to_counters.created_by)
                    .setString("updated_by", to_counters.updated_by)
                    .setNumber("status", to_counters.status)
                    .setString("shortcut", to_counters.shortcut)
                    .setNumber("login", to_counters.login)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "update counter_departments set "
                    + " counter= :counter "
                    + " where counter_id='" + to_counters.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("counter", to_counters.counter)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();

            Lg.s(Counters.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_login_status(to_counters to_counters, int login_status) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update counters set "
                    + " login= :login"
                    + " where id='" + to_counters.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setNumber("login", login_status)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Counters.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_counters to_counters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from counters  "
                    + " where id='" + to_counters.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();

            String s2 = "delete from counter_departments  "
                    + " where counter_id='" + to_counters.id + "' "
                    + " ";

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(Counters.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_counters> ret_data(String where) {
        List<to_counters> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",counter"
                    + ",department"
                    + ",department_id"
                    + ",ip_address"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ",status"
                    + ",shortcut"
                    + ",login"
                    + " from counters"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String counter = rs.getString(2);
                String department = rs.getString(3);
                String department_id = rs.getString(4);
                String ip_address = rs.getString(5);
                String created_at = rs.getString(6);
                String updated_at = rs.getString(7);
                String created_by = rs.getString(8);
                String updated_by = rs.getString(9);
                int status = rs.getInt(10);
                String shortcut = rs.getString(11);
                int login = rs.getInt(12);
                to_counters to = new to_counters(id, counter, department, department_id, ip_address, created_at, updated_at, created_by, updated_by, status, shortcut, login);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}
