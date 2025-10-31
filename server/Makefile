CC      ?= $(CROSS_COMPILE)gcc
CFLAGS  ?= -Wall -Wextra -g
TARGET  ?= aesdsocket
SRC     ?= aesdsocket.c
OBJ     ?= $(SRC:.c=.o)
LDFLAGS += -Wl,--hash-style=gnu
TARGET_LDFLAGS ?= 

.PHONY: all clean

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) $(CFLAGS) $^ -o $@ $(INCLUDES) $(LDFLAGS) $(TARGET_LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(TARGET) $(OBJ)

