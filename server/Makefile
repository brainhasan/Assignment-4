CC ?= $(CROSS_COMPILE)gcc
CFLAGS += -Wall -Werror -g
LDFLAGS += -pthread -lrt

all: aesdsocket

aesdsocket: aesdsocket.c
	$(CC) $(CFLAGS) $(LDFLAGS) -o aesdsocket aesdsocket.c

clean:
	rm -f aesdsocket *.o
