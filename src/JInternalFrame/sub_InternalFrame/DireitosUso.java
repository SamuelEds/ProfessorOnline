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
public class DireitosUso extends javax.swing.JInternalFrame {

    /**
     * Creates new form DireitosUso
     */
    public DireitosUso() {
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
        setTitle("DIREITOS DE USO");

        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        texto.setRows(5);
        texto.setText("\n\n\n\tDIREITOS POR PARTE DOS USUÁRIOS\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n-ADMINISTRADOR: TEM ACESSO À FERRAMENTAS ESPECÍFICAS QUE CONTROLAM A APLICAÇÃO\n\n-PROFESSOR/USUÁRIO: TEM ACESSO ÀS TELAS DE CÁLCULO DE NOTAS E MÉDIAS\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n\n\t© TODOS OS DIREITOS RESERVADOS - EQUIPE DE DESENVOLVIMENTO DA E.E.E.P JOAQUIM NOGUEIRA\n\n-DESENVOLVEDORES:\n \t\n\tSAMUEL EDSON RIBEIRO SAMPAIO\n\tPEDRO AUGUSTO SOUZA\n\tDENIS BRAGA SOUZA\n\tJOÃO VICTOR GOMEZ AZEVEDO");
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
