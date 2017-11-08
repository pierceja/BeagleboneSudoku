#! /usr/bin/env python3
import json
from pprint import pprint

with open('wordpuzzle.json') as data_file:
	file=data_file.read()
	data=json.loads(file)

file=open("output.txt","w")


file.write(data['textAnnotations'][0]['description'])
file.close()
file=open("output.txt", "r")
file2=open("correctedoutput.txt", "w")
for line in file:
	newLine = True
	for digit in line:
		if(digit=="\n"):
			file2.write(digit)
		else:
			file2.write(digit + " ")
file.close()
