#!/bin/bash
# This script does the intial setup required to get Jenkins running (more to come later)

# Comment out MAXOPENFILES=8192 or else Jenkins will error out upon booting up
sed -e '/MAXOPENFILES=8192/ s/^#*/#/' -i /etc/default/jenkins

# Start Jenkins
service jenkins start

# Begin idling

echo "This is an idle script (infinite loop) to keep the container running"

cleanup ()
{
	kill -s SIGTERM $!
	exit 0
}

trap cleanup SIGINT SIGTERM

while [ 1 ]
do
	sleep 60 &
	wait $!
done

