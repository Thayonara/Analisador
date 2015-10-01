package analisador;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

public class Analisador {

	public static void main(String[] args) throws IOException {
		//String path = "C:/Users/Alessandro/workspace/Lexer/src/analisador/Lexer.flex";
		//gerarLexer(path);
		Scanner in = new Scanner(System.in);
		String texto = in.nextLine();
		executar(texto);

	}

	public static void gerarLexer(String path) {
		File file = new File(path);
		//gerar .flex
		jflex.Main.generate(file);

	}

	public static void executar(String texto) throws IOException {

		Lexer lexer = new Lexer(new StringReader(texto));

		String resultado = "";

		while (true) {
			Token token = lexer.yylex();
			if (token == null) {

				System.out.println(resultado);
				return;
			}
			
			//analisando

			switch (token) {

			case PALAVRA_CHAVE:
				resultado = resultado + "<PALAVRA_CHAVE> " + lexer.lexeme
						+ "\n";
				break;
			case OPERADOR_ARITMETICO:
				resultado = resultado + "<Operador_Aritmético> " + lexer.lexeme
						+ "\n";
				break;
			case OPERADOR_LOGICO:
				resultado = resultado + "<Operador_Lógico> " + lexer.lexeme
						+ "\n";
				break;
			case OP_RELACIONAL:
				resultado = resultado + "<Operador_Relacional> " + lexer.lexeme
						+ "\n";
				break;
			case OP_BOOLEANO:
				resultado = resultado + "<Operador_Booleano> " + lexer.lexeme
						+ "\n";
				break;
			case DELIMITADOR:
				resultado = resultado + "<DELIMITADOR> " + lexer.lexeme + "\n";
				break;
			case COMENTARIO:
				resultado = resultado + "<COMENTARIO> " + lexer.lexeme + "\n";
				break;
			case ERROR:
				resultado = resultado + "<Error> \n";
				break;
			case ID:
				resultado = resultado + "<ID> " + lexer.lexeme + "\n";
				break;
			case LIT_INTEIRO:
				resultado = resultado + "<LIT_INTEIRO> " + lexer.lexeme + "\n";
				break;
			case LIT_FLUTUANTE:
				resultado = resultado + "<LIT_FLUTUANTE> " + lexer.lexeme
						+ "\n";
				break;
			default:
				resultado = resultado + "<" + lexer.lexeme + ">";

			}
		}

	}

}
