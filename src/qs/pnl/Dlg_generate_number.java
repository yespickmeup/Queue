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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import mijzcx.synapse.desk.utils.CloseDialog;
import mijzcx.synapse.desk.utils.KeyMapping;
import mijzcx.synapse.desk.utils.KeyMapping.KeyAction;
import mijzcx.synapse.desk.utils.TableWidthUtilities;
import qs.departments.Departments;
import qs.queues.Queues;
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                .addGap(50, 50, 50)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbl_degrees;
    // End of variables declaration//GEN-END:variables
    private void myInit() {
        init_key();
        init_tbl_degrees(tbl_degrees);
        ret_degrees();

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
            return;
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
                String department=dep.department;
                String department_id=""+dep.id;
                String customer="";
                String customer_id="";
                String counter_no="";
                String teller;
                String teller_id;
                String remarks;
                int status;
                String created_at;
                String updated_at;
                String created_by;
                String updated_by;
            }
        });
        nd.setLocationRelativeTo(jScrollPane1);
        nd.setVisible(true);
    }

    private void generate() {

    }
}
