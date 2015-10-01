package analisador;

import static analisador.Token.*;
%%
%class Lexer
%type Token

letter = [a-zA-Z_]
digit= [0-9]
digit1= [1-9]

WHITE=[ \t\r\n]
%{
public String lexeme;
%}
%%
{WHITE} {/*Ignore*/}

/* Operadores Aritméticos */

( "+" | "-" | "*" | "/" | "%" )    {lexeme = yytext(); return OPERADOR_ARITMETICO;}

/* Operadores Lógicos */
("&&" | "||" | "!" | "|" )    {lexeme = yytext(); return OPERADOR_LOGICO;}

/*Operadores Relacionais */
(">" | "<" | "==" | "!=" | ">=" | "<=")   {lexeme = yytext(); return OP_RELACIONAL;}

/*Operadores Booleanos*/
(true | false)      {lexeme=yytext(); return OP_BOOLEANO;}

/*Delimitadores */
("(" | ")" | "{" | "}" | "[" | "]" | ";" | "," |  ".")      {lexeme = yytext(); return DELIMITADOR;}


/* Comentarios */
( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTARIO;}

/* Palavras-chave */
(class | public | extends | static | void | int | boolean | void |while 
| if | else | return | this | new) {lexeme = yytext(); return PALAVRA_CHAVE;}

/* IDs */
("_" | {letter})({letter}|{digit} | "_")* {lexeme=yytext(); return ID;}

/* Literais Inteiros*/
{digit}{digit1}*  {lexeme=yytext(); return LIT_INTEIRO;}
("0")  {lexeme=yytext(); return LIT_INTEIRO;}


/* Literais_ponto_flutuante */
{digit}{digit1}*("."){digit}{digit1}*  {lexeme=yytext(); return LIT_FLUTUANTE;}
("0")("."){digit}{digit1}*  {lexeme=yytext(); return LIT_FLUTUANTE;}




. {return ERROR;}