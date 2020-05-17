#!/bin/bash

while true
do
#Giving 10 seconds before taking picture
#onecar.jpg is for demonstration purposes
#nocar.jpg is for demonstration purposes
	raspistill -t 10000 -o /home/pi/yolo-object-detection/images/acquiredImage.jpg
	#python detect_car.py --image images/onecar.jpg  --yolo yolo-coco
	#python detect_car.py --image images/nocar.jpg  --yolo yolo-coco
	python detect_car.py --image images/acquiredImage.jpg  --yolo yolo-coco
	rm /home/pi/yolo-object-detection/images/acquiredImage.jpg
done