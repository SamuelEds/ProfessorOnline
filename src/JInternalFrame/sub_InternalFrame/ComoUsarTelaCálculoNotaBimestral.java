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
public class ComoUsarTelaCálculoNotaBimestral extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComoUsarTelaCálculoNotaBimestral
     */
    public ComoUsarTelaCálculoNotaBimestral() {
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
        setTitle("COMO USAR A TELA PARA CÁLCULO RÁPIDO PARA NOTA DE PROVA BIMESTRAL");

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        texto.setRows(5);
        texto.setText("\n\n\t\t\t\t\tVAMOS À UM PEQUENO TUTORIAL - SEREI RÁPIDO E BREVE\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\t\tA tela \"Cálculo rápido para nota de prova parcial\" é acessível pelo menu: CÁLCULO RÁPIDO PARA NOTA DE PROVA -> Cálculo de Nota Bimestral. Nesse local o professor vai poder calcular uma nota rápida para uma prova bimestral usando um método de comparação por gabarito.\n\t\t\n\t\tNessa tela existem dois campos: \"INSIRA O GABARITO OFICIAL DA PROVA\" e \"INSIRA AS RESPOSTAS MARCADAS PELO ALUNO\". Nem precisa explicar esses campos né?\n\t\tOBS: Nos dois campos é preciso inserir os gabaritos por questão separando-as por uma vírgula. Por exemplo: uma prova que tem 5 questões. No campo de gabarito oficial ou no campo do gabarito do aluno é preciso inserir do seguinte modelo: a,b,c,d,e - sem espaço e separado por vírgula.\n\n\t\tOBS: O número que questões inseridas no campo de gabarito do aluno não pode ultrapassar o número de questões inseridas no campo de gabarito da prova oficial.\n\t\n\t\tDepois é só clicar em \"GERAR NOTA\" e ver a mágica acontecendo. No campo ao lado do botão é onde vai aparecer a nota que foi calculada e ao lado desse campo vai aparecer o resultado \n\t\t(\"APROVADO\" - Caso a nota for maior ou igual que 6,\"RECUPERAÇÃO\" - Caso a nota for menor 6 e maior que 4,\"REPROVADO\" - Caso a nota for menor que 4) ");
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
