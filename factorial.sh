#!/bin/bash

#******************************************************#
# The script calculates the factorial of the argument. #
#                                                      #
# Author: VitasSalvantes                               #
# Version: 1.0                                         #
#******************************************************#

echo "File: $0"
echo "Number of arguments: $#"
echo

if [ $# -ne 1 ]; then
  echo "The number of the arguments must be 1!"
  exit 1
fi

if [ "$1" -lt 0 ]; then
  echo "The number must not be negative!"
  exit 1
fi

number=$1
factorial=1

for ((i = number; i > 1; i--)); do
  ((factorial *= i))
done

echo "$number! = $factorial"

exit 0
