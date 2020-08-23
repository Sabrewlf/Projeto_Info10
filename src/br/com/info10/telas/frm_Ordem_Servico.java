/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.info10.telas;

import java.sql.*;
import br.com.info10.dal.Modulo_Conexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author marco
 */
public class frm_Ordem_Servico extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    //linha abaixo cria uma variavel que armazena um texto de acordo com radiobutton selecionado
    private String tipo;

    /**
     * Creates new form frm_Ordem_Servico
     */
    public frm_Ordem_Servico() {
        initComponents();
        conexao = Modulo_Conexao.conector();
    }

    private void pesquisar_Cliente() {
        //Comando abaixo mascara os nomes do banco de dados ex: id_cliente aparece como: Id
        String sql = "select id_cliente as Id, nome_cliente as Nome, telefone_cli as Telefone from clientes where nome_cliente like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txt_Pesquisar_Cliente.getText() + "%");
            rs = pst.executeQuery();
            tabela_Clientes.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
        }

    }

    // Vincula o nome do cliente ao seu id quando selecionado na tabela clientes
    private void setar_Campos() {

        int setar = tabela_Clientes.getSelectedRow();
        txt_Id_Cliente.setText(tabela_Clientes.getModel().getValueAt(setar, 0).toString());

    }

    //Método para emissão de ordem de serviço
    private void emitir_Os() {

        if ((txt_Id_Cliente.getText().isEmpty() || txt_Os_Equipamento.getText().isEmpty() || txt_Defeito.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios.");
        } else {

            String sql = "insert into ordem_servico(tipo, situacao, equipamento,defeito, servico, tecnico, valor, id_cliente) values(?, ?, ?, ?, ? ,?, ?, ?)";

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, tipo);
                pst.setString(2, cB_Situacao.getSelectedItem().toString());
                pst.setString(3, txt_Os_Equipamento.getText());
                pst.setString(4, txt_Defeito.getText());
                pst.setString(5, txt_Servico.getText());
                pst.setString(6, txt_Tecnico.getText());
                
                //.replace subistitui a virgula pelo ponto na textbox
                pst.setString(7, txt_Valor_Total.getText().replace(",", "."));
                pst.setString(8, txt_Id_Cliente.getText());
                
                int adicionado = pst.executeUpdate();
                
                if(adicionado > 0){
                    
                    JOptionPane.showMessageDialog(null, "Ordem de serviço emitida com sucesso!");
                    
                    txt_Os_Equipamento.setText(null);
                    txt_Defeito.setText(null);
                    txt_Servico.setText(null);
                    txt_Tecnico.setText(null);
                    txt_Valor_Total.setText(null);
                    txt_Id_Cliente.setText(null);
                }

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    //Método para pesquisar ordem de serviço 
    
    private void pesquisar_Os(){
        
        //o código abaixo cria uma caixa de entrada do tipo JOptionPane
       
        
        String num_os = JOptionPane.showInputDialog("Número da ordem de serviço");
        
        String sql = "select * from ordem_servico where os = " + num_os;
        
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            if(rs.next()){
                
                txt_N_Os.setText(rs.getString(1));
                txt_Data_Os.setText(rs.getString(2));
                
                //setando os radiobuttons
                String rb_tipo = rs.getString(3);
                if(rb_tipo.equals("Ordem de serviço")){
                    
                    rB_Ordem_Servico.setSelected(true);
                    tipo = "Ordem de serviço";
                }else{
                    
                    rB_Orcamento.setSelected(true);
                    tipo = "Orçamento";
                }
                
            }else{
                
                JOptionPane.showMessageDialog(null, "Ordem de serviço não cadastrada.");
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);   
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lbl_N_Os = new javax.swing.JLabel();
        lbl_Data = new javax.swing.JLabel();
        txt_Data_Os = new javax.swing.JTextField();
        txt_N_Os = new javax.swing.JTextField();
        rB_Orcamento = new javax.swing.JRadioButton();
        rB_Ordem_Servico = new javax.swing.JRadioButton();
        lbl_Situacao = new javax.swing.JLabel();
        cB_Situacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txt_Pesquisar_Cliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbl_Id_Cliente = new javax.swing.JLabel();
        txt_Id_Cliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_Clientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Os_Equipamento = new javax.swing.JTextField();
        txt_Defeito = new javax.swing.JTextField();
        txt_Servico = new javax.swing.JTextField();
        txt_Tecnico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Valor_Total = new javax.swing.JTextField();
        btn_Adicionar = new javax.swing.JButton();
        btn_Deletar = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Pesquisar = new javax.swing.JButton();
        btn_Imprimir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(640, 480));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_N_Os.setText("Nº Os");

        lbl_Data.setText("Data");

        txt_Data_Os.setEditable(false);

        txt_N_Os.setEditable(false);

        buttonGroup1.add(rB_Orcamento);
        rB_Orcamento.setText("Orçamento");
        rB_Orcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rB_OrcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rB_Ordem_Servico);
        rB_Ordem_Servico.setText("Ordem de serviço");
        rB_Ordem_Servico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rB_Ordem_ServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_N_Os)
                                .addGap(19, 19, 19)
                                .addComponent(lbl_Data))
                            .addComponent(rB_Orcamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(rB_Ordem_Servico))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_N_Os, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_Data_Os)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_N_Os)
                    .addComponent(lbl_Data))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Data_Os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_N_Os, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rB_Orcamento)
                    .addComponent(rB_Ordem_Servico))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lbl_Situacao.setText("Situação");

        cB_Situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Na Bancada(Em reparo)", "Entraga OK", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado pelo cliente", "Retornou", " " }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txt_Pesquisar_Cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_Pesquisar_ClienteKeyReleased(evt);
            }
        });

        jLabel1.setText("Pesquisar");

        lbl_Id_Cliente.setText("* ID");

        tabela_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id_cliente", "nome_cliente", "telefone_cli"
            }
        ));
        tabela_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_Clientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_Pesquisar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_Id_Cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Pesquisar_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_Id_Cliente)
                    .addComponent(txt_Id_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setText("* Equipamento");

        jLabel3.setText("* Defeito");

        jLabel4.setText("Serviço");

        jLabel5.setText("Técnico");

        jLabel6.setText("Valor Total");

        txt_Valor_Total.setText("0");

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

        btn_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/info10/icones/Imprimir.png"))); // NOI18N
        btn_Imprimir.setToolTipText("Imprimir Ordem de serviço");
        btn_Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Imprimir.setPreferredSize(new java.awt.Dimension(80, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbl_Situacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(txt_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_Valor_Total))
                                .addComponent(txt_Defeito)
                                .addComponent(txt_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_Os_Equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_Situacao)
                            .addComponent(cB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_Os_Equipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_Defeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_Valor_Total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Deletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AdicionarActionPerformed
        // Metodo Emitir ordem de serviço
        emitir_Os();

    }//GEN-LAST:event_btn_AdicionarActionPerformed

    private void btn_DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeletarActionPerformed
        // Chamando método remover

    }//GEN-LAST:event_btn_DeletarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        // Chamando método alterar

    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PesquisarActionPerformed
        // Chamando o método pesquisar ordem de serviço
        pesquisar_Os();

    }//GEN-LAST:event_btn_PesquisarActionPerformed

    private void txt_Pesquisar_ClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Pesquisar_ClienteKeyReleased
        // faz a pesquisa de clientes de acordo com o nome digitado
        //chamando o método pesquisar clientes
        pesquisar_Cliente();

    }//GEN-LAST:event_txt_Pesquisar_ClienteKeyReleased

    private void tabela_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_ClientesMouseClicked
        // Chamando o método setar campos

        setar_Campos();
    }//GEN-LAST:event_tabela_ClientesMouseClicked

    private void rB_OrcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rB_OrcamentoActionPerformed
        // Atribuindo um texto se a variavel tipo for selecionada
        tipo = "Orçamento";
    }//GEN-LAST:event_rB_OrcamentoActionPerformed

    private void rB_Ordem_ServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rB_Ordem_ServicoActionPerformed
        // Atribuindo um texto se a variavel tipo for selecionada
        tipo = "Ordem de Servico";
    }//GEN-LAST:event_rB_Ordem_ServicoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // marca o radiobutton quando carrega o form
        rB_Orcamento.setSelected(true);
        tipo = "Orçamento";
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Adicionar;
    private javax.swing.JButton btn_Deletar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Imprimir;
    private javax.swing.JButton btn_Pesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cB_Situacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Data;
    private javax.swing.JLabel lbl_Id_Cliente;
    private javax.swing.JLabel lbl_N_Os;
    private javax.swing.JLabel lbl_Situacao;
    private javax.swing.JRadioButton rB_Orcamento;
    private javax.swing.JRadioButton rB_Ordem_Servico;
    private javax.swing.JTable tabela_Clientes;
    private javax.swing.JTextField txt_Data_Os;
    private javax.swing.JTextField txt_Defeito;
    private javax.swing.JTextField txt_Id_Cliente;
    private javax.swing.JTextField txt_N_Os;
    private javax.swing.JTextField txt_Os_Equipamento;
    private javax.swing.JTextField txt_Pesquisar_Cliente;
    private javax.swing.JTextField txt_Servico;
    private javax.swing.JTextField txt_Tecnico;
    private javax.swing.JTextField txt_Valor_Total;
    // End of variables declaration//GEN-END:variables
}
