CC      ?= $(CROSS_COMPILE)gcc
CFLAGS  ?= -Wall -Wextra -g
LDFLAGS ?= 

TARGET  ?= aesdsocket
SRC     ?= aesdsocket.c
OBJ     ?= $(SRC:.c=.o)

.PHONY: all clean

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) $(OBJ) -o $@ $(LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(TARGET) $(OBJ)

