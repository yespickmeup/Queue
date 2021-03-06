/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.swing.JFrame;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import qs.pnl.Dlg_call_number;
import qs.pnl.Frm_Dashboard;
import qs.settings.Settings;

import qs.util.Center;

/**
 *
 * @author Guinness
 */
public class MyMain {

    public static void main(String[] args) {
        ret_config();
    }

    private static void ret_config() {
        String home = System.getProperty("user.home") + "\\my_config_queue.conf";

        try {

            Properties prop = new Properties();
            String conf = "my_config_queue.conf";
            String userHome = System.getProperty("user.home");
//            System.out.println(conf);
            File file = new File(userHome + "/" + conf);
            if (file.exists()) {
                InputStream is = new FileInputStream(file);
                prop.load(is);
            } else {
                file = new File(conf);
                if (file.exists()) {
                    InputStream is = new FileInputStream(file);
                    prop.load(is);
                }
            }

//            System.out.println(home);
            System.setProperty("pool_host", prop.getProperty("pool_host", "localhost"));
            System.setProperty("pool_port", prop.getProperty("pool_port", "3306"));
            System.setProperty("pool_user", prop.getProperty("pool_user", "root"));
            System.setProperty("pool_password", prop.getProperty("pool_password", "synapse246"));
            System.setProperty("pool_db", prop.getProperty("pool_db", "db_queue"));
            System.setProperty("hdd_drive", prop.getProperty("hdd_drive", ""));
            System.setProperty("environment", prop.getProperty("environment", "production"));
            System.setProperty("version", prop.getProperty("version", ""));
            System.setProperty("VLC_PLUGIN_PATH", prop.getProperty("VLC_PLUGIN_PATH", ""));
            System.setProperty("VLC_PLUGIN_NATIVE_PATH", prop.getProperty("VLC_PLUGIN_NATIVE_PATH", ""));

            System.out.println("Host: " + System.getProperty("pool_host"));
            List<Settings.to_settings> settings = Settings.ret_data("");
            if (!settings.isEmpty()) {
                Settings.to_settings setting = settings.get(0);
                System.setProperty("business_name", prop.getProperty("business_name", setting.business_name));
                System.setProperty("address", prop.getProperty("address", setting.address));
                System.setProperty("operated_by", prop.getProperty("operated_by", ""));
                System.setProperty("contact_number", prop.getProperty("contact_number", setting.contact_no));
                System.setProperty("slogan", prop.getProperty("slogan", ""));
                if (setting.print_queue_no == 0) {
                    System.setProperty("print_queue_no", prop.getProperty("print_queue_no", "false"));
                } else {
                    System.setProperty("print_queue_no", prop.getProperty("print_queue_no", "true"));
                }
                System.setProperty("queue_server_ip", prop.getProperty("queue_server_ip", setting.queue_server_ip));
                System.setProperty("queue_server_port", prop.getProperty("queue_server_port", setting.queue_server_port));
                System.setProperty("location_screen_x", prop.getProperty("location_screen_x", setting.location_screen_x));
                System.setProperty("location_screen_y", prop.getProperty("location_screen_y", setting.location_screen_y));

                System.setProperty("screen_size_x", prop.getProperty("screen_size_x", "" + setting.screen_size_x));
                System.setProperty("screen_size_y", prop.getProperty("screen_size_y", "" + setting.screen_size_y));
                System.setProperty("play_video_sound", prop.getProperty("play_video_sound", "" + setting.play_video_sound));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            Window p = (Window) new JFrame();
            Loading nd = Loading.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Loading.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Loading.OutputData data) {
                    new MyMain().start();
                    closeDialog.ok();
                }
            });
            Center.setCenter(nd);
            nd.setVisible(true);
        }
    }

    private void start() {

        Application.setSystemLookAndFeel();

        Frm_Dashboard f = new Frm_Dashboard();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/qs/img/link_logo (Custom).png"));
        f.setIconImage(image);
        Dlg_call_number dialog = Dlg_call_number.create(new javax.swing.JFrame(), true);

        f.setSize(258, dialog.getHeight() + 25);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - f.getWidth() - 5;
        int y = (int) rect.getMaxY() - f.getHeight() - 55;

        f.setLocation(x, y);

        f.setVisible(true);
        f.add_call();
    }

    private void start2() {

        Application.setSystemLookAndFeel();
        JFrame f = new JFrame();

        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/qs/img/link_logo (Custom).png"));
        f.setIconImage(image);
        Dlg_call_number dialog = Dlg_call_number.create(new javax.swing.JFrame(), true);
        dialog.start_teller_server();
        f.add(dialog.getContentPane());
        f.setUndecorated(true);
        f.setSize(dialog.getWidth(), dialog.getHeight() - 50);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - f.getWidth() - 5;
        int y = (int) rect.getMaxY() - f.getHeight() - 55;

        f.setLocation(x, y);

        f.setVisible(true);
        dialog.login();
    }

    public static String getSerialNumber() {
        String drive = System.getProperty("hdd_drive", "");

        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    + "Set colDrives = objFSO.Drives\n"
                    + "Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    + "Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.trim();
    }
}
