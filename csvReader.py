import csv
import os
import fnmatch

filesList = []

for file in os.listdir("/home/hunter/Documents/csvFiles"):
    if fnmatch.fnmatch(file, "*.csv"):
        filesList.append(file)



count = 1
for i in filesList:
    with open("/home/hunter/Documents/csvFiles/" + i, newline='') as csvfile:
        readCSV = csv.reader(csvfile, delimiter=",")
        frame = []
        for row in readCSV:
            frame = row[4]
        print(file)
        print(frame)
        count += 1
