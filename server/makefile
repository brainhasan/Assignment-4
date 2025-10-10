TARGET := aesdsocket
SRCS   := aesdsocket.c
OBJS   := $(SRCS:.c=.o)

CC     ?= gcc
CFLAGS := -Wall

.PHONY: all clean

all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	@echo "Compiling $<"
	$(CC) $(CFLAGS) -c -o $@ $<

clean:
	@echo "Cleaning up..."
	@rm -f *.o $(TARGET)

