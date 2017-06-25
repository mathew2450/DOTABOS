#!/bin/bash
cd input/
for filename in /*.bz2; do
	bzip2 -ckd $filename > "$(basename ${filename%%.*})".dem
done
for filename in /*.dem; 
do
		java -jar stats-0.1.0.jar $filename output/"$(basename ${filename%%.*})"		
done
cd ../
cd output/
for filename in /*; 
do
		zip compressed/"$(basename ${filename%%.*})" "$(basename ${filename%%.*})"
done 
cd ../
cd compressed/
for filename in /*; 
do
		php upload.php "$(basename ${filename%%.*})" "$(basename ${filename%%.*})".zip
done 
