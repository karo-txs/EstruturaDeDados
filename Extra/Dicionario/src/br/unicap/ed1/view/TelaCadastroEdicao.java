package br.unicap.ed1.view;

import br.unicap.ed1.control.Dicionario;
import br.unicap.ed1.excecoes.CadastroInexistenteException;
import br.unicap.ed1.excecoes.DadosInvalidosException;
import br.unicap.ed1.excecoes.DadosRepetidosException;
import br.unicap.ed1.model.Termo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastroEdicao extends javax.swing.JDialog {

    private boolean isCad;
    private Dicionario dic;

    public TelaCadastroEdicao(java.awt.Frame parent, boolean modal, Dicionario dic) {
        super(parent, modal);
        initComponents();
        this.dic = dic;
        this.isCad = true;
        this.tTitulo.setText("Cadastro de um Termo");
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    public TelaCadastroEdicao(java.awt.Frame parent, boolean modal, Dicionario dic, Termo selecionado) {
        super(parent, modal);
        initComponents();
        this.dic = dic;
        this.isCad = false;
        this.tTitulo.setText("Edição de um Termo");
        textNome.setText(selecionado.getNome());
        textNome.setEditable(false);
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textNome = new javax.swing.JTextField();
        jScrollDescricao = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jbtConfirmar = new javax.swing.JButton();
        tTitulo = new javax.swing.JLabel();
        tNome = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textNome.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(textNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, -1));

        textDescricao.setBackground(new java.awt.Color(255, 255, 255));
        textDescricao.setColumns(20);
        textDescricao.setForeground(new java.awt.Color(0, 0, 0));
        textDescricao.setRows(5);
        jScrollDescricao.setViewportView(textDescricao);

        getContentPane().add(jScrollDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 260, -1));

        jLabel3.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html> <Center>Descrição");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 80, 30));

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/Confirma0.png"))); // NOI18N
        jbtConfirmar.setBorder(null);
        jbtConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtConfirmarMouseClicked(evt);
            }
        });
        getContentPane().add(jbtConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 40));

        tTitulo.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        tTitulo.setForeground(new java.awt.Color(188, 0, 0));
        tTitulo.setText("<html><Center> Cadastro de um termo");
        getContentPane().add(tTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 260, 60));

        tNome.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        tNome.setForeground(new java.awt.Color(255, 255, 255));
        tNome.setText("<html> <Center>Nome");
        getContentPane().add(tNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 30));

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/unicap/ed1/view/imgs/FundoPopupComumGrande.png"))); // NOI18N
        getContentPane().add(lblFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 560, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtConfirmarMouseClicked
        if (isCad) {
            try {
                dic.cadastrarTermo(textNome.getText(), textDescricao.getText());
                FrameInicio.mostrarPopUp("Termo Cadastrado!", false);
                this.dispose();
            } catch (DadosRepetidosException | DadosInvalidosException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }
        } else {
            try {
                dic.editarTermo(new Termo(textNome.getText(), textDescricao.getText()));
                FrameInicio.mostrarPopUp("Termo editado!", false);
                this.dispose();
            } catch (CadastroInexistenteException | DadosInvalidosException ex) {
                FrameInicio.mostrarPopUp(ex.getMessage(), true);
            }
        }
        FrameInicio.getFrame().setContentPane(new TelaInicioDicionario(dic));
        FrameInicio.getFrame().revalidate();
    }//GEN-LAST:event_jbtConfirmarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollDescricao;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel tNome;
    private javax.swing.JLabel tTitulo;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}
