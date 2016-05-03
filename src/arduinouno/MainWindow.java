/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arduinouno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author zerg
 */
public class MainWindow extends javax.swing.JFrame {

    private TimeChartGenerator theTimeChart;
    private File saveFile=null;

    public void setTheTimeChart(TimeChartGenerator theTimeChart) {
        this.theTimeChart = theTimeChart;
    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    public void updateA0Reading(double value) {
        jTextA0Reading.setText(String.format("%.2f", value));
    }

    public void updateA1Reading(double value) {
        jTextA1Reading.setText(String.format("%.2f", value));
    }

    public void updateA2Reading(double value) {
        jTextA2Reading.setText(String.format("%.2f", value));
    }

    public void updateA3Reading(double value) {
        jTextA3Reading.setText(String.format("%.2f", value));
    }

    public void updateA4Reading(double value) {
        jTextA4Reading.setText(String.format("%.2f", value));
    }

    public void updateA5Reading(double value) {
        jTextA5Reading.setText(String.format("%.2f", value));
    }

    public void setChartPanel(ChartPanel theChartPanel) {
        theChartPanel.setSize(jPanel1.getSize());
        jPanel1.add(theChartPanel);
        jPanel1.getParent().validate();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextA0Reading = new javax.swing.JTextField();
        jTextA1Reading = new javax.swing.JTextField();
        jButtonExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextA2Reading = new javax.swing.JTextField();
        jTextA3Reading = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jTextA4Reading = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextA5Reading = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jCheckBoxA0 = new javax.swing.JCheckBox();
        jCheckBoxA1 = new javax.swing.JCheckBox();
        jCheckBoxA2 = new javax.swing.JCheckBox();
        jCheckBoxA3 = new javax.swing.JCheckBox();
        jCheckBoxA4 = new javax.swing.JCheckBox();
        jCheckBoxA5 = new javax.swing.JCheckBox();
        jButtonGuardar = new javax.swing.JButton();
        jButtonSelectFile = new javax.swing.JButton();
        jTextFieldSaveFile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );

        jLabel1.setText("Grafico");

        jLabel2.setText("A0");

        jLabel3.setText("A1");

        jTextA0Reading.setEditable(false);
        jTextA0Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA0Reading.setText("0");

        jTextA1Reading.setEditable(false);
        jTextA1Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA1Reading.setText("0");

        jButtonExit.setText("Salir");
        jButtonExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonExitMouseClicked(evt);
            }
        });

        jLabel4.setText("A2");

        jLabel5.setText("A3");

        jTextA2Reading.setEditable(false);
        jTextA2Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA2Reading.setText("0");

        jTextA3Reading.setEditable(false);
        jTextA3Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA3Reading.setText("0");

        jTextA4Reading.setEditable(false);
        jTextA4Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA4Reading.setText("0");

        jLabel6.setText("A5");

        jTextA5Reading.setEditable(false);
        jTextA5Reading.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextA5Reading.setText("0");

        jLabel7.setText("A4");

        jCheckBoxA0.setText("jCheckBox1");
        jCheckBoxA0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBoxA0MouseClicked(evt);
            }
        });

        jCheckBoxA1.setText("jCheckBox1");

        jCheckBoxA2.setText("jCheckBox1");

        jCheckBoxA3.setText("jCheckBox1");

        jCheckBoxA4.setText("jCheckBox1");

        jCheckBoxA5.setText("jCheckBox1");

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGuardarMouseClicked(evt);
            }
        });
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonSelectFile.setText("Select File");
        jButtonSelectFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectFileActionPerformed(evt);
            }
        });

        jTextFieldSaveFile.setEditable(false);
        jTextFieldSaveFile.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldSaveFile.setText("None");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(378, 378, 378)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel5))
                                    .addComponent(jTextA2Reading, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(jTextA3Reading)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel6))
                            .addComponent(jTextA5Reading)
                            .addComponent(jTextA4Reading))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxA2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextA0Reading, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel2))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel3))
                                .addComponent(jTextA1Reading, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxA0, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(jButtonGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSelectFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldSaveFile))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA0Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA0))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA1Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA2Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA3Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA4Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextA5Reading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCheckBoxA5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldSaveFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSelectFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExit)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jButtonExitMouseClicked

    private void jCheckBoxA0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBoxA0MouseClicked
        Boolean sA0 = jCheckBoxA0.isSelected();
        if (sA0) {
            jCheckBoxA0.setSelected(true);
        } else {
            jCheckBoxA0.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBoxA0MouseClicked

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        Double[][] theDataVector = theTimeChart.getPlotInfo();
        if (saveFile!= null) {
            dataVectorToCSVFile(saveFile, theDataVector);
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGuardarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGuardarMouseClicked

    private void jButtonSelectFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectFileActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            saveFile = fileChooser.getSelectedFile();
            jTextFieldSaveFile.setText(saveFile.getName());
            
        }
    }//GEN-LAST:event_jButtonSelectFileActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonSelectFile;
    private javax.swing.JCheckBox jCheckBoxA0;
    private javax.swing.JCheckBox jCheckBoxA1;
    private javax.swing.JCheckBox jCheckBoxA2;
    private javax.swing.JCheckBox jCheckBoxA3;
    private javax.swing.JCheckBox jCheckBoxA4;
    private javax.swing.JCheckBox jCheckBoxA5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextA0Reading;
    private javax.swing.JTextField jTextA1Reading;
    private javax.swing.JTextField jTextA2Reading;
    private javax.swing.JTextField jTextA3Reading;
    private javax.swing.JTextField jTextA4Reading;
    private javax.swing.JTextField jTextA5Reading;
    private javax.swing.JTextField jTextFieldSaveFile;
    // End of variables declaration//GEN-END:variables

    private void dataVectorToCSVFile(File theFile, Double[][] theDataVector) {
        PrintWriter writer;
        
        int columns = theDataVector[0].length;
        
        String header = new String();
        for (int j = 0; j < columns; j++) {
            if (j == columns - 1) {
                header = header.concat("A" + j);
            } else {
                header = header.concat("A" + j + ",");
            }
        }

        try {
            writer = new PrintWriter(theFile, "UTF-8");
            int i = 0;
            writer.println(header);
            
            while (i < theDataVector.length) {
                String line = new String();
                for (int j = 0; j < columns; j++) {
                    Double value = theDataVector[i][j];
                    if (j == columns - 1) {
                        line = line.concat("\""+String.format("%.2f", value)+"\"");
                    } else {
                        line = line.concat("\""+String.format("%.2f", value)+"\"" + ",");
                    }
                }
                writer.println(line);
                i++;
            }
            writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
