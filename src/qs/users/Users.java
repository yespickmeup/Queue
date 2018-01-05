/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.users;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;
import qs.util.MyConnection;

/**
 *
 * @author Guinness
 */
public class Users {

    public static class to_users {

        public final int id;
        public final String screen_name;
        public final String user_name;
        public final String password;
        public final String clinic;
        public final String clinic_id;
        public final String doctor;
        public final String doctor_id;
        public final String created_at;
        public final String updated_at;
        public final int status;
        public final int is_uploaded;

        public to_users(int id, String screen_name, String user_name, String password, String clinic, String clinic_id, String doctor, String doctor_id, String created_at, String updated_at, int status, int is_uploaded) {
            this.id = id;
            this.screen_name = screen_name;
            this.user_name = user_name;
            this.password = password;
            this.clinic = clinic;
            this.clinic_id = clinic_id;
            this.doctor = doctor;
            this.doctor_id = doctor_id;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.status = status;
            this.is_uploaded = is_uploaded;
        }
    }

    public static void add_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into users("
                    + "screen_name"
                    + ",user_name"
                    + ",password"
                    + ",clinic"
                    + ",clinic_id"
                    + ",doctor"
                    + ",doctor_id"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",is_uploaded"
                    + ")values("
                    + ":screen_name"
                    + ",:user_name"
                    + ",:password"
                    + ",:clinic"
                    + ",:clinic_id"
                    + ",:doctor"
                    + ",:doctor_id"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:status"
                    + ",:is_uploaded"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", to_users.screen_name)
                    .setString("user_name", to_users.user_name)
                    .setString("password", to_users.password)
                    .setString("clinic", to_users.clinic)
                    .setString("clinic_id", to_users.clinic_id)
                    .setString("doctor", to_users.doctor)
                    .setString("doctor_id", to_users.doctor_id)
                    .setString("created_at", to_users.created_at)
                    .setString("updated_at", to_users.updated_at)
                    .setNumber("status", to_users.status)
                    .setNumber("is_uploaded", to_users.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update users set "
                    + "screen_name= :screen_name "
                    + ",user_name= :user_name "
                    + ",password= :password "
                    + ",clinic= :clinic "
                    + ",clinic_id= :clinic_id "
                    + ",doctor= :doctor "
                    + ",doctor_id= :doctor_id "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",status= :status "
                    + ",is_uploaded= :is_uploaded "
                    + " where id='" + to_users.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("screen_name", to_users.screen_name)
                    .setString("user_name", to_users.user_name)
                    .setString("password", to_users.password)
                    .setString("clinic", to_users.clinic)
                    .setString("clinic_id", to_users.clinic_id)
                    .setString("doctor", to_users.doctor)
                    .setString("doctor_id", to_users.doctor_id)
                    .setString("created_at", to_users.created_at)
                    .setString("updated_at", to_users.updated_at)
                    .setNumber("status", to_users.status)
                    .setNumber("is_uploaded", to_users.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Users.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_users to_users) {
        try {
            Connection conn = MyConnection.connect();
            conn.setAutoCommit(false);
            String s0 = "delete from users  "
                    + " where id='" + to_users.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.addBatch(s0);

            String s2 = "delete from user_priveleges  "
                    + " where user_id='" + to_users.id + "' "
                    + " ";

            stmt.addBatch(s2);

            stmt.executeBatch();
            conn.commit();
            Lg.s(Users.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_users> ret_data(String where) {
        List<to_users> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",clinic"
                    + ",clinic_id"
                    + ",doctor"
                    + ",doctor_id"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",is_uploaded"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                String clinic = rs.getString(5);
                String clinic_id = rs.getString(6);
                String doctor = rs.getString(7);
                String doctor_id = rs.getString(8);
                String created_at = rs.getString(9);
                String updated_at = rs.getString(10);
                int status = rs.getInt(11);
                int is_uploaded = rs.getInt(12);

                to_users to = new to_users(id, screen_name, user_name, password, clinic, clinic_id, doctor, doctor_id, created_at, updated_at, status, is_uploaded);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_users ret_data_autho(String where) {
        to_users to = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",clinic"
                    + ",clinic_id"
                    + ",doctor"
                    + ",doctor_id"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",is_uploaded"
                    + " from users"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                String clinic = rs.getString(5);
                String clinic_id = rs.getString(6);
                String doctor = rs.getString(7);
                String doctor_id = rs.getString(8);
                String created_at = rs.getString(9);
                String updated_at = rs.getString(10);
                int status = rs.getInt(11);
                int is_uploaded = rs.getInt(12);

                to = new to_users(id, screen_name, user_name, password, clinic, clinic_id, doctor, doctor_id, created_at, updated_at, status, is_uploaded);

            }
            return to;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}
