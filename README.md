# Tucil3_13522028

##  Penyelesaian Permainan Word Ladder Menggunakan Algoritma UCS, Greedy Best First Search, dan A*

```
Oleh:
    13522028 - Panji Sri Kuncara Wisma
```

## Deskripsi Program

Program **java** berbasis **CLI (Command Line Interface)** pada repository ini digunakan untuk menyelesaian permainan word ladder menggunakan algoritma UCS, Greedy Best First Search, dan A*. Word ladder (juga dikenal sebagai Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, atau word golf) adalah salah satu permainan kata yang terkenal bagi seluruh kalangan. Word ladder ditemukan oleh Lewis Carroll, seorang penulis dan matematikawan, pada tahun 1877. Pada permainan ini, pemain diberikan dua kata yang disebut sebagai start word dan end word. Untuk memenangkan permainan, pemain harus menemukan rantai kata yang dapat menghubungkan antara start word dan end word. Banyaknya huruf pada start word dan end word selalu sama. Tiap kata yang berdekatan dalam rantai kata tersebut hanya boleh berbeda satu huruf saja. Pada permainan ini, diharapkan solusi optimal, yaitu solusi yang meminimalkan banyaknya kata yang dimasukkan pada rantai kata. 


## Struktur Program
```
.
├── bin/
│   ├── A_Star.class
│   ├── Greedy.class
│   ├── Main.class
│   ├── SearchAlgorithm.class
│   ├── StringIntegerPair.class
│   ├── UCS.class
│   └── Worddiff.class
├── doc/
│   └── Tucil3_K02_13522028.pdf
├── src/
│   ├── A_Star.java
│   ├── Greedy.java
│   ├── Main.java
│   ├── SearchAlgorithm.java
│   ├── StringIntegerPair.java
│   ├── UCS.java
│   └── Worddiff.java
├── test/
│   ├── test1.txt
│   ├── test2.txt
│   ├── test3.txt
│   ├── test4.txt
│   ├── test5.txt
│   └── test6.txt
├── Makefile
├── README.md
└── run.bat
```

## Requirements

Berikut adalah versi java minimal yang disarankan :

- Windows

    - java 22.0.1 2024-04-16
    - Java(TM) SE Runtime Environment (build 22.0.1+8-16)
    - Java HotSpot(TM) 64-Bit Server VM (build 22.0.1+8-16, mixed mode, sharing)

- Linux
    - openjdk 21.0.2 2024-01-16
    - OpenJDK Runtime Environment (build 21.0.2+13-Ubuntu-122.04.1)
    - OpenJDK 64-Bit Server VM (build 21.0.2+13-Ubuntu-122.04.1, mixed mode, sharing)



## Cara mengkompilasi dan menjalankan program

1. Clone repository ini
```
    git clone https://github.com/PanjiSri/Tucil3_13522028.git
```
2. Masuk ke folder path yang setara dengan Makefile dan run.bat

```
    cd Tucil3_13522028
```
3. Jalankan program

    - Apabila anda menggunakan Windows gunakanlah run.bat untuk menjalankan program

        ```
        ./run.bat
        ```

    - Apabila anda menggunakan Linux atau WSL2 gunakanlah Makefile untuk menjalankan program

        ```
        make
        ```

4. Isi masukkan atau inputan sesuai yang dinginkan dengan mengikuti panduan pada CLI (Command Line Interface)

    - Pada bagian ini ketikkan kata mulai yang anda inginkan

        ```
        Ketikkan Kata Mulai: 
        ```
    - Pada bagian ini ketikkan kata tujuan yang anda inginkan

        ```
        Ketikkan Kata Mulai: 
        ```


5. Program sudah diuji coba dan dapat berjalan. Jika ada error berikut adalah hal-hal yang bisa dilakukan : 

    - Castikan kembali inputan sudah sesuai petunjuk yang diberikan.
    - Coba untuk menggunakan versi java yang disarankan
    - Pastikan sudah memiliki ekstensi Makefile Tools

