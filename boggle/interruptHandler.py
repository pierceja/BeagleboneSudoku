#!/usr/bin/env python3
import Adafruit_BBIO.GPIO as GPIO
import time

input="GP1_3"
keepGoing=True

# Set the GPIO pins:
GPIO.setup(input, GPIO.IN)

def updateLED(channel,):
	global keepGoing
	keepGoing=False
	print("Solving")

print("Running...")

GPIO.add_event_detect(input, GPIO.BOTH, callback=updateLED)

try:
	while keepGoing:
		continue

except KeyboardInterrupt:
	print("Cleaning Up")
	GPIO.cleanup()
