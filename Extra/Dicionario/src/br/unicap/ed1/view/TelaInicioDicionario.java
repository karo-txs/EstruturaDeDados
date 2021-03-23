package br.unicap.ed1.view;

import br.unicap.TiposDeDados.LDECCrescenteSemRepetidos;
import br.unicap.ed1.control.Dicionario;
import br.unicap.ed1.control.Letra;
import br.unicap.ed1.excecoes.CadastroInexistenteException;
import br.unicap.ed1.model.Termo;

public class TelaInicioDicionario extends javax.swing.JPanel {

    private Dicionario dicionario;
    private Termo[] termosAux;
    private Letra[] letrasAux;

    public TelaInicioDicionario(Dicionario dic) {
        initComponents();
        dicionario = dic;
        this.initTermos(dicionario.exibirTodos());
        this.initLetras();
    }

    private void initTermos(LDECCrescenteSemRepetidos<Termo> termos) {
        String[] dados;
        dados = new String[termos.size()];
        termosAux = new Termo[termos.size()];

        int i, tam = termos.size();
        for (i = 0; i < tam; i++) {
            dados[i] = termos.get(i).toString();
            termosAux[i] = termos.get(i);
        }
        lstTermos.setModel(new javax.swing.DefaultComboBoxModel<>(dados));
    }

    private void initLetras() {
        String[] dados;
        LDECCrescenteSemRepetidos<Letra> letras = dicionario.todasLetras();
        dados = new String[letras.size() + 1];
        letrasAux = new Letra[letras.size() + 1];

        int i, tam = letras.size();
        for (i = 0; i < tam; i++) {
            if (i == 0) {
                dados[i] = "--";
                dados[i + 1] = letras.get(i).getLetra();
                letrasAux[i + 1] = letras.get(i);
            } else {
                dados[i + 1] = letras.get(i).getLetra();
                letrasAux[i + 1] = letras.get(i);
            }
        }
        lstLetras.setModel(new javax.swing.DefaultComboBoxModel<>(dados));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstTermos = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jbtEdicao = new javax.swing.JButton();
        jbtCadastrar = new javax.swing.JButton();
        jbtRemover = new javax.swing.JButton();
        lstLetras = new javax.swing.JComboBox<>();
        jbtFinalizar = new javax.swing.JButton();
        lblBackCine = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(460, 530));
        setMinimumSize(new java.awt.Dimension(460, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstTermos.setBackground(new java.awt.Color(21, 17, 17));
        lstTermos.setFont(new java.awt.Font("Estrangelo Edessa", 0, 18)); // NOI18N
        lstTermos.setForeground(new java.awt.Color(255, 255, 255));
        lstTermos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Arroz : Comida asiatica", "Cachorro : Animal quadrupede", "Lampada : Objeto para iluminar comodos" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstTermos.setToolTipText("");
        lstTermos.setFixedCellHeight(60);
        lstTermos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        lstTermos.setValueIsAdjusting(true);
        jScrollPane1.setViewportView(lstTermos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 390, 240));

        jLabel1.setFont(new java.awt.Font("URW Gothic L", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DICIONÁRIO INTERATIVO");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 380, 40));

        jbtEdicao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/Editar.png"))); // NOI18N
        jbtEdicao.setBorder(null);
        jbtEdicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtEdicaoMouseClicked(evt);
            }
        });
        add(jbtEdicao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 40, 40));

        jbtCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/Adiciona.png"))); // NOI18N
        jbtCadastrar.setBorder(null);
        jbtCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtCadastrarMouseClicked(evt);
            }
        });
        add(jbtCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 40, 40));

        jbtRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/Remove.png"))); // NOI18N
        jbtRemover.setBorder(null);
        jbtRemover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtRemoverMouseClicked(evt);
            }
        });
        add(jbtRemover, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 40, 40));

        lstLetras.setBackground(new java.awt.Color(204, 204, 204));
        lstLetras.setFont(new java.awt.Font("Segoe UI Symbol", 0, 18)); // NOI18N
        lstLetras.setForeground(new java.awt.Color(102, 102, 102));
        lstLetras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-  Todas  -", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));
        lstLetras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lstLetrasActionPerformed(evt);
            }
        });
        add(lstLetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 120, 30));

        jbtFinalizar.setBackground(new java.awt.Color(227, 0, 0));
        jbtFinalizar.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jbtFinalizar.setForeground(new java.awt.Color(0, 0, 0));
        jbtFinalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/BotaoComprido (1).png"))); // NOI18N
        jbtFinalizar.setText("Sair");
        jbtFinalizar.setBorder(null);
        jbtFinalizar.setContentAreaFilled(false);
        jbtFinalizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtFinalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtFinalizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtFinalizarMouseClicked(evt);
            }
        });
        add(jbtFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 250, 40));

        lblBackCine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/FundoPopupSenhaInvalida.png"))); // NOI18N
        add(lblBackCine, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCadastrarMouseClicked
        TelaCadastroEdicao telaCad = new TelaCadastroEdicao(FrameInicio.getFrame(), true, this.dicionario);
        telaCad.setLocationRelativeTo(null);
        telaCad.setVisible(true);
    }//GEN-LAST:event_jbtCadastrarMouseClicked

    private void jbtRemoverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtRemoverMouseClicked

        if (lstTermos.getSelectedIndex() != -1) {
            String[] nomeTermoSelecionado = lstTermos.getSelectedValue().split(":");
            Termo termo = new Termo(nomeTermoSelecionado[0]);
            System.out.println(termo.getNome());
            try {
                dicionario.removerTermo(termo);
                FrameInicio.mostrarPopUp("Termo Removido!", false);
                Thread.sleep(1L);
                FrameInicio.getFrame().setContentPane(new TelaInicioDicionario(dicionario));
                FrameInicio.getFrame().revalidate();
            } catch (InterruptedException ex) {
            } catch (CadastroInexistenteException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }
        }
    }//GEN-LAST:event_jbtRemoverMouseClicked

    private void jbtFinalizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtFinalizarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jbtFinalizarMouseClicked

    private void lstLetrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lstLetrasActionPerformed
        if(lstLetras.getSelectedIndex() == 0){
            initTermos(dicionario.exibirTodos());
        }else if (lstLetras.getSelectedIndex() != -1) {
            String letraSelecionada = letrasAux[lstLetras.getSelectedIndex()].getLetra();
            try {
                LDECCrescenteSemRepetidos<Termo> termosPorLetra = dicionario.exibirTodosPorLetra(letraSelecionada);
                initTermos(termosPorLetra);
            } catch (CadastroInexistenteException ex) {
               FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }
        }
    }//GEN-LAST:event_lstLetrasActionPerformed

    private void jbtEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtEdicaoMouseClicked
        if (lstTermos.getSelectedIndex() != -1) {
            String[] nomeTermoSelecionado = lstTermos.getSelectedValue().split(":");
            Termo termo = new Termo(nomeTermoSelecionado[0]);
            TelaCadastroEdicao telaCad = new TelaCadastroEdicao(FrameInicio.getFrame(), true, this.dicionario, termo);
            telaCad.setLocationRelativeTo(null);
            telaCad.setVisible(true);
        }
    }//GEN-LAST:event_jbtEdicaoMouseClicked

    public void setDicionario(Dicionario dicionario) {
        this.dicionario = dicionario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtEdicao;
    private javax.swing.JButton jbtFinalizar;
    private javax.swing.JButton jbtRemover;
    private javax.swing.JLabel lblBackCine;
    private javax.swing.JComboBox<String> lstLetras;
    private javax.swing.JList<String> lstTermos;
    // End of variables declaration//GEN-END:variables
}
