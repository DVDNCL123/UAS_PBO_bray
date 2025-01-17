package uas.pbo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS
 */
public class MenuDriver extends javax.swing.JFrame {

    /**
     * Creates new form MenuSeller
     */
    public MenuDriver() {
        initComponents();
        loadPesanan();
    }
    private void loadPesanan() {
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID Pesanan", "ID Customer", "ID Driver", "Nama", "Nomor Telepon", "Alamat", "Status Pesanan"}, 0);

        try {
            Connection conn = dbConnection.getConnection();
            Statement stmt = conn.createStatement();
    
            // Query untuk mendapatkan data pesanan dan customer
            String query = "SELECT p.idPesanan, p.idCustomer, p.idDriver, c.nameFull, c.noHP, c.alamat, p.statusPesanan " +
                           "FROM pesanan p " +
                            "JOIN customer c ON p.idCustomer = c.id";

            ResultSet rs = stmt.executeQuery(query);

            // Loop untuk menambah data ke dalam tabel
            while (rs.next()) {
                String idPesanan = rs.getString("idPesanan");
                String idCustomer = rs.getString("idCustomer");
                String idDriver = rs.getString("idDriver");
                String nameFull = rs.getString("nameFull");
                String noHP = rs.getString("noHP");
                String alamat = rs.getString("alamat");
                String statusPesanan = rs.getString("statusPesanan");

                // Menambahkan baris data ke tabel
                model.addRow(new Object[]{idPesanan, idCustomer, idDriver, nameFull, noHP, alamat, statusPesanan});
            }

            // Menetapkan model ke jTable1
            jTable1.setModel(model);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data pesanan dan customer: " + e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        exitBT = new javax.swing.JButton();
        antarBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(690, 325));
        setSize(new java.awt.Dimension(700, 340));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 325));

        jLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("GO DRY");
        jLabel2.setPreferredSize(new java.awt.Dimension(140, 55));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uas/pbo/baju0.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uas/pbo/ojek50.png"))); // NOI18N
        jLabel1.setText("DRIVER MENU");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pesanan", "ID Driver", "ID Costumer", "Nama", "No Telepon", "Alamat", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        exitBT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        exitBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uas/pbo/exi.png"))); // NOI18N
        exitBT.setText("EXIT");
        exitBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTActionPerformed(evt);
            }
        });

        antarBT.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        antarBT.setText("ANTAR PESANAN");
        antarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antarBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(antarBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitBT))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitBT)
                    .addComponent(antarBT, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void antarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antarBTActionPerformed
        // TODO add your handling code here:
        if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Tabel kosong, tidak ada data untuk diperbarui.");
            return;
        }

        // Ambil baris yang dipilih pada tabel
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow != -1) {
            // Ambil ID Pesanan dari baris yang dipilih
            String idPesanan = jTable1.getValueAt(selectedRow, 0).toString();

            // Set status baru langsung menjadi "Delivered"
            String newStatus = "Delivered";

            // Update data di database
            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                // Koneksi ke database
                conn = dbConnection.getConnection();

                // SQL query untuk update statusPesanan
                String query = "UPDATE pesanan SET statusPesanan = ? WHERE idPesanan = ?";

                // Prepare statement untuk mencegah SQL Injection
                pstmt = conn.prepareStatement(query);
                pstmt.setString(1, newStatus); // Set status baru menjadi "Delivered"
                pstmt.setString(2, idPesanan); // Set idPesanan yang dipilih
                
                // Eksekusi update
                int rowsUpdated = pstmt.executeUpdate();

                // Cek apakah update berhasil
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "Status Pesanan berhasil diperbarui menjadi Delivered!");
                    // Refresh data pesanan setelah pembaruan
                    loadPesanan();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal memperbarui status pesanan.");
                }

            } catch (Exception e) {
                // Jika terjadi error pada koneksi atau query
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            } finally {
                try {
                    // Pastikan koneksi ditutup setelah operasi selesai
                    if (pstmt != null) {
                        pstmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Error closing connection: " + e.getMessage());
                }
            }
        } else {
            // Jika tidak ada baris yang dipilih
            JOptionPane.showMessageDialog(this, "Silakan pilih pesanan yang ingin diupdate.");
        }
    }//GEN-LAST:event_antarBTActionPerformed

    private void exitBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
            MenuLogin Login = new MenuLogin();
            Login.setVisible(true);
        }
    }//GEN-LAST:event_exitBTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDriver.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDriver().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton antarBT;
    private javax.swing.JButton exitBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
