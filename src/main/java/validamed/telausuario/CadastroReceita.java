package validamed.telausuario;

import validamed.*;
import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import validamed.metodo.MetodosReceita;

public class CadastroReceita extends JDialog {

    private final Paciente paciente;
    private JFormattedTextField txtData;
    private JTextField txtCrm, txtMedicamento;
    private JCheckBox chkCarimbo;
    private JSpinner spnComprimidos, spnDias;
    private DefaultTableModel modeloMeds;
    private JTable tblMeds;

    public CadastroReceita(Frame parent, Paciente paciente) {
        super(parent, "Cadastrar Receita", true);
        this.paciente = paciente;
        montarTela();
        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void montarTela() {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');
            txtData = new JFormattedTextField(mask);
        } catch (ParseException e) {
            txtData = new JFormattedTextField();
        }
        txtCrm = new JTextField(15);
        chkCarimbo = new JCheckBox("Receita carimbada");

        // --- dados da receita ---
        JPanel dados = new JPanel(new GridBagLayout());
        dados.setBorder(BorderFactory.createTitledBorder("Dados da receita"));
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.WEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        adicionar(dados, c, 0, "Data de emissão (dd/mm/aaaa):", txtData);
        adicionar(dados, c, 1, "CRM do médico (só números):", txtCrm);
        adicionar(dados, c, 2, "Carimbo:", chkCarimbo);

        // --- medicamentos ---
        txtMedicamento = new JTextField(15);
        spnComprimidos = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        spnDias = new JSpinner(new SpinnerNumberModel(1, 1, 365, 1));
        JButton btnAdd = new JButton("Adicionar medicamento");
        btnAdd.addActionListener(e -> adicionarMedicamento());

        JPanel entrada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        entrada.add(new JLabel("Nome:"));
        entrada.add(txtMedicamento);
        entrada.add(new JLabel("Comprimidos/dia:"));
        entrada.add(spnComprimidos);
        entrada.add(new JLabel("Dias:"));
        entrada.add(spnDias);
        entrada.add(btnAdd);

        modeloMeds = new DefaultTableModel(new String[]{"Medicamento", "Comprimidos/dia", "Dias"}, 0) {
            @Override
            public boolean isCellEditable(int l, int col) {
                return false;
            }
        };
        tblMeds = new JTable(modeloMeds);
        JScrollPane scroll = new JScrollPane(tblMeds);
        scroll.setPreferredSize(new Dimension(520, 120));

        JButton btnRemover = new JButton("Remover selecionado");
        btnRemover.addActionListener(e -> removerMedicamento());
        JPanel remover = new JPanel(new FlowLayout(FlowLayout.LEFT));
        remover.add(btnRemover);

        JPanel meds = new JPanel(new BorderLayout());
        meds.setBorder(BorderFactory.createTitledBorder("Medicamentos da receita"));
        meds.add(entrada, BorderLayout.NORTH);
        meds.add(scroll, BorderLayout.CENTER);
        meds.add(remover, BorderLayout.SOUTH);

        JPanel centro = new JPanel(new BorderLayout(0, 10));
        centro.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        centro.add(dados, BorderLayout.NORTH);
        centro.add(meds, BorderLayout.CENTER);

        // --- botões ---
        JButton btnSalvar = new JButton("Salvar receita");
        JButton btnCancelar = new JButton("Cancelar");
        btnSalvar.addActionListener(e -> salvar());
        btnCancelar.addActionListener(e -> dispose());
        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        botoes.add(btnCancelar);
        botoes.add(btnSalvar);

        setLayout(new BorderLayout());
        add(centro, BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);
    }

    private void adicionar(JPanel p, GridBagConstraints c, int linha, String rotulo, JComponent campo) {
        c.gridy = linha;
        c.gridx = 0; c.weightx = 0;
        p.add(new JLabel(rotulo), c);
        c.gridx = 1; c.weightx = 1;
        p.add(campo, c);
    }

    private void adicionarMedicamento() {
        String nome = txtMedicamento.getText().trim();
        if (nome.isEmpty()) {
            aviso("Informe o nome do medicamento.");
            return;
        }
        modeloMeds.addRow(new Object[]{nome, spnComprimidos.getValue(), spnDias.getValue()});
        txtMedicamento.setText("");
        spnComprimidos.setValue(1);
        spnDias.setValue(1);
        txtMedicamento.requestFocus();
    }

    private void removerMedicamento() {
        int linha = tblMeds.getSelectedRow();
        if (linha >= 0) {
            modeloMeds.removeRow(linha);
        } else {
            aviso("Selecione um medicamento na tabela para remover.");
        }
    }

    private void salvar() {
        // se digitou um medicamento e esqueceu de clicar em "Adicionar", adiciona agora
        if (!txtMedicamento.getText().trim().isEmpty()) {
            adicionarMedicamento();
        }
        if (modeloMeds.getRowCount() == 0) {
            aviso("Adicione pelo menos um medicamento.");
            return;
        }

        int crm;
        try {
            crm = Integer.parseInt(txtCrm.getText().trim());
        } catch (NumberFormatException ex) {
            aviso("CRM inválido: digite apenas números.");
            return;
        }

        LocalDate dataEmissao;
        try {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                    .withResolverStyle(ResolverStyle.STRICT);
            dataEmissao = LocalDate.parse(txtData.getText(), fmt);
        } catch (DateTimeParseException ex) {
            aviso("Data de emissão inválida.");
            return;
        }

        Receita receita = new Receita();
        receita.setDataEmissao(dataEmissao);
        receita.setCRMDoMedico(crm);
        receita.setCarimbo(chkCarimbo.isSelected());

        Medicamento[] medicamentos = new Medicamento[modeloMeds.getRowCount()];
        for (int i = 0; i < medicamentos.length; i++) {
            Medicamento m = new Medicamento();
            m.setNome((String) modeloMeds.getValueAt(i, 0));
            m.setComprimidos((Integer) modeloMeds.getValueAt(i, 1));
            m.setDias((Integer) modeloMeds.getValueAt(i, 2));
            medicamentos[i] = m;
        }

        boolean ok = new MetodosReceita().cadastrarReceita(paciente, receita, medicamentos);
        if (ok) {
            JOptionPane.showMessageDialog(this, "Receita cadastrada com sucesso!");
            dispose();
        }
    }

    private void aviso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Atenção", JOptionPane.WARNING_MESSAGE);
    }
}