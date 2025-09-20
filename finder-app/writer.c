#include <stdio.h>
#include <syslog.h>
#include <errno.h>

int main(int argc, char** argv)
{
	int res = 0;
	openlog("writer", LOG_PID | LOG_CONS, LOG_USER);

	if (argc != 3)
	{
		syslog(LOG_ERR, "Invalid number of args provided");
		res = 1;
		goto cleanup;	
	}

	char* writeFile = argv[1];
	char* writeStr = argv[2];

	syslog(LOG_DEBUG, "Writing %s to %s", writeStr, writeFile);

	FILE *fp;
	fp = fopen(writeFile, "w");

	if (fp == NULL)
	{
		syslog(LOG_ERR, "Could not open file");
		res = 1;
		goto cleanup;
	}

	int bytesWritten = fprintf(fp, "%s",  writeStr);
	if (bytesWritten < 0)
	{
		syslog(LOG_ERR, "Error writing to file");
		res = 1;
		goto cleanup;
	}


cleanup:
	if (fp != NULL)
	{
		fclose(fp);
	}
	closelog();

	return res;

}
