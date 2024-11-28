package a4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Juliana
 */
public class TelaAnimal extends javax.swing.JFrame {

    /**
     * Creates new form TelaAnimal
     *
     * @param inicio
     * @param donos
     */
    public TelaAnimal(TelaInicial inicio, ArrayList<Dono> donos) {
        initComponents();
        this.inicio = inicio;
        this.donos = donos;

        jListAnimaisSemDono.setVisible(false);
        Excluirbtn.setEnabled(false);

        //listener da busca
        jFormattedTextFieldCPF.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && jFormattedTextFieldCPF.getText().trim().isEmpty() == false) {
                    buscar_Animal();
                    mostrar_Animal();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        //formata��o da data de nascimento
        try {
            MaskFormatter formatoDob = new MaskFormatter("##/##/####");
            formatoDob.setPlaceholderCharacter('_');

            //linkando esse formato com o text field
            jFormattedTextFieldDob.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatoDob));
        } catch (java.text.ParseException e) {
            e.getErrorOffset();
        }

        //formata��o do cpf
        try {
            MaskFormatter formatoCPF = new MaskFormatter("###.###.###-##");
            formatoCPF.setPlaceholderCharacter('_');

            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatoCPF));

        } catch (java.text.ParseException e) {
            e.getErrorOffset();
        }

        //listener formata��o do nome
        Nometxf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume(); // Ignora os numeros
                }
            }
        });

        Runnable manejarBotaoExlcuir = () -> {
            boolean isCheckBoxSelecionada = jCheckBoxSemDono.isSelected();
            boolean isComboboxSelecionada = ComboBox.getSelectedItem() != null && !ComboBox.getSelectedItem().toString().isEmpty();
            Excluirbtn.setEnabled(isCheckBoxSelecionada || isComboboxSelecionada);
        };

        ComboBox.addActionListener(e -> manejarBotaoExlcuir.run());
        jCheckBoxSemDono.addActionListener(e -> manejarBotaoExlcuir.run());

    }

    public void atualizarDados(ArrayList<Dono> novosDonos, ArrayList<Animal> novosAnimais) {
        this.donos = novosDonos;
        this.animais = novosAnimais;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Animaljtbn = new javax.swing.JLabel();
        CPFjtbn = new javax.swing.JLabel();
        Nomejtbn = new javax.swing.JLabel();
        Racajtbn = new javax.swing.JLabel();
        Dobjtbn = new javax.swing.JLabel();
        Nometxf = new javax.swing.JTextField();
        Racatxf = new javax.swing.JTextField();
        Salvarbtn = new javax.swing.JButton();
        Excluirbtn = new javax.swing.JButton();
        Voltarbtn = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Limparbtn = new javax.swing.JButton();
        jFormattedTextFieldDob = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jCheckBoxSemDono = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAnimaisSemDono = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Animaljtbn.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        Animaljtbn.setText("Cadastro Animal");
        Animaljtbn.setMinimumSize(new java.awt.Dimension(40, 20));

        CPFjtbn.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        CPFjtbn.setText("CPF do Respons�vel:");

        Nomejtbn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Nomejtbn.setText("Nome:");

        Racajtbn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Racajtbn.setText("Ra�a:");

        Dobjtbn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Dobjtbn.setText("Data de Nascimento:");

        Nometxf.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        Racatxf.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        Salvarbtn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Salvarbtn.setText("Salvar");
        Salvarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarbtnActionPerformed(evt);
            }
        });

        Excluirbtn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Excluirbtn.setText("Excluir");
        Excluirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirbtnActionPerformed(evt);
            }
        });

        Voltarbtn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Voltarbtn.setText("Voltar");
        Voltarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltarbtnActionPerformed(evt);
            }
        });

        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel1.setText("Lista de animais do Dono:");

        Limparbtn.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        Limparbtn.setText("Limpar");
        Limparbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparbtnActionPerformed(evt);
            }
        });

        jFormattedTextFieldDob.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jFormattedTextFieldCPF.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jCheckBoxSemDono.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jCheckBoxSemDono.setText("Listar animais sem dono vinculado");
        jCheckBoxSemDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxSemDonoActionPerformed(evt);
            }
        });

        jScrollPane1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jListAnimaisSemDono.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListAnimaisSemDono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jListAnimaisSemDono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAnimaisSemDonoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAnimaisSemDono);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jCheckBoxSemDono)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Racajtbn)
                            .addComponent(Nomejtbn)
                            .addComponent(Dobjtbn)
                            .addComponent(jLabel1)
                            .addComponent(CPFjtbn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nometxf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Racatxf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Salvarbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Excluirbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Limparbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Voltarbtn)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addComponent(Animaljtbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(Animaljtbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CPFjtbn)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(42, 42, 42)
                        .addComponent(Nomejtbn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Racajtbn, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(Dobjtbn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Nometxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Racatxf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxSemDono)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Salvarbtn)
                    .addComponent(Excluirbtn)
                    .addComponent(Limparbtn)
                    .addComponent(Voltarbtn))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalvarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarbtnActionPerformed
        if (camposPreenchidos() == true && isDobValida() == true) {
            salvar_Animal();
        } else if (camposPreenchidos() == false && isDobValida() == true) {
            JOptionPane.showMessageDialog(null,
                      "Para continuar, por favor preencha todos os campos adequadamente.",
                      "Erro...", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                      "Data inv�lida!\n\nPor favor, insira uma data v�lida",
                      "Erro", JOptionPane.ERROR_MESSAGE);

            jFormattedTextFieldDob.requestFocus();
        }


    }//GEN-LAST:event_SalvarbtnActionPerformed

    private void ExcluirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirbtnActionPerformed
        excluir_Animal();
        limpar_Animal();
    }//GEN-LAST:event_ExcluirbtnActionPerformed

    private void VoltarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarbtnActionPerformed
        // TODO add your handling code here:
        irInicio();
    }//GEN-LAST:event_VoltarbtnActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
        // TODO add your handling code here:
        mostrar_Animal();
    }//GEN-LAST:event_ComboBoxActionPerformed

    private void LimparbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparbtnActionPerformed
        // TODO add your handling code here:
        limpar_Animal();
    }//GEN-LAST:event_LimparbtnActionPerformed

    private void jCheckBoxSemDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxSemDonoActionPerformed
        // TODO add your handling code here:
        limpar_Animal();
        listar_sem_dono();
    }//GEN-LAST:event_jCheckBoxSemDonoActionPerformed

    private void jListAnimaisSemDonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAnimaisSemDonoMouseClicked
        // TODO add your handling code here:
        dados_sem_dono();
    }//GEN-LAST:event_jListAnimaisSemDonoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    public ArrayList<Animal> animais;
    public ArrayList<Dono> donos;
    public Iterator it;
    private TelaInicial inicio;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Animaljtbn;
    private javax.swing.JLabel CPFjtbn;
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JLabel Dobjtbn;
    private javax.swing.JButton Excluirbtn;
    private javax.swing.JButton Limparbtn;
    private javax.swing.JLabel Nomejtbn;
    private javax.swing.JTextField Nometxf;
    private javax.swing.JLabel Racajtbn;
    private javax.swing.JTextField Racatxf;
    private javax.swing.JButton Salvarbtn;
    private javax.swing.JButton Voltarbtn;
    private javax.swing.JCheckBox jCheckBoxSemDono;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldDob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jListAnimaisSemDono;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private void limpar_Animal() {
        Nometxf.setText("");
        Racatxf.setText("");
        jFormattedTextFieldDob.setText("");
        jFormattedTextFieldCPF.setText("");
        ComboBox.removeAllItems();
    }

    private void salvar_Animal() {

        String cpfDigitado = jFormattedTextFieldCPF.getText();
        String nomeAnimalDigitado = Nometxf.getText();
        boolean animalAtualizado = false;

        if (animais == null) {
            animais = new ArrayList<>();
        }
        
        for (Dono dono : donos){
            if (!cpfDigitado.equals("___.___.___-__")&& !dono.getCpf().equals(cpfDigitado)) {
                JOptionPane.showMessageDialog(null, "Para continuar cadastre esse CPF","CPF n�o cadastrado", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        //atualiza o ponteiro pro incio da lista
        it = animais.iterator();

        while (it.hasNext()) {
            Animal animalExistente = (Animal) it.next();

            //Caso 1 - editando animal com dono j� vinculado
            if (cpfDigitado.equals(animalExistente.getCpfD()) && animalExistente.getNome().equals(nomeAnimalDigitado)) {

                animalExistente.setNome(Nometxf.getText());
                animalExistente.setRaca(Racatxf.getText());
                animalExistente.setDataNasc(jFormattedTextFieldDob.getText());
                animalExistente.setCpfD(jFormattedTextFieldCPF.getText());

                animalAtualizado = true;
                break;
            }

            //Caso 2 - vinculando novo dono com animal
            if (animalExistente.getCpfD() == null && animalExistente.getNome().equals(nomeAnimalDigitado)) {

                animalExistente.setCpfD(jFormattedTextFieldCPF.getText());
                animalExistente.setNome(Nometxf.getText());
                animalExistente.setRaca(Racatxf.getText());
                animalExistente.setDataNasc(jFormattedTextFieldDob.getText());
                animalExistente.setCpfD(jFormattedTextFieldCPF.getText());

                animalAtualizado = true;
                break;
            }
        }

        //Caso 3 - vinculando dono com novo animal
        if (animalAtualizado == false) {
            Animal animal = new Animal();
            
            if (cpfDigitado.equals("___.___.___-__")){
                animal.setCpfD(null);
            } else {
                animal.setCpfD(cpfDigitado);
            }
            
            animal.setNome(nomeAnimalDigitado);
            animal.setRaca(Racatxf.getText());
            animal.setDataNasc(jFormattedTextFieldDob.getText());

            animais.add(animal);
        }

        
        it = animais.iterator();
        limpar_Animal();

    }

    private void excluir_Animal() {

        Animal animalSelecionado = null;
        
        if (ComboBox.getSelectedItem() == null && jListAnimaisSemDono.isSelectionEmpty()) return;

        if (JOptionPane.showConfirmDialog(null, "Realmente deseja deletar este animal?", "Apagar Animal", JOptionPane.YES_NO_OPTION) == 0) {

            for (Animal animal : animais) {
            
                if (ComboBox.getSelectedItem() != null && ComboBox.getSelectedItem().toString().equals(animal.getNome()) && jFormattedTextFieldCPF.getText().equals(animal.getCpfD())) {
                    animalSelecionado = animal;
                    break;
                }

                if (!jListAnimaisSemDono.isSelectionEmpty() && jListAnimaisSemDono.getSelectedValue().equals(animal.getNome())) {
                    animalSelecionado = animal;
                    break;
                }
            }
            
            animais.remove(animalSelecionado);

            //atualizar display na lista
            listar_sem_dono();

        }
    }

    private void irInicio() {
        inicio.setAnimais(animais);
        inicio.setVisible(true);
        this.setVisible(false);
        limpar_Animal();
        jCheckBoxSemDono.setSelected(false);
        jListAnimaisSemDono.setVisible(false);
    }

    private void buscar_Animal() {

        ComboBox.removeAllItems();

        if (animais == null) {
            return;
        }

        for (Animal animal : animais) {
            if (animal.getCpfD() == null) {
                break;
            }

            if (animal.getCpfD().equals(jFormattedTextFieldCPF.getText())) {
                ComboBox.addItem(animal.getNome());
            }
        }

    }

    private void mostrar_Animal() {

        if (ComboBox.getSelectedItem() == null || ComboBox.getSelectedItem().toString().trim().isEmpty()) {
            return;
        }

        String animalSelecionado = ComboBox.getSelectedItem().toString();
        boolean encontrado = false;

        for (Animal animal : animais) {
            if (animalSelecionado.equals(animal.getNome())) {
                Nometxf.setText(animal.getNome());
                Racatxf.setText(animal.getRaca());
                jFormattedTextFieldDob.setText(animal.getDataNasc());
                encontrado = true;
                break;
            }
        }

        if (encontrado == false) {
            JOptionPane.showMessageDialog(null, "Animal n�o encontrado na lista", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private boolean camposPreenchidos() {

        if (Nometxf.getText().equals("") || Racatxf.getText().equals("") || jFormattedTextFieldDob.getText().equals("")) {
            return false;
        } else {
            return true;
        }

    }

    private boolean isDobValida() {
        String textoDob = jFormattedTextFieldDob.getText();

        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            formato.setLenient(false);

            Date dataInserida = formato.parse(textoDob);
            Date dataAtual = new Date();

            if (dataAtual.after(dataInserida)) {
                return true;
            }
        } catch (ParseException e) {
            e.getErrorOffset();
        }

        return false;
    }

    //lista os animais sem dono no jlist
    private void listar_sem_dono() {

        //controla a disponibilidade da lista
        jListAnimaisSemDono.setVisible(jCheckBoxSemDono.isSelected());

        DefaultListModel<String> ModeloLista = new DefaultListModel<>();
        jListAnimaisSemDono.setModel(ModeloLista);

        if (animais == null) {
            return;
        }

        for (Animal animal : animais) {
            if (animal.getCpfD() == null) {
                ModeloLista.addElement(animal.getNome());
            }
        }

    }

    //mostra os dados do animal selecionado no jlist
    private void dados_sem_dono() {
        if (animais == null) {
            return;
        }

        for (Animal animal : animais) {
            if (animal.getNome().equals(jListAnimaisSemDono.getSelectedValue())) {
                jFormattedTextFieldCPF.setText(animal.getCpfD());
                jFormattedTextFieldDob.setText(animal.getDataNasc());
                Nometxf.setText(animal.getNome());
                Racatxf.setText(animal.getRaca());
            }
        }

    }

}
