package exercicios;

import java.util.Scanner;

public class RomanosParaDecimais {

	public static int totalV = 0;
	public static int totalL = 0;
	public static int totalD = 0;
	public static int totalI = 0;
	public static int totalX = 0;
	public static int totalC = 0;
	public static int totalM = 0;

	public static String V = new String();
	public static String L = new String();
	public static String D = new String();
	public static String I = new String();
	public static String X = new String();
	public static String C = new String();
	public static String M = new String();

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entre com os numerais romanos");
		String num = sc.next().toUpperCase();

		String texto1 = "As letras I,X,C e M são agrupadas somente seguidas por 3 vezes, por exemplo: III = 3; XXX = 30.";
		String texto2 = "As letras V, D e L só podem aparecer uma vez";

		String texto3 = "A letra I deve ser utilizada somente antes do I, V, e do X, por exemplo: II = 2; IV = 4; IX = 9.";
		String texto4 = "A letra I deve ser utilizada somente depois do I, V e do X, por exemplo: II = 2; VI = 6; XI = 11.";

		String texto5 = "A letra X deve ser utilizada somente antes do L, X e do C, por exemplo: XL = 40; XX = 20; XC = 90";
		String texto6 = "A letra X deve ser utilizada somente depois do L, X e do C, por exemplo: LX = 60; XX = 20; CX = 110";

		// aceita apenas dez digitos
		if (num.length() < 10) {

			// verifica se os caracteres digitados sao iguais aos abaixo
			for (int k = 0; k < num.length(); k++) {

				char validaV = num.charAt(k);
				char validaL = num.charAt(k);
				char validaD = num.charAt(k);
				char validaI = num.charAt(k);
				char validaX = num.charAt(k);
				char validaC = num.charAt(k);
				char validaM = num.charAt(k);

				V = String.valueOf(validaV);
				L = String.valueOf(validaL);
				D = String.valueOf(validaD);
				I = String.valueOf(validaI);
				X = String.valueOf(validaX);
				C = String.valueOf(validaC);
				M = String.valueOf(validaM);
			}

			// verifica se os caracteres digitados sao numerais romanos
			if ((V.equalsIgnoreCase("V")) || (L.equalsIgnoreCase("L")) || (D.equalsIgnoreCase("D"))
					|| (I.equalsIgnoreCase("I")) || (X.equalsIgnoreCase("X")) || (C.equalsIgnoreCase("C"))
					|| (M.equalsIgnoreCase("M"))) {

				// verifica se o V, L e o D sao utilizados apenas uma vez e se I, X, C e o M sao
				// utilizados no maximo 3 vezes
				for (int j = 0; j < num.length(); j++) {

					char contV = num.charAt(j);
					char contL = num.charAt(j);
					char contD = num.charAt(j);
					char contI = num.charAt(j);
					char contX = num.charAt(j);
					char contC = num.charAt(j);
					char contM = num.charAt(j);

					String v = String.valueOf(contV);
					String l = String.valueOf(contL);
					String d = String.valueOf(contD);
					String i = String.valueOf(contI);
					String x = String.valueOf(contX);
					String c = String.valueOf(contC);
					String m = String.valueOf(contM);

					if (v.equalsIgnoreCase("v")) {
						totalV++;
					}
					if (l.equalsIgnoreCase("l")) {
						totalL++;
					}
					if (d.equalsIgnoreCase("d")) {
						totalD++;
					}
					if (i.equalsIgnoreCase("i")) {
						totalI++;
					}
					if (x.equalsIgnoreCase("x")) {
						totalX++;
					}
					if (c.equalsIgnoreCase("c")) {
						totalC++;
					}
					if (m.equalsIgnoreCase("m")) {
						totalM++;
					}
				}

				// verifica se os numeros sao utilizados o maximo de vezes validadas em numerais
				// romanos
				if ((totalV < 2) && (totalL < 2) && (totalD < 2) && (totalI < 4) && (totalX < 4) && (totalC < 4) && (totalM < 4)) {

					for (int a = 0; a < num.length(); a++) {

						char contI = num.charAt(a);
						char contX = num.charAt(a);
						char contC = num.charAt(a);

						String i = String.valueOf(contI);
						String x = String.valueOf(contX);
						String c = String.valueOf(contC);

						// valida se o I é utilizado de forma correta antes e depois do X e do V. E
						// antes e depois do proprio I
						if (i.equalsIgnoreCase("i")) {
							if ((a > 0) && (a + 1 < num.length())) {
								char aux1 = num.charAt(a - 1);
								char aux2 = num.charAt(a + 1);

								String menosI = String.valueOf(aux1);
								String maisI = String.valueOf(aux2);
								if ((!menosI.equalsIgnoreCase("X")) || (!menosI.equalsIgnoreCase("V")) || (!menosI.equalsIgnoreCase("I"))) {
									System.out.println(texto3);
									System.out.println(texto4);

									return;
								}

								if ((!maisI.equalsIgnoreCase("X")) || (!maisI.equalsIgnoreCase("V")) || (!maisI.equalsIgnoreCase("I"))) {
									System.out.println(texto3);
									System.out.println(texto4);

									return;
								}
							}
						}

						if (x.equalsIgnoreCase("x")) {
							if ((a > 0) && (a + 1 < num.length())) {

								char aux1 = num.charAt(a - 1);
								char aux2 = num.charAt(a + 1);

								String menosX = String.valueOf(aux1);
								String maisX = String.valueOf(aux2);
								if ((!menosX.equalsIgnoreCase("L")) || (!menosX.equalsIgnoreCase("C")) || (!menosX.equalsIgnoreCase("X"))) {
									System.out.println(texto5);
									System.out.println(texto6);

									return;
								}
								if ((!maisX.equalsIgnoreCase("L")) || (!maisX.equalsIgnoreCase("C")) || (!maisX.equalsIgnoreCase("X"))) {
									System.out.println(texto5);
									System.out.println(texto6);

									return;
								}

							}
						}

						if (c.equalsIgnoreCase("c")) {
							if ((a > 0) && (a + 1 < num.length())) {
								char aux1 = num.charAt(a - 1);
								char aux2 = num.charAt(a + 1);

								String menosC = String.valueOf(aux1);
								String maisC = String.valueOf(aux2);
								if ((!menosC.equalsIgnoreCase("D")) || (!menosC.equalsIgnoreCase("M"))|| (!menosC.equalsIgnoreCase("C"))) {
									System.out.println(texto5);
									System.out.println(texto6);

									return;
								}
								if ((!maisC.equalsIgnoreCase("D")) || (!maisC.equalsIgnoreCase("M"))
										|| (!maisC.equalsIgnoreCase("C"))) {
									System.out.println(texto5);
									System.out.println(texto6);

									return;
								}
							}
						}

					}

					int valor = traduzirNumeralRomano(num);
					System.out.println("O valor digitado em decimais é: " + valor);

				} else {
					System.out.println(texto1);
					System.out.println(texto2);
				}

			} else {
				System.out.println("Digite apenas números romanos");
			}

		} else {
			System.out.println("Digite no máximo 10 letras");
		}

		sc.close();

	}

	private static int traduzirNumeralRomano(String texto) {
		int n = 0;
		int numeralDaDireita = 0;
		for (int i = texto.length() - 1; i >= 0; i--) {
			int valor = (int) traduzirNumeralRomano(texto.charAt(i));
			n += valor * Math.signum(valor + 0.5 - numeralDaDireita);
			numeralDaDireita = valor;
		}
		return n;
	}

	private static double traduzirNumeralRomano(char caractere) {
		return Math.floor(Math.pow(10, "IXCM".indexOf(caractere)))
				+ 5 * Math.floor(Math.pow(10, "VLD".indexOf(caractere)));
	}
}
