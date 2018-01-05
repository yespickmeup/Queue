/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.users;

/**
 *
 * @author Guinness
 */
public class MyUser {

    public static String user_id;
    public static String user_name;
    public static String user_screen_name;
    public static String branch;
    public static String branch_id;
    public static String location;
    public static String location_id;
    public static String clinic;
    public static String clinic_id;

    public MyUser() {
    }

    public static String getClinic() {
        if (clinic == null) {
            return "";
        }
        return clinic;
    }

    public static void setClinic(String clinic) {
        MyUser.clinic = clinic;
    }

    public static String getClinic_id() {
        if (clinic_id == null) {
            return "";
        }
        return clinic_id;
    }

    public static void setClinic_id(String clinic_id) {
        MyUser.clinic_id = clinic_id;
    }

    public static String getBranch() {
        if (branch == null) {
            return "";
        }
        return branch;
    }

    public static void setBranch(String branch) {
        MyUser.branch = branch;
    }

    public static String getBranch_id() {
        if (branch_id == null) {
            return "";

        }
        return branch_id;
    }

    public static void setBranch_id(String branch_id) {
        MyUser.branch_id = branch_id;
    }

    public static String getLocation() {
        if (location == null) {
            return "";
        }
        return location;
    }

    public static void setLocation(String location) {
        MyUser.location = location;
    }

    public static String getLocation_id() {
        if (location_id == null) {
            return "";
        }
        return location_id;
    }

    public static void setLocation_id(String location_id) {
        MyUser.location_id = location_id;
    }

    public static String getUser_id() {
        if (user_id == null) {
            return "";
        }
        return user_id;
    }

    public static void setUser_id(String user_id) {
        MyUser.user_id = user_id;
    }

    public static String getUser_name() {
        if (user_name == null) {
            return "";
        }
        return user_name;
    }

    public void setUser_name(String user_name) {
        MyUser.user_name = user_name;
    }

    public static String getUser_screen_name() {
        if (user_screen_name == null) {
            return "";
        }
        return user_screen_name;
    }

    public void setUser_screen_name(String user_screen_name) {
        MyUser.user_screen_name = user_screen_name;
    }

}
