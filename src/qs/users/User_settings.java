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
public class User_settings {

    public static class to_user_settings {

        public final int id;
        public final String user_id;
        public final String user_name;
        public final String counter_id;
        public final String counter_no;
        public final String created_at;
        public final String updated_at;
        public final String created_by;
        public final String updated_by;

        public to_user_settings(int id, String user_id, String user_name, String counter_id, String counter_no, String created_at, String updated_at, String created_by, String updated_by) {
            this.id = id;
            this.user_id = user_id;
            this.user_name = user_name;
            this.counter_id = counter_id;
            this.counter_no = counter_no;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.created_by = created_by;
            this.updated_by = updated_by;
        }
    }

    public static void add_data(to_user_settings to_user_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_settings("
                    + "user_id"
                    + ",user_name"
                    + ",counter_id"
                    + ",counter_no"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + ")values("
                    + ":user_id"
                    + ",:user_name"
                    + ",:counter_id"
                    + ",:counter_no"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:created_by"
                    + ",:updated_by"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_settings.user_id)
                    .setString("user_name", to_user_settings.user_name)
                    .setString("counter_id", to_user_settings.counter_id)
                    .setString("counter_no", to_user_settings.counter_no)
                    .setString("created_at", to_user_settings.created_at)
                    .setString("updated_at", to_user_settings.updated_at)
                    .setString("created_by", to_user_settings.created_by)
                    .setString("updated_by", to_user_settings.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_settings.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_user_settings to_user_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_settings set "
                    + "user_id= :user_id "
                    + ",user_name= :user_name "
                    + ",counter_id= :counter_id "
                    + ",counter_no= :counter_no "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + " where id='" + to_user_settings.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("user_id", to_user_settings.user_id)
                    .setString("user_name", to_user_settings.user_name)
                    .setString("counter_id", to_user_settings.counter_id)
                    .setString("counter_no", to_user_settings.counter_no)
                    .setString("created_at", to_user_settings.created_at)
                    .setString("updated_at", to_user_settings.updated_at)
                    .setString("created_by", to_user_settings.created_by)
                    .setString("updated_by", to_user_settings.updated_by)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_settings.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_user_settings to_user_settings) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_settings  "
                    + " where id='" + to_user_settings.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_settings.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_settings> ret_data(String where) {
        List<to_user_settings> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",user_id"
                    + ",user_name"
                    + ",counter_id"
                    + ",counter_no"
                    + ",created_at"
                    + ",updated_at"
                    + ",created_by"
                    + ",updated_by"
                    + " from user_settings"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String user_id = rs.getString(2);
                String user_name = rs.getString(3);
                String counter_id = rs.getString(4);
                String counter_no = rs.getString(5);
                String created_at = rs.getString(6);
                String updated_at = rs.getString(7);
                String created_by = rs.getString(8);
                String updated_by = rs.getString(9);

                to_user_settings to = new to_user_settings(id, user_id, user_name, counter_id, counter_no, created_at, updated_at, created_by, updated_by);
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
