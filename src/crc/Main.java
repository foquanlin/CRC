package crc;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������ԭʼ����,�ûس���β");
		CRC crc = new CRC(sc.nextLine());
		sc.close();
		crc.incode(crc.getData());
	}
}
