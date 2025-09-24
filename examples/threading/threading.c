#include "threading.h"
#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>

#define DEBUG_LOG(msg,...) //printf("DEBUG: " msg "\n", ##__VA_ARGS__)
#define ERROR_LOG(msg,...) printf("threading ERROR: " msg "\n", ##__VA_ARGS__)

// Hilfsfunktion: Millisekunden in Mikrosekunden
#define MS_TO_US(ms) ((ms) * 1000)

void* threadfunc(void* thread_param)
{
    struct thread_data* data = (struct thread_data*) thread_param;

    // Erst warten, bevor Mutex gesperrt wird
    usleep(MS_TO_US(data->wait_to_obtain_ms));

    // Mutex sperren
    if (pthread_mutex_lock(data->mutex) != 0) {
        ERROR_LOG("Failed to acquire mutex\n");
        data->thread_complete_success = false;
        return data;
    }

    // Während Mutex gehalten wird, warten
    usleep(MS_TO_US(data->wait_to_release_ms));

    // Mutex freigeben
    if (pthread_mutex_unlock(data->mutex) != 0) {
        ERROR_LOG("Failed to release mutex\n");
        data->thread_complete_success = false;
        return data;
    }

    data->thread_complete_success = true;
    return data;
}

bool start_thread_obtaining_mutex(pthread_t *thread, pthread_mutex_t *mutex, int wait_to_obtain_ms, int wait_to_release_ms)
{
    struct thread_data* data = malloc(sizeof(struct thread_data));
    if (!data) {
        ERROR_LOG("Failed to allocate memory for thread_data\n");
        return false;
    }

    data->mutex = mutex;
    data->wait_to_obtain_ms = wait_to_obtain_ms;
    data->wait_to_release_ms = wait_to_release_ms;
    data->thread_complete_success = false;

    if (pthread_create(thread, NULL, threadfunc, data) != 0) {
        ERROR_LOG("Failed to create thread\n");
        free(data);
        return false;
    }

    return true;
}

