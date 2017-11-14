sudo apt-get update
sudo apt-get upgrade

#Install python
sudo apt install python3-pip
git clone https://github.com/MarkAYoder/adafruit-beaglebone-io-python.git

#Install JDK for Java code
sudo apt-get install default-jdk

#Install ImageMagick
sudo apt-get install imagemagick

# From: http://www.egr.msu.edu/classes/ece480/capstone/fall13/group04/docs/briapp.pdf
sudo apt-get install v4l-utils libv4l-dev imagemagick
gcc -lv4l2 -o grabber grabber.c

# apt-get install graphicsmagick
# npm install -g v4l2camera
# npm install -g gm
# git clone https://github.com/derekmolloy/boneCV.git

# This is for exploring BeagleBone - Chapter 12
sudo apt update
sudo apt install libv4l-dev v4l-utils fswebcam gpicview libav-tools

# 134M and almost 2 hours to install.
sudo apt install libopencv-core-dev

#Install request for API
sudo npm install request

