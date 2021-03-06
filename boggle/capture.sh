# From exploringBB/chp12/fswebcam
./on.sh

while true
do
	`sudo ./grabber`
	`sudo fbi -noverbose -T 1 -a grabber000.ppm`
	trap break SIGINT
done

#Joey: I changed the code below to use the test25 image
JSON=wordpuzzle.json


#Joey: I commented out the code below because we are not using a camera
#fswebcam --device /dev/video0 --input 0 --resolution 640x360 \
 #   --rotate 270 \
  #  --no-banner \
   # --jpeg 100 --save $FRAME

# echo Resizing
# 1280x720, 640x360, 320x176
# convert $FRAME -resize 320x180 $FRAME

# echo Converting to gray
# convert $FRAME -colorspace Gray $FRAME
`convert -resize 1200X1200 grabber000.ppm grabber000.jpg`
`convert grabber000.jpg -type Grayscale -negate -define morphology:compose=darken -morphology Thinning 'Rectangle:1x80+0+0<' -negate grabber000.jpg`
`sudo fbi -noverbose -T 1 -a grabber000.jpg`
FRAME=grabber000.jpg
echo "Press button to send to Google"
./interruptHandler.py
echo "Sending to Google"
if ./boggle.js $FRAME > $JSON
then echo Success
else echo Failure; exit 1
fi

# echo "Marking boxes"
#./boxText.js $FRAME $JSON

#Joey: Grab the detected text from the Json file
./jsonparse.py
# Append 4 images into one
# convert \( frame0.jpg frame90.jpg +append \) \
#     \( frame180.jpg frame270.jpg +append \) -append tmp.jpg
echo "Displaying Image"

#Joey: Convert the text file of detected digits to an image
`sudo convert -size 150x150 xc:white -pointsize 12 -fill black \-annotate +15+15 "@correctedoutput.txt" correctedoutput.png`

#Joey: display the sudoku image
`sudo fbi -noverbose -T 1 -a correctedoutput.png`

echo "Press button to solve the puzzle"
#Joey: This program waits for an interrupt on GP1_3 to start solving
./interruptHandler.py

#Joey: This is our puzzle solver program
`java Sudoku correctedoutput.txt` 

#Joey: Convert the resulting solution text file into an image
`sudo convert -size 225x150 xc:white -pointsize 12 -fill black \-annotate +15+15 "@solution.txt" solution.png`

`convert -resize 185X160 boundingbox.PNG boundingbox.PNG`
`composite -blend 30 solution.png boundingbox.PNG composedImg.png`

`sudo fbi -noverbose -T 1 -a composedImg.png`

