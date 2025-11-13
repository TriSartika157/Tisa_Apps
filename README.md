# UTS Pemrograman Mobile – Tisa Apps

---

##  Deskripsi Umum
Aplikasi **Tisa Apps** dikembangkan untuk memenuhi **Ujian Tengah Semester (UTS)** mata kuliah **Pemrograman Mobile** pada Program Studi **Informatika - Institut Teknologi Nasional**.  
Proyek ini dibangun menggunakan **Android Studio (Kotlin)** dengan penerapan berbagai **layout**, **widget**, dan prinsip **User Interface (UI)** serta **User Experience (UX)**.

Aplikasi ini terdiri dari **Splash Screen** dan **Dashboard utama** dengan **Bottom Navigation Bar**, yang menghubungkan 5 menu utama:
> Biodata • Kontak • Kalkulator • Cuaca • Berita

---

##  Tujuan Pengembangan
Tujuan aplikasi ini adalah untuk mengimplementasikan konsep dasar pembuatan aplikasi mobile berbasis Android, khususnya:
- Penggunaan **Activity** dan **Fragment**
- Penerapan **navigasi antar halaman (Bottom Navigation)**
- Pembuatan **tampilan interaktif dan responsif**
- Pemanfaatan **widget umum Android** (EditText, Spinner, RadioButton, RecyclerView, dll)

---

##  Struktur dan Deskripsi Halaman

| No | Halaman | Deskripsi |
|----|----------|-----------|
| 1 | **Splash Screen** | Tampilan pembuka selama 5 detik yang berisi judul aplikasi, foto pengembang, nama, dan NIM. Setelah itu masuk otomatis ke Dashboard. |
| 2 | **Dashboard** | Halaman utama dengan navigasi bawah (*Bottom Navigation Bar*) untuk berpindah antar menu. |
| 3 | **Biodata** | Halaman profil interaktif berisi foto, input teks (nama, NIM), dropdown pilihan Program Studi, radio button jenis kelamin, dan date picker untuk tanggal lahir. |
| 4 | **Kontak** | Menampilkan daftar 15 kontak statis dengan foto profil melingkar, nama, dan nomor telepon menggunakan RecyclerView dan Adapter. |
| 5 | **Kalkulator** | Kalkulator sederhana dengan fungsi tambah (+), kurang (-), kali (×), bagi (÷), kuadrat, akar kuadrat, dan tombol hapus (C). |
| 6 | **Cuaca** | Menampilkan data cuaca **statis** dari file `cuaca.json` (suhu, kelembapan, dan kondisi cuaca) dengan ikon animasi yang menarik. |
| 7 | **Berita** | Daftar berita statis menggunakan RecyclerView dalam bentuk CardView berisi gambar, judul, dan deskripsi singkat. |

---

## 🖼️ Screenshot Aplikasi

| Halaman | Tampilan |
|----------|-----------|
| Splash Screen | ![Splash](screenshots/splash.jpg) |
| Dashboard | ![Dashboard](screenshots/dashboard.jpg) |
| Biodata | ![Biodata](screenshots/biodata.jpg) |
| Kontak | ![Kontak](screenshots/kontak.jpg) |
| Kalkulator | ![Kalkulator](screenshots/kalkulator.jpg) |
| Cuaca | ![Cuaca](screenshots/cuaca.jpg) |
| Berita | ![Berita](screenshots/berita.jpg) |

> Semua desain dibuat dengan prinsip **clean design**, **responsif**, dan **mudah digunakan** untuk meningkatkan pengalaman pengguna (UX).

---

##  Teknologi yang Digunakan
- **Bahasa Pemrograman:** Kotlin  
- **IDE:** Android Studio  
- **Struktur Navigasi:** Bottom Navigation dengan Fragment  
- **Library & Komponen:**
  - RecyclerView + Adapter
  - CardView
  - Spinner (Dropdown)
  - RadioGroup dan RadioButton
  - DatePickerDialog
  - EditText dan Button
- **Sumber Data:**  
  - Data statis dari file lokal (`cuaca.json`, array/list di Kotlin)

---

##  Cara Menjalankan Proyek

1. **Clone repository ini:**
   ```bash
   git clone https://github.com/USERNAME/TisaApps.git
