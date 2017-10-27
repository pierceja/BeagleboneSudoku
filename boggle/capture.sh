# From exploringBB/chp12/fswebcam
#Joey: I changed the code below to use the test25 image
FRAME=wordpuzzle.jpg
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

echo "Sending to Google"
if ./boggle.js $FRAME > $JSON
then echo Success
else echo Failure; exit 1
fi

# echo "Marking boxes"
#./boxText.js $FRAME $JSON

./jsonparse.py
# Append 4 images into one
# convert \( frame0.jpg frame90.jpg +append \) \
#     \( frame180.jpg frame270.jpg +append \) -append tmp.jpg
