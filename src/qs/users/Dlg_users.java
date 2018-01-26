/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.users;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.users.User_default_priveleges.to_user_default_priveleges;
import qs.users.Users.to_users;
import qs.util.Alert;
import qs.util.DateType;
import qs.util.Dlg_confirm_action;
import qs.util.Dlg_confirm_delete;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_users extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_users
     */
    //<editor-fold defaultstate="collapsed" desc=" callback ">
    private Callback callback;

    public void setCallback(Callback callback) {
        this.callback = callback;

    }

    public static interface Callback {

        void ok(CloseDialog closeDialog, OutputData data);
    }

    public static class InputData {
    }

    public static class OutputData {
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Constructors ">
    private Dlg_users(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_users(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_users() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_users myRef;

    private void setThisRef(Dlg_users myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_users> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_users create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_users create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Frame) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        if (parent instanceof java.awt.Dialog) {
            Dlg_users dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_users((java.awt.Dialog) parent, false);
                dialog.setModalityType(modalType);
                dialogContainer.put(parent, dialog);
                java.util.logging.Logger.getAnonymousLogger().log(Level.INFO, "instances: {0}", dialogContainer.size());
                dialog.setThisRef(dialog);
                return dialog;
            } else {
                dialog.setModalityType(modalType);
                return dialog;
            }

        }

        return null;

    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" main ">
    public static void main(String args[]) {

        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Dlg_users dialog = Dlg_users.create(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" added ">
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible == true) {
            getContentPane().removeAll();
            initComponents();
            myInit();
            repaint();
        }

    }

    public javax.swing.JPanel getSurface() {
        return (javax.swing.JPanel) getContentPane();
    }

    public void nullify() {
        myRef.setVisible(false);
        myRef = null;
    }
    //</editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new Field.Input();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new Field.Input();
        jLabel5 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new Button.Success();
        jButton2 = new Button.Default();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_users = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new Field.Search();
        jButton3 = new Button.Default();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_user_default_priveleges = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Screen Name:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("User Name:");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Password:");

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Active:");

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Yes/No");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 175, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jPasswordField1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jPasswordField1))
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(143, 143, 143))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List of Users", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_usersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_users);

        jLabel1.setText("Total no. of rows:");

        jLabel2.setText("0");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Priveleges", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_user_default_priveleges.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_user_default_priveleges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_user_default_privelegesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_user_default_priveleges);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ret_users();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_usersMouseClicked
        ret_priveleges();
    }//GEN-LAST:event_tbl_usersMouseClicked

    private void tbl_user_default_privelegesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_user_default_privelegesMouseClicked
        select_privelege();
    }//GEN-LAST:event_tbl_user_default_privelegesMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new_user();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_user();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_user_default_priveleges;
    private javax.swing.JTable tbl_users;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_users(tbl_users);
        ret_users();
        init_tbl_user_default_priveleges(tbl_user_default_priveleges);

    }

    public void do_pass() {

    }

    // <editor-fold defaultstate="collapsed" desc="Key">
    private void disposed() {
        this.dispose();
    }

    private void init_key() {
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_ESCAPE, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                btn_0.doClick();
                disposed();
            }
        });
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" users "> 
    public static ArrayListModel tbl_users_ALM;
    public static TblusersModel tbl_users_M;

    public static void init_tbl_users(JTable tbl_users) {
        tbl_users_ALM = new ArrayListModel();
        tbl_users_M = new TblusersModel(tbl_users_ALM);
        tbl_users.setModel(tbl_users_M);
        tbl_users.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_users.setRowHeight(25);
        int[] tbl_widths_users = {100, 80, 100, 50, 30, 30, 30, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_users.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_users, i, tbl_widths_users[i]);
        }
        Dimension d = tbl_users.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_users.getTableHeader().setPreferredSize(d);
        tbl_users.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_users.setRowHeight(25);
        tbl_users.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_users.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        tbl_users.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
        tbl_users.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_users(List<to_users> acc) {
        tbl_users_ALM.clear();
        tbl_users_ALM.addAll(acc);
    }

    public static class TblusersModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Screen Name", "User Name", "Assigned To", "Status", "", "", "", "doctor_id", "created_at", "updated_at", "status", "is_uploaded"
        };

        public TblusersModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int col) {
            if (col == 1000) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_users tt = (to_users) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.screen_name;
                case 1:
                    return " " + tt.user_name;
                case 2:
                    return " " + tt.doctor;
                case 3:
                    if (tt.status == 0) {
                        return " Active";
                    } else {
                        return " Inactive";
                    }
                case 4:
                    return "/qs/icons/new-file.png";
                case 5:
                    return "/qs/icons/remove11.png";
                case 6:
                    return "/qs/icons/settings (1).png";
                case 7:
                    return tt.doctor_id;
                case 8:
                    return tt.created_at;
                case 9:
                    return tt.updated_at;
                case 10:
                    return tt.status;
                default:
                    return tt.is_uploaded;
            }
        }
    }

    private void ret_users() {
        String where = " order by screen_name asc ";
        List<to_users> users = Users.ret_data(where);
        loadData_users(users);
        jLabel2.setText("" + users.size());
    }

    private void new_user() {
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField1.setText("");
        jCheckBox1.setSelected(true);
        tbl_users.clearSelection();
        tbl_user_default_priveleges.clearSelection();
        jTextField1.grabFocus();
    }

    private void save_user() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            int id = 0;
            String screen_name = jTextField1.getText();
            String user_name = jTextField2.getText();
            String password = jPasswordField1.getText();
            String clinic = "";
            String clinic_id = "";
            String doctor = "";
            String doctor_id = "";
            String created_at = DateType.now();
            String updated_at = DateType.now();
            int status = 0;
            if (jCheckBox1.isSelected()) {
                status = 1;
            }
            int is_uploaded = 0;
            final Users.to_users user = new to_users(id, screen_name, user_name, password, clinic, clinic_id, doctor, doctor_id, created_at, updated_at, status, is_uploaded);

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Proceed adding this record?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Users.add_data(user);
                    ret_users();
                    new_user();
                    Alert.set(1, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            Users.to_users u = (Users.to_users) tbl_users_ALM.get(row);
            int id = u.id;
            String screen_name = jTextField1.getText();
            String user_name = jTextField2.getText();
            String password = jPasswordField1.getText();
            String clinic = u.clinic;
            String clinic_id = u.clinic_id;
            String doctor = u.doctor;
            String doctor_id = u.doctor_id;
            String created_at = u.created_at;
            String updated_at = DateType.now();
            int status = 0;
            if (jCheckBox1.isSelected()) {
                status = 1;
            }
            int is_uploaded = 0;
            final Users.to_users user = new to_users(id, screen_name, user_name, password, clinic, clinic_id, doctor, doctor_id, created_at, updated_at, status, is_uploaded);

            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.do_pass("Are you sure you want to update this record?");
            nd.setCallback(new Dlg_confirm_action.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Users.update_data(user);
                    ret_users();
                    new_user();
                    Alert.set(2, "");

                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" user_default_priveleges "> 
    public static ArrayListModel tbl_user_default_priveleges_ALM;
    public static Tbluser_default_privelegesModel tbl_user_default_priveleges_M;

    public static void init_tbl_user_default_priveleges(JTable tbl_user_default_priveleges) {
        tbl_user_default_priveleges_ALM = new ArrayListModel();
        tbl_user_default_priveleges_M = new Tbluser_default_privelegesModel(tbl_user_default_priveleges_ALM);
        tbl_user_default_priveleges.setModel(tbl_user_default_priveleges_M);
        tbl_user_default_priveleges.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_user_default_priveleges.setRowHeight(25);
        int[] tbl_widths_user_default_priveleges = {100, 100, 60, 60, 60, 60, 60, 60, 0, 0};
        for (int i = 0, n = tbl_widths_user_default_priveleges.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_user_default_priveleges, i, tbl_widths_user_default_priveleges[i]);
        }
        Dimension d = tbl_user_default_priveleges.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_user_default_priveleges.getTableHeader().setPreferredSize(d);
        tbl_user_default_priveleges.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_user_default_priveleges.setRowHeight(25);
        tbl_user_default_priveleges.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_user_default_priveleges.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_user_default_priveleges(List<to_user_default_priveleges> acc) {
        tbl_user_default_priveleges_ALM.clear();
        tbl_user_default_priveleges_ALM.addAll(acc);
    }

    public static class Tbluser_default_privelegesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Privelege", "Type", "  View", "  Add", " Edit", " Delete", "Finalize", "Report", "", ""
        };

        public Tbluser_default_privelegesModel(ListModel listmodel) {
            super(listmodel, COLUMNS);
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 100) {
                return true;
            }
            return false;
        }

        @Override
        public Class getColumnClass(int column) {
            if (column == 2 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7) {
                return Boolean.class;
            }
            return Object.class;
        }

        @Override
        public Object getValueAt(int row, int col) {
            to_user_default_priveleges tt = (to_user_default_priveleges) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.name;
                case 1:
                    return " " + tt.account;
                case 2:
                    return tt.view;
                case 3:
                    return tt.add;
                case 4:
                    return tt.edit;
                case 5:
                    return tt.delete;
                case 6:
                    return tt.finalize;
                case 7:
                    return tt.report;
                case 8:
                    return "/cms/icons/remove11.png";

                default:
                    return tt.is_uploaded;
            }
        }
    }

    private void ret_priveleges() {
        int row = tbl_users.getSelectedRow();
        if (row < 0) {
            return;
        }
        final to_users user = (to_users) tbl_users_ALM.get(row);
        int col = tbl_users.getSelectedColumn();
        if (col < 4) {
            String where = " where user_id='" + user.id + "' ";
            List<to_user_default_priveleges> priveleges = User_default_priveleges.ret_data(where);
            loadData_user_default_priveleges(priveleges);
        }
        if (col == 4) {
            jTextField1.setText(user.screen_name);
            jTextField2.setText(user.user_name);
            jPasswordField1.setText(user.password);
            if (user.status == 0) {
                jCheckBox1.setSelected(false);
            } else {
                jCheckBox1.setSelected(false);
            }
        }
        if (col == 5) {
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Users.delete_data(user);
                    ret_users();
                    new_user();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
        if (col == 6) {
            Window p = (Window) this;
            Dlg_user_settings nd = Dlg_user_settings.create(p, true);
            nd.setTitle("");
            nd.do_pass(user);
            nd.setCallback(new Dlg_user_settings.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_user_settings.OutputData data) {
                    closeDialog.ok();

                    List<User_settings.to_user_settings> settings = User_settings.ret_data(" where user_id ='" + user.id + "' ");
                    if (!settings.isEmpty()) {
                        User_settings.to_user_settings to=(User_settings.to_user_settings) settings.get(0);
                        int id=to.id;
                        String user_id = "" + user.id;
                        String user_name = user.user_name;
                        String counter_id = data.counter_id;
                        String counter_no = data.counter_no;
                        String created_at = to.created_at;
                        String updated_at = DateType.now();
                        String created_by = to.created_by;
                        String updated_by = MyUser.getUser_id();
                         User_settings.to_user_settings to2=new User_settings.to_user_settings(id, user_id, user_name, counter_id, counter_no, created_at, updated_at, created_by, updated_by);
                         User_settings.update_data(to2);
                        Alert.set(2, "");
                    } else {
                        int id = 0;
                        String user_id = "" + user.id;
                        String user_name = user.user_name;
                        String counter_id = data.counter_id;
                        String counter_no = data.counter_no;
                        String created_at = DateType.now();
                        String updated_at = DateType.now();
                        String created_by = MyUser.getUser_id();
                        String updated_by = MyUser.getUser_id();

                        User_settings.to_user_settings to = new User_settings.to_user_settings(id, user_id, user_name, counter_id, counter_no, created_at, updated_at, created_by, updated_by);
                        User_settings.add_data(to);
                        Alert.set(1, "");
                    }
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }

    }
//</editor-fold> 

    private void select_privelege() {
        int row = tbl_user_default_priveleges.getSelectedRow();
        if (row < 0) {
            return;
        }
        to_user_default_priveleges privelege = (to_user_default_priveleges) tbl_user_default_priveleges_ALM.get(row);

        int row2 = tbl_users.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        to_users user = (to_users) tbl_users_ALM.get(row2);

        int col = tbl_user_default_priveleges.getSelectedColumn();
        if (col == 2) {
            if (privelege.view == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (View)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);
                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (View)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
        if (col == 3) {
            if (privelege.add == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (Add)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);

                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (Add)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
        if (col == 4) {
            if (privelege.edit == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (Edit)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);

                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (Edit)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
        if (col == 5) {
            if (privelege.delete == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (Delete)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);

                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (Delete)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
        if (col == 6) {
            if (privelege.finalize == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (Finalize)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);

                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (Finalize)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
        if (col == 7) {
            if (privelege.report == false) {
                int id = 0;
                String account = privelege.account;
                String priv = privelege.name + " - (Report)";
                String user_id = "" + user.id;
                String user_name = user.user_name;
                User_priveleges.to_user_priveleges up = new User_priveleges.to_user_priveleges(id, account, priv, user_id, user_name);
                User_priveleges.add_data(up);

                ret_priveleges();
            } else {
                String where = " where user_id='" + user.id + "' and privelege='" + privelege.name + " - (Report)" + "'";
                User_priveleges.delete_data(where);
                ret_priveleges();
            }
        }
    }

}
