/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info10.telas;

import java.sql.*;
import br.com.info10.dal.Modulo_Conexao;
import javax.swing.JOptionPane;

//importando recursos da biblioteca rs2xml.jar
import net.proteanit.sql.DbUtils;

/**
 *
 * @author marco
 */
public class frm_Clientes extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form frm_Clientes
     */
    public frm_Clientes() {
        initComponents();
        conexao = Modulo_Conexao.conector();
    }

    private void Adicionar() {

        if ((txt_Nome_Cliente.getText().isEmpty() || txt_Endereco_Cliente.getText().isEmpty() || txt_Telefone_Cliente.getText().isEmpty() || txt_Email_Cliente.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        } else {

            String sql = "insert into clientes(nome_cliente, end_cliente, telefone_cli, email) values(?,?,?,?)";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Nome_Cliente.getText());
                pst.setString(2, txt_Endereco_Cliente.getText());
                pst.setString(3, txt_Telefone_Cliente.getText());
                pst.setString(4, txt_Email_Cliente.getText());

                //Validação de campos obrigatórios
                //Atualizando atabela com os dados do usuario
                //Confirmação de inserção de dados na tabela
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    //Limpando os camposset
                    txt_Nome_Cliente.setText(null);
                    txt_Endereco_Cliente.setText(null);
                    txt_Telefone_Cliente.setText(null);
                    txt_Email_Cliente.setText(null);

                } else {
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    //Método para pesquisar pelo nome com filtro
    private void pesquisar_Cliente() {
        String sql = "select * from clientes where nome_cliente like ?";

        try {
            pst = conexao.prepareStatement(sql);
            //passando o conteúdo da caixa de pesquisa para o "?"
            //o sinal de "%" é a continuação da string sql
            pst.setString(1, txt_Pesquisa_Cliente.getText() + "%");
            rs = pst.executeQuery();

            //usando a biblioteca rs2xml.jar para preencher a tabela
            tabela_Clientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    //Método para setar os campos do formulario com o conteudo da tabela
    public void setar_Campos() {

        int setar = tabela_Clientes.getSelectedRow();
        txt_Id_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 0).toString());
        txt_Nome_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 1).toString());
        txt_Endereco_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 2).toString());
        txt_Telefone_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 3).toString());
        txt_Email_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 4).toString());
        btn_Adicionar.setEnabled(false);

    }

    //Método para alterar os dados do cliente
    private void Alterar() {

        if ((txt_Nome_Cliente.getText().isEmpty() || txt_Endereco_Cliente.getText().isEmpty() || txt_Telefone_Cliente.getText().isEmpty() || txt_Email_Cliente.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Dados não fornecidos. Para editar, utilize a caixa de pesquisa.");
        } else {
            String sql = "update clientes set nome_cliente = ?, end_cliente = ?, telefone_cli = ?, email = ? where id_cliente = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Nome_Cliente.getText());
                pst.setString(2, txt_Endereco_Cliente.getText());
                pst.setString(3, txt_Telefone_Cliente.getText());
                pst.setString(4, txt_Email_Cliente.getText());
                pst.setString(5, txt_Id_Cliente.getText());

                //confirmação de alteração de dados de usuario
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso.");
                    //Limpando os campos
                    txt_Nome_Cliente.setText(null);
                    txt_Endereco_Cliente.setText(null);
                    txt_Telefone_Cliente.setText(null);
                    txt_Email_Cliente.setText(null);
                    btn_Adicionar.setEnabled(true);

                } else {
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    //Método remover clientes
    private void Remover() {

        if ((txt_Nome_Cliente.getText().isEmpty() || txt_Endereco_Cliente.getText().isEmpty() || txt_Telefone_Cliente.getText().isEmpty() || txt_Email_Cliente.getText().isEmpty())) {

            JOptionPane.showMessageDialog(null, "Campos com asteriscos(*)são obrigatórios.");

        } else {

            String sql = "delete from clientes where id_cliente = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Id_Cliente.getText());

                //confirmação de exlcusão de cliente
                int excluido = pst.executeUpdate();
                if (excluido > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente removido com sucesso!");

                    //Limpando os camoos
                    txt_Id_Cliente.setText(null);
                    txt_Nome_Cliente.setText(null);
                    txt_Endereco_Cliente.setText(null);
                    txt_Telefone_Cliente.setText(null);
                    txt_Email_Cliente.setText(null);
                    btn_Adicionar.setEnabled(true);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
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

        btn_Adicionar = new javax.swing.JButton();
        btn_Deletar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        lbl_Nome = new javax.swing.JLabel();
        lbl_Endereco = new javax.swing.JLabel();
        lbl_Telefone = new javax.swing.JLabel();
        lbl_Email = new javax.swing.JLabel();
        txt_Endereco_Cliente = new javax.swing.JTextField();
        txt_Nome_Cliente = new javax.swing.JTextField();
        txt_Telefone_Cliente = new javax.swing.JTextField();
        txt_Email_Cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_Pesquisa_Cliente = new javax.swing.JTextField();
        lbl_Pesquisar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Clientes = new javax.swing.JTable();
        lbl_Id_Cliente = new javax.swing.JLabel();
        txt_Id_Cliente = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setPreferredSize(new java.awt.Dimension(640, 480));

        btn_Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/add.png"))); // NOI18N
        btn_Adicionar.setToolTipText("Adicionar");
        btn_Adicionar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Adicionar.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AdicionarActionPerformed(evt);
            }
        });

        btn_Deletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/delete.png"))); // NOI18N
        btn_Deletar.setToolTipText("Deletar");
        btn_Deletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Deletar.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_Deletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeletarActionPerformed(evt);
            }
        });

        btn_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/editar.png"))); // NOI18N
        btn_Editar.setToolTipText("Editar");
        btn_Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Editar.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        lbl_Nome.setText("* Nome");

        lbl_Endereco.setText("* Endereço");

        lbl_Telefone.setText("* Telefone");

        lbl_Email.setText("* Email");

        jLabel1.setText("* Campos obrigatórios");

        txt_Pesquisa_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Pesquisa_ClienteKeyReleased(evt);
            }
        });

        lbl_Pesquisar.setText("Pesquisar");

        tabela_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_Clientes);

        lbl_Id_Cliente.setText("Id");

        txt_Id_Cliente.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_Id_Cliente)
                            .addComponent(lbl_Nome)
                            .addComponent(lbl_Endereco)
                            .addComponent(lbl_Telefone)
                            .addComponent(lbl_Email))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Email_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Telefone_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Endereco_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Nome_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbl_Pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Pesquisa_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_Pesquisa_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id_Cliente)
                    .addComponent(txt_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nome)
                    .addComponent(txt_Nome_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Endereco)
                    .addComponent(txt_Endereco_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Telefone)
                    .addComponent(txt_Telefone_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Email)
                    .addComponent(txt_Email_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        // Metodo adicionar

        Adicionar();

    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarActionPerformed
        // Chamando método deletar
        Remover();

    }//GEN-LAST:event_btn_DeletarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        // Chamando método alterar
        Alterar();

    }//GEN-LAST:event_btn_EditarActionPerformed

    private void txt_Pesquisa_ClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Pesquisa_ClienteKeyReleased
        // Chamando o método pesquisar_Cliente com filtro
        pesquisar_Cliente();

    }//GEN-LAST:event_txt_Pesquisa_ClienteKeyReleased

    //este método faz o preenchimento dos textbox quando clicado na tabela de pesquisa
    private void tabela_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_ClientesMouseClicked
        // Chamando o método setar_Campos

        setar_Campos();
    }//GEN-LAST:event_tabela_ClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Deletar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Email;
    private javax.swing.JLabel lbl_Endereco;
    private javax.swing.JLabel lbl_Id_Cliente;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Pesquisar;
    private javax.swing.JLabel lbl_Telefone;
    private javax.swing.JTable tabela_Clientes;
    private javax.swing.JTextField txt_Email_Cliente;
    private javax.swing.JTextField txt_Endereco_Cliente;
    private javax.swing.JTextField txt_Id_Cliente;
    private javax.swing.JTextField txt_Nome_Cliente;
    private javax.swing.JTextField txt_Pesquisa_Cliente;
    private javax.swing.JTextField txt_Telefone_Cliente;
    // End of variables declaration//GEN-END:variables
}
