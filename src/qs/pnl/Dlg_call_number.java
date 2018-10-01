/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.counter_departments.Counter_departments;
import qs.counters.Counters;
import qs.customers.Customers;
import qs.queues.Queues;
import qs.queues.Queues.to_queues;
import qs.util.DateType;
import qs.util.Dlg_confirm_action2;
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
        setUndecorated(false);
        initComponents();
        myInit();
    }

    private Dlg_call_number(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(false);
        initComponents();
        myInit();
    }

    public Dlg_call_number() {
        super();
        setUndecorated(false);
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
        dialog.f.add(dialog.getContentPane());
        dialog.f.setUndecorated(true);
        dialog.f.setSize(dialog.getWidth(), dialog.getHeight() - 50);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - dialog.f.getWidth() - 5;
        int y = (int) rect.getMaxY() - dialog.f.getHeight() - 55;
        dialog.f.setLocation(x, y);
        dialog.f.setVisible(true);
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
        jPanel9 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_waiting_list = new javax.swing.JTable();
        jButton9 = new Button.Default();
        jButton10 = new Button.Default();
        jButton11 = new Button.Default();
        jButton12 = new Button.Default();
        jButton13 = new Button.Default();
        jButton14 = new Button.Default();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
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
        jButton3 = new Button.Default();
        jButton2 = new Button.Default();
        jButton4 = new Button.Warning();
        jButton5 = new Button.Success();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jButton22 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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

        jButton9.setText("1");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("2");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("3");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("4");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("5");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("6");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Refresh - F5");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Queue");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10)
                    .addComponent(jButton11)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
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

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/ring.png"))); // NOI18N
        jButton3.setText("Call Again");
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
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

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 115, 172));
        jLabel1.setText(" Department:");
        jLabel1.setOpaque(true);

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 115, 172));
        jLabel3.setText(" Transaction Number:");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        jLabel11.setBackground(new java.awt.Color(204, 204, 204));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 115, 172));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Counter:");
        jLabel11.setOpaque(true);

        jLabel12.setBackground(new java.awt.Color(204, 204, 204));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 60)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 115, 172));
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
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(jXLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Now Serving");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel19.setBackground(new java.awt.Color(18, 115, 172));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("0");
        jLabel19.setOpaque(true);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("On Queue");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel21.setBackground(new java.awt.Color(18, 115, 172));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("0");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/magnifying-glass.png"))); // NOI18N
        jButton17.setText(" F1- Get New Number");
        jButton17.setBorder(null);
        jButton17.setBorderPainted(false);
        jButton17.setEnabled(false);
        jButton17.setFocusable(false);
        jButton17.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton17.setOpaque(false);
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/phone-call.png"))); // NOI18N
        jButton18.setText(" F3 - Call Again");
        jButton18.setBorder(null);
        jButton18.setBorderPainted(false);
        jButton18.setEnabled(false);
        jButton18.setFocusable(false);
        jButton18.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton18.setOpaque(false);
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/invisible-symbol.png"))); // NOI18N
        jButton19.setText(" F4 - Now Show");
        jButton19.setBorder(null);
        jButton19.setBorderPainted(false);
        jButton19.setEnabled(false);
        jButton19.setFocusable(false);
        jButton19.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton19.setOpaque(false);
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/cross-out (1).png"))); // NOI18N
        jButton20.setText(" F5 - Cancel");
        jButton20.setBorder(null);
        jButton20.setBorderPainted(false);
        jButton20.setEnabled(false);
        jButton20.setFocusable(false);
        jButton20.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton20.setOpaque(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/tick.png"))); // NOI18N
        jButton21.setText(" F6 - Finish");
        jButton21.setBorder(null);
        jButton21.setBorderPainted(false);
        jButton21.setEnabled(false);
        jButton21.setFocusable(false);
        jButton21.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton21.setOpaque(false);
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jLabel22.setText("Counter Number:");

        jLabel23.setText("00");

        jLabel24.setText("Customer ID No.:");

        jLabel27.setText("Customer Name:");

        jLabel28.setText("Customer Address:");

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/settings (2).png"))); // NOI18N
        jLabel30.setToolTipText("Settings");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel30MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel30MouseExited(evt);
            }
        });

        jButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/magnifying-glass.png"))); // NOI18N
        jButton22.setText(" F2 - Priority Number");
        jButton22.setBorder(null);
        jButton22.setBorderPainted(false);
        jButton22.setEnabled(false);
        jButton22.setFocusable(false);
        jButton22.setMargin(new java.awt.Insets(0, 14, 0, 0));
        jButton22.setOpaque(false);
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(18, 115, 172));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("0");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Regular");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Priority");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel30))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(0, 0, 0)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel31))
                .addGap(0, 0, 0)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        call_again();


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

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (out != null) {
            System.out.println("Sending....1");
            out.println("1");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (out != null) {
            System.out.println("Sending....2");
            out.println("2");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        ret_waiting_list();

    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        connect_to_queue_server();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (jButton17.isEnabled()) {
            get_new_number();
        }

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if (jButton18.isEnabled()) {
            call_again();
        }

    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (jButton19.isEnabled()) {
            finish_queue(3);
        }

    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if (jButton20.isEnabled()) {
            finish_queue(2);
        }

    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (jButton21.isEnabled()) {
            finish_queue(1);
        }

    }//GEN-LAST:event_jButton21ActionPerformed

    private void jLabel30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseEntered
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/settings (3).png")));
        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel30MouseEntered

    private void jLabel30MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseExited
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qs/icons/settings (2).png")));
        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_jLabel30MouseExited

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
        menu();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if (jButton22.isEnabled()) {
            get_new_number_priority();
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
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
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
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
     JFrame f = new JFrame();

    private void myInit() {

//        System.setProperty("pool_host", "192.168.1.148");
//        System.setProperty("counter_no", "01");
//        System.setProperty("teller", "Ronald Pascua");
//        System.setProperty("teller_id", "1");
//        System.setProperty("department", "Evaluation");
//        System.setProperty("department_id", "1");
//        System.setProperty("chatServerAddress", "192.168.1.148");
//        System.setProperty("chatServerPort", "1000");
        jPanel8.setVisible(false);
//        jLabel16.setText(System.getProperty("business_name", "Bayawan Water District"));
        String environment = System.getProperty("environment", "production");
        if (environment.equalsIgnoreCase("production")) {
//            jButton15.setVisible(false);
            jButton16.setVisible(false);
            jButton9.setVisible(false);
            jButton10.setVisible(false);
            jButton11.setVisible(false);
            jButton12.setVisible(false);
            jButton13.setVisible(false);
            jButton14.setVisible(false);
        }

        init_key();

        init_tbl_queues(tbl_waiting_list);
        init_tbl_queues_finished(jTable2);
        ret_finished_queues();
        init_tbl_queues_cancelled(jTable4);
        ret_cancelled_queues();
        init_tbl_queues_noshow(jTable3);
        ret_noshow_queues();
//        set_border();
//        connect_to_queue_server();
    }

    public void login() {

        Window p = (Window) this;
        Dlg_login nd = Dlg_login.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_login.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_login.OutputData data) {
                closeDialog.ok();
                ret_waiting_list();
                get_previous_number();
//                start_teller_server();

                String counter_no = System.getProperty("counter_no", "");
                String ip_address = "";
                try {
                    InetAddress localhost = InetAddress.getLocalHost();
                    ip_address = localhost.getHostAddress().trim();
                    System.out.println("System IP Address : "
                            + (localhost.getHostAddress()).trim());
                } catch (UnknownHostException ex) {
                    ip_address = "";
                    System.out.println(ex);
                }
                if (!ip_address.isEmpty()) {

                    List<Counters.to_counters> counters = Counters.ret_data(" where ip_address='" + ip_address + "'");
                    if (!counters.isEmpty()) {
                        Counters.to_counters counter = counters.get(0);
                        Counters.update_login_status(counter, 1);
                    }
                }

                jLabel12.setText(counter_no);
                jLabel23.setText(counter_no);

            }
        });
        nd.setLocationRelativeTo(jPanel9);
        nd.setVisible(true);
    }

    private void close() {
        Window p = (Window) this;
        Dlg_confirm_action2 nd = Dlg_confirm_action2.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_confirm_action2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action2.OutputData data) {
                closeDialog.ok();
                Dlg_call_number.this.f.dispose();

            }
        });
        nd.setLocationRelativeTo(jPanel9);
        nd.setVisible(true);
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

                disposed();
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F1, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton17.isEnabled()) {
                    get_new_number();
                }

            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F2, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton22.isEnabled()) {
                    get_new_number_priority();
                }
            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F3, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton18.isEnabled()) {
                    call_again();

                }

            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F4, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton19.isEnabled()) {
                    finish_queue(3);

                }

            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F5, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (jButton20.isEnabled()) {
                    finish_queue(2);

                }

            }
        });
        KeyMapping.mapKeyWIFW(getSurface(),
                KeyEvent.VK_F6, new KeyAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                finish_queue(1);

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
        String counter_id = System.getProperty("counter_id", "");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "");
//        System.out.println("department_id: " + department_id);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                List<Counter_departments.to_counter_departments> counter_departments = Counter_departments.ret_data(" where counter_id='" + counter_id + "' ");
                String in = department_id;
                String in_priority = "1000";
                for (Counter_departments.to_counter_departments to : counter_departments) {
                    if (to.priority == 1) {
                        in_priority = in_priority + "," + to.department_id;
                    } else {
                        in = in + "," + to.department_id;
                    }

                }

                String date = DateType.sf.format(new Date());
                String where = " where status=0 and department_id IN(" + in + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
                String where2 = " where status=0 and department_id IN(" + in_priority + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
                List<to_queues> q_all = new ArrayList();
                List<to_queues> q = Queues.ret_data(where);
                List<to_queues> q2 = Queues.ret_data(where2);
                
                q_all.addAll(q);
                q_all.addAll(q2);
                loadData_queues(q_all);
                jLabel21.setText("" + q.size());
                jLabel31.setText("" + q2.size());
            }
        });

    }

//</editor-fold> 
    int queue_id = 0;

    private void get_previous_number() {
        String counter_no = System.getProperty("counter_no", "01");
        String department = System.getProperty("department", "Evaluation");
        String department_id = System.getProperty("department_id", "");
        String teller = System.getProperty("teller", "Ronald Pascua");
        String teller_id = System.getProperty("teller_id", "");
        String date = DateType.sf.format(new Date());
//        String where = " where status=0 and teller_id='" + teller_id + "' and department_id='" + department_id + "' and Date(created_at)='" + date + "' and teller IS NOT NULL order by id asc ";
        String where = " where status=0 and teller_id='" + teller_id + "'  and Date(created_at)='" + date + "' and teller IS NOT NULL order by id asc ";

//        System.out.println(where);
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

//            jLabel23.setText(to.department);
            jLabel19.setText(to.queue_no);
            jLabel25.setText(to.customer_id);
            jLabel26.setText(to.customer);
            jLabel29.setText(address);
            enable_buttons_gnn(false);
        } else {
            enable_buttons_gnn(true);
            jLabel19.setText("0");
            jLabel25.setText("");
            jLabel26.setText("");
            jLabel29.setText("");
        }
    }

    private void get_new_number() {

        String counter_no = System.getProperty("counter_no", "");
        String counter_id = System.getProperty("counter_id", "");
        String department = System.getProperty("department", "");
        String department_id = System.getProperty("department_id", "");
        String teller = System.getProperty("teller", "");
        String teller_id = System.getProperty("teller_id", "");

        List<Counter_departments.to_counter_departments> counter_departments = Counter_departments.ret_data(" where counter_id='" + counter_id + "' ");
        String in = department_id;
        String in_priority = "1000";
        int i = 0;
        for (Counter_departments.to_counter_departments to : counter_departments) {
            if (to.priority == 1) {
                in_priority = in_priority + "," + to.department_id;

            } else {
                in = in + "," + to.department_id;
            }

        }

//        System.out.println("in_priority: " + in_priority);
//        String where = " where status=0 and department_id IN(" + in + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
        String date = DateType.sf.format(new Date());
        String where = " where status=0 and department_id IN(" + in + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
        String where2 = " where status=0 and department_id IN(" + in_priority + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";

        List<to_queues> q_all = new ArrayList();
        List<to_queues> q = Queues.ret_data(where);
//        List<to_queues> q_priority = Queues.ret_data(where2);
//        q_all.addAll(q_priority);
        q_all.addAll(q);
        if (!q_all.isEmpty()) {
            to_queues to = (to_queues) q_all.get(0);
            List<Customers.to_customers> custs = Customers.ret_data(" where customer_no='" + to.customer_id + "'");
            String address = "";
            if (!custs.isEmpty()) {
                Customers.to_customers cus = (Customers.to_customers) custs.get(0);
                address = cus.address;
            }
            queue_id = to.id;
            jLabel2.setText(to.department);
            jLabel4.setText(to.queue_no);
//            jLabel6.setText("ID No.: " + to.customer_id);
//            jLabel7.setText("Name : " + to.customer);
//            jXLabel1.setText("Address: " + address);

//            jLabel23.setText(to.department);
            jLabel19.setText(to.queue_no);
            jLabel25.setText(to.customer_id);
            jLabel26.setText(to.customer);
            jLabel29.setText(address);
            //update queue
            Queues.update_teller(to.id, counter_no, teller, teller_id);
//            jButton1.setEnabled(false);
//            jButton3.setEnabled(true);
//            jButton2.setEnabled(true);
//            jButton4.setEnabled(true);
//            jButton5.setEnabled(true);

            String queue_no = jLabel4.getText();
            String message = "" + counter_no + "," + queue_no + ",1";
            send_message(message);
            enable_buttons_gnn(false);
        }
    }

    private void get_new_number_priority() {

        String counter_no = System.getProperty("counter_no", "");
        String counter_id = System.getProperty("counter_id", "");
        String department = System.getProperty("department", "");
        String department_id = System.getProperty("department_id", "");
        String teller = System.getProperty("teller", "");
        String teller_id = System.getProperty("teller_id", "");

        List<Counter_departments.to_counter_departments> counter_departments = Counter_departments.ret_data(" where counter_id='" + counter_id + "' ");
        String in = department_id;
        String in_priority = "1000";
        int i = 0;
        for (Counter_departments.to_counter_departments to : counter_departments) {
            if (to.priority == 1) {
                in_priority = in_priority + "," + to.department_id;

            } else {
                in = in + "," + to.department_id;
            }

        }

//        System.out.println("in_priority: " + in_priority);
//        String where = " where status=0 and department_id IN(" + in + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
        String date = DateType.sf.format(new Date());
        String where = " where status=0 and department_id IN(" + in + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";
        String where2 = " where status=0 and department_id IN(" + in_priority + ") and Date(created_at)='" + date + "' and teller IS NULL order by id asc ";

        List<to_queues> q_all = new ArrayList();
//        List<to_queues> q = Queues.ret_data(where);
        List<to_queues> q_priority = Queues.ret_data(where2);
        q_all.addAll(q_priority);
//        q_all.addAll(q);
        if (!q_all.isEmpty()) {
            to_queues to = (to_queues) q_all.get(0);
            List<Customers.to_customers> custs = Customers.ret_data(" where customer_no='" + to.customer_id + "'");
            String address = "";
            if (!custs.isEmpty()) {
                Customers.to_customers cus = (Customers.to_customers) custs.get(0);
                address = cus.address;
            }
            queue_id = to.id;
            jLabel2.setText(to.department);
            jLabel4.setText(to.queue_no);
//            jLabel6.setText("ID No.: " + to.customer_id);
//            jLabel7.setText("Name : " + to.customer);
//            jXLabel1.setText("Address: " + address);

//            jLabel23.setText(to.department);
            jLabel19.setText(to.queue_no);
            jLabel25.setText(to.customer_id);
            jLabel26.setText(to.customer);
            jLabel29.setText(address);
            //update queue
            Queues.update_teller(to.id, counter_no, teller, teller_id);
//            jButton1.setEnabled(false);
//            jButton3.setEnabled(true);
//            jButton2.setEnabled(true);
//            jButton4.setEnabled(true);
//            jButton5.setEnabled(true);

            String queue_no = jLabel4.getText();
            String message = "" + counter_no + "," + queue_no + ",1";
            send_message(message);
            enable_buttons_gnn(false);
        }
    }

    private void enable_buttons_gnn(boolean stmt) {

        if (stmt == true) {
            jButton17.setEnabled(true);
            jButton22.setEnabled(true);
            jButton18.setEnabled(false);
            jButton19.setEnabled(false);
            jButton20.setEnabled(false);
            jButton21.setEnabled(false);

        } else {
            jButton17.setEnabled(false);
            jButton22.setEnabled(false);
            jButton18.setEnabled(true);
            jButton19.setEnabled(true);
            jButton20.setEnabled(true);
            jButton21.setEnabled(true);
        }

    }

    private void call_again() {
        String queue_no = jLabel4.getText();
        String counter_no = jLabel12.getText();
        String message = "" + counter_no + "," + queue_no + ",2";
        send_message(message);
    }
    PrintWriter out2 = null;

    private void send_message(String message) {
        try {
//            System.out.println("Sending Message to Server...");
//            print_config();
            String queue_server_ip = System.getProperty("queue_server_ip", "192.168.1.152");
            int queue_server_port = FitIn.toInt(System.getProperty("queue_server_port", "2000"));
            Socket s = new Socket(queue_server_ip, queue_server_port);
            out2 = new PrintWriter(s.getOutputStream(), true);
            out2.println(message);
//            System.out.println("Message: " + message);

        } catch (IOException ex) {
            System.out.println("Error: " + ex);
        }
    }

    private void print_config() {
        String counter_no_1_ip = System.getProperty("counter_no_1_ip", "");
        int counter_no_1_port = FitIn.toInt(System.getProperty("counter_no_1_port", ""));

        String counter_no_2_ip = System.getProperty("counter_no_2_ip", "");
        int counter_no_2_port = FitIn.toInt(System.getProperty("counter_no_2_port", ""));

        String counter_no_3_ip = System.getProperty("counter_no_3_ip", "");
        int counter_no_3_port = FitIn.toInt(System.getProperty("counter_no_3_port", ""));

        String counter_no_4_ip = System.getProperty("counter_no_4_ip", "");
        int counter_no_4_port = FitIn.toInt(System.getProperty("counter_no_4_port", ""));

        String counter_no_5_ip = System.getProperty("counter_no_5_ip", "");
        int counter_no_5_port = FitIn.toInt(System.getProperty("counter_no_5_port", ""));

        String counter_no_6_ip = System.getProperty("counter_no_6_ip", "");
        int counter_no_6_port = FitIn.toInt(System.getProperty("counter_no_6_port", ""));

        System.out.println("counter_no_1_ip: " + counter_no_1_ip + " + counter_no_1_port: " + counter_no_1_port);
        System.out.println("counter_no_2_ip: " + counter_no_2_ip + " + counter_no_2_port: " + counter_no_2_port);
        System.out.println("counter_no_3_ip: " + counter_no_3_ip + " + counter_no_3_port: " + counter_no_3_port);
        System.out.println("counter_no_4_ip: " + counter_no_4_ip + " + counter_no_4_port: " + counter_no_4_port);
        System.out.println("counter_no_5_ip: " + counter_no_5_ip + " + counter_no_5_port: " + counter_no_5_port);
        System.out.println("counter_no_6_ip: " + counter_no_6_ip + " + counter_no_6_port: " + counter_no_6_port);
    }

    private void finish_queue(int status) {
        Window p = (Window) this;
        Dlg_confirm_action2 nd = Dlg_confirm_action2.create(p, true);
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

        nd.setCallback(new Dlg_confirm_action2.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_confirm_action2.OutputData data) {
                closeDialog.ok();
                Queues.update_queue(queue_id, status);
                ret_waiting_list();
                int type = 3;
                if (status == 1) {
                    type = 5;
                    ret_finished_queues();
                }
                if (status == 2) {
                    type = 4;
                    ret_cancelled_queues();
                }
                if (status == 3) {
                    type = 3;
                    ret_noshow_queues();
                }

                queue_id = 0;
//                jButton1.setEnabled(true);
//                jButton5.setEnabled(false);
//                jButton4.setEnabled(false);
//                jButton2.setEnabled(false);
//                jButton3.setEnabled(false);
                enable_buttons_gnn(true);

                String queue_no = jLabel4.getText();
                String counter_no = jLabel12.getText();
                String message = "" + counter_no + "," + queue_no + "," + type;
                send_message(message);

                jLabel2.setText("");
                jLabel4.setText("");
//                jLabel6.setText("ID No.: ");
//                jLabel7.setText("Name : ");
//                jXLabel1.setText("Address: ");

                jLabel19.setText("0");
//                jLabel21.setText("");
                jLabel25.setText("");
                jLabel26.setText("");
                jLabel29.setText("");
                ret_waiting_list();

            }
        }
        );
        nd.setLocationRelativeTo(jPanel9);
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
        String counter_no = System.getProperty("counter_no", "");
        String department = System.getProperty("department", "");
        String department_id = System.getProperty("department_id", "");
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
        String counter_no = System.getProperty("counter_no", "");
        String department = System.getProperty("department", "");
        String department_id = System.getProperty("department_id", "");
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
        String counter_no = System.getProperty("counter_no", "");
        String department = System.getProperty("department", "");
        String department_id = System.getProperty("department_id", "");
        String date = DateType.sf.format(jDateChooser3.getDate());

        String where = " where status=3 and department_id='" + department_id + "' and Date(created_at)='" + date + "' order by id asc ";
        List<to_queues> q = Queues.ret_data(where);
        loadData_queues_noshow(q);
    }

//</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc=" Chat Server ">
    BufferedReader in;
    PrintWriter out;
    Socket socket_queue = null;

    public void connect_to_queue_server() {
        String queue_server_ip = System.getProperty("queue_server_ip", "192.168.1.148");

        if (!queue_server_ip.isEmpty()) {
            int queue_server_port = FitIn.toInt(System.getProperty("queue_server_port", "2000"));
            System.out.println("Queue Server ip: " + queue_server_ip);
            System.out.println("Queue Server port: " + queue_server_port);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("socket_queue isClosed: " + socket_queue.isClosed());
//                    System.out.println("socket_queue isBound: " + socket_queue.isBound());
//                    System.out.println("socket_queue isConnected: " + socket_queue.isConnected());
//                    System.out.println("socket_queue isInputShutdown: " + socket_queue.isInputShutdown());
//                    System.out.println("socket_queue isOutputShutdown: " + socket_queue.isOutputShutdown());

                    try {
                        if (socket_queue == null) {
                            socket_queue = new Socket(queue_server_ip, queue_server_port);
                            in = new BufferedReader(new InputStreamReader(socket_queue.getInputStream()));
                            out = new PrintWriter(socket_queue.getOutputStream(), true);
                            System.out.println("Queue Server initializing....");
                            out.println("Initializing Queue server");
                        } else {
                            System.out.println("Connected: " + socket_queue.isConnected());
                            if (socket_queue.isConnected()) {
                                socket_queue.close();
                                in.close();
                                out.close();
                                socket_queue = new Socket(queue_server_ip, queue_server_port);
                                in = new BufferedReader(new InputStreamReader(socket_queue.getInputStream()));
                                out = new PrintWriter(socket_queue.getOutputStream(), true);
                            } else {
                                socket_queue.close();
                                in.close();
                                out.close();
                                socket_queue = new Socket(queue_server_ip, queue_server_port);
                                in = new BufferedReader(new InputStreamReader(socket_queue.getInputStream()));
                                out = new PrintWriter(socket_queue.getOutputStream(), true);
                            }

                        }
                    } catch (IOException ex) {
                        System.out.println("Cannot connect to Queue server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Teller Server ">
    private static final HashSet<String> names = new HashSet();
    private static final HashSet<PrintWriter> writers = new HashSet();

    public void start_teller_server() {

        int port = FitIn.toInt(System.getProperty("queue_server_port", "2000"));
//
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    System.out.println("Starting Counter Server ...");
                    ServerSocket listener = new ServerSocket(port);
                    try {
                        while (true) {
                            java.net.Socket socket = listener.accept();
                            try {
                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                        socket.getInputStream()));
                                String input = in.readLine();
//                                System.out.println("input: "+input);
                                ret_waiting_list();

                            } finally {
                                socket.close();
                            }
                        }
                    } finally {
                        listener.close();
                    }
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        });
        t.start();

    }

    //</editor-fold>
    private void menu() {
        Window p = (Window) this;
        Dlg_menu nd = Dlg_menu.create(p, true);
        nd.setTitle("");

        nd.setCallback(new Dlg_menu.Callback() {

            @Override
            public void ok1(CloseDialog closeDialog, Dlg_menu.OutputData data) {
//                closeDialog.ok();

            }

            @Override
            public void logout(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                System.exit(1);
            }

            @Override
            public void standby(CloseDialog closeDialog, Dlg_menu.OutputData data) {
                closeDialog.ok();
                login();
            }

            @Override
            public void minimize(CloseDialog closeDialog, Dlg_menu.OutputData data) {

            }

        });
        Point point = jLabel30.getLocationOnScreen();
        nd.setLocation(point.x - 150, point.y + 17);
        nd.setVisible(true);
    }
}
