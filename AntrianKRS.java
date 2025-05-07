public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max, diproses;

    public AntrianKRS(int max) {
        this.max = max;
        this.data = new Mahasiswa[max];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.diproses = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("Antrian telah dikosongkan.");
    }

    public void tambahAntrian(Mahasiswa mhs) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = mhs;
        size++;
        System.out.println("Mahasiswa berhasil ditambahkan ke antrian.");
    }

    public void prosesKRS() {
        if (size < 2) {
            System.out.println("Minimal 2 mahasiswa untuk diproses.");
            return;
        }
        if (diproses + 2 > 30) {
            System.out.println("Jumlah maksimal 30 mahasiswa sudah diproses.");
            return;
        }

        System.out.println("Mahasiswa yang diproses:");
        for (int i = 0; i < 2; i++) {
            Mahasiswa mhs = data[front];
            front = (front + 1) % max;
            size--;
            diproses++;
            mhs.tampilkanData();
        }
    }

    public void lihatSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Daftar Mahasiswa dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[idx].tampilkanData();
        }
    }

    public void lihatTerdepan2() {
        if (size < 1) {
            System.out.println("Antrian kosong.");
            return;
        }

        System.out.println("2 Mahasiswa terdepan:");
        for (int i = 0; i < Math.min(2, size); i++) {
            int idx = (front + i) % max;
            System.out.print((i + 1) + ". ");
            data[idx].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        System.out.println("Mahasiswa terakhir dalam antrian:");
        data[rear].tampilkanData();
    }

    public int getJumlah() {
        return size;
    }

    public int getDiproses() {
        return diproses;
    }

    public int getSisa() {
        return 30 - diproses;
    }
}
