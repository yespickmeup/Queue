/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.counters;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.counter_departments.Counter_departments;
import qs.counter_departments.Counter_departments.to_counter_departments;
import qs.departments.Departments;
import qs.departments.Dlg_department;
import qs.users.MyUser;
import qs.users.MyUser1;
import qs.users.User_priveleges;
import qs.util.Alert;
import qs.util.DateType;
import qs.util.Dlg_confirm_action;
import qs.util.Dlg_confirm_delete;

import qs.util.TableRenderer;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_counter extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_degress
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
    private Dlg_counter(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_counter(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_counter() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_counter myRef;

    private void setThisRef(Dlg_counter myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_counter> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_counter create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_counter create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_counter dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_counter((java.awt.Frame) parent, false);
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
            Dlg_counter dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_counter((java.awt.Dialog) parent, false);
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

        Dlg_counter dialog = Dlg_counter.create(new javax.swing.JFrame(), true);
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
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new Field.Combo();
        jButton2 = new Button.Default();
        jButton1 = new Button.Success();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new Field.Input();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new Field.Input();
        jButton4 = new Button.Default();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_counter_departments = new javax.swing.JTable();
        jButton5 = new Button.Primary();
        jPanel3 = new javax.swing.JPanel();
        jTextField17 = new Field.Input();
        jButton3 = new Button.Default();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_degrees = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new Field.Combo();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Department:");

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Counter:");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ip Address:");

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/add.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Additional Departments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbl_counter_departments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_counter_departments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_counter_departmentsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_counter_departments);

        jButton5.setText("New");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 557, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextField3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        tbl_degrees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_degrees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_degreesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_degrees);

        jLabel1.setText("Total no. of rows:");

        jLabel2.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Department:");

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBox1.setSelected(true);
        jCheckBox1.setText("All");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCheckBox1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCheckBox1))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new_counter();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        save_counter();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ret_counters();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_degreesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_degreesMouseClicked
        select_counter();

    }//GEN-LAST:event_tbl_degreesMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        init_clinic();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked

    }//GEN-LAST:event_jPanel2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dlg_departments();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        init_clinic();
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        counter_departments();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbl_counter_departmentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_counter_departmentsMouseClicked
        select_counter_department();
    }//GEN-LAST:event_tbl_counter_departmentsMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tbl_counter_departments;
    private javax.swing.JTable tbl_degrees;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
//        System.setProperty("pool_password", "password");
        init_key();
        init_tbl_degrees(tbl_degrees);
        ret_counters();
        ret_departments();

        init_tbl_counter_departments(tbl_counter_departments);
    }

    int is_callback = 0;

    public void do_pass() {
        is_callback = 1;
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
    //<editor-fold defaultstate="collapsed" desc=" init cb departments ">
    private void ret_departments() {
        departments = Departments.ret_data(" order by department asc ");
        if (!departments.isEmpty()) {
            Departments.to_departments dep = (Departments.to_departments) departments.get(0);
            Field.Combo cl = (Field.Combo) jTextField3;
            cl.setText(dep.department);
            cl.setId("" + dep.id);
        }
    }
    List<Departments.to_departments> departments = new ArrayList();

    private void init_clinic() {

        Object[][] obj = new Object[departments.size()][1];
        int i = 0;
        for (Departments.to_departments to : departments) {
            obj[i][0] = " " + to.department;
            i++;
        }
        JLabel[] labels = {};
        int[] tbl_widths_customers = {jTextField3.getWidth()};
        String[] col_names = {""};
        TableRenderer tr = new TableRenderer();
        TableRenderer.setPopup(jTextField3, obj, labels, tbl_widths_customers, col_names);
        tr.setCallback(new TableRenderer.Callback() {
            @Override
            public void ok(TableRenderer.OutputData data) {
                Departments.to_departments dep = (Departments.to_departments) departments.get(data.selected_row);
                Field.Combo cl = (Field.Combo) jTextField3;
                cl.setText(dep.department);
                cl.setId("" + dep.id);
            }
        });
    }

    private void dlg_departments() {
        Window p = (Window) this;
        Dlg_department nd = Dlg_department.create(p, true);
        nd.setTitle("");
        nd.do_pass();
        nd.setCallback(new Dlg_department.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_department.OutputData data) {
                ret_departments();
                ret_counters();
            }
        });
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" counters "> 
    public static ArrayListModel tbl_degrees_ALM;
    public static TbldegreesModel tbl_degrees_M;

    public static void init_tbl_degrees(JTable tbl_degrees) {
        tbl_degrees_ALM = new ArrayListModel();
        tbl_degrees_M = new TbldegreesModel(tbl_degrees_ALM);
        tbl_degrees.setModel(tbl_degrees_M);
        tbl_degrees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_degrees.setRowHeight(25);
        int[] tbl_widths_degrees = {100, 100, 100, 50, 30, 30, 0, 0};
        for (int i = 0, n = tbl_widths_degrees.length; i < n; i++) {
            if (i == 0 || i == 1) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_degrees, i, tbl_widths_degrees[i]);
        }
        Dimension d = tbl_degrees.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_degrees.getTableHeader().setPreferredSize(d);
        tbl_degrees.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_degrees.setRowHeight(25);
        tbl_degrees.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_degrees.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());
        tbl_degrees.getColumnModel().getColumn(5).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_counters(List<Counters.to_counters> acc) {
        tbl_degrees_ALM.clear();
        tbl_degrees_ALM.addAll(acc);
    }

    public static class TbldegreesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Counter", "Department", "IP Address", "Status", "", "", "status", "is_uploaded"
        };

        public TbldegreesModel(ListModel listmodel) {
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
            Counters.to_counters tt = (Counters.to_counters) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.counter;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.ip_address;
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
                    return tt.status;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_counters() {
        String where = " order by counter asc ";
        List<Counters.to_counters> datas = Counters.ret_data(where);
        loadData_counters(datas);
        if (is_callback == 1) {
            ok();
        }
    }

    private void new_counter() {

        jTextField4.setText("");
        jTextField5.setText("");

        tbl_degrees.clearSelection();
        jTextField3.grabFocus();
    }

    private void save_counter() {
        int row = tbl_degrees.getSelectedRow();
        if (row < 0) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and privelege like 'Counters - (Add)' ";
            List<User_priveleges.to_user_priveleges> datas = User_priveleges.ret_data(where);
            if (datas.isEmpty()) {
                Alert.set(0, "Privilege Not Added!");
                return;
            }

            Field.Combo dep = (Field.Combo) jTextField3;
            int id = 0;
            String counter = jTextField4.getText();

            String department = dep.getText();
            String department_id = dep.getId();
            String ip_address = jTextField5.getText();
            String created_by = MyUser1.getUser_id();
            String updated_by = MyUser1.getUser_id();
            String created_at = DateType.now();
            String updated_at = DateType.now();
            int status = 0;
//            if (tbl_degrees_ALM.size() >= 6) {
//                Alert.set(0, "Counter limit exceeded!");
//                return;
//            }
            if (counter.length() > 1 || counter.isEmpty()) {
                jTextField4.grabFocus();
                Alert.set(0, "Input Counter Number!");
                return;
            }
            List<Departments.to_departments> deps = Departments.ret_data(" where id='" + dep.getId() + "' ");
            Departments.to_departments dep1 = (Departments.to_departments) deps.get(0);
            Counters.to_counters count = new Counters.to_counters(id, counter, department, department_id, ip_address, created_at, updated_at, created_by, updated_by, status, dep1.shortcut, 0);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    List<Counter_departments.to_counter_departments> counter_departments = tbl_counter_departments_ALM;
                    Counters.add_data(count, counter_departments);
                    ret_counters();
                    new_counter();
                    tbl_counter_departments_ALM.clear();
                    Alert.set(1, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        } else {
            String where = " where user_id='" + MyUser.getUser_id() + "' and privelege like 'Counters - (Edit)' ";
            List<User_priveleges.to_user_priveleges> datas = User_priveleges.ret_data(where);
            if (datas.isEmpty()) {
                Alert.set(0, "Privilege Not Added!");
                return;
            }
            Counters.to_counters to = (Counters.to_counters) tbl_degrees_ALM.get(row);
            Field.Combo dep = (Field.Combo) jTextField3;
            int id = to.id;
            String counter = jTextField4.getText();
            String department = dep.getText();
            String department_id = dep.getId();
            String ip_address = jTextField5.getText();
            String created_by = to.created_by;
            String updated_by = "";//MyUser.getUser_id();
            String created_at = to.created_at;
            String updated_at = DateType.now();
            int status = to.status;
            int is_uploaded = 0;
            System.out.println("dep id: " + dep.getId());
            List<Departments.to_departments> deps = Departments.ret_data(" where id='" + dep.getId() + "' ");
            Departments.to_departments dep1 = (Departments.to_departments) deps.get(0);
            Counters.to_counters degr = new Counters.to_counters(id, counter, department, department_id, ip_address, created_at, updated_at, created_by, updated_by, status, dep1.shortcut, 0);
            Window p = (Window) this;
            Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_action.Callback() {
                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                    closeDialog.ok();
                    Counters.update_data(degr);
                    ret_counters();
                    new_counter();
                    Alert.set(2, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);

        }
    }

    private void select_counter() {
        int row = tbl_degrees.getSelectedRow();
        if (row < 0) {
            return;
        }
        Counters.to_counters to = (Counters.to_counters) tbl_degrees_ALM.get(row);
        int col = tbl_degrees.getSelectedColumn();
        if (col == 4) {

            Field.Combo dep = (Field.Combo) jTextField3;
            dep.setText(to.department);
            dep.setId("" + to.department_id);

            jTextField4.setText(to.counter);
            jTextField5.setText(to.ip_address);
            ret_counter_departments();
        }
        if (col == 5) {
            String where = " where user_id='" + MyUser.getUser_id() + "' and privelege like 'Counters - (Delete)' ";
            List<User_priveleges.to_user_priveleges> datas = User_priveleges.ret_data(where);
            if (datas.isEmpty()) {
                Alert.set(0, "Privilege Not Added!");
                return;
            }
            Window p = (Window) this;
            Dlg_confirm_delete nd = Dlg_confirm_delete.create(p, true);
            nd.setTitle("");
            nd.setCallback(new Dlg_confirm_delete.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_confirm_delete.OutputData data) {
                    closeDialog.ok();
                    Counters.delete_data(to);
                    ret_counters();
                    new_counter();
                    tbl_counter_departments_ALM.clear();
                    Alert.set(3, "");
                }
            });
            nd.setLocationRelativeTo(this);
            nd.setVisible(true);
        }
    }

    private void ok() {
        if (callback != null) {
            callback.ok(new CloseDialog(this), new OutputData());
        }
    }
//</editor-fold> 

    //<editor-fold defaultstate="collapsed" desc=" counter_departments "> 
    public static ArrayListModel tbl_counter_departments_ALM;
    public static Tblcounter_departmentsModel tbl_counter_departments_M;

    public static void init_tbl_counter_departments(JTable tbl_counter_departments) {
        tbl_counter_departments_ALM = new ArrayListModel();
        tbl_counter_departments_M = new Tblcounter_departmentsModel(tbl_counter_departments_ALM);
        tbl_counter_departments.setModel(tbl_counter_departments_M);
        tbl_counter_departments.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_counter_departments.setRowHeight(25);
        int[] tbl_widths_counter_departments = {100, 80, 30, 30, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_counter_departments.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_counter_departments, i, tbl_widths_counter_departments[i]);
        }
        Dimension d = tbl_counter_departments.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_counter_departments.getTableHeader().setPreferredSize(d);
        tbl_counter_departments.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_counter_departments.setRowHeight(25);
        tbl_counter_departments.setFont(new java.awt.Font("Arial", 0, 12));
        tbl_counter_departments.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        tbl_counter_departments.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
    }

    public static void loadData_counter_departments(List<to_counter_departments> acc) {
        tbl_counter_departments_ALM.clear();
        tbl_counter_departments_ALM.addAll(acc);
    }

    public static class Tblcounter_departmentsModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Department", "Priority", "", "", "department", "created_at", "updated_at", "status", "priority"
        };

        public Tblcounter_departmentsModel(ListModel listmodel) {
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
            to_counter_departments tt = (to_counter_departments) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.department;
                case 1:
                    if (tt.priority == 1) {
                        return " Yes";
                    } else {
                        return " No";
                    }
                case 2:
                    return "/qs/icons/new-file.png";
                case 3:
                    return "/qs/icons/remove11.png";
                case 4:
                    return tt.department;
                case 5:
                    return tt.created_at;
                case 6:
                    return tt.updated_at;
                case 7:
                    return tt.status;
                default:
                    return tt.priority;
            }
        }
    }
//</editor-fold> 

    private void counter_departments() {
        Window p = (Window) this;
        Dlg_counter_departments nd = Dlg_counter_departments.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_counter_departments.Callback() {
            @Override
            public void ok(CloseDialog closeDialog, Dlg_counter_departments.OutputData data) {
                closeDialog.ok();
                Field.Combo def_department = (Field.Combo) jTextField3;
                if (def_department.getId().equalsIgnoreCase(data.department_id)) {
                    Alert.set(0, "Choose Another Department!");
                    return;
                }

                int row = tbl_degrees.getSelectedRow();
                if (row < 0) {
                    int id = 0;
                    String counter_id = "";
                    String counter = jTextField4.getText();
                    String department_id = data.department_id;
                    String department = data.department;
                    String created_at = DateType.now();
                    String updated_at = DateType.now();
                    int status = 1;
                    int priority = data.priority;
                    Counter_departments.to_counter_departments cd = new to_counter_departments(id, counter_id, counter, department_id, department, created_at, updated_at, status, priority);

                    List<Counter_departments.to_counter_departments> list = tbl_counter_departments_ALM;
                    int exists = 0;
                    for (Counter_departments.to_counter_departments to : list) {
                        if (to.department_id.equalsIgnoreCase(department_id)) {
                            exists = 1;
                            break;
                        }
                    }
                    if (exists == 0) {
                        tbl_counter_departments_ALM.add(cd);
                    } else {
                        Alert.set(0, "Already Added!");
                    }
                } else {
                    int row2 = tbl_degrees.getSelectedRow();
                    if (row2 < 0) {
                        return;
                    }
                    Counters.to_counters to = (Counters.to_counters) tbl_degrees_ALM.get(row2);
                    int id = 0;
                    String counter_id = "" + to.id;
                    String counter = to.counter;
                    String department_id = data.department_id;
                    String department = data.department;
                    String created_at = DateType.now();
                    String updated_at = DateType.now();
                    int status = 1;
                    int priority = data.priority;
                    Counter_departments.to_counter_departments cd = new to_counter_departments(id, counter_id, counter, department_id, department, created_at, updated_at, status, priority);

                    List<Counter_departments.to_counter_departments> list = tbl_counter_departments_ALM;
                    int exists = 0;
                    for (Counter_departments.to_counter_departments to2 : list) {
                        if (to2.department_id.equalsIgnoreCase(department_id)) {
                            exists = 1;
                            break;
                        }
                    }
                    if (exists == 0) {
                        Counter_departments.add_data(cd);
                        Alert.set(1, "");
                        ret_counter_departments();
                    } else {
                        Alert.set(0, "Already Added!");
                    }
                }

            }
        });
        nd.setLocationRelativeTo(jPanel4);
        nd.setVisible(true);
    }

    private void select_counter_department() {
        int row = tbl_counter_departments.getSelectedRow();
        if (row < 0) {
            return;
        }
        Counter_departments.to_counter_departments to = (Counter_departments.to_counter_departments) tbl_counter_departments_ALM.get(row);
        int col = tbl_counter_departments.getSelectedColumn();
        if (col == 2) {
            int row2 = tbl_degrees.getSelectedRow();
            Window p = (Window) this;
            Dlg_counter_departments nd = Dlg_counter_departments.create(p, true);
            nd.setTitle("");
            nd.edit_new(to);
            nd.setCallback(new Dlg_counter_departments.Callback() {

                @Override
                public void ok(CloseDialog closeDialog, Dlg_counter_departments.OutputData data) {
                    closeDialog.ok();
                    if (row2 < 0) {
                        to.setDepartment(data.department);
                        to.setDepartment_id(data.department_id);
                        to.setPriority(data.priority);
                        tbl_counter_departments_M.fireTableDataChanged();
                    } else {
                        int id = to.id;
                        String counter_id = to.counter_id;
                        String counter = to.counter;
                        String department_id = to.department_id;
                        String department = to.department;
                        String created_at = to.created_at;
                        String updated_at = to.updated_at;
                        int status = to.status;
                        int priority = data.priority;
                        Counter_departments.to_counter_departments to2 = new Counter_departments.to_counter_departments(id, counter_id, counter, department_id, department, created_at, updated_at, status, priority);
                        Counter_departments.update_data(to2);
                        Alert.set(2, "");
                    }
                }
            }
            );
            nd.setLocationRelativeTo(jPanel4);

            nd.setVisible(
                    true);

        }
        if (col == 3) {
            int row2 = tbl_degrees.getSelectedRow();
            if (row2 < 0) {
                tbl_counter_departments_ALM.remove(row);
                tbl_counter_departments_M.fireTableDataChanged();
            } else {
                Counter_departments.delete_data(to);
                ret_counter_departments();
                Alert.set(3, "");
            }
        }
    }

    private void ret_counter_departments() {
        int row2 = tbl_degrees.getSelectedRow();
        if (row2 < 0) {
            return;
        }
        Counters.to_counters to = (Counters.to_counters) tbl_degrees_ALM.get(row2);
        String where = " where counter_id='" + to.id + "' ";
        List<Counter_departments.to_counter_departments> datas = Counter_departments.ret_data(where);
        loadData_counter_departments(datas);
    }
}
