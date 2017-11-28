/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.template;


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
public class Degrees {

    public static class to_degrees {

        public final int id;
        public final String degree;
        public final String created_by;
        public final String updated_by;
        public final String created_at;
        public final String updated_at;
        public final int status;
        public final int is_uploaded;

        public to_degrees(int id, String degree, String created_by, String updated_by, String created_at, String updated_at, int status, int is_uploaded) {
            this.id = id;
            this.degree = degree;
            this.created_by = created_by;
            this.updated_by = updated_by;
            this.created_at = created_at;
            this.updated_at = updated_at;
            this.status = status;
            this.is_uploaded = is_uploaded;
        }
    }

    public static void add_data(to_degrees to_degrees) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into degrees("
                    + "degree"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",is_uploaded"
                    + ")values("
                    + ":degree"
                    + ",:created_by"
                    + ",:updated_by"
                    + ",:created_at"
                    + ",:updated_at"
                    + ",:status"
                    + ",:is_uploaded"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("degree", to_degrees.degree)
                    .setString("created_by", to_degrees.created_by)
                    .setString("updated_by", to_degrees.updated_by)
                    .setString("created_at", to_degrees.created_at)
                    .setString("updated_at", to_degrees.updated_at)
                    .setNumber("status", to_degrees.status)
                    .setNumber("is_uploaded", to_degrees.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Degrees.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void update_data(to_degrees to_degrees) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update degrees set "
                    + "degree= :degree "
                    + ",created_by= :created_by "
                    + ",updated_by= :updated_by "
                    + ",created_at= :created_at "
                    + ",updated_at= :updated_at "
                    + ",status= :status "
                    + ",is_uploaded= :is_uploaded "
                    + " where id='" + to_degrees.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("degree", to_degrees.degree)
                    .setString("created_by", to_degrees.created_by)
                    .setString("updated_by", to_degrees.updated_by)
                    .setString("created_at", to_degrees.created_at)
                    .setString("updated_at", to_degrees.updated_at)
                    .setNumber("status", to_degrees.status)
                    .setNumber("is_uploaded", to_degrees.is_uploaded)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Degrees.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_data(to_degrees to_degrees) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from degrees  "
                    + " where id='" + to_degrees.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(Degrees.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_degrees> ret_data(String where) {
        List<to_degrees> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",degree"
                    + ",created_by"
                    + ",updated_by"
                    + ",created_at"
                    + ",updated_at"
                    + ",status"
                    + ",is_uploaded"
                    + " from degrees"
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String degree = rs.getString(2);
                String created_by = rs.getString(3);
                String updated_by = rs.getString(4);
                String created_at = rs.getString(5);
                String updated_at = rs.getString(6);
                int status = rs.getInt(7);
                int is_uploaded = rs.getInt(8);

                to_degrees to = new to_degrees(id, degree, created_by, updated_by, created_at, updated_at, status, is_uploaded);
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
