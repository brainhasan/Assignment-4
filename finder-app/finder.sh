#!/bin/sh

if [ "$#" -ne 2 ]
then
	echo "Incorrect number of args given"
	echo "Needs both file directory and search string"
	exit 1
fi

filesdir="$1"
searchstr="$2"

echo "file directory: $filesdir"
echo "search str: $searchstr"

if [ ! -d "$filesdir" ]
then
	echo "Directory provided does not exist"
	exit 1
fi

totalFiles=$(find "$filesdir" -type f | wc -l)
matchingLines=$(grep -r "$searchstr" "$filesdir" | wc -l)

echo "The number of files are $totalFiles and the number of matching lines are $matchingLines"
exit 0


