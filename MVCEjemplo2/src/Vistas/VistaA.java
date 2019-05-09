/*
 * VistaA.java
 *
 * Created on 9 de junio de 2006, 18:59
 */
package Vistas;

import Modelo.Modelo;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author  root
 */
public class VistaA extends javax.swing.JPanel implements Observer
{

    Modelo modeloObservado;

    /** Creates new form VistaA */
    public VistaA(Modelo modelo)
    {
        initComponents();
        modeloObservado = modelo;
        modeloObservado.addObserver(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stTexto = new javax.swing.JTextField();

        stTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stTextoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(stTexto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(stTexto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 167, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void stTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stTextoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_stTextoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField stTexto;
    // End of variables declaration//GEN-END:variables

    public void update(Observable observable, Object object)
    {
        if (observable != modeloObservado)
        {
            throw new IllegalArgumentException();
        }
        String dato = (String) object;
        setTexto(dato);
    }

    public void setTexto(String t)
    {
        stTexto.setText(t);
    }
}