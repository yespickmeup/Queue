/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.pnl;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
import mijzcx.synapse.desk.utils.Application;
import mijzcx.synapse.desk.utils.CloseDialog;
import qs.announcements.Dlg_announcement;
import qs.counters.Counters;
import qs.counters.Dlg_counter;
import qs.customers.Dlg_customers;
import qs.departments.Dlg_department;
import qs.reports.Dlg_rpt_queues;
import qs.users.Dlg_users;
import qs.users.MyUser;
import qs.users.User_settings;
import qs.users.Users;
import qs.util.Alert;
import qs.util.MyFrame;

import synsoftech.fields.Button;
import synsoftech.fields.Field;

/**
 *
 * @author i1
 */
public class Pnl_Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Pnl_Dashboard
     */
    public Pnl_Dashboard() {
        initComponents();
        myInit();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnl_main_holder = new javax.swing.JPanel();
        pnl_login = new javax.swing.JPanel();
        login = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tf_username = new Field.Input();
        jLabel12 = new javax.swing.JLabel();
        tf_password = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new Button.Default();
        jLabel2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JDesktopPane();
        jPanel6 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(54, 128, 11));

        jLabel51.setBackground(new java.awt.Color(234, 234, 234));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/menu53.png"))); // NOI18N
        jLabel51.setOpaque(true);
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("V1.11.1712");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setBackground(new java.awt.Color(54, 128, 11));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel7MouseEntered(evt);
            }
        });

        pnl_main_holder.setBackground(new java.awt.Color(204, 204, 204));
        pnl_main_holder.setLayout(new java.awt.CardLayout());

        pnl_login.setBackground(new java.awt.Color(255, 255, 255));

        login.setOpaque(false);

        jLabel8.setBackground(new java.awt.Color(69, 157, 18));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(69, 157, 18));
        jLabel8.setText("Username:");

        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(69, 157, 18));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(69, 157, 18));
        jLabel12.setText("Password:");

        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(69, 157, 18));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(69, 157, 18));
        jLabel13.setText("Login with your ");

        jLabel14.setBackground(new java.awt.Color(69, 157, 18));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(69, 157, 18));
        jLabel14.setText("credentials!");

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(129, 159, 0));
        jButton2.setText("Login");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/img/synapse_logo_green (Custom).png"))); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel30.setBackground(new java.awt.Color(69, 157, 18));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(69, 157, 18));
        jLabel30.setText("Synapse Software ");

        jLabel31.setBackground(new java.awt.Color(69, 157, 18));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(69, 157, 18));
        jLabel31.setText("Technologies");

        jLabel32.setBackground(new java.awt.Color(69, 157, 18));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(69, 157, 18));
        jLabel32.setText(" Integrating business with technology");

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_username)
                    .addComponent(tf_password)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))))
                .addContainerGap())
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(loginLayout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel31)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_username, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_password, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl_loginLayout = new javax.swing.GroupLayout(pnl_login);
        pnl_login.setLayout(pnl_loginLayout);
        pnl_loginLayout.setHorizontalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnl_loginLayout.setVerticalGroup(
            pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loginLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addGroup(pnl_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnl_loginLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_main_holder.add(pnl_login, "card5");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        pnl_main_holder.add(jPanel1, "card2");

        jPanel6.setBackground(new java.awt.Color(69, 157, 18));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnl_main_holder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnl_main_holder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowClosing

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
//        check_credentials();
        tf_password.grabFocus();
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        check_credentials();
    }//GEN-LAST:event_tf_passwordActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (jPanel6.isVisible()) {
            jPanel6.setVisible(false);
        } else {
            jPanel6.setVisible(true);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel7MouseEntered

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        menu();
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        check_credentials();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Application.setSystemLookAndFeel();
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Pnl_Dashboard aw = new Pnl_Dashboard();
                String url = "/POS/img/5.png";
                Toolkit tk = Toolkit.getDefaultToolkit();
                int xSize = ((int) tk.getScreenSize().
                        getWidth());
                int ySize = ((int) tk.getScreenSize().
                        getHeight());
                aw.setSize(xSize, ySize);
                Dimension d = aw.jPanel1.getSize();
                aw.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JDesktopPane jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel login;
    private javax.swing.JPanel pnl_login;
    private javax.swing.JPanel pnl_main_holder;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables

    private void myInit() {

        jPanel6.setVisible(false);
        time();
        set_card_items();
        hover();
        set_default_branch();
    }

    private void set_default_branch() {
//        Branch_locations.to_branch_locations to = S4_branch_locations.ret_data();
//        my_branch = to.branch;
//        my_branch_id = to.branch_id;
//        my_location = to.location;
//        my_location_id = "" + to.id;
//        MyUser.setBranch(my_branch);
//        MyUser.setBranch_id(my_branch_id);
//        MyUser.setLocation(my_location);
//        MyUser.setLocation_id(my_location_id);

    }
    String my_branch = "";
    String my_branch_id = "";
    String my_location = "";
    String my_location_id = "";

    private void hover() {
        JLabel[] lbl = {};
        for (final JLabel l : lbl) {
            l.setVisible(false);
            l.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    if (l.isEnabled()) {
                        l.setBackground(new java.awt.Color(255, 255, 255));
                    }

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (l.isEnabled()) {
                        l.setBackground(new java.awt.Color(140, 175, 227));
                    }
                }
            });
        }
    }

    CardLayout cardLayout = new CardLayout();

    private void set_card_items() {
        cardLayout = (CardLayout) pnl_main_holder.getLayout();

        cardLayout.addLayoutComponent("1", pnl_login);
        cardLayout.addLayoutComponent("2", jPanel1);

    }

    private void time() {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Timer ti = new Timer(1000, new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        Calendar currentCalendar = Calendar.getInstance();
//                        Date currentTime = currentCalendar.getTime();
//
//
//                    }
//                });
//                ti.start();
//            }
//        });
//        t.start();
    }

    public void wallpaper(Pnl_Dashboard f) {

//        String url = "/POS/img_wallpaper/1238-hexagons-1680x1050-digital-art-wallpaper.jpg";
//        Wallpaper.do_set(url, f.jPanel1);
    }

    public JDesktopPane pane() {
        return jPanel1;
    }

//    public JXPanel pane2() {
//        return jXPanel2;
//    }
    private void set_account() {

    }

    private void hover(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(230, 227, 227));
        lbl.setForeground(new java.awt.Color(0, 0, 0));
    }

    private void exit(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(139, 125, 107));
        lbl.setForeground(new java.awt.Color(255, 255, 255));
    }

    private void hover2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(29, 141, 253));
//        lbl.setForeground(new java.awt.Color(0, 0, 0));
    }

    private void exit2(JLabel lbl) {
        lbl.setBackground(new java.awt.Color(51, 153, 255));
//        lbl.setForeground(new java.awt.Color(51, 153, 255));
    }

    private void pm_tbl_users() {

//        Point l = jLabel7.getLocation();
//        jPopupMenu1.show(this, l.x, l.y + 34);
    }

    private void check_credentials() {
        String user_name = tf_username.getText();

        String password = tf_password.getText();
        String where = " where user_name = '" + user_name + "' and password='" + password + "' ";
        final Users.to_users to = Users.ret_data_autho(where);
        if (to == null) {
            tf_username.setText("");
            tf_password.setText("");
            tf_username.grabFocus();
            Alert.set(0, "Wrong Username/Password!!");
        } else {

            tf_username.setText("");
            tf_password.setText("");
            MyUser.user_id = "" + to.id;
            MyUser.user_name = to.user_name;
            MyUser.user_screen_name = to.screen_name;
            List<User_settings.to_user_settings> settings = User_settings.ret_data(" where user_id ='" + to.id + "' ");
            if (!settings.isEmpty()) {
                User_settings.to_user_settings setting = (User_settings.to_user_settings) settings.get(0);
                List<Counters.to_counters> counters = Counters.ret_data(" where id='" + setting.counter_id + "'");
//                System.out.println("setting.counter_id: "+setting.counter_id);
                Counters.to_counters counter = (Counters.to_counters) counters.get(0);

                System.setProperty("counter_no", setting.counter_no);
                System.setProperty("teller", to.screen_name);
                System.setProperty("teller_id", "" + to.id);
                System.setProperty("department_id", counter.department_id);
                System.setProperty("department", counter.department);

            }
            jPanel1.removeAll();
            jPanel1.updateUI();
            set_previleges();
            cardLayout.show(pnl_main_holder, "2");

//            if (to.user_name.equals("q1")) {
//                this.dispose();
//                Window p = (Window) this;
//                Dlg_queue nd = Dlg_queue.create(p, true);
//                nd.setTitle("");
//                nd.setCallback(new Dlg_queue.Callback() {
//                    @Override
//                    public void ok(CloseDialog closeDialog, Dlg_queue.OutputData data) {
//                        closeDialog.ok();
//                    }
//                });
////                nd.setLocationRelativeTo(this);
//                Toolkit tk = Toolkit.getDefaultToolkit();
//                int xSize = ((int) tk.getScreenSize().
//                        getWidth());
//                int ySize = ((int) tk.getScreenSize().
//                        getHeight());
//                nd.setSize(xSize, ySize);
//                nd.setVisible(true);
//            }
        }
    }

    //<editor-fold defaultstate="collapsed" desc=" privileges ">
    private void set_previleges() {
//        String where = " where user_id='" + MyUser.getUser_id() + "' order by previledge asc";
//        List<User_previleges.to_user_previleges> datas = User_previleges.ret_data(where);
//        for (User_previleges.to_user_previleges to : datas) {
//            if (to.previledge.equalsIgnoreCase("Sales")) {
//            }
//            //<editor-fold defaultstate="collapsed" desc=" menu icons ">
//            //</editor-fold>
//        }
    }

    //</editor-fold>
    private void menu() {

        Window p = (Window) this;
        Dlg_menu nd = Dlg_menu.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_menu.Callback() {

            @Override
            public void minimize(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();
                Pnl_Dashboard.this.setState(Frame.ICONIFIED);
            }

            @Override
            public void ok1(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();

                if (data.stmt.equals("standby")) {
                    JLabel[] lbl = {};
                    for (final JLabel l : lbl) {
                        l.setVisible(false);
                    }
                    jPanel6.setVisible(false);
                    cardLayout.show(pnl_main_holder, "1");
//                    MyUser.setUser_id("");
                }

                if (data.stmt.equals("logout")) {
                    System.exit(1);
                }
                if (data.stmt.equals("minimize")) {
                    Pnl_Dashboard.this.setState(Frame.ICONIFIED);
                }

                //<editor-fold defaultstate="collapsed" desc=" transactions ">
                if (data.stmt.equals("Queue")) {
//                    t_queue();
                }
                if (data.stmt.equals("Number")) {
                    t_number();
                }

                if (data.stmt.equals("Call")) {
                    t_call();
                }

                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" maintenance ">
                if (data.stmt.equals("Customers")) {
                    m_customers();
                }
                if (data.stmt.equals("Users")) {
                    m_users();
                }
                if (data.stmt.equals("Announcements")) {
                    m_announcements();
                }
                if (data.stmt.equals("Counters")) {
                    m_counters();
                }
                if (data.stmt.equals("Departments")) {
                    m_departments();
                }
                //</editor-fold>
                //<editor-fold defaultstate="collapsed" desc=" Reports ">
                if (data.stmt.equals("Queues - (Report)")) {
                    r_queues();
                }
                if (data.stmt.equals("Customers - (Report)")) {
//                    r_queues();
                }
//                if (data.stmt.equals("Barcodes")) {
//                    r_barcode();
//                }
                //</editor-fold>
            }

            @Override
            public void standby(CloseDialog closeDialog, Dlg_menu.OutputData data) {

                closeDialog.ok();
            }

            @Override
            public void logout(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();
            }
        });
        Point point = jLabel51.getLocationOnScreen();
        nd.setLocation(point.x - 125, point.y + 37);
        nd.setVisible(true);
    }

    private void t_queue() {

//        Dlg_queue dtc = new Dlg_queue();
//        dtc.do_pass();
//        MyFrame.set(dtc.getSurface(), jPanel1, "Queue");
        Window p = (Window) this;
        Dlg_queue nd = Dlg_queue.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_queue.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_queue.OutputData data) {
                closeDialog.ok();

            }
        });
//        nd.setLocationRelativeTo(this);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        nd.setSize(xSize, ySize);
        nd.setVisible(true);

    }

    private void t_number() {
        Dlg_generate_number dtc = new Dlg_generate_number();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Generate", dtc.getWidth(), dtc.getHeight());
    }

    private void t_call() {
        Dlg_call_number dtc = new Dlg_call_number();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Call", dtc.getWidth(), dtc.getHeight());
    }

    private void m_customers() {
        Dlg_customers dtc = new Dlg_customers();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Customers", dtc.getWidth(), dtc.getHeight());
    }

    private void m_users() {
        Dlg_users dtc = new Dlg_users();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Users", dtc.getWidth(), dtc.getHeight());
    }

    private void m_announcements() {
        Dlg_announcement dtc = new Dlg_announcement();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Announcements", dtc.getWidth(), dtc.getHeight());
    }

    private void m_counters() {
        Dlg_counter dtc = new Dlg_counter();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Counters", dtc.getWidth(), dtc.getHeight());
    }

    private void m_departments() {
        Dlg_department dtc = new Dlg_department();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Departments", dtc.getWidth(), dtc.getHeight());
    }

    private void r_queues() {
        Dlg_rpt_queues dtc = new Dlg_rpt_queues();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Queues", dtc.getWidth(), dtc.getHeight());
    }

    private void r_customers() {
        Dlg_rpt_queues dtc = new Dlg_rpt_queues();
        dtc.do_pass();
        MyFrame.set2(dtc.getSurface(), jPanel1, "Queues", dtc.getWidth(), dtc.getHeight());
    }
//    private void m_departments() {
//        Dlg_my_services_departments dtc = new Dlg_my_services_departments();
//        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Departments", dtc.getWidth(), dtc.getHeight());
//    }
//
//    private void m_members() {
//        Dlg_my_services_crews dtc = new Dlg_my_services_crews();
//        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Department Members", dtc.getWidth(), dtc.getHeight());
//    }
//
//    private void m_type() {
//        Dlg_my_service_type dtc = new Dlg_my_service_type();
//        MyFrame.set2(dtc.getSurface(), jPanel1, "Service Transaction Type", dtc.getWidth(), dtc.getHeight());
//    }
//
//    private void r_services() {
//        Dlg_report_services dtc = new Dlg_report_services();
//        MyFrame.set(dtc.getSurface(), jPanel1, "Services Report");
//
//    }
//
//    private void r_barcode() {
//        Dlg_my_services_print_barcodes dtc = new Dlg_my_services_print_barcodes();
//        MyFrame.set(dtc.getSurface(), jPanel1, "Barcodes");
//
//    }
}
