#!/bin/bash

#
# MIT License
#
# Copyright (c) 2022 Ivan Bobrov
#
# Permission is hereby granted, free of charge, to any person obtaining a copy of this
# software and associated documentation files (the "Software"), to deal in the Software
# without restriction, including without limitation the rights to use, copy, modify, merge,
# publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to
# whom the Software is furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all copies or
# substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
#

#******************************************************#
# The script calculates the factorial of the argument. #
#                                                      #
# Author: Ivan Bobrov                                  #
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
