/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JInternalFrame.sub_InternalFrame;

/**
 *
 * @author User
 */
public class ComoUsarTelaDeEdicaoDeBoletimMedia extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComoUsarTelaDeEdicaoDeBoletimMedia
     */
    public ComoUsarTelaDeEdicaoDeBoletimMedia() {
        initComponents();
        texto.setEditable(false);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("COMO USAR A TELA DE EDIÇÃO DE DADOS DO BOLETIM E MÉDIA");

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        texto.setRows(5);
        texto.setText("\n\n\t\t\t\t\t\tVAMOS À UM PEQUENO TUTORIAL - SEREI RÁPIDO E BREVE\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\t\tA tela de Edição de dados de boletim e média é acessada através do Menu: \"EDITAR DADOS DE ALUNOS\" -> \"Editar Dados de Boletim e Média\". Nesse local, o professor precisará de um pouco de atenção.\n\t\t\n\t\tExistem duas tabelas: a tabela de boletim que foram cadastrados pelo professor(a) e a tabela de resultados, que é onde vai ser armazenado o resultado final de médias de uma ano letivo. Além de dois botões: \">\" e \"<\".\n\t\t\t\n\t\tO botão \">\" irá adicionar um registro de aluno na tabela resultado e consequentemente irá ser armazenado no banco de dados. A média calculada na tela principal do professor é a média de um bimestre qualquer (ou seja, vai ser calculada nessa tela), ao clicar em um registro na tabela de boletim de um aluno qualquer e clicar no botão \">\" irá adicionar a matrícula, o nome, a série e a média do primeiro bimestre do aluno selecionado.\n\n\t\t-VOU EXPLICAR AGORA, COMO FUNCIONA O CÁLCULO PARA A MÉDIA FINAL DO ANO LETIVO\n\t\n\t\tAo clicar no registro de boletim do aluno e clicar uma vez no botão \">\" vai adicionar os campos já citado e a média que estiver no registro selecionado do aluno na tabela boletim vai ser adicionado à média do primeiro bimestre. Se o botão \">\" for clicado e a seleção ainda estiver no aluno específico e caso a média do primeiro bimestre já for inserido, a próxima média a ser inserida é a do segundo bimestre e assim por diante no terceiro bimestre e no quarto bimestre.\n\n\t\tQuando o quarto bimestre tiver uma nota, o sistema vai identificar que todas as médias dos 4 bimestres já foram inseridas e vai calcular a média final do ano letivo junto com o resultado (\"APROVADO(A)\" - Se a média for maior que 6, \"RECUPERAÇÃO\" - Se a média for menor que 6 e maior que 4,\"REPROVADO(A)\", se a média for menor que 4)\n\n\t\tOBS: Isso acontecerá caso a matrículado aluno na tabela boletim coincidir com a matrícula do aluno na tabela resultado, ou seja, precisa ser o mesmo aluno(a), caso for diferente, o sistema vai adicionar um novo registro para calcular a média final do ano letivo.\n\n\t\tAgora temos o botão \"<\", ele serve para fazer exatamente o contrário do botão \">\", quando selecionado um registro na tabela resultado, ele vai remover aos poucos os dados do registro selecionado, até apagar o registro da tabela por completo.\n\n\t\tUfa, espero que tenha entendido. Um pouquinho complicado, mas é só ir mexendo que dá certo :)");
        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
