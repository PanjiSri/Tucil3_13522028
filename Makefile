# Nama file yang akan dihasilkan
OUTPUT := bin/Main

# Semua file Java dalam direktori src
SOURCES := $(wildcard src/*.java)

# Opsi kompilasi
JAVAC := javac
JAVAC_FLAGS := -d bin

# Opsi menjalankan program
JAVA := java
JAVA_FLAGS := -classpath bin

# Target default, yaitu membuat file bin/Main dan menjalankannya
all: $(OUTPUT) run

# Aturan untuk membuat file bin/Main dari file-file Java dalam src/
$(OUTPUT): $(SOURCES)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

# Aturan untuk menjalankan Main.class
run:
	$(JAVA) $(JAVA_FLAGS) Main

