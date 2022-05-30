package proyectocompiladores;
import java_cup.runtime.Symbol;
/* DECLARACIONES A UTILIZAR*/
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+

espacio=[ ,\n,\r,\t]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

/* PALABRAS RESERVADAS QUE UTILIZAREMOS */
/* Para asignar un valor a una variable se utiliza la palabra reservada */
(Set | set| PutS | puts | expr | break | continue | incr) {return new Symbol(sym.PalabraReservada, yychar, yyline, yytext());}

( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}
( else ) {return new Symbol(sym.Else, yychar, yyline, yytext());}
( do ) {return new Symbol(sym.Do, yychar, yyline, yytext());}
( while ) {return new Symbol(sym.While, yychar, yyline, yytext());}
( for ) {return new Symbol(sym.For, yychar, yyline, yytext());}
( String ) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}
( switch ) {return new Symbol(sym.SwitchCase, yychar, yyline, yytext());}
( default ) {return new Symbol(sym.Defecto, yychar, yyline, yytext());}
( int ) {return new Symbol(sym.Int, yychar, yyline, yytext());}
( main ) {return new Symbol(sym.Main, yychar, yyline, yytext());}

/*CORCHETES*/
( "[" ) {return new Symbol(sym.CorcheteApertura, yychar, yyline, yytext());}
( "]" ) {return new Symbol(sym.CorcheteCierre, yychar, yyline, yytext());}

/* LLAVES */
( "{" ) {return new Symbol(sym.LlaveApertura, yychar, yyline, yytext());}
( "}" ) {return new Symbol(sym.LlaveCierre, yychar, yyline, yytext());}

/* PARENTESIS DE APERTURA*/
( "(" ) {return new Symbol(sym.ParentesisApertura, yychar, yyline, yytext());}
( ")" ) {return new Symbol(sym.ParentesisCierre, yychar, yyline, yytext());}

/*OPERADORES RELACIONALES */
( ">" | "<" | "==" | "!=" | ">=" | "<=" ) {return new Symbol(sym.OperadoresRelacionales, yychar, yyline, yytext());}

/* Identificador y números */
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

/* Operadores Aritméticos */
( "*" | "/" | "%" | "+" | "-") {return new Symbol(sym.OperadoresAritmeticos, yychar, yyline, yytext());}

( "=" ) {return new Symbol(sym.Igual, yychar, yyline, yytext());}
( "$" ) {return new Symbol(sym.Dolar, yychar, yyline, yytext());}
( "\"" ) {return new Symbol(sym.Comillas, yychar, yyline, yytext());}
( ";" ) {return new Symbol(sym.PuntoComa, yychar, yyline, yytext());}

/* por ejemplo 2**2 dará como resultado 4. */
( "**" ) {return new Symbol(sym.Exponente, yychar, yyline, yytext());}

/* Operadores logicos Operadores Atribución*/
( "&&" | "||" | "!" | "&" | "|" | "#" ) {return new Symbol(sym.OperadoresLogicos, yychar, yyline, yytext());}
( "+=" | "-="  | "*=" | "/=" | "%=" ) {return new Symbol(sym.OperadoresAtribucion, yychar, yyline, yytext());}

/*OPERADORES BOOLEANOS*/
( true | false ) {return new Symbol(sym.OperadoresBooleano, yychar, yyline, yytext());}

/*OPERADORES RELACIONALES PARA CADENAS*/
(eq | ne | in | ni) {return new Symbol(sym.OperadoresDeCadenas, yychar, yyline, yytext());}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

{espacio} {/*Ignore*/}

( "\n" ) {return Linea;}

/* Error de analisis */
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}

