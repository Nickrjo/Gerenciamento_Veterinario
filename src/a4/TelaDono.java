package a4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Juliene Monteiro
 */
public class TelaDono extends javax.swing.JFrame {

    private Dono dono; // Objeto da classe Dono
    private ArrayList<Dono> listaDonos; // Lista para armazenar todos os donos cadastrados
    private TelaInicial inicio;
    private ArrayList<Animal> listaAnimais;

    /**
     * Creates new form TelaDono
     *
     * @param inicio
     * @param animais
     */
    public TelaDono(TelaInicial inicio, ArrayList<Animal> animais) {
        initComponents();  // Inicializa os componentes
        this.inicio = inicio;
        this.listaAnimais = animais;
        listaDonos = new ArrayList<>(); // Inicializa a lista de donos

        // Desabilita os bot�es Excluir e Editar no in�cio
        jButtonExcluir.setEnabled(false);
        
         // Listener para CPF
        jTextFieldCPF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { 
                formatarCPF(); 
            }
            @Override
            public void removeUpdate(DocumentEvent e) { 
                formatarCPF(); 
            }
            @Override
            public void changedUpdate(DocumentEvent e) { 
                formatarCPF(); 
            }
        });
         // Listener para Nome
        jTextFieldNome.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { 
                verificarNome(); 
            }
            @Override
            public void removeUpdate(DocumentEvent e) { 
                verificarNome(); 
            }
            @Override
            public void changedUpdate(DocumentEvent e) { 
                verificarNome(); 
            }
        });
        
        //listener para telefone
        jTextFieldTel.addKeyListener(new KeyAdapter(){
           
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)){
                    e.consume(); //ignora o caracter
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
            
        });
        
    }

    // M�todo para adicionar um dono � lista
    private void adicionarDono(Dono dono) {
        listaDonos.add(dono);
    }

    // M�todo para buscar o dono pelo CPF
    private Dono buscarPorCPF(String cpf) {
        for (Dono dono : listaDonos) {
            if (dono.getCpf().equals(cpf)) {
                return dono; // Retorna o dono encontrado
            }
        }
        return null; // Se n�o encontrar, retorna null
    }

    // M�todo para limpar os campos
    private void limparCampos() {
        jTextFieldCPF.setText("");
        jTextFieldNome.setText("");
        jTextFieldTel.setText("");
        jTextFieldEnd.setText("");
        jTextFieldEmail.setText("");

        // Desabilita os bot�es Excluir e Editar ao limpar os campos
        jButtonExcluir.setEnabled(false);
        
    }

    private void irInicio() {
        inicio.setDonos(listaDonos);
        inicio.setAnimais(listaAnimais);
        inicio.setVisible(true);
        limparCampos();
        this.setVisible(false);
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldTel = new javax.swing.JTextField();
        jTextFieldEnd = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButtonLimpar = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("CPF:");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel3.setText("Telefone:");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel4.setText("Endere�o:");

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel5.setText("E-mail:");

        jTextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Serif", 1, 48)); // NOI18N
        jLabel6.setText("Cadastro Dono");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(203, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(178, 178, 178))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEnd, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(jTextFieldTel, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmail))
                                .addGap(82, 82, 82)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonBuscar)
                                    .addComponent(jButtonExcluir)
                                    .addComponent(jButtonVoltar)
                                    .addComponent(jButtonLimpar))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(63, 63, 63)
                                .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonSalvar)
                                .addGap(41, 41, 41)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonVoltar)
                        .addGap(47, 47, 47))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        String cpf = jTextFieldCPF.getText();
        String nome = jTextFieldNome.getText();
        String telefone = jTextFieldTel.getText();
        String endereco = jTextFieldEnd.getText();
        String email = jTextFieldEmail.getText();

        //verifica formata��o do email
        if (isEmailValido(email) == false) {
            JOptionPane.showMessageDialog(null, "Erro! Para continuar, por favor insira um email v�lido", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Verifica se todos os campos est�o preenchidos
        if (cpf.isEmpty() || nome.isEmpty() || telefone.isEmpty() || endereco.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos para salvar um novo dono.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Dono donoEncontrado = buscarPorCPF(cpf);
            if (donoEncontrado != null) {
                // Atualiza os dados do dono existente
                donoEncontrado.setNome(nome);
                donoEncontrado.setTelefone(telefone);
                donoEncontrado.setEndereco(endereco);
                donoEncontrado.setEmail(email);

                JOptionPane.showMessageDialog(this, "Cadastro atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Cria um novo objeto Dono e adiciona na lista
                Dono novoDono = new Dono(nome, cpf, telefone, endereco, email);
                adicionarDono(novoDono); // Adiciona o dono � lista
                JOptionPane.showMessageDialog(this, "Novo dono cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }
            limparCampos(); // Limpa os campos ap�s o salvamento
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        String cpf = jTextFieldCPF.getText();
        Dono donoEncontrado = buscarPorCPF(cpf);
            
        if (donoEncontrado != null) {

            if (listaAnimais == null){
                listaAnimais = new ArrayList<>();
            }
            //procura animais desse dono e exclui seu vinculo
            for (Animal animal : listaAnimais) {
                if (animal.getCpfD().equals(donoEncontrado.getCpf()) == true) {
                    animal.setCpfD(null);
                }
            }
            
            listaDonos.remove(donoEncontrado); // Remove o dono da lista
            limparCampos(); // Limpa os campos ap�s a exclus�o
            JOptionPane.showMessageDialog(this, "Dono exclu�do com sucesso!");
    } else {
            JOptionPane.showMessageDialog(this, "Dono n�o encontrado para exclus�o.");
    }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        irInicio();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        String cpf = jTextFieldCPF.getText();
        Dono donoEncontrado = buscarPorCPF(cpf);

        if (donoEncontrado != null) {
            // Preenche os campos com os dados do dono encontrado
            jTextFieldNome.setText(donoEncontrado.getNome());
            jTextFieldTel.setText(donoEncontrado.getTelefone());
            jTextFieldEnd.setText(donoEncontrado.getEndereco());
            jTextFieldEmail.setText(donoEncontrado.getEmail());

            // Habilita os bot�es Excluir e Editar ap�s encontrar o dono
            jButtonExcluir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Dono n�o encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);

            // Desabilita os bot�es Excluir e Editar caso n�o encontre o dono
            jButtonExcluir.setEnabled(false);

        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        limparCampos(); // Chama o m�todo que limpa os campos

    }//GEN-LAST:event_jButtonLimparActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEnd;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldTel;
    // End of variables declaration//GEN-END:variables

    public void atualizarAnimais(ArrayList<Animal> animais) {
        this.listaAnimais = animais;
    }
    
    private boolean isEmailValido(String email){
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    // M�todo para formatar o CPF enquanto o usu�rio digita
    private void formatarCPF() {
        // Remove qualquer caractere que n�o seja n�mero
        String cpf = jTextFieldCPF.getText().replaceAll("[^0-9]", "");

        // Limita a 11 d�gitos
        if (cpf.length() > 11) {
            cpf = cpf.substring(0, 11);
        }

        // Aplica a formata��o "xxx.xxx.xxx-xx"
        StringBuilder cpfFormatado = new StringBuilder();
        if (cpf.length() > 0) {
            cpfFormatado.append(cpf.substring(0, Math.min(cpf.length(), 3))); // Primeiro bloco (xxx)
        }
        if (cpf.length() > 3) {
            cpfFormatado.append(".").append(cpf.substring(3, Math.min(cpf.length(), 6))); // Segundo bloco (xxx)
        }
        if (cpf.length() > 6) {
            cpfFormatado.append(".").append(cpf.substring(6, Math.min(cpf.length(), 9))); // Terceiro bloco (xxx)
        }
        if (cpf.length() > 9) {
            cpfFormatado.append("-").append(cpf.substring(9, Math.min(cpf.length(), 11))); // Quarto bloco (xx)
        }

        // Atualiza o campo de texto com a formata��o e mant�m o cursor no final
        String cpfFinal = cpfFormatado.toString();
        // Evita atualizar o campo se o texto n�o mudou
        if (!jTextFieldCPF.getText().equals(cpfFinal)) {
        // Usar invokeLater para adiar a atualiza��o do texto
            SwingUtilities.invokeLater(() -> {
                jTextFieldCPF.setText(cpfFinal);
                jTextFieldCPF.setCaretPosition(cpfFinal.length());
            });
        }
    }
    
    private void verificarNome() {
        String texto = jTextFieldNome.getText();
        String novoTexto = texto.replaceAll("[^a-zA-Z\\s]", "");
        if (!novoTexto.equals(texto)) {
            SwingUtilities.invokeLater(() -> {
                jTextFieldNome.setText(novoTexto);
            });
        }
    }    
    
}
