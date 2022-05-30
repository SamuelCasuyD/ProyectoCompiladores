/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocompiladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author KAZZU
 */
public class Pcompiladores {
    
    public static void main(String[] args) throws Exception {           
        String rutaArchivo = "C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/Lexer.flex";
        String rutaCup = "C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/LexerCup.flex";
        String[] rutaSintactico = {"-parser", "Sintaxis", "C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/Sintaxis.cup"};
        generarPaquetes(rutaArchivo,rutaCup,rutaSintactico);
    }
    
    public static void generarPaquetes(String rutaArchivo, String rutaCup, String[] rutaSintactico) throws IOException, Exception{
        File archivo;
        archivo = new File(rutaArchivo);
        JFlex.Main.generate(archivo);
          
        archivo = new File(rutaCup);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintactico);
            
        Path rutaSymbolos = Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/sym.java");            
        /** VALIDAR QUE EL ARCHIVO SE ENCUENTRE O NO**/
        if (Files.exists(rutaSymbolos)) {
            Files.delete(rutaSymbolos);
        }
            
        Files.move(
            Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/sym.java"),
            Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/sym.java")
        );
            
        Path rutaSintaxis = Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/Sintaxis.java");
        /** VALIDAR QUE EL ARCHIVO SE ENCUENTRE O NO**/
        if (Files.exists(rutaSintaxis)) {
             Files.delete(rutaSintaxis);
        }
           
        Files.move(
            Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/Sintaxis.java"),
            Paths.get("C:/Users/KAZZU/OneDrive/Documents/NetBeansProjects/ProyectoCompiladores/src/proyectocompiladores/Sintaxis.java")
        );
    }           
    
}
