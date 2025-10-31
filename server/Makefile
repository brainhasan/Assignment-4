CC      ?= $(CROSS_COMPILE)gcc
CFLAGS  ?= -Wall -Wextra -g
TARGET  ?= aesdsocket
SRC     ?= aesdsocket.c
OBJ     ?= $(SRC:.c=.o)

# Use the flags Yocto provides
CFLAGS  += $(TARGET_CFLAGS)
LDFLAGS += $(TARGET_LDFLAGS)

.PHONY: all clean

all: $(TARGET)

$(TARGET): $(OBJ)
	$(CC) $(CFLAGS) $^ -o $@ $(INCLUDES) $(LDFLAGS)

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

clean:
	rm -f $(TARGET) $(OBJ)

