import java.util.Scanner;

public class MainKRS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianKRS antrian = new AntrianKRS(10);

        int pilihan;

        do {
            System.out.println("\n=== MENU LAYANAN KRS DPA ===");
            System.out.println("1. Tambah Mahasiswa ke Antrian");
            System.out.println("2. Proses KRS (2 Mahasiswa)");
            System.out.println("3. Lihat Semua Antrian");
            System.out.println("4. Lihat 2 Mahasiswa Terdepan");
            System.out.println("5. Lihat Mahasiswa Terakhir");
            System.out.println("6. Cek Jumlah Antrian");
            System.out.println("7. Cek Jumlah Mahasiswa Diproses");
            System.out.println("8. Cek Mahasiswa Belum Diproses");
            System.out.println("9. Kosongkan Antrian");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // flush

            switch (pilihan) {
                case 1:
                    System.out.print("NIM   : ");
                    String nim = sc.nextLine();
                    System.out.print("Nama  : ");
                    String nama = sc.nextLine();
                    System.out.print("Prodi : ");
                    String prodi = sc.nextLine();
                    System.out.print("Kelas : ");
                    String kelas = sc.nextLine();
                    Mahasiswa m = new Mahasiswa(nim, nama, prodi, kelas);
                    antrian.tambahAntrian(m);
                    break;
                case 2:
                    antrian.prosesKRS();
                    break;
                case 3:
                    antrian.lihatSemua();
                    break;
                case 4:
                    antrian.lihatTerdepan2();
                    break;
                case 5:
                    antrian.lihatAkhir();
                    break;
                case 6:
                    System.out.println("Jumlah Mahasiswa dalam antrian: " + antrian.getJumlah());
                    break;
                case 7:
                    System.out.println("Jumlah Mahasiswa sudah diproses: " + antrian.getDiproses());
                    break;
                case 8:
                    System.out.println("Jumlah Mahasiswa belum diproses: " + antrian.getSisa());
                    break;
                case 9:
                    antrian.clear();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan layanan KRS.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        sc.close();
    }
}
