/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info10.telas;

/**
 *
 * @author marco
 */
// Importando pacotes
import java.sql.*;
import br.com.info10.dal.Modulo_Conexao;
import javax.swing.JOptionPane;

public class frm_Tela_Usuarios extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form frm_Tela_Usuarios
     */
    public frm_Tela_Usuarios() {
        initComponents();
        conexao = Modulo_Conexao.conector();
    }

    private void Consultar() {
        String sql = "select * from usuarios where id_user = ?";

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_Id.getText());
            rs = pst.executeQuery();

            if (rs.next()) {

                txt_Nome.setText(rs.getString(2));
                txt_Telefone.setText(rs.getString(3));
                txt_Login.setText(rs.getString(4));
                txt_Senha.setText(rs.getString(5));

                //Código abaixo refere se ao combobox cb_Perfil
                cb_Perfil.setSelectedItem(rs.getString(6));

            } else {

                JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");

                //limpando os campos
                txt_Nome.setText(null);
                txt_Telefone.setText(null);
                txt_Login.setText(null);
                txt_Senha.setText(null);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void Adicionar() {

        if ((txt_Id.getText().isEmpty() || txt_Nome.getText().isEmpty() || txt_Telefone.getText().isEmpty() || txt_Login.getText().isEmpty() || txt_Senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        } else {

            String sql = "insert into usuarios(id_User, usuario, telefone, login, senha, perfil) values(?,?,?,?,?,?)";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Id.getText());
                pst.setString(2, txt_Nome.getText());
                pst.setString(3, txt_Telefone.getText());
                pst.setString(4, txt_Login.getText());
                pst.setString(5, txt_Senha.getText());
                pst.setString(6, cb_Perfil.getSelectedItem().toString());
                //Validação de campos obrigatórios

                //Atualizando atabela com os dados do usuario
                //Confirmação de inserção de dados na tabela
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Registro inserido com sucesso!");
                    //Limpando os camposset
                    txt_Id.setText(null);
                    txt_Nome.setText(null);
                    txt_Telefone.setText(null);
                    txt_Login.setText(null);
                    txt_Senha.setText(null);

                } else {
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    //Método alterar usuário
    private void Alterar() {

        if ((txt_Id.getText().isEmpty() || txt_Nome.getText().isEmpty() || txt_Telefone.getText().isEmpty() || txt_Login.getText().isEmpty() || txt_Senha.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        } else {
            String sql = "update usuarios set usuario = ?, telefone = ?, login = ?, senha = ?, perfil = ? where id_user = ?";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Nome.getText());
                pst.setString(2, txt_Telefone.getText());
                pst.setString(3, txt_Login.getText());
                pst.setString(4, txt_Senha.getText());
                pst.setString(5, cb_Perfil.getSelectedItem().toString());
                pst.setString(6, txt_Id.getText());

                //confirmação de alteração de dados de usuario
                int adicionado = pst.executeUpdate();

                if (adicionado > 0) {
                    JOptionPane.showMessageDialog(null, "Dados do usuário atualizados com sucesso!");
                    //Limpando os campos
                    txt_Id.setText(null);
                    txt_Nome.setText(null);
                    txt_Telefone.setText(null);
                    txt_Login.setText(null);
                    txt_Senha.setText(null);

                } else {
                }
            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

    //Método remover
    private void Remover() {

        //Remover usuário
        int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o usuário?", "Atanção!", JOptionPane.YES_NO_OPTION);

        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "delete from usuarios where id_user = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txt_Id.getText());

                //confirmação de exlcusão de usuario
                int excluido = pst.executeUpdate();
                if (excluido > 0) {
                    JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");

                    //Limpando os camoos
                    txt_Id.setText(null);
                    txt_Nome.setText(null);
                    txt_Telefone.setText(null);
                    txt_Login.setText(null);
                    txt_Senha.setText(null);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lbl_Id = new javax.swing.JLabel();
        lbl_Nome = new javax.swing.JLabel();
        lbl_Telefone = new javax.swing.JLabel();
        lbl_Login = new javax.swing.JLabel();
        lbl_Senha = new javax.swing.JLabel();
        lbl_Perfil = new javax.swing.JLabel();
        txt_Id = new javax.swing.JTextField();
        txt_Nome = new javax.swing.JTextField();
        txt_Telefone = new javax.swing.JTextField();
        txt_Login = new javax.swing.JTextField();
        txt_Senha = new javax.swing.JTextField();
        cb_Perfil = new javax.swing.JComboBox<>();
        btn_Adicionar = new javax.swing.JButton();
        btn_Deletar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Pesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuários");

        lbl_Id.setText("* Id");

        lbl_Nome.setText("* Nome");

        lbl_Telefone.setText("* Telefone");

        lbl_Login.setText("Login");

        lbl_Senha.setText("* Senha");

        lbl_Perfil.setText("Perfil");

        cb_Perfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "user" }));

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

        btn_Pesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/pesquisar.png"))); // NOI18N
        btn_Pesquisar.setToolTipText("Pesquisar");
        btn_Pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Pesquisar.setPreferredSize(new java.awt.Dimension(80, 80));
        btn_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("* Campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Nome)
                            .addComponent(lbl_Telefone)
                            .addComponent(lbl_Senha)
                            .addComponent(lbl_Id))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_Senha, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txt_Telefone))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_Login, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_Perfil, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Login)
                                    .addComponent(cb_Perfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btn_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Id)
                    .addComponent(txt_Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Nome)
                    .addComponent(txt_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Telefone)
                    .addComponent(txt_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Login)
                    .addComponent(txt_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Senha)
                    .addComponent(txt_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Perfil)
                    .addComponent(cb_Perfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        setBounds(0, 0, 641, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        // Chamando o método consultar
        Consultar();
    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        // Metodo adicionar
        Adicionar();
    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        // Chamando método alterar
        Alterar();
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarActionPerformed
        // Chamando método remover
        Remover();
    }//GEN-LAST:event_btn_DeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Deletar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Pesquisar;
    private javax.swing.JComboBox<String> cb_Perfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbl_Id;
    private javax.swing.JLabel lbl_Login;
    private javax.swing.JLabel lbl_Nome;
    private javax.swing.JLabel lbl_Perfil;
    private javax.swing.JLabel lbl_Senha;
    private javax.swing.JLabel lbl_Telefone;
    private javax.swing.JTextField txt_Id;
    private javax.swing.JTextField txt_Login;
    private javax.swing.JTextField txt_Nome;
    private javax.swing.JTextField txt_Senha;
    private javax.swing.JTextField txt_Telefone;
    // End of variables declaration//GEN-END:variables
}
