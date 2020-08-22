/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.info10.telas;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class frm_Principal extends javax.swing.JFrame {

    /** Creates new form frm_Principal */
    public frm_Principal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deskTop = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        lbl_Data = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Cadastro = new javax.swing.JMenu();
        menu_Add_Cliente = new javax.swing.JMenuItem();
        menu_Add_Os = new javax.swing.JMenuItem();
        menu_Add_Usuario = new javax.swing.JMenuItem();
        menu_Relatorio = new javax.swing.JMenu();
        menu_Servicos = new javax.swing.JMenuItem();
        menu_Ajuda = new javax.swing.JMenu();
        menu_Sobre = new javax.swing.JMenuItem();
        menu_Opcoes = new javax.swing.JMenu();
        meu_Sair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle ordem de serviço");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout deskTopLayout = new javax.swing.GroupLayout(deskTop);
        deskTop.setLayout(deskTopLayout);
        deskTopLayout.setHorizontalGroup(
            deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );
        deskTopLayout.setVerticalGroup(
            deskTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/3d_system_folder_20520 (2).png"))); // NOI18N

        lbl_Usuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Usuario.setText("Usuário");

        lbl_Data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_Data.setText("Data");

        menu_Cadastro.setText("Cadastro");

        menu_Add_Cliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menu_Add_Cliente.setText("Cliente");
        menu_Add_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Add_ClienteActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menu_Add_Cliente);

        menu_Add_Os.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        menu_Add_Os.setText("OS");
        menu_Add_Os.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Add_OsActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menu_Add_Os);

        menu_Add_Usuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK));
        menu_Add_Usuario.setText("Usuários");
        menu_Add_Usuario.setEnabled(false);
        menu_Add_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_Add_UsuarioActionPerformed(evt);
            }
        });
        menu_Cadastro.add(menu_Add_Usuario);

        jMenuBar1.add(menu_Cadastro);

        menu_Relatorio.setText("Relatório");
        menu_Relatorio.setEnabled(false);

        menu_Servicos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        menu_Servicos.setText("Serviços");
        menu_Relatorio.add(menu_Servicos);

        jMenuBar1.add(menu_Relatorio);

        menu_Ajuda.setText("Ajuda");

        menu_Sobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        menu_Sobre.setText("Sobre");
        menu_Sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_SobreActionPerformed(evt);
            }
        });
        menu_Ajuda.add(menu_Sobre);

        jMenuBar1.add(menu_Ajuda);

        menu_Opcoes.setText("Opções");
        menu_Opcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_OpcoesActionPerformed(evt);
            }
        });

        meu_Sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        meu_Sair.setText("Sair");
        meu_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meu_SairActionPerformed(evt);
            }
        });
        menu_Opcoes.add(meu_Sair);

        jMenuBar1.add(menu_Opcoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deskTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Usuario)
                    .addComponent(lbl_Data))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deskTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lbl_Usuario)
                .addGap(33, 33, 33)
                .addComponent(lbl_Data)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        setSize(new java.awt.Dimension(823, 522));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Substituindo label data pela pela data atual do sistema
        Date data = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.LONG);
        lbl_Data.setText(formatador.format(data));
    }//GEN-LAST:event_formWindowActivated

    private void menu_OpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_OpcoesActionPerformed
        
    }//GEN-LAST:event_menu_OpcoesActionPerformed

    private void meu_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meu_SairActionPerformed
        //Exibe uma caixa de dialogo sim ou nao para sair do sistema
        int sair = JOptionPane.showConfirmDialog(null,"Sair do Sistema?", "Atenção", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_meu_SairActionPerformed

    private void menu_SobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_SobreActionPerformed
        // Chamando a tela sobre
        frm_Sobre sobre = new frm_Sobre();
        sobre.setVisible(true);
        
    }//GEN-LAST:event_menu_SobreActionPerformed

    private void menu_Add_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Add_UsuarioActionPerformed
        // Chamando tela frm_Tela_Usuarios dentro do DesktopPane.
        frm_Tela_Usuarios usuarios = new frm_Tela_Usuarios();
        usuarios.setVisible(true);
        deskTop.add(usuarios);
    }//GEN-LAST:event_menu_Add_UsuarioActionPerformed

    private void menu_Add_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Add_ClienteActionPerformed
        // Chamando tela de Clientes
        
        frm_Clientes frm = new frm_Clientes();
        frm.setVisible(true);
        deskTop.add(frm);
    }//GEN-LAST:event_menu_Add_ClienteActionPerformed

    private void menu_Add_OsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_Add_OsActionPerformed
        // Chamando a tela de ordem de serviços
        frm_Ordem_Servico os = new frm_Ordem_Servico();
        os.setVisible(true);
        deskTop.add(os);
    }//GEN-LAST:event_menu_Add_OsActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane deskTop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_Data;
    public static javax.swing.JLabel lbl_Usuario;
    private javax.swing.JMenuItem menu_Add_Cliente;
    private javax.swing.JMenuItem menu_Add_Os;
    public static javax.swing.JMenuItem menu_Add_Usuario;
    private javax.swing.JMenu menu_Ajuda;
    private javax.swing.JMenu menu_Cadastro;
    private javax.swing.JMenu menu_Opcoes;
    public static javax.swing.JMenu menu_Relatorio;
    private javax.swing.JMenuItem menu_Servicos;
    private javax.swing.JMenuItem menu_Sobre;
    private javax.swing.JMenuItem meu_Sair;
    // End of variables declaration//GEN-END:variables

}
