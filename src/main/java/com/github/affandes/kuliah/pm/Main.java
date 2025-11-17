package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== HISTORY BROWSER ===");
            System.out.println("1. Browse (Kunjungi website)");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Pilih menu : ");
            int menu = input.nextInt();
            input.nextLine(); // buang newline

            switch (menu) {
                case 1:
                    System.out.print("Masukkan alamat website: ");
                    String webs = input.nextLine();
                    browse(webs);
                    break;

                case 2:
                    back();
                    break;

                case 3:
                    view();
                    break;

                case 4:
                    System.out.println("Keluar...");
                    return;

                default:
                    System.out.println("Menu tidak ada!");
            }
        }
    }

    public static void browse(String website) {
        history.add(website);
        System.out.println("Kunjungan disimpan: " + website);
    }

    public static void back() {
        if (history.isEmpty()) {
            System.out.println("History kosong! Tidak bisa back.");
            return;
        }

        String removed = history.remove(history.size() - 1);
        System.out.println("Kembali dari: " + removed);

        if (!history.isEmpty()) {
            System.out.println("Sekarang kamu di: " + history.get(history.size() - 1));
        } else {
            System.out.println("Tidak ada history lain.");
        }
    }

    public static void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong!");
            return;
        }

        System.out.println("\n=== LIST HISTORY (dari terbaru) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println((history.size() - i) + ". " + history.get(i));
        }
    }
}
