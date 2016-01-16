#!/bin/bash
set -e
version=$1
echo 1 | sudo alternatives --config java  >> alter.txt
chmod 777 alter.txt
#a="$(tail -n 3 alter.txt | awk '{print $1}' | sed -n 1p)"
a="$(cat alter.txt | grep "1.$version" | awk '{print$1}')"
echo -e "$a" | sudo alternatives --config java

