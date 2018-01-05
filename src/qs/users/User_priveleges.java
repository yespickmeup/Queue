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
public class User_priveleges {

    public static class to_user_priveleges {

        public final int id;
        public final String account;
        public final String privelege;
        public final String user_id;
        public final String user_name;

        public to_user_priveleges(int id, String account, String privelege, String user_id, String user_name) {
            this.id = id;
            this.account = account;
            this.privelege = privelege;
            this.user_id = user_id;
            this.user_name = user_name;
        }
    }

    public static void add_data(to_user_priveleges to_user_priveleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into user_priveleges("
                    + "account"
                    + ",privelege"
                    + ",user_id"
                    + ",user_name"
                    + ")values("
                    + ":account"
                    + ",:privelege"
                    + ",:user_id"
                    + ",:user_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_priveleges.account)
                    .setString("privelege", to_user_priveleges.privelege)
                    .setString("user_id", to_user_priveleges.user_id)
                    .setString("user_name", to_user_priveleges.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_priveleges.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_user_priveleges to_user_priveleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update user_priveleges set "
                    + "account= :account "
                    + ",privelege= :privelege "
                    + ",user_id= :user_id "
                    + ",user_name= :user_name "
                    + " where id='" + to_user_priveleges.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("account", to_user_priveleges.account)
                    .setString("privelege", to_user_priveleges.privelege)
                    .setString("user_id", to_user_priveleges.user_id)
                    .setString("user_name", to_user_priveleges.user_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_priveleges.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_user_priveleges to_user_priveleges) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_priveleges  "
                    + " where id='" + to_user_priveleges.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_priveleges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(String where) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from user_priveleges  "
                    + " " + where;

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(User_priveleges.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_user_priveleges> ret_data(String where) {
        List<to_user_priveleges> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",account"
                    + ",privelege"
                    + ",user_id"
                    + ",user_name"
                    + " from user_priveleges"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String account = rs.getString(2);
                String privelege = rs.getString(3);
                String user_id = rs.getString(4);
                String user_name = rs.getString(5);

                to_user_priveleges to = new to_user_priveleges(id, account, privelege, user_id, user_name);
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
