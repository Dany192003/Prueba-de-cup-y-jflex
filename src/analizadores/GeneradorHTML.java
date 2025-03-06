
package analizadores;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorHTML {

    // Método para generar el archivo HTML con tokens
    public static void generarArchivoHTMLTokens(Lexer s) {
        StringBuilder htmlContent = new StringBuilder();

        // Iniciar el documento HTML
        htmlContent.append("<html>\n<head>\n<title>Tokens</title>\n");
        htmlContent.append("<style>\n");
        htmlContent.append("body {\n");
        htmlContent.append("    font-family: Arial, sans-serif;\n");
        htmlContent.append("    margin: 0;\n");
        htmlContent.append("    padding: 0;\n");
        htmlContent.append("    background-color: #f4f4f4;\n");
        htmlContent.append("}\n");
        htmlContent.append("h1 {\n");
        htmlContent.append("    text-align: center;\n");
        htmlContent.append("    color: #333;\n");
        htmlContent.append("}\n");
        htmlContent.append("table {\n");
        htmlContent.append("    width: 80%;\n");
        htmlContent.append("    margin: 20px auto;\n");
        htmlContent.append("    border-collapse: collapse;\n");
        htmlContent.append("    background-color: #fff;\n");
        htmlContent.append("    box-shadow: 0 2px 5px rgba(0,0,0,0.1);\n");
        htmlContent.append("}\n");
        htmlContent.append("th, td {\n");
        htmlContent.append("    padding: 12px;\n");
        htmlContent.append("    text-align: left;\n");
        htmlContent.append("    border-bottom: 1px solid #ddd;\n");
        htmlContent.append("}\n");
        htmlContent.append("th {\n");
        htmlContent.append("    background-color: #f4f4f4;\n");
        htmlContent.append("    color: #333;\n");
        htmlContent.append("}\n");
        htmlContent.append("tr:hover {\n");
        htmlContent.append("    background-color: #f1f1f1;\n");
        htmlContent.append("}\n");
        htmlContent.append("</style>\n");
        htmlContent.append("</head>\n<body>\n");
        htmlContent.append("<h1>Lista de Tokens</h1>\n");
        htmlContent.append("<table>\n");
        htmlContent.append("<tr>\n<th>Número</th>\n<th>Lexema</th>\n<th>Tipo</th>\n<th>Línea</th>\n<th>Columna</th>\n</tr>\n");

        // Iterar sobre los tokens y agregar una fila por cada uno
        for (var token : s.listaTokens) {
            htmlContent.append("<tr>\n");
            htmlContent.append("<td>").append(token.getNumero()).append("</td>\n");
            htmlContent.append("<td>").append(token.getLexema()).append("</td>\n");
            htmlContent.append("<td>").append(token.getTipo()).append("</td>\n");
            htmlContent.append("<td>").append(token.getLinea()).append("</td>\n");
            htmlContent.append("<td>").append(token.getColumna()).append("</td>\n");
            htmlContent.append("</tr>\n");
        }

        // Cerrar la tabla y el documento HTML
        htmlContent.append("</table>\n</body>\n</html>");

        // Escribir el contenido en un archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Tokens.html"))) {
            writer.write(htmlContent.toString());
            System.out.println("Archivo HTML con tokens generado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo HTML de tokens: " + e.getMessage());
        }
    }

    // Método para generar el archivo HTML con errores
    public static void generarArchivoHTMLErrores(Lexer s, Parser p) {
    StringBuilder htmlContent = new StringBuilder();

    // Iniciar el documento HTML
    htmlContent.append("<html>\n<head>\n<title>Errores Léxicos y Sintácticos</title>\n");
    htmlContent.append("<style>\n");
    htmlContent.append("body {\n");
    htmlContent.append("    font-family: Arial, sans-serif;\n");
    htmlContent.append("    margin: 0;\n");
    htmlContent.append("    padding: 0;\n");
    htmlContent.append("    background-color: #f4f4f4;\n");
    htmlContent.append("}\n");
    htmlContent.append("h1 {\n");
    htmlContent.append("    text-align: center;\n");
    htmlContent.append("    color: #333;\n");
    htmlContent.append("}\n");
    htmlContent.append("table {\n");
    htmlContent.append("    width: 80%;\n");
    htmlContent.append("    margin: 20px auto;\n");
    htmlContent.append("    border-collapse: collapse;\n");
    htmlContent.append("    background-color: #fff;\n");
    htmlContent.append("    box-shadow: 0 2px 5px rgba(0,0,0,0.1);\n");
    htmlContent.append("}\n");
    htmlContent.append("caption {\n");
    htmlContent.append("    padding: 10px;\n");
    htmlContent.append("    font-size: 1.2em;\n");
    htmlContent.append("    font-weight: bold;\n");
    htmlContent.append("    text-align: center;\n");
    htmlContent.append("    background-color: #f4f4f4;\n");
    htmlContent.append("    color: #333;\n");
    htmlContent.append("    border-bottom: 2px solid #ddd;\n");
    htmlContent.append("}\n");
    htmlContent.append("th, td {\n");
    htmlContent.append("    padding: 12px;\n");
    htmlContent.append("    text-align: left;\n");
    htmlContent.append("    border-bottom: 1px solid #ddd;\n");
    htmlContent.append("}\n");
    htmlContent.append("th {\n");
    htmlContent.append("    background-color: #f4f4f4;\n");
    htmlContent.append("    color: #333;\n");
    htmlContent.append("}\n");
    htmlContent.append("tr:hover {\n");
    htmlContent.append("    background-color: #f1f1f1;\n");
    htmlContent.append("}\n");
    htmlContent.append("</style>\n");
    htmlContent.append("</head>\n<body>\n");
    htmlContent.append("<h1>Lista de Errores Léxicos y Sintácticos</h1>\n");

    // Generar tabla de errores léxicos
    htmlContent.append("<table>\n");
    htmlContent.append("<caption>Errores Léxicos</caption>\n");
    htmlContent.append("<tr>\n<th>Índice</th>\n<th>Tipo</th>\n<th>Descripcion</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n");

    // Contador de errores léxicos
    int index = 1;

    // Iterar sobre los errores léxicos y agregar una fila por cada uno
    for (var error : s.listaErrores) {
        htmlContent.append("<tr>\n");
        htmlContent.append("<td>").append(index++).append("</td>\n");
        htmlContent.append("<td>").append(error.getTipo()).append("</td>\n");
        htmlContent.append("<td>").append(error.getDescripcion()).append("</td>\n");
        htmlContent.append("<td>").append(error.getFila()).append("</td>\n");
        htmlContent.append("<td>").append(error.getColumna()).append("</td>\n");
        htmlContent.append("</tr>\n");
    }

    htmlContent.append("</table>\n");

    // Generar tabla de errores sintácticos
    htmlContent.append("<table>\n");
    htmlContent.append("<caption>Errores Sintácticos</caption>\n");
    htmlContent.append("<tr>\n<th>Índice</th>\n<th>Tipo</th>\n<th>Descripcion</th>\n<th>Fila</th>\n<th>Columna</th>\n</tr>\n");

    // Contador de errores sintácticos
    int sintaxisIndex = 1;

    // Iterar sobre los errores sintácticos y agregar una fila por cada uno
    for (var error : p.listaErrores) {
        htmlContent.append("<tr>\n");
        htmlContent.append("<td>").append(sintaxisIndex++).append("</td>\n");
        htmlContent.append("<td>").append(error.getTipo()).append("</td>\n");
        htmlContent.append("<td>").append(error.getDescripcion()).append("</td>\n");
        htmlContent.append("<td>").append(error.getFila()).append("</td>\n");
        htmlContent.append("<td>").append(error.getColumna()).append("</td>\n");
        htmlContent.append("</tr>\n");
    }

    // Cerrar las tablas y el documento HTML
    htmlContent.append("</table>\n</body>\n</html>");

    // Escribir el contenido en un archivo
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Errores.html"))) {
        writer.write(htmlContent.toString());
        System.out.println("Archivo HTML con errores generado correctamente.");
    } catch (IOException e) {
        System.err.println("Error al escribir el archivo HTML de errores: " + e.getMessage());
    }
}


}
