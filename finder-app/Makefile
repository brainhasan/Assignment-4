
CROSS_COMPILE ?=
CC = $(CROSS_COMPILE)gcc

TARGET = writer
SRC = writer.c
OBJ = $(SRC:.c=.o)

all: $(TARGET)

$(TARGET): $(SRC)
	$(CC) $(SRC) -o $(TARGET)

clean:
	rm -f $(TARGET)
