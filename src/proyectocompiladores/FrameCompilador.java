/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompiladores;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;

/**
 *
 * @author KAZZU
 */
public class FrameCompilador extends javax.swing.JFrame {

    /**
     * Creates new form FrameCompilador
     */
    public FrameCompilador() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    /** ANALIZADOR LEXICO */
    private void analizadorLexico() throws IOException{
        
        int contador = 1;
        
        String expr = (String) IngresarDatos.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultados = "LINEA " + contador + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                ResultadoanalizadorLexico.setText(resultados);
                return;
            }
            switch (token) {
                case Linea:
                contador++;
                resultados += "LINEA " + contador + "\n";
                break;                
                
                case PalabraReservada: case Else: case Do: case While: case For: case Cadena: case SwitchCase: case Defecto:
                resultados += "  <Palabra reservada : >\t" + lexer.lexeme + "\n";
                break;
                
                case If:
                resultados += "  <Sentencia If : >\t" + lexer.lexeme + "\n";
                break;
                case CorcheteApertura:
                resultados += "  <Corchete de apertura : >\t" + lexer.lexeme + "\n";
                break;
                
                case CorcheteCierre:
                resultados += "  <Corchete de cierre : >\t" + lexer.lexeme + "\n";
                break;
                
                case LlaveApertura:
                resultados += "  <Llave de apertura : >\t" + lexer.lexeme + "\n";
                break;
                
                case LlaveCierre:
                resultados += "  <Llave de cierre : >\t" + lexer.lexeme + "\n";
                break;
                
                case ParentesisApertura:
                resultados += "  <Parentesis de apertura : >\t" + lexer.lexeme + "\n";
                break;
                
                case ParentesisCierre:
                resultados += "  <Parentesis de cierre : >\t" + lexer.lexeme + "\n";
                break;
                
                case OperadoresRelacionales:
                resultados += "  <Operador relacional : >\t" + lexer.lexeme + "\n";                  
                break;
                
                case Identificador:
                resultados += "  <Identificador : >\t\t" + lexer.lexeme + "\n";
                break;
                
                case Numero:
                resultados += "  <Numero : >\t\t" + lexer.lexeme + "\n";
                break;
                
                case TipoDeDatos: case Int:
                resultados += "  <Tipo de dato : >\t" + lexer.lexeme + "\n";
                break;
                
                case OperadoresAritmeticos:
                resultados += "  <Operador aritmetico : >\t" + lexer.lexeme + "\n";
                break;
                
                case OperadoresLogicos:
                resultados += "  <Operador logico : >\t" + lexer.lexeme + "\n";
                break;
                
                case OperadoresAtribucion:
                resultados += "  <Operador de atribucion : >\t" + lexer.lexeme + "\n";
                break;
                
                case Exponente:
                resultados += "  <Exponente : >\t" + lexer.lexeme + "\n";
                break;
                case OperadoresBooleano:
                resultados += "  <Operador booleano : >\t" + lexer.lexeme + "\n";
                break;
                
                case OperadoresDeCadenas:
                resultados += "  <Operador de cadena : >\t" + lexer.lexeme + "\n";
                break;

                case OperadoresMasMenos:
                resultados += "  <Operador incremento : >\t" + lexer.lexeme + "\n";
                break;
                
                case Main:
                resultados += "  <palabra reservada main C++ : >\t" + lexer.lexeme + "\n";
                break;
                
                case PuntoComa:
                resultados += "  <Punto y coma : >\t" + lexer.lexeme + "\n";
                break;
                
                case Estructura:
                resultados += "  <palabra reservada struct : >\t" + lexer.lexeme + "\n";
                break;
                
                case Comillas:
                resultados += "  <Comillas : >\t\t" + lexer.lexeme + "\n";
                break;
                
                case Igual:
                resultados += "  <Operador igual>\t" + lexer.lexeme + "\n";
                break;
                
                case Dolar:
                resultados += "  <Simbolo de dolar : >\t" + lexer.lexeme + "\n";
                break;
                
                case ERROR:
                resultados += "  <Simbolo no definido NO EXISTE EL TOKEN>\t" + lexer.lexeme + "\n";
                break;
                    
                default:
                resultados += "  < " + lexer.lexeme + " >\n";
                break;
            }
        }
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
        ButtonBorrarSintaxis = new javax.swing.JButton();
        ButtonLeerArchivo = new javax.swing.JButton();
        ButtonAnalizar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ResultadoSintacrico = new javax.swing.JTextArea();
        ButtonAnalizarSintactico = new javax.swing.JButton();
        ButtonBorrarAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        IngresarDatos = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        ResultadoanalizadorLexico = new javax.swing.JTextArea();
        ButtonBorrarDatosArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador léxico sintáctico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI Black", 1, 24), new java.awt.Color(0, 102, 204))); // NOI18N

        ButtonBorrarSintaxis.setBackground(new java.awt.Color(255, 102, 51));
        ButtonBorrarSintaxis.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonBorrarSintaxis.setText("Borrar datos");
        ButtonBorrarSintaxis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBorrarSintaxisActionPerformed(evt);
            }
        });

        ButtonLeerArchivo.setBackground(new java.awt.Color(0, 153, 255));
        ButtonLeerArchivo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonLeerArchivo.setText("Abrir archivo");
        ButtonLeerArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLeerArchivoActionPerformed(evt);
            }
        });

        ButtonAnalizar1.setBackground(new java.awt.Color(153, 204, 0));
        ButtonAnalizar1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonAnalizar1.setText("Analizar datos");
        ButtonAnalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAnalizar1ActionPerformed(evt);
            }
        });

        ResultadoSintacrico.setColumns(20);
        ResultadoSintacrico.setRows(5);
        ResultadoSintacrico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Análisis sintáctico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jScrollPane1.setViewportView(ResultadoSintacrico);

        ButtonAnalizarSintactico.setBackground(new java.awt.Color(153, 204, 0));
        ButtonAnalizarSintactico.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonAnalizarSintactico.setText("Analizar datos");
        ButtonAnalizarSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonAnalizarSintacticoActionPerformed(evt);
            }
        });

        ButtonBorrarAnalizar.setBackground(new java.awt.Color(255, 102, 51));
        ButtonBorrarAnalizar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonBorrarAnalizar.setText("Borrar datos");
        ButtonBorrarAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBorrarAnalizarActionPerformed(evt);
            }
        });

        IngresarDatos.setColumns(20);
        IngresarDatos.setRows(5);
        IngresarDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ingrese los datos o cargue un archivo.txt", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Symbol", 1, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        jScrollPane2.setViewportView(IngresarDatos);

        ResultadoanalizadorLexico.setColumns(20);
        ResultadoanalizadorLexico.setRows(5);
        ResultadoanalizadorLexico.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Análisis léxico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 12), new java.awt.Color(0, 102, 204))); // NOI18N
        jScrollPane3.setViewportView(ResultadoanalizadorLexico);

        ButtonBorrarDatosArchivo.setBackground(new java.awt.Color(255, 102, 51));
        ButtonBorrarDatosArchivo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        ButtonBorrarDatosArchivo.setText("Borrar datos");
        ButtonBorrarDatosArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBorrarDatosArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ButtonBorrarAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ButtonAnalizar1)))
                            .addComponent(ButtonBorrarSintaxis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonAnalizarSintactico, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(ButtonLeerArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonBorrarDatosArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(ButtonAnalizar1)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBorrarAnalizar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonLeerArchivo)
                            .addComponent(ButtonBorrarDatosArchivo))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ButtonAnalizarSintactico)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonBorrarSintaxis)))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBorrarSintaxisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBorrarSintaxisActionPerformed
        // TODO add your handling code here:
        ResultadoSintacrico.setText(null);
    }//GEN-LAST:event_ButtonBorrarSintaxisActionPerformed

    private void ButtonLeerArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLeerArchivoActionPerformed
        // TODO add your handling code here:
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            IngresarDatos.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrameCompilador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrameCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonLeerArchivoActionPerformed

    private void ButtonAnalizarSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnalizarSintacticoActionPerformed
       
        String ST = IngresarDatos.getText();
        Sintaxis s = new Sintaxis(new proyectocompiladores.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            ResultadoSintacrico.setText("Analisis sintactico realizado con exito");
            ResultadoSintacrico.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            ResultadoSintacrico.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            ResultadoSintacrico.setForeground(Color.red);
        }
    }//GEN-LAST:event_ButtonAnalizarSintacticoActionPerformed

    private void ButtonAnalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonAnalizar1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            analizadorLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrameCompilador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonAnalizar1ActionPerformed

    private void ButtonBorrarAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBorrarAnalizarActionPerformed
        // TODO add your handling code here:
        ResultadoanalizadorLexico.setText(null);
    }//GEN-LAST:event_ButtonBorrarAnalizarActionPerformed

    private void ButtonBorrarDatosArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBorrarDatosArchivoActionPerformed
        // TODO add your handling code here:
        IngresarDatos.setText(null);
        
    }//GEN-LAST:event_ButtonBorrarDatosArchivoActionPerformed

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
            java.util.logging.Logger.getLogger(FrameCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameCompilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAnalizar1;
    private javax.swing.JButton ButtonAnalizarSintactico;
    private javax.swing.JButton ButtonBorrarAnalizar;
    private javax.swing.JButton ButtonBorrarDatosArchivo;
    private javax.swing.JButton ButtonBorrarSintaxis;
    private javax.swing.JButton ButtonLeerArchivo;
    private javax.swing.JTextArea IngresarDatos;
    private javax.swing.JTextArea ResultadoSintacrico;
    private javax.swing.JTextArea ResultadoanalizadorLexico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
