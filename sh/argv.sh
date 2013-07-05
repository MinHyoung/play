#!/bin/sh

echo "`basename $0` has $# arguments:"
while [ $# -gt "0" ]; do
    echo "$1"
    shift
done
