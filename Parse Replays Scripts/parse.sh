#!/bin/bash
for filename in input/*.bz2; do
	bzip2 -ckd $filename > input/"$(basename ${filename%%.*})".dem
done
for filename in input/*.dem; 
do
		java -jar stats-0.1.0.jar $filename output/"$(basename ${filename%%.*})"		
done
for filename in output/*; 
do
		zip compressed/"$(basename ${filename%%.*})" output/"$(basename ${filename%%.*})"
done 
for filename in compressed/*; 
do
		php upload.php "$(basename ${filename%%.*})" compressed/"$(basename ${filename%%.*})".zip
done 
