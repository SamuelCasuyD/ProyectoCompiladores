/* PAQUETE Y LIBRERIAS A UTILIZAR*/
package proyectocompiladores;

import static proyectocompiladores.Tokens.*;

/* DECLARACIONES A UTILIZAR*/
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\n,\r,\t]+
%{
public String lexeme;
%}
%%







/* PALABRAS RESERVADAS QUE UTILIZAREMOS */
/* Para asignar un valor a una variable se utiliza la palabra reservada */
( Set | set | SET | PutS | PUTS | puts |  expr | break | continue) {lexeme=yytext(); return PalabraReservada;}

( if ) {lexeme=yytext(); return If;}
( else ) {lexeme=yytext(); return Else;}
( do ) {lexeme=yytext(); return Do;}
( while ) {lexeme=yytext(); return While;}
( for ) {lexeme=yytext(); return For;}
( String ) {lexeme=yytext(); return Cadena;}
( switch ) {lexeme=yytext(); return SwitchCase;}
( default ) {lexeme=yytext(); return Defecto;}
( int ) {lexeme=yytext(); return Int;}
( main ) {lexeme=yytext(); return Main;}

/* CORCHETES */
( "[" ) {lexeme = yytext(); return CorcheteApertura;}
( "]" ) {lexeme = yytext(); return CorcheteCierre;}

/*LLAVES*/
( "{" ) {lexeme=yytext(); return LlaveApertura;}
( "}" ) {lexeme=yytext(); return LlaveCierre;}

/*PARENTESIS DE APERTURA*/
( "(" ) {lexeme=yytext(); return ParentesisApertura;}
( ")" ) {lexeme=yytext(); return ParentesisCierre;}

/*OPERADORES RELACIONALES */
( ">" | "<" | "==" | "!=" | ">=" | "<="  ) {lexeme = yytext(); return OperadoresRelacionales;}

/* Identificador y números */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

/* Operadores Aritméticos */
("*" | "/" | "%" | "+" | "-") {lexeme = yytext(); return OperadoresAritmeticos;}
( "=" ) {lexeme=yytext(); return Igual;}
( "$" ) {lexeme=yytext(); return Dolar;}
( "\"" ) {lexeme=yytext(); return Comillas;}
( ";" ) {lexeme=yytext(); return PuntoComa;}

/* por ejemplo 2**2 dará como resultado 4. */
( "**" ) {lexeme=yytext(); return Exponente;}

/* Operadores logicos y Operadores Atribución */
( "&&" | "||" | "!" | "&" | "|" | "#" ) {lexeme=yytext(); return OperadoresLogicos;}
( "+=" | "-="  | "*=" | "/=" | "%=" ) {lexeme = yytext(); return OperadoresAtribucion;}

/*OPERADORES BOOLEANOS*/
( true | false ) {lexeme = yytext(); return OperadoresBooleano;}

/*OPERADORES RELACIONALES PARA CADENAS*/
(eq | ne | in | ni) {lexeme = yytext(); return OperadoresDeCadenas;}

/* Comentarios */
( "//"(.)* ) {/*Ignore*/}

{espacio} {/*Ignore*/}

( "\n" ) {return Linea;}

/* Error de analisis */
 . {return ERROR;}
