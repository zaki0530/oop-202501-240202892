# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: [Tuliskan judul topik, misalnya "Class dan Object"]

## Identitas
- Nama  : [Abu zaki]
- NIM   : [240202892]
- Kelas : [3IKRB]

---

## Tujuan
agar bisa memahami mata kuliah minggu ini 

---

## Dasar Teori
1.Pemrograman Berorientasi Objek (OOP): Paradigma yang berfokus pada Objek (instansiasi dari Kelas). Data dan perilaku (metode) dibungkus menjadi satu unit. Contoh di praktikum adalah class Mahasiswa.
2.Pemrograman Prosedural: Paradigma yang berfokus pada urutan instruksi dan prosedur (fungsi atau metode) yang dijalankan. Data biasanya terpisah dari prosedur yang memprosesnya.
3.Pemrograman Fungsional (Dasar): Paradigma yang memperlakukan komputasi sebagai evaluasi fungsi matematika, berfokus pada input dan output (ekspresi) tanpa mengubah state global. (Dalam Java, fitur ini diwujudkan oleh lambda dan Stream API).
4.Metode Statis (static): Metode yang terkait dengan kelas itu sendiri, bukan dengan objek tertentu. Digunakan dalam pendekatan Prosedural atau main method (public static void main).

---

## Langkah Praktikum
1.Setup Awal: Melakukan instalasi dan konfigurasi lingkungan Java Development Kit (JDK) dan Visual Studio Code (VS Code) untuk menjalankan proyek Java serta install git sebagai persiapan untuk mengelola proyek yang lebih kompleks dan agar terbiasa dengan alur kerja profesional.
2.Implementasi OOP: Membuat file HelloOOP.java dan mendefinisikan class Mahasiswa dengan atribut nama dan nim, serta metode sapa() dan konstruktor.
3.Implementasi Prosedural: Membuat file HelloProsedural.java yang menggunakan metode statis (sapa()) untuk menampilkan data secara berurutan.
4.Implementasi Fungsional: Membuat file HelloFunctional.java yang menampilkan hasil sebagai ekspresi sederhana dari data nama dan nim.
5.Eksekusi dan Verifikasi: Setiap file dikompilasi (javac) dan dieksekusi (java) untuk memverifikasi output yang benar.
6.Dokumentasi: Pengambilan screenshot hasil eksekusi untuk laporan.

---

## Kode Program
1.HelloProsedural.java
package main.java.com.upb.agripos;

public class HelloProsedural {
        public static void sapa(String nama, String nim){
        System.out.println("Hello World, I am "+ nama + " -"+ nim);
    }

    public static void main(String[] args) {
        
        // Prosedural Tanpa Method
        String nama = "Abu zaki";
        String nim = " 240202892";
        System.out.println("Hello World, I am "+ nama + " -"+ nim);
        

        // Prosedural dengan method
        sapa("Abu zaki", " 240202892");
        // Bisa dipanggil secara berulang

    }

    
}

2.HelloOop.java
package main.java.com.upb.agripos;
class Mahasiswa {
    String nama;
    String nim; // Menggunakan String untuk NIM

    // Konstruktor dengan nama dan NIM
    Mahasiswa(String n, String ni){
        nama = n;
        nim = ni;
    }

    // Metode sapa
    void sapa(){
        System.out.println("Halo, nama saya " + nama + " dengan NIM " + nim + ".");
    }
}
public class HelloOop {
    public static void main(String[] args) {
        // Membuat objek Mahasiswa
        Mahasiswa m = new Mahasiswa("Abu zaki", "240202892");

        // Memanggil metode sapa
        m.sapa();
    }
    
}

3.HelloFunctional.java
package main.java.com.upb.agripos;

public class HelloFunctional {
    public static void main(String[] args) {
        String nim = "240202892";
        String nama = "Abu zaki"; 

        // Tampilan yang diminta
        System.out.println("Hello World, I am " + nama + " -" + nim);

        // Pesan penutup
        System.out.println("Program Functional Selesai, Terimakasih");
    }
    
}

---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots(107).png screenshots(108).png screenshots(109).png)
)
---

## Analisis
A. Perbedaan Struktur Paradigma

1.fitur kunci: HelloOOP.java (Berorientasi Objek), HelloProsedural.java (Prosedural), HelloFunctional.java (Fungsional Dasar);
2.unit utama: HelloOOP.java (Berorientasi Objek) = Kelas (Mahasiswa) dan Objek (m). Digunakan untuk memodelkan entitas HelloProsedural.java (Prosedural) = Metode/prosedur (sapa()). Digunakan untuk mendefinisikan urutan langkah HelloFunctional.java (Fungsional Dasar) = Fungsi statis (main) sebagai evaluasi ekspresi data.
3.data dan fungsi: HelloOOP.java (Berorientasi Objek) = Daata (nama, nim) terikat (terenkapsulasi) pada objek HelloProsedural.java (Prosedural) = Data dan fungsi (sapa()) dipisahkan. Data dilewatkan melalui argumen HelloFunctional.java (Fungsional Dasar) = Data diolah dalam satu fungsi/ekspresi untuk hasil akhir.
4.pemanggilan: HelloOOP.java (Berorientasi Objek) = Melalui objek yang diinstansiasi (m.sapa();) HelloProsedural.java (Prosedural) = Pemanggilan fungsi langsung, seringkali statis (sapa(data);) HelloFunctional.java (Fungsional Dasar) = Ekspresi langsung di dalam main melalui concatenation.
5.fokus: HelloOOP.java (Berorientasi Objek) = Bagaimana entitas (objek) berinteraksi dan mengelola datanya sendiri HelloProsedural.java (Prosedural) = Langkah demi langkah (algoritma) untuk menyelesaikan suatu tugas HelloFunctional.java (Fungsional Dasar) = Apa hasil yang didapatkan dari data input. B. Cara Kerja (Flow Control) Kode
6.HelloOOP.java: Alur dimulai dengan Instansiasi (new Mahasiswa(...)), yang menciptakan objek m di memori dan memanggil konstruktor untuk mengisi data internal objek. Perilaku dipanggil secara eksklusif melalui objek tersebut (m.sapa()), menekankan konsep enkapsulasi.
7.HelloProsedural.java: Alur bersifat Linear. Program mendeklarasikan data lokal di main, menjalankan instruksi cetak langsung, lalu memanggil prosedur sapa() dengan melewatkan salinan data tersebut sebagai parameter.
8.HelloFunctional.java: Program berfokus pada Ekspresi. Variabel didefinisikan, dan kemudian satu ekspresi tunggal ("Hello World, I am " + nama + " -" + nim) dievaluasi (digabungkan) untuk menghasilkan output yang final. C. Kendala dan Penanganan
9.Kendala awal: Ditemukan kendala tipe data (menggunakan int untuk umur/NIM di awal implementasi OOP) serta inkonsistensi penulisan nama (tidak menggunakan kapitalisasi) pada file fungsional.
10.Penanganan: Kendala diatasi dengan: a. Mengganti tipe data int dengan String untuk atribut nim pada semua implementasi agar lebih fleksibel. b. Melakukan Kapitalisasi pada variabel nama ("Kayla Putri Arsonisr") untuk mengikuti konvensi penulisan dan memastikan output yang lebih formal.


## Kesimpulan
Praktikum ini berhasil menunjukkan bahwa Java adalah bahasa multi-paradigma. OOP unggul dalam strukturisasi kode untuk aplikasi besar dengan mengikat data dan perilaku ke dalam kelas. Prosedural cepat dan langsung untuk tugas sederhana, sementara pendekatan Fungsional (walaupun sederhana) menunjukkan fokus pada evaluasi ekspresi data, menjadikannya bersih dari side effect. Pemahaman ketiga paradigma ini adalah dasar penting dalam pengembangan perangkat lunak Java.
---

## Quiz
1.Apakah OOP selalu lebih baik dari prosedural? Jawaban: Tidak. OOP lebih baik untuk aplikasi kompleks, besar, dan membutuhkan pemodelan entitas (seperti Mahasiswa). Prosedural lebih baik untuk skrip atau program kecil yang hanya menjalankan tugas berurutan sederhana.
2.Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural? Jawaban: Ketika fokus utama adalah transformasi data (memproses list, filter, map) dan ketika dibutuhkan paralelisme (multithreading) karena sifatnya yang menghindari state yang dapat diubah (mutable state).
3.Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi? Jawaban: OOP dan Fungsional memiliki maintainability dan scalability yang tinggi. OOP unggul karena enkapsulasi mengisolasi perubahan, sementara Fungsional unggul karena fungsi murni mudah diuji. Prosedural memiliki maintainability dan scalability rendah pada skala besar.
4.Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural? Jawaban: Aplikasi POS (Point of Sale) penuh dengan entitas seperti Produk, Transaksi, dan Karyawan. OOP mampu mengikat data dan perilaku ini secara logis (misalnya, Produk tahu cara menghitung harganya), sehingga sistem tidak berantakan saat fitur baru ditambahkan.
5.Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)? Jawaban: FP menggunakan Fungsi Tingkat Tinggi dan Stream API (seperti filter(), map()) yang memungkinkan Anda menyatakan apa yang ingin dilakukan pada data, tanpa harus menulis ulang loop (for atau while) yang prosedural dan berulang (boilerplate).
