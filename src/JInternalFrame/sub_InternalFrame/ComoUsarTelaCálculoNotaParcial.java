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
public class ComoUsarTelaCálculoNotaParcial extends javax.swing.JInternalFrame {

    /**
     * Creates new form ComoUsarTelaCálculoNotaParcial
     */
    public ComoUsarTelaCálculoNotaParcial() {
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
        setTitle("COMO USAR A TELA PARA CÁLCULO RÁPIDO DE NOTA DE PROVA PARCIAL");

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        texto.setRows(5);
        texto.setText("\n\n\t\t\t\tVAMOS À UM PEQUENO TUTORIAL - SEREI RÁPIDO E BREVE\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\tA tela \"Calculo rápido para nota de prova parcial\" é acessível pelo menu: CÁLCULO RÁPIDO PARA NOTA DE PROVA->CÁLCULO DE NOTA PARCIAL. Nesse local não tem segredo, o sistema vai apenas calcular uma nota rápida para uma prova parcial. O sistema usa o método de cálculo por \"Escore\".\n\t\t\n\tNessa tela, existem dois campos de entrada: o campo \"INSIRA O TOTAL DE ESCORES DA PROVA\" e o \"INSIRA OS ESCORES OBTIDOS PELO ALUNO(A) POR QUESTÕES\".\n\t\t\n\tJá meio óbvio, o professor irá inserir o total de escores que a prova vale no primeiro campo e no segundo campo irá colocar os escores obtidos pelo aluno(a) por questões.\n\t\t\n\t\tOBS: É preciso separa as questões por vírgula - por exemplo: uma prova de 5 questões onde cada uma vale 2 escores. É preciso inserir do seguinte modo: 2,2,2,2,2 - por vírgula e sem espaço.\n\t\t\n\t\tOBS 2: Esse modo de separação só é aplicável no segundo campo, que é onde fica os resultados do aluno.\n\n\t\tAo preencher todos os campos, é só clicar no botão \"GERAR NOTA\" que o sistema gerará uma nota aplicável. O sistema usa o método de correção por escores para calcular a nota.\n\t\t\n\t\tNo campo ao lado do botão é onde vai aparecer a nota que foi calculada e ao lado desse campo vai aparecer o resultado \n\t\t(\"APROVADO\" - Caso a nota for maior ou igual que 6,\"RECUPERAÇÃO\" - Caso a nota for menor 6 e maior que 4,\"REPROVADO\" - Caso a nota for menor que 4) \n\t\t\n\t\tPronto, acabou - Bem fácil né?");
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
