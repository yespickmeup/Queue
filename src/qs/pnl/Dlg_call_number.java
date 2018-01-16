/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.customers.Customers;
import qs.queues.Queues;
import qs.queues.Queues.to_queues;
import qs.util.DateType;
import qs.util.Dlg_confirm_action;
import synsoftech.fields.Button;

/**
 *
 * @author Guinness
 */
public class Dlg_call_number extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_call_number
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
    private Dlg_call_number(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_call_number(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_call_number() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_call_number myRef;

    private void setThisRef(Dlg_call_number myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_call_number> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_call_number create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_call_number create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_call_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_call_number((java.awt.Frame) parent, false);
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
            Dlg_call_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_call_number((java.awt.Dialog) parent, false);
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

        Dlg_call_number dialog = Dlg_call_number.create(new javax.swing.JFrame(), true);
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_waiting_list = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new Button.Info();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jButton8 = new Button.Info();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton7 = new Button.Info();
        jButton1 = new Button.Primary();
        jButton2 = new Button.Default();
        jButton3 = new Button.Default();
        jButton4 = new Button.Warning();
        jButton5 = new Button.Success();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tbl_waiting_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_waiting_list);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Waiting List", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jDateChooser1.setDate(new Date());
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Date:");

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/magnifying-glass.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Finished", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jDateChooser3.setDate(new Date());
        jDateChooser3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Date:");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/magnifying-glass.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("No Show", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date:");

        jDateChooser2.setDate(new Date());
        jDateChooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/magnifying-glass.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 862, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cancelled", jPanel5);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/right-arrow.png"))); // NOI18N
        jButton1.setText("Get new number");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/delete-user.png"))); // NOI18N
        jButton2.setText("No show");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/ring.png"))); // NOI18N
        jButton3.setText("Call Again");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/multiply (2).png"))); // NOI18N
        jButton4.setText("Cancel");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/checked (1).png"))); // NOI18N
        jButton5.setText("Finish");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(54, 128, 11));
        jLabel5.setText(" Account Details:");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(204, 204, 204));
        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("ID No.: ");

        jLabel7.setBackground(new java.awt.Color(204, 204, 204));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Name : ");

        jXLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jXLabel1.setText("Address: ");
        jXLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jXLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jXLabel1.setLineWrap(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(54, 128, 11));
        jLabel1.setText(" Department:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(54, 128, 11));
        jLabel3.setText(" Transaction Number:");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        get_new_number();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        finish_queue(3);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        out.println("Calling");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        finish_queue(2);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        finish_queue(1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        ret_finished_queues();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ret_cancelled_queues();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ret_noshow_queues();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private javax.swing.JTable tbl_waiting_list;
    // End of variables declaration//GEN-END:variables
    private void myInit() {

        System.setProperty("counter_no", "01");
        System.setProperty("teller", "Ronald Pascua");
        System.setProperty("teller_id", "1");
        System.setProperty("department", "Evaluation");
        System.setProperty("department_id", "1");
        System.setProperty("chatServerAddress", "192.168.1.152");
        System.setProperty("chatServerPort", "1000");
        init_key();

        init_tbl_queues(tbl_waiting_list);
        ret_waiting_list();
        init_tbl_queues_finished(jTable2);
        ret_finished_queues();
        init_tbl_queues_cancelled(jTable4);
        ret_cancelled_queues();
        init_tbl_queues_noshow(jTable3);
        ret_noshow_queues();
        set_border();
        get_previous_number();

        run_server();
    }

    private void set_border() {

        brdr(jLabel2);
        brdr(jLabel4);
        brdr(jLabel6);
        brdr(jLabel7);
        brdr(jXLabel1);
    }

    private void brdr(JComponent comp) {
        Border border2 = comp.getBorder();
        Border margin2 = new EmptyBorder(0, 10, 0, 0);
        comp.setBorder(new CompoundBorder(border2, margin2));
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

    //<editor-fold defaultstate="collapsed" desc=" queues "> 
    public static ArrayListModel tbl_queues_ALM;
    public static TblqueuesModel tbl_queues_M;

    public static void init_tbl_queues(JTable tbl_queues) {
        tbl_queues_ALM = new ArrayListModel();
        tbl_queues_M = new TblqueuesModel(tbl_queues_ALM);
        tbl_queues.setModel(tbl_queues_M);
        tbl_queues.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_queues.setRowHeight(25);
        int[] tbl_widths_queues = {100, 100, 100, 100, 150, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_queues.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_queues, i, tbl_widths_queues[i]);
        }
        Dimension d = tbl_queues.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_queues.getTableHeader().setPreferredSize(d);
        tbl_queues.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_queues.setRowHeight(25);
        tbl_queues.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_queues(List<to_queues> acc) {
        tbl_queues_ALM.clear();
        tbl_queues_ALM.addAll(acc);
    }

    public static class TblqueuesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Queue #", "Department", "Consumer #", "Consumer Name", "Date Added", "customer_id", "counter_no", "teller", "teller_id", "remarks", "status", "created_at", "updated_at", "created_by", "updated_by"
        };

        public TblqueuesModel(ListModel listmodel) {
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
            to_queues tt = (to_queues) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.queue_no;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.customer_id;
                case 3:
                    return " " + tt.customer;
                case 4:
                    return " " + DateType.convert_slash_datetime3(tt.created_at);
                case 5:
                    return tt.customer_id;
                case 6:
                    return tt.counter_no;
                case 7:
                    return tt.teller;
                case 8:
                    return tt.teller_id;
                case 9:
                    return tt.remarks;
                case 10:
                    return tt.status;
                case 11:
                    return tt.created_at;
                case 12:
                    return tt.updated_at;
                case 13:
                    return tt.created_by;
                default:
                    return tt.updated_by;
            }
        }
    }

    private void ret_waiting_list() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String date = DateType.sf.format(new Date());
        String where = " where status=0 and department_id='" + department_id + "' order by id asc ";
        List<to_queues> q = Queues.ret_data(where);
        loadData_queues(q);
    }

//</editor-fold> 
    int queue_id = 0;

    private void get_previous_number() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String teller = System.getProperty("teller", "Ronald Pascua");
        String teller_id = System.getProperty("teller_id", "1");

        String date = DateType.sf.format(new Date());
        String where = " where status=0 and teller_id='" + teller_id + "' and department_id='" + department_id + "'  and teller IS NOT NULL order by id asc ";
        System.out.println(where);
        List<to_queues> q = Queues.ret_data(where);

        if (!q.isEmpty()) {
            to_queues to = (to_queues) q.get(0);
            List<Customers.to_customers> custs = Customers.ret_data(" where customer_no='" + to.customer_id + "'");
            String address = "";
            if (!custs.isEmpty()) {
                Customers.to_customers cus = (Customers.to_customers) custs.get(0);
                address = cus.address;
            }
            queue_id = to.id;
            jLabel2.setText(to.department);
            jLabel4.setText(to.queue_no);
            jLabel6.setText("ID No.: " + to.customer_id);
            jLabel7.setText("Name : " + to.customer);
            jXLabel1.setText("Address: " + address);

            jButton1.setEnabled(false);
        }
    }

    private void get_new_number() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String teller = System.getProperty("teller", "Ronald Pascua");
        String teller_id = System.getProperty("teller_id", "1");

        String date = DateType.sf.format(new Date());
        String where = " where status=0 and department_id='" + department_id + "' and teller IS NULL order by id asc ";
        List<to_queues> q = Queues.ret_data(where);

        if (!q.isEmpty()) {
            to_queues to = (to_queues) q.get(0);
            List<Customers.to_customers> custs = Customers.ret_data(" where customer_no='" + to.customer_id + "'");
            String address = "";
            if (!custs.isEmpty()) {
                Customers.to_customers cus = (Customers.to_customers) custs.get(0);
                address = cus.address;
            }
            queue_id = to.id;
            jLabel2.setText(to.department);
            jLabel4.setText(to.queue_no);
            jLabel6.setText("ID No.: " + to.customer_id);
            jLabel7.setText("Name : " + to.customer);
            jXLabel1.setText("Address: " + address);

            //update queue
            Queues.update_teller(to.id, counter_no, teller, teller_id);

            jButton1.setEnabled(false);
        }
    }

    private void finish_queue(int status) {
        Window p = (Window) this;
        Dlg_confirm_action nd = Dlg_confirm_action.create(p, true);
        nd.setTitle("");
        if (status == 1) {
            nd.do_pass(" Finish Transaction?");
        }
        if (status == 2) {
            nd.do_pass(" Cancel Transaction?");
        }
        if (status == 3) {
            nd.do_pass(" No Show?");
        }

        nd.setCallback(new Dlg_confirm_action.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action.OutputData data) {
                closeDialog.ok();
                Queues.update_queue(queue_id, status);
                ret_waiting_list();

                if (status == 1) {
                    ret_finished_queues();
                }
                if (status == 2) {
                    ret_cancelled_queues();
                }
                if (status == 3) {
                    ret_noshow_queues();
                }

                queue_id = 0;
                jButton1.setEnabled(true);
                jButton5.setEnabled(false);
                jButton4.setEnabled(false);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);

                jLabel2.setText("");
                jLabel4.setText("");
                jLabel6.setText("ID No.: ");
                jLabel7.setText("Name : ");
                jXLabel1.setText("Address: ");
            }
        }
        );
        nd.setLocationRelativeTo(this);
        nd.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc=" finished queues "> 
    public static ArrayListModel tbl_queues_finished_ALM;
    public static TblqueuesFinishedModel tbl_queues_finished_M;

    public static void init_tbl_queues_finished(JTable tbl_queues) {
        tbl_queues_finished_ALM = new ArrayListModel();
        tbl_queues_finished_M = new TblqueuesFinishedModel(tbl_queues_finished_ALM);
        tbl_queues.setModel(tbl_queues_finished_M);
        tbl_queues.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_queues.setRowHeight(25);
        int[] tbl_widths_queues = {100, 100, 100, 100, 130, 130, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_queues.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_queues, i, tbl_widths_queues[i]);
        }
        Dimension d = tbl_queues.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_queues.getTableHeader().setPreferredSize(d);
        tbl_queues.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_queues.setRowHeight(25);
        tbl_queues.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_queues_finished(List<to_queues> acc) {
        tbl_queues_finished_ALM.clear();
        tbl_queues_finished_ALM.addAll(acc);
    }

    public static class TblqueuesFinishedModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Queue #", "Department", "Consumer #", "Consumer Name", "Date Added", "Finished At", "counter_no", "teller", "teller_id", "remarks", "status", "created_at", "updated_at", "created_by", "updated_by"
        };

        public TblqueuesFinishedModel(ListModel listmodel) {
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
            to_queues tt = (to_queues) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.queue_no;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.customer_id;
                case 3:
                    return " " + tt.customer;
                case 4:
                    return " " + DateType.convert_slash_datetime3(tt.created_at);
                case 5:
                    return " " + DateType.convert_slash_datetime3(tt.updated_at);
                case 6:
                    return tt.counter_no;
                case 7:
                    return tt.teller;
                case 8:
                    return tt.teller_id;
                case 9:
                    return tt.remarks;
                case 10:
                    return tt.status;
                case 11:
                    return tt.created_at;
                case 12:
                    return tt.updated_at;
                case 13:
                    return tt.created_by;
                default:
                    return tt.updated_by;
            }
        }
    }

    private void ret_finished_queues() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String date = DateType.sf.format(jDateChooser1.getDate());

        String where = " where status=1 and department_id='" + department_id + "' and Date(created_at)='" + date + "' order by id asc ";
        List<to_queues> q = Queues.ret_data(where);
        loadData_queues_finished(q);
    }

//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" cancelled queues "> 
    public static ArrayListModel tbl_queues_cancelled_ALM;
    public static TblqueuesCancelledModel tbl_queues_cancelled_M;

    public static void init_tbl_queues_cancelled(JTable tbl_queues) {
        tbl_queues_cancelled_ALM = new ArrayListModel();
        tbl_queues_cancelled_M = new TblqueuesCancelledModel(tbl_queues_cancelled_ALM);
        tbl_queues.setModel(tbl_queues_cancelled_M);
        tbl_queues.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_queues.setRowHeight(25);
        int[] tbl_widths_queues = {100, 100, 100, 100, 130, 130, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_queues.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_queues, i, tbl_widths_queues[i]);
        }
        Dimension d = tbl_queues.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_queues.getTableHeader().setPreferredSize(d);
        tbl_queues.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_queues.setRowHeight(25);
        tbl_queues.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_queues_cancelled(List<to_queues> acc) {
        tbl_queues_cancelled_ALM.clear();
        tbl_queues_cancelled_ALM.addAll(acc);
    }

    public static class TblqueuesCancelledModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Queue #", "Department", "Consumer #", "Consumer Name", "Date Added", "Cancelled At", "counter_no", "teller", "teller_id", "remarks", "status", "created_at", "updated_at", "created_by", "updated_by"
        };

        public TblqueuesCancelledModel(ListModel listmodel) {
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
            to_queues tt = (to_queues) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.queue_no;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.customer_id;
                case 3:
                    return " " + tt.customer;
                case 4:
                    return " " + DateType.convert_slash_datetime3(tt.created_at);
                case 5:
                    return " " + DateType.convert_slash_datetime3(tt.updated_at);
                case 6:
                    return tt.counter_no;
                case 7:
                    return tt.teller;
                case 8:
                    return tt.teller_id;
                case 9:
                    return tt.remarks;
                case 10:
                    return tt.status;
                case 11:
                    return tt.created_at;
                case 12:
                    return tt.updated_at;
                case 13:
                    return tt.created_by;
                default:
                    return tt.updated_by;
            }
        }
    }

    private void ret_cancelled_queues() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String date = DateType.sf.format(jDateChooser2.getDate());

        String where = " where status=2 and department_id='" + department_id + "' and Date(created_at)='" + date + "' order by id asc ";
        List<to_queues> q = Queues.ret_data(where);
        loadData_queues_cancelled(q);
    }

//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" no show queues "> 
    public static ArrayListModel tbl_queues_noshow_ALM;
    public static TblqueuesNoshowModel tbl_queues_noshow_M;

    public static void init_tbl_queues_noshow(JTable tbl_queues) {
        tbl_queues_noshow_ALM = new ArrayListModel();
        tbl_queues_noshow_M = new TblqueuesNoshowModel(tbl_queues_noshow_ALM);
        tbl_queues.setModel(tbl_queues_noshow_M);
        tbl_queues.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_queues.setRowHeight(25);
        int[] tbl_widths_queues = {100, 100, 100, 100, 130, 130, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_queues.length; i < n; i++) {
            if (i == 3) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_queues, i, tbl_widths_queues[i]);
        }
        Dimension d = tbl_queues.getTableHeader().getPreferredSize();
        d.height = 25;
        tbl_queues.getTableHeader().setPreferredSize(d);
        tbl_queues.getTableHeader().setFont(new java.awt.Font("Arial", 0, 12));
        tbl_queues.setRowHeight(25);
        tbl_queues.setFont(new java.awt.Font("Arial", 0, 12));
    }

    public static void loadData_queues_noshow(List<to_queues> acc) {
        tbl_queues_noshow_ALM.clear();
        tbl_queues_noshow_ALM.addAll(acc);
    }

    public static class TblqueuesNoshowModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Queue #", "Department", "Consumer #", "Consumer Name", "Date Added", "Cancelled At", "counter_no", "teller", "teller_id", "remarks", "status", "created_at", "updated_at", "created_by", "updated_by"
        };

        public TblqueuesNoshowModel(ListModel listmodel) {
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
            to_queues tt = (to_queues) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.queue_no;
                case 1:
                    return " " + tt.department;
                case 2:
                    return " " + tt.customer_id;
                case 3:
                    return " " + tt.customer;
                case 4:
                    return " " + DateType.convert_slash_datetime3(tt.created_at);
                case 5:
                    return " " + DateType.convert_slash_datetime3(tt.updated_at);
                case 6:
                    return tt.counter_no;
                case 7:
                    return tt.teller;
                case 8:
                    return tt.teller_id;
                case 9:
                    return tt.remarks;
                case 10:
                    return tt.status;
                case 11:
                    return tt.created_at;
                case 12:
                    return tt.updated_at;
                case 13:
                    return tt.created_by;
                default:
                    return tt.updated_by;
            }
        }
    }

    private void ret_noshow_queues() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "1");
        String date = DateType.sf.format(jDateChooser3.getDate());

        String where = " where status=3 and department_id='" + department_id + "' and Date(created_at)='" + date + "' order by id asc ";
        List<to_queues> q = Queues.ret_data(where);
        loadData_queues_noshow(q);
    }

//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" Chat Server ">
    BufferedReader in;
    PrintWriter out;

    public void run_server() {
        String serverAddress = System.getProperty("chatServerAddress", "192.168.1.152");
        int serverPort = FitIn.toInt(System.getProperty("chatServerPort", "1000"));
        String screen_name = System.getProperty("teller", "Ronald Pascua");
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                Socket socket;
                try {
                    socket = new Socket(serverAddress, serverPort);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);

                    while (true) {
                        String line = in.readLine();

                        if (line.startsWith("SUBMITNAME")) {
                            out.println(screen_name);
                        } else if (line.startsWith("NAMEACCEPTED")) {
//                            System.out.println("Name Accepted!");
                        } else if (line.startsWith("MESSAGE")) {

                            String message = line.substring(8);
//                            System.out.println("Message: " + message);
//                            int l = message.indexOf("%");
//                            String user = message.substring(0, l);
//                            System.out.println("Name: " + user);
//                            String msg = message.substring(l + 1, message.length());
//                            System.out.println("Message: " + msg);
//
//                            if (user.equals(screen_name)) {
//                                user = "Me";
//                            }
//
//                            String date = DateType.slash_w_time.format(new Date());
//                            Chat.to_chats to1 = new Chat.to_chats(0, "1", user, date, msg);
//                            String text = jTextArea1.getText();
//                            if (text.isEmpty()) {
//                                jTextArea1.setText(msg);
//                            } else {
//                                text = text + "\n" + msg;
//                                jTextArea1.setText(text);
//                            }

                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(synsoftech.chat.Dlg_test_chat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();

    }
    //</editor-fold>
}
