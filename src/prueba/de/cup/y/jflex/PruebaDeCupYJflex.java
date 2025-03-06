/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba.de.cup.y.jflex;

import analizadores.GeneradorHTML;
import analizadores.Lexer;
import analizadores.Parser;
import java.io.StringReader;

/**
 *
 * @author Danyj
 */
public class PruebaDeCupYJflex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    Lexer scanner = new Lexer(new StringReader("operar 5 - 5"));
    Parser parser = new Parser(scanner);
    parser.parse();
    
        GeneradorHTML.generarArchivoHTMLTokens(scanner);
        GeneradorHTML.generarArchivoHTMLErrores(scanner, parser);
    }
    
}
