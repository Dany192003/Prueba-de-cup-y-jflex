package analizadores;


public class GeneradorDeAnalizadores {
   public static void main(String[] args) {
    // Ruta al archivo .flex y .cup
    String rutaAnalizador = "src/analizadores/";
    
    // Ejecutar JFlex y CUP
    try {
        // Generar el analizador léxico con JFlex
        String[] Flex = {rutaAnalizador + "Lexico.jflex", "-d", rutaAnalizador};
        jflex.Main.generate(Flex);
        
        // Generar el analizador sintáctico con CUP
        String[] Cup = {"-destdir", rutaAnalizador, "-parser", "Parser", rutaAnalizador + "Sintactico.cup"};
        java_cup.Main.main(Cup);
        
        System.out.println("Generación del analizador correcta.");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}