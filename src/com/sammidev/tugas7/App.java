package com.sammidev.tugas7;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		soal1();
		soal2();
		soal3();
		soal4a();
		soal4b();
	}

	static void soal1() {
		clearScreen();
		final int UPAH_PER_JAM = 2000;
		final int UPAH_PER_JAM_LEMBUR = 3000;
		final int LIMIT = 48;
		int jam,
				jamLembur = 0,
				gaji = 0,
				gajiLembur = 0;


		System.out.print("Masukkan total jam anda bekerja : ");
		jam = scanner();

		if (jam <= LIMIT) gaji = jam * UPAH_PER_JAM;
		else
			jamLembur = jam - LIMIT;
		gajiLembur = jamLembur * UPAH_PER_JAM_LEMBUR;
		gaji = gajiLembur + (jam - jamLembur) * UPAH_PER_JAM;


		System.out.println("Jam kerja lembur anda : " + jamLembur + " jam\n" +
				"Bonus hasil kerja lembur : Rp." + gajiLembur + "\n" +
				"Total gaji 		      : Rp." + gaji);
	}

	static void soal2() {
		clearScreen();
		int suhu;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Masukkan Suhu : ");
		suhu = scanner.nextInt();

		// switch with lambda style
		String status = switch (suhu) {
			case 30 -> "Panas";
			case 24 -> "Normal";
			case 20 -> "Dingin";
			default -> "STATUS SUHU TIDAK DIKETAHUI";
		};

		System.out.println("Suhu : " + suhu + "\n" +
				"Status : " + status);
	}

	static void soal3() {
		clearScreen();
		String name = scanner("Masukkan Nama");
		String golongan = scanner("Masukkan Golongan");

		double gajiBersih = 0, pajak, tunjangan;
		final double golonganA = 400,
				golonganB = 500,
				golonganC = 750,
				golonganD = 900;

		if (golongan.equalsIgnoreCase("A")) {
			tunjangan = 0.05 * golonganA;
			gajiBersih = golonganA + ((0.3 * golonganA) + tunjangan) + tunjangan;
		} else if (golongan.equalsIgnoreCase("B")) {
			tunjangan = 0.05 * golonganB;
			gajiBersih = golonganB + ((0.3 * golonganB) + tunjangan) + tunjangan;
		} else if (golongan.equalsIgnoreCase("C")) {
			tunjangan = 0.05 * golonganC;
			gajiBersih = golonganC + ((0.3 * golonganC) + tunjangan) + tunjangan;
		} else if (golongan.equalsIgnoreCase("D")) {
			tunjangan = 0.05 * golonganD;
			gajiBersih = golonganD + ((0.3 * golonganD) + tunjangan) + tunjangan;
		} else {
			System.out.println("Golongan Salah");
			System.exit(0);
		}

		System.out.println("Nama         : " + name + "\n" +
				"Golongan     : " + golongan + "\n" +
				"Gaji bersih  : " + gajiBersih);
	}

	static void soal4a() {
		/* TERNARY OPERATOR
			int besar = if (angka1 < angka2) ? angka2 : angka1;
		*/
		clearScreen();
		int angka1, angka2, angka3;
		System.out.print("Masukkan angka pertama : ");
		angka1 = scanner();

		System.out.print("Masukkan angka kedua: ");
		angka2 = scanner();

		int besar = Math.max(angka1, angka2);
		System.out.println("Angka 1  : " + angka1 + "\n" +
				"Angka 2  : " + angka2 + "\n" +
				"Angka terbesar  : " + besar);
	}

	static void soal4b() {
		clearScreen();
		int angka1, angka2, angka3;

		System.out.print("Masukkan angka pertama : ");
		angka1 = scanner();

		System.out.print("Masukkan angka kedua   : ");
		angka2 = scanner();

		System.out.print("Masukkan angka ketiga  : ");
		angka3 = scanner();

		int angkaTerkecil = angka1, angkaTerbesar = angka1;

		// TERKECIL
		if (angka2 < angkaTerkecil) angkaTerkecil = angka2;
		if (angka3 < angkaTerkecil) angkaTerkecil = angka3;

		// TERBESAR
		if (angka2 > angkaTerbesar) angkaTerbesar = angka2;
		if (angka3 > angkaTerbesar) angkaTerbesar = angka3;

		System.out.println("Angka terkecil : " + angkaTerkecil + "\n" +
				"Angka terbesar : " + angkaTerbesar);
	}

	// helpers (overloading scanner)
	static int scanner() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	static String scanner(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(message + ": ");
		return scanner.nextLine();
	}

	static void clearScreen() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033\143");
			}
		} catch (Exception ex) {
			System.err.println("tidak bisa clear screen");
		}
	}
}