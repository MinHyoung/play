#!/bin/sh

echo "Please talk to me ..."

while [ 1 ]; do
    read input_string
    case $input_string in
    hello)
        echo "Hello yourself!"
        ;;


    bye)
        echo "See you again!"
        break
        ;;

    *)
        echo "Sorry, I don't understand"
        ;;
    esac
done

echo
echo "That's all folks"
