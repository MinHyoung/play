#!/bin/sh

file=
lines=
sleep=
i=0

while [ 1 ]; do
    tail -n $lines $file > /tmp/a.txt
    sleep $sleep
    tail -n $lines $file > /tmp/b.txt
    ans=`diff -u /tmp/a.txt /tmp/b.txt | grep "^+" | grep -n -v "+++" | grep -n " 500\| 502\| 503"`
    i=`expr $i + 1`
    echo "$i : $ans"
done
