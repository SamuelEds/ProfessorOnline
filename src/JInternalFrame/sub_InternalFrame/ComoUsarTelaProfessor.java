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
public class ComoUsarTelaProfessor extends javax.swing.JInternalFrame {

    /**
     * Creates new form DireitosUso
     */
    public ComoUsarTelaProfessor() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();

        setClosable(true);
        setTitle("COMO USAR A TELA PRINCIPAL DO PROFESSOR");

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        texto.setRows(5);
        texto.setText("\n\t\tVAMOS À UM PEQUENO TUTORIAL - SEREI BREVE E PRECISO\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\n\tA tela principal do professor é aquela que é acessada após o login e sua funcionalidade é calcular uma média para um bimestre qualquer \npara um aluno específico. Nesse local é divido por dois espaços: a seção dos dados do aluno e a seção dos dados do boletim.\n\n\t-SEÇÃO DOS DADOS DO ALUNO\n\t\n\tNesse local é onde é preciso informar ao sistema o específico aluno(a) para calcular sua média. Existem 3 campos: Nome, Série e Disciplina. \nAlém de uma tabela que contém todos os alunos que foram cadastradospelo administrador. Para obter os dados (Nome, série) é preciso, somente, dá um clique com o botão esquerdo do mouse em cima do aluno(a) desejado(a). \n\t\n\tOBS: Caso o aluno(a) desejado(a) não for visto na tabela é preciso uma busca. Para isso é só selecionar o botão de \"pesquisar\" e \ndigitar a matrícula do aluno(a) (não precisa a matrícula inteira, basta digitar um número que contém na matrícula do aluno(a) desejado(a)).\n\t\n\tQuando o aluno(a) for encontrado(a), basta somente dar um clique com botão esquerdo do mouse em cima do \naluno(a) desejado(a). Ao clicar, vai aparecer seus respectivos dados em seus campos (Nome e Série), porém na disciplina é preciso informar ao sistema a matéria em que se está calculando a média.\n\t\n\tAo preencher todos os dados da seção do aluno, agora é só passar para a seção dos dados do boletim.\n\n\n\t-SEÇÃO DOS DADOS DE BOLETIM\n\n\tNesse local tem-se 4 campos: 2 campos de gabarito e 2 campos de provas. O sistema utiliza um método de \"comparação de resultados\" para obter-se a \nnota e a média.\n\n\tA comparação é feita do seguinte modo: Escores Parcial - Prova Parcial, esses campos utilizam o cáculo por \"Ëscore\", ou seja, \npor pontuações alcançáveis, onde no \"Escore Parcial\" é onde o professor deve colocar o total de escores que a prova vale (no formato numérico inteiro) e \nem \"Prova Parcial\" é onde o professor irá inserir os escores que o aluno(a) acertou (em formato número inteiro).\n\t\n\tOBS 1: Para cada questão é obrigatório separar por vírgula, por exemplo: Se a prova do aluno tem 2 questões cada uma valendo 5 escores coloca-se 5,5 - Sem espaço e sendo número inteiro.\n\n\tOBS 2: A separação de questões por vírgula, na prova parcial, é aplicada somente à prova do aluno (no campo Prova Parcial).\n\n\tNos campos: gabariro oficial e prova bimestral é utilizado o método de comparação por gabarito. Nesse caso, a separação das questões por vírgula é aplicável aos dois campos - sem espaço. \nO campo gabarito oficial é onde o professor insere o gabarito oficial da prova bimestral e no campo prova bimestral é onde o professor insere o gabarito que o aluno marcou na prova - Não esqueça: separar as questões por vígula.\n\n\t_____________________________________________________________________________________________________________________________________________\n\n\n\n\tQuando terminar de preencher todos os campos é só clicar em \"cadastrar gabarito\", vai aparecer uma \"telinha\" pedindo para inserir \nquanto vale cada questão da prova bimestral - nesse caso você já deve saber o que fazer né? Depois é só ir apertando ok e mais ok e ver a mágica acontecendo. O sistema irá calcular automaticamente uma média para um bimestre qualquer.");
        jScrollPane1.setViewportView(texto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea texto;
    // End of variables declaration//GEN-END:variables
}
