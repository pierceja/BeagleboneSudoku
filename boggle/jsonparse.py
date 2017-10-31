#! /usr/bin/env python3
import json
from pprint import pprint

with open('wordpuzzle.json') as data_file:
	file=data_file.read()
	data=json.loads(file)

file=open("hardoutput.txt","w")


file.write(data['textAnnotations'][0]['description'])
file.close()
