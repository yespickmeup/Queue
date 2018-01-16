/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qs.pnl;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.binding.list.ArrayListModel;
import java.awt.Dimension;
import java.awt.Toolkit;
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
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.FitIn;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.customers.Customers;
import qs.departments.Departments;
import qs.queues.Queues;
import qs.util.Alert;
import qs.util.DateType;
import synsoftech.fields.Button;
import synsoftech.fields.Field;
import synsoftech.util.ImageRenderer;

/**
 *
 * @author Guinness
 */
public class Dlg_generate_number extends javax.swing.JDialog {

    /**
     * Creates new form Dlg_call_customer
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
    private Dlg_generate_number(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    private Dlg_generate_number(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        initComponents();
        myInit();
    }

    public Dlg_generate_number() {
        super();
        setUndecorated(true);
        initComponents();
        myInit();

    }
    private Dlg_generate_number myRef;

    private void setThisRef(Dlg_generate_number myRef) {
        this.myRef = myRef;
    }
    private static java.util.Map<Object, Dlg_generate_number> dialogContainer = new java.util.HashMap();

    public static void clearUpFirst(java.awt.Window parent) {
        if (dialogContainer.containsKey(parent)) {
            dialogContainer.remove(parent);
        }
    }

    public static Dlg_generate_number create(java.awt.Window parent, boolean modal) {

        if (modal) {
            return create(parent, ModalityType.APPLICATION_MODAL);
        }

        return create(parent, ModalityType.MODELESS);

    }

    public static Dlg_generate_number create(java.awt.Window parent, java.awt.Dialog.ModalityType modalType) {

        if (parent instanceof java.awt.Frame) {

            Dlg_generate_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_generate_number((java.awt.Frame) parent, false);
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
            Dlg_generate_number dialog = dialogContainer.get(parent);

            if (dialog == null) {
                dialog = new Dlg_generate_number((java.awt.Dialog) parent, false);
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

        Dlg_generate_number dialog = Dlg_generate_number.create(new javax.swing.JFrame(), true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().
                getWidth());
        int ySize = ((int) tk.getScreenSize().
                getHeight());
        dialog.setSize(xSize, ySize);

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_degrees = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new Field.Search();
        jButton1 = new Button.Primary();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

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
        tbl_degrees.setFocusable(false);
        tbl_degrees.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbl_degrees);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Choose Department:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("Proceed");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Consumer Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
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
        proceed();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_degrees;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_degrees(tbl_degrees);
        ret_degrees();

        connect_to_teller_server();
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

    //<editor-fold defaultstate="collapsed" desc=" degrees "> 
    public static ArrayListModel tbl_degrees_ALM;
    public static TbldegreesModel tbl_degrees_M;

    public static void init_tbl_degrees(JTable tbl_degrees) {
        tbl_degrees_ALM = new ArrayListModel();
        tbl_degrees_M = new TbldegreesModel(tbl_degrees_ALM);
        tbl_degrees.setModel(tbl_degrees_M);
        tbl_degrees.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tbl_degrees.setRowHeight(25);
        int[] tbl_widths_degrees = {100, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0, n = tbl_widths_degrees.length; i < n; i++) {
            if (i == 0) {
                continue;
            }
            TableWidthUtilities.setColumnWidth(tbl_degrees, i, tbl_widths_degrees[i]);
        }
        Dimension d = tbl_degrees.getTableHeader().getPreferredSize();
        d.height = 0;
        tbl_degrees.getTableHeader().setPreferredSize(d);
        tbl_degrees.getTableHeader().setFont(new java.awt.Font("Arial", 0, 24));
        tbl_degrees.setRowHeight(50);
        tbl_degrees.setFont(new java.awt.Font("Arial", 0, 24));
        tbl_degrees.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        tbl_degrees.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tbl_degrees.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

    }

    public static void loadData_degrees(List<Departments.to_departments> acc) {
        tbl_degrees_ALM.clear();
        tbl_degrees_ALM.addAll(acc);
    }

    public static class TbldegreesModel extends AbstractTableAdapter {

        public static String[] COLUMNS = {
            "Degree", "Status", "", "", "created_at", "updated_at", "status", "is_uploaded"
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
            Departments.to_departments tt = (Departments.to_departments) getRow(row);
            switch (col) {
                case 0:
                    return " " + tt.department;
                case 1:
                    if (tt.status == 0) {
                        return " Active";
                    } else {
                        return " Inactive";
                    }
                case 2:
                    return "/qs/icons/new-file.png";
                case 3:
                    return "/qs/icons/remove11.png";
                case 4:
                    return tt.created_at;
                case 5:
                    return tt.updated_at;
                case 6:
                    return tt.status;
                default:
                    return tt.status;
            }
        }
    }

    private void ret_degrees() {
        String where = " order by department asc ";
        List<Departments.to_departments> datas = Departments.ret_data(where);
        loadData_degrees(datas);

    }

    private void proceed() {

        int row = tbl_degrees.getSelectedRow();
        if (row < 0) {
            Alert.set(0, "Select Department!");
            return;
        }

        String number = jTextField1.getText();
        if (!number.isEmpty()) {
            List<Customers.to_customers> list = Customers.ret_data(" where customer_no='" + number + "'");
            if (!list.isEmpty()) {
                Customers.to_customers to = (Customers.to_customers) list.get(0);
                jLabel3.setText(to.lname + ", " + to.fname + " " + to.mi);
            } else {
                Alert.set(0, "Consumer not found!");
                jTextField1.setText("");
                return;
            }
        }

        Departments.to_departments dep = (Departments.to_departments) tbl_degrees_ALM.get(row);
        Window p = (Window) this;
        Dlg_generate_number_prompt nd = Dlg_generate_number_prompt.create(p, true);
        nd.setTitle("");
        nd.setCallback(new Dlg_generate_number_prompt.Callback() {

            @Override
            public void ok(CloseDialog closeDialog, Dlg_generate_number_prompt.OutputData data) {
                closeDialog.ok();
                int id = 0;
                String date = DateType.sf.format(new Date());
                String queue_no = Queues.increment_id(dep.department, "" + dep.id);
                List<Queues.to_queues> exist = Queues.ret_data(" where queue_no='" + queue_no + "' and department_id='" + dep.id + "' and Date(created_at)='" + date + "' ");
                do {
                    queue_no = Queues.increment_id(dep.department, "" + dep.id);
                } while (!exist.isEmpty());

                String department = dep.department;
                String department_id = "" + dep.id;
                String customer = jLabel3.getText();
                String customer_id = jTextField1.getText();
                String counter_no = null;
                String teller = null;
                String teller_id = null;
                String remarks = "";
                int status = 0;
                String created_at = DateType.now();
                String updated_at = DateType.now();
                String created_by = "";
                String updated_by = "";

                Queues.to_queues q = new Queues.to_queues(id, queue_no, department, department_id, customer, customer_id, counter_no, teller, teller_id, remarks, status, created_at, updated_at, created_by, updated_by);
                Queues.add_data(q);

                if (out1 != null) {
                    out1.println("Hi teller 1");
                }
                if (out2 != null) {
                    out2.println("Hi teller 2");
                }
                if (out3 != null) {
                    out3.println("Hi teller 3");
                }
                if (out4 != null) {
                    out4.println("Hi teller 4");
                }
                if (out5 != null) {
                    out5.println("Hi teller 5");
                }
                if (out6 != null) {
                    out6.println("Hi teller 6");
                } 
               
                Alert.set(1, "");
                jTextField1.setText("");
                jLabel3.setText("");
                jTextField1.grabFocus();
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void generate() {

    }

    //<editor-fold defaultstate="collapsed" desc=" Chat Server ">
    BufferedReader in1;
    PrintWriter out1;

    BufferedReader in2;
    PrintWriter out2;

    BufferedReader in3;
    PrintWriter out3;

    BufferedReader in4;
    PrintWriter out4;

    BufferedReader in5;
    PrintWriter out5;

    BufferedReader in6;
    PrintWriter out6;

    public void connect_to_teller_server() {
        String counter_no_1_ip = System.getProperty("counter_no_1_ip", "192.168.1.152");
        System.out.println("counter_no_1_ip: " + counter_no_1_ip);
        if (!counter_no_1_ip.isEmpty()) {
            int counter_no_1_port = FitIn.toInt(System.getProperty("counter_no_1_port", "2001"));
            String screen_name = System.getProperty("teller", "Ronald Pascua1");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_1_ip, counter_no_1_port);
                        in1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out1 = new PrintWriter(socket.getOutputStream(), true);
                        while (true) {
                            String line = in1.readLine();
                            if (line.startsWith("SUBMITNAME")) {
                                out1.println(screen_name);
                            } else if (line.startsWith("NAMEACCEPTED")) {
                            } else if (line.startsWith("MESSAGE")) {
                                String message = line.substring(8);
                            }
                        }
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 1 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
        String counter_no_2_ip = System.getProperty("counter_no_2_ip", "192.168.1.153");
        System.out.println("counter_no_2_ip: " + counter_no_2_ip);
        if (!counter_no_2_ip.isEmpty()) {
            int counter_no_2_port = FitIn.toInt(System.getProperty("counter_no_1_port", "2002"));
            String screen_name = System.getProperty("teller", "Ronald Pascua2");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_2_ip, counter_no_2_port);
                        in2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out2 = new PrintWriter(socket.getOutputStream(), true);
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 2 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }

        String counter_no_3_ip = System.getProperty("counter_no_3_ip", "192.168.1.154");
        if (!counter_no_3_ip.isEmpty()) {
            int counter_no_3_port = FitIn.toInt(System.getProperty("counter_no_3_port", "2003"));
            String screen_name = System.getProperty("teller", "Ronald Pascua3");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_3_ip, counter_no_3_port);
                        in3 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out3 = new PrintWriter(socket.getOutputStream(), true);

                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 3 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }

        String counter_no_4_ip = System.getProperty("counter_no_4_ip", "192.168.1.155");
        if (!counter_no_4_ip.isEmpty()) {
            int counter_no_4_port = FitIn.toInt(System.getProperty("counter_no_4_port", "2004"));
            String screen_name = System.getProperty("teller", "Ronald Pascua4");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_4_ip, counter_no_4_port);
                        in4 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out4 = new PrintWriter(socket.getOutputStream(), true);

                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 4 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }

        String counter_no_5_ip = System.getProperty("counter_no_5_ip", "192.168.1.156");
        if (!counter_no_5_ip.isEmpty()) {
            int counter_no_5_port = FitIn.toInt(System.getProperty("counter_no_5_port", "2005"));
            String screen_name = System.getProperty("teller", "Ronald Pascua5");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_5_ip, counter_no_5_port);
                        in5 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out5 = new PrintWriter(socket.getOutputStream(), true);
                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 5 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
        String counter_no_6_ip = System.getProperty("counter_no_6_ip", "192.168.1.157");
        if (!counter_no_6_ip.isEmpty()) {
            int counter_no_6_port = FitIn.toInt(System.getProperty("counter_no_6_port", "2006"));
            String screen_name = System.getProperty("teller", "Ronald Pascua6");
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    Socket socket;
                    try {
                        socket = new Socket(counter_no_6_ip, counter_no_6_port);
                        in6 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        out6 = new PrintWriter(socket.getOutputStream(), true);

                    } catch (IOException ex) {
                        System.out.println("Generate Number, Cannot connect to Counter No. 6 server!");
                        System.out.println(ex);
                    }
                }
            });
            t.start();
        }
    }
    //</editor-fold>
}
