# Nama file yang akan dihasilkan
OUTPUT := bin/Main

SOURCES := $(wildcard src/*.java)

JAVAC := javac

JAVAC_FLAGS := -d bin

JAVA := java

JAVA_FLAGS := -classpath bin

all: $(OUTPUT) run

$(OUTPUT): $(SOURCES)
	$(JAVAC) $(JAVAC_FLAGS) $(SOURCES)

run:
	$(JAVA) $(JAVA_FLAGS) Main

