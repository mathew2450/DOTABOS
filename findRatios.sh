#!/bin/bash

for filename in parsed/*; do
	echo "$(basename ${filename%%.*})"
	java -jar FastRatioParse.jar parsed/"$(basename ${filename%%.*})" output/"$(basename ${filename%%.*}).csv" antimage radiant
done

