
package analizadores;

// importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
%%

// código de usuario
%{
    public LinkedList<Errores> listaErrores = new LinkedList<Errores>();
    public LinkedList<Token> listaTokens = new LinkedList<Token>(); // Lista para almacenar los tokens
    private int numeroToken = 1; // Contador para los tokens
    String lexema;
%}

%init{
    yyline = 0;
    yycolumn = 0; // Cambiado a 0
    listaErrores = new LinkedList<>();
    listaTokens = new LinkedList<>(); // Inicializar la lista de tokens
%init}

// características de JFlex
%cup
%class Lexer
%public
%line
%column
%buffer 1024
%char
%full
%debug

// Definición de patrones
ESPACIOS = [\ \r\t\f\n]+
IDENTIFICADOR = [a-zA-Z_][a-zA-Z_0-9]*
ENTERO = [-]?[0-9]+
DECIMAL= [-]?[0-9]+(\.[0-9]+)?
MAS="+"
MENOS="-"
MULTI="*"
DIV="/"
OPERAR="operar"

%%


<YYINITIAL> {ESPACIOS} {}

<YYINITIAL> {OPERAR} {
    listaTokens.add(new Token(numeroToken++, yytext(), "OPERAR", yyline+1, yycolumn+1));
    return new Symbol(sym.OPERAR, yyline, yycolumn, yytext());
}
<YYINITIAL> {MAS} {
    listaTokens.add(new Token(numeroToken++, yytext(), "MAS", yyline+1, yycolumn+1));
    return new Symbol(sym.MAS, yyline, yycolumn, yytext());
}
<YYINITIAL> {MENOS} {
    listaTokens.add(new Token(numeroToken++, yytext(), "MENOS", yyline+1, yycolumn+1));
    return new Symbol(sym.MENOS, yyline, yycolumn, yytext());
}
<YYINITIAL> {MULTI} {
    listaTokens.add(new Token(numeroToken++, yytext(), "MULTI", yyline+1, yycolumn+1));
    return new Symbol(sym.MULTI, yyline, yycolumn, yytext());
}
<YYINITIAL> {DIV} {
    listaTokens.add(new Token(numeroToken++, yytext(), "DIV", yyline+1, yycolumn+1));
    return new Symbol(sym.DIV, yyline, yycolumn, yytext());
}

<YYINITIAL> {IDENTIFICADOR} {
    listaTokens.add(new Token(numeroToken++, yytext(), "IDENTIFICADOR", yyline+1, yycolumn+1));
    return new Symbol(sym.IDENTIFICADOR, yyline, yycolumn, yytext());
}
<YYINITIAL> {ENTERO} {
    listaTokens.add(new Token(numeroToken++, yytext(), "ENTERO", yyline+1, yycolumn+1));
    return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());
}
<YYINITIAL> {DECIMAL} {
    listaTokens.add(new Token(numeroToken++, yytext(), "DECIMAL", yyline+1, yycolumn+1));
    return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());
}


// Manejo de caracteres no reconocidos
<YYINITIAL> . {
    listaErrores.add(new Errores("Lexico","El lexema: "+yytext()+" no esta definido",yyline+1, yycolumn+1));
}