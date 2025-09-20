if [ "$#" -ne 2 ]
then
	echo "Incorrect number of args passed"
	exit 1
fi

writefile="$1"
writestr="$2"

dirpath=$(dirname "$writefile")

if ! (mkdir -p "$dirpath" && touch "$writefile")
then
	echo "Failed to create file: $writefile"
	exit 1
fi

if ! echo "$writestr" > "$writefile"
then
	echo "Failed to write $writestr to $writefile"
	exit 1
fi

exit 0



