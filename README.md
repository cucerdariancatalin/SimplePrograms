# Simple programs

![logo](/res/img/logo.png)

[![GitHub license](https://img.shields.io/github/license/VitasSalvantes/SimplePrograms)](https://github.com/VitasSalvantes/SimplePrograms/blob/main/LICENSE)
[![GitHub issues](https://img.shields.io/github/issues/VitasSalvantes/SimplePrograms)](https://github.com/VitasSalvantes/SimplePrograms/issues)

This repository presents implementations of various algorithms in various programming languages (the
[author](https://github.com/VitasSalvantes) mainly uses [Java](https://www.oracle.com/java/)
and [Kotlin](https://kotlinlang.org/)). You can suggest your own options for implementing existing examples (naming them
in accordance with the samples) or new options in any programming language.

## Table of contents

- [How does it work](#how-does-it-work)
- [List of all programs](#list-of-all-programs)
- [Technologies](#technologies)
- [Development progress](#development-progress)
- [Project statistics](#project-statistics)
- [How to install](#how-to-install)
- [How to contribute](#how-to-contribute)

## How does it work

For quick access to the description of the program and its implementation you can use
the [list of all programs](#List-of-all-programs).

## List of all programs

- [AnagramDetector](#anagramdetector)
- [AtbashCipher](#atbashcipher)
- [BoxComparator](#boxcomparator)
- [BubbleSorter](#bubblesorter)
- [CaesarCipher](#caesarcipher)
- [ChocolateBreaker](#chocolatebreaker)
- [Cinema](#cinema)
- [CollatzConjecture](#collatzconjecture)
- [CommonDenominators](#commondenominators)
- [CountTheDigit](#countthedigit)
- [EuclideanAlgorithm](#euclideanalgorithm)
- [Factorial](#factorial)
- [FibonacciNumbers](#fibonaccinumbers)
- [FirstUniqueCharacterInString](#firstuniquecharacterinstring)
- [FizzBuzz](#fizzbuzz)
- [HappyBirthday](#happybirthday)
- [NumberBaseConverter](#numberbaseconverter)
- [PerfectNumbers](#perfectnumbers)
- [Polynomial](#polynomial)
- [PrimeNumbers](#primenumbers)
- [QuadraticEquation](#quadraticequation)
- [RecamanSequence](#recamansequence)
- [Restaurant](#restaurant)
- [RightRotation](#rightrotation)
- [RotateRectangleArray](#rotaterectanglearray)
- [SimpleCurrencyConverter](#simplecurrencyconverter)
- [TicTacToe](#tictactoe)
- [TortoiseRacing](#tortoiseracing)

### AnagramDetector

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once. For example, the word *anagram* itself can be rearranged into *nag a ram*, also the word
binary into brainy and the word *adobe* into *abode*.

The original word or phrase is known as the subject of the anagram. Any word or phrase that exactly reproduces the
letters in another order is an anagram. Someone who creates anagrams may be called an "anagrammatist", and the goal of a
serious or skilled anagrammatist is to produce anagrams that reflect or comment on their subject.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Anagram))

[Here](src/main/java/com/simpleprograms/AnagramDetector.java) you can see the implementation of the anagram detection in
Java and [here](src/test/java/com/simpleprograms/AnagramDetectorTest.java) - the JUnit tests.

### AtbashCipher

The Atbash cipher is a particular type of monoalphabetic cipher formed by taking the alphabet (or abjad, syllabary,
etc.) and mapping it to its reverse, so that the first letter becomes the last letter, the second letter becomes the
second to last letter, and so on. For example, the Latin alphabet would work like this:

<table>
<tbody>
<tr>
<th>Plain</th>
<td>A</td>
<td>B</td>
<td>C</td>
<td>D</td>
<td>E</td>
<td>F</td>
<td>G</td>
<td>H</td>
<td>I</td>
<td>J</td>
<td>K</td>
<td>L</td>
<td>M</td>
<td>N</td>
<td>O</td>
<td>P</td>
<td>Q</td>
<td>R</td>
<td>S</td>
<td>T</td>
<td>U</td>
<td>V</td>
<td>W</td>
<td>X</td>
<td>Y</td>
<td>Z</td>
</tr>

<tr>
<th>Cipher</th>
<td> Z</td>
<td>Y</td>
<td>X</td>
<td>W</td>
<td>V</td>
<td>U</td>
<td>T</td>
<td>S</td>
<td>R</td>
<td>Q</td>
<td>P</td>
<td>O</td>
<td>N</td>
<td>M</td>
<td>L</td>
<td>K</td>
<td>J</td>
<td>I</td>
<td>H</td>
<td>G</td>
<td>F</td>
<td>E</td>
<td>D</td>
<td>C</td>
<td>B</td>
<td>A</td>
</tr>
</tbody>
</table>

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Atbash))

[Here](src/main/java/com/simpleprograms/AtbashCipher.java) you can see the implementation of the Atbash Cipher in Java
and [here](src/test/java/com/simpleprograms/AtbashCipherTest.java) - the JUnit tests.

### BoxComparator

There are two boxes on the table. The first box has a size of X1 x Y1 x Z1, and the second box has a size of X2 x Y2 x
Z2. You need to determine whether one of the boxes can be put inside the other. It should go in without sticking out.
You can rotate both boxes as you want.

**Important**: two equally sized boxes cannot be placed inside one another. See the third test case as an example of how
the borderline case should be treated.

Input consists of two lines:

the first line contains numbers X1, Y1, Z1; the second line contains numbers X2, Y2, Z2. All numbers are integers and
greater than 0.

Output:

"Box 1 < Box 2", if the first box can be put inside the second box;
"Box 1 > Box 2", if the second box can be put inside the first box; otherwise, output "Incompatible".

This task is on [JetBrains Academy](https://hyperskill.org/learn/step/10613).

[Here](src/main/java/com/simpleprograms/BoxComparator.java) you can see the solution of this task in Java
and [here](src/test/java/com/simpleprograms/BoxComparatorTest.java) - the JUnit tests.

### BubbleSorter

Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the
list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated
until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements "
bubble" to the top of the list.

Take an array of numbers " 5 1 4 2 8" and sort the array from the lowest number to the greatest number using bubble
sort. In each step, elements written in bold are being compared. Three passes will be required:

**First Pass**

( **5 1** 4 2 8 ) → ( **1 5** 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.

( 1 **5 4** 2 8 ) → ( 1 **4 5** 2 8 ), Swap since 5 > 4

( 1 4 **5 2** 8 ) → ( 1 4 **2 5** 8 ), Swap since 5 > 2

( 1 4 2 **5 8** ) → ( 1 4 2 **5 8** ), Now, since these elements are already in order (8 > 5), algorithm does not swap
them.

**Second Pass**

( **1 4** 2 5 8 ) → ( **1 4** 2 5 8 )

( 1 **4 2** 5 8 ) → ( 1 **2 4** 5 8 ), Swap since 4 > 2

( 1 2 **4 5** 8 ) → ( 1 2 **4 5** 8 )

( 1 2 4 **5 8** ) → ( 1 2 4 **5 8** )

Now, the array is already sorted, but the algorithm does not know if it is completed. The algorithm needs one whole pass
without any swap to know it is sorted.

**Third Pass**

( **1 2** 4 5 8 ) → ( **1 2** 4 5 8 )

( 1 **2 4** 5 8 ) → ( 1 **2 4** 5 8 )

( 1 2 **4 5** 8 ) → ( 1 2 **4 5** 8 )

( 1 2 4 **5 8** ) → ( 1 2 4 **5 8** )

This simple algorithm performs poorly in real world use and is used primarily as an educational tool.

(See more
in [Wikipedia](https://en.wikipedia.org/wiki/Bubble_sort#:~:text=Bubble%20sort%2C%20sometimes%20referred%20to%20as%20sinking%20sort%2C,list%20is%20repeated%20until%20the%20list%20is%20sorted.))

[Here](src/main/kotlin/com/simpleprograms/BubbleSorter.kt) you can see example of bubble sort implementation in Kotlin.

### CaesarCipher

In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code or Caesar shift, is one
of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which each letter in
the plaintext is replaced by a letter some fixed number of positions down the alphabet. For example, with a left shift
of 3, D would be replaced by A, E would become B, and so on. The method is named after Julius Caesar, who used it in his
private correspondence.

The transformation can be represented by aligning two alphabets; the cipher alphabet is the plain alphabet rotated left
or right by some number of positions. For instance, here is a Caesar cipher using a left rotation of three places,
equivalent to a right shift of 23 (the shift parameter is used as the key):

<table>
<tbody>
<tr>
<th>Plain</th>
<td>A</td>
<td>B</td>
<td>C</td>
<td>D</td>
<td>E</td>
<td>F</td>
<td>G</td>
<td>H</td>
<td>I</td>
<td>J</td>
<td>K</td>
<td>L</td>
<td>M</td>
<td>N</td>
<td>O</td>
<td>P</td>
<td>Q</td>
<td>R</td>
<td>S</td>
<td>T</td>
<td>U</td>
<td>V</td>
<td>W</td>
<td>X</td>
<td>Y</td>
<td>Z</td>
</tr>

<tr>
<th>Cipher</th>
<td>X</td>
<td>Y</td>
<td>Z</td>
<td>A</td>
<td>B</td>
<td>C</td>
<td>D</td>
<td>E</td>
<td>F</td>
<td>G</td>
<td>H</td>
<td>I</td>
<td>J</td>
<td>K</td>
<td>L</td>
<td>M</td>
<td>N</td>
<td>O</td>
<td>P</td>
<td>Q</td>
<td>R</td>
<td>S</td>
<td>T</td>
<td>U</td>
<td>V</td>
<td>W</td>
</tr>
</tbody>
</table>

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Caesar_cipher))

[Here](src/main/java/com/simpleprograms/CaesarCipher.java) you can see the implementation of Caesar Cipher (I used
offset to the right) in Java and [here](src/test/java/com/simpleprograms/CaesarCipherTest.java) - the JUnit tests.

### ChocolateBreaker

Imagine a chocolate bar. Remember how it is usually split into smaller bits by a special grid?

Now think of chocolate as an N x M rectangle divided into little segments: N segments in length and M in width. Each
segment is 1x1 and unbreakable. Find out whether it is possible to break off exactly K segments from the chocolate with
a single straight line: vertical or horizontal.

This task is on [JetBrains Academy](https://hyperskill.org/learn/step/2170).

[Here](src/main/java/com/simpleprograms/ChocolateBreaker.java) you can see the implementation of this program in Java
and [here](src/test/java/com/simpleprograms/ChocolateBreakerTest.java) - the JUnit tests.

### Cinema

The cinema has **n** rows, each row consists of **m** seats (**n** and **m** do not exceed 20). A two-dimensional matrix
stores the information on the sold tickets: the number **1** means that the ticket for this place is already sold, and
the number **0** means that the place is available. You want to buy **k** tickets to neighboring seats in the same row.
Find whether it can be done.

**Input data format**

On the input, the program gets the number of **n** rows and **m** seats. Then, there are **n** lines, each containing **
m** numbers (**0** or **1**) separated by spaces. The last line contains the number **k**.

**Output data format**

The program should output the number of the row with **k** consecutive available seats. If there are several rows
with **k** available seats, output the first row with these seats. If there is no such a row, output the number 0.

This task is on [JetBrains Academy](https://hyperskill.org/learn/step/1930).

[Here](src/main/java/com/simpleprograms/Cinema.java) you can see the solution of this task in Java.

### CollatzConjecture

The Collatz conjecture in mathematics asks whether repeating two simple arithmetic operations will eventually transform
every positive integer into one. It concerns sequences of integers in which each term is obtained from the previous term
as follows: if the previous term is even, the next term is one half of the previous term. If the previous term is odd,
the next term is 3 times the previous term plus 1. The conjecture is that these sequences always reach 1, no matter
which positive integer is chosen to start the sequence.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Collatz_conjecture))

[Here](src/main/java/com/simpleprograms/CollatzConjecture.java) you can see the implementation of this algorithm in
Java.

### CommonDenominators

The program converts any number of fractions to a common denominator.

The algorithm is quite simple:

1. We get a two-dimensional array, where each element is a fraction and consists of the first number (numerator) and the
   second (denominator), and we simplify it (we reduce the numerator and denominator)
2. We look for the least common multiple for all denominators
3. We bring all fractions to a common denominator (it is equal to the least common multiple)
4. We get the answer as a string like "(numerator_1,denominator_1)(numerator_2,denominator_2)...(numerator_n,
   denominator_n)"

This task is on [Codewars](https://www.codewars.com/kata/54d7660d2daf68c619000d95).

[Here](src/main/java/com/simpleprograms/CommonDenominators.java) you can see the implementation of this program in Java.

### CountTheDigit

In the range from 0 to largestNumber, you need to count the number of repetitions of one arbitrary digit.

This task is on [Codewars](https://www.codewars.com/kata/566fc12495810954b1000030).

[Here](src/main/kotlin/com/simpleprograms/CountTheDigit.kt) you can see the implementation of this program in Kotlin.

### EuclideanAlgorithm

In mathematics, the Euclidean algorithm, or Euclid's algorithm, is an efficient method for computing the
greatest common divisor (GCD) of two integers (numbers), the largest number that divides them both without a remainder.
It is named after the ancient Greek mathematician Euclid, who first described it in his Elements (c. 300 BC). It is an
example of an algorithm, a step-by-step procedure for performing a calculation according to well-defined rules, and is
one of the oldest algorithms in common use. It can be used to reduce fractions to their simplest form, and is a part of
many other number-theoretic and cryptographic calculations.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Euclidean_algorithm))

[Here](src/main/java/com/simpleprograms/EuclideanAlgorithm.java) you can see the implementation of this algorithm in
Java.

### Factorial

In mathematics, the factorial of a positive integer n, denoted by n!, is the product of all positive integers less than
or equal to n:

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/4f850a56fb2d948805be9a7eb87b7b0bbeacb1c5" alt="factorial-formula">

For example,

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/7ef2aaeff6a5a3fe133932ab28153a750783a9ab" alt="factorial-example">

The value of 0! is 1, according to the convention for an empty product.

<table style="text-align:center;">
<tbody>
<tr>
<th>n</th>
<td>0</td>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
<td>5</td>
<td>6</td>
</tr>

<tr>
<th>n!</th>
<td>1</td>
<td>1</td>
<td>2</td>
<td>6</td>
<td>24</td>
<td>120</td>
<td>720</td>
</tr>
</tbody>
</table>

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Factorial))

[Here](src/main/java/com/simpleprograms/Factorial.java) you can see the implementation of Factorial in
Java, [here](src/main/kotlin/com/simpleprograms/Factorial.kt) in
Kotlin and [here](src/main/bash/com/SimplePrograms/factorial.sh) in Bash.

### FibonacciNumbers

In mathematics, the Fibonacci numbers, commonly denoted Fn, form a sequence, called the Fibonacci sequence, such that
each number is the sum of the two preceding ones, starting from 0 and 1. That is,

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/3c667d91153450b3a161371582ee8227af85951f" alt="fibonacci-formula">

and

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/4fa6d281e7a54e08aeffeef7458ddc0884333686" alt="fibonacci-formula">

for n > 1.

The beginning of the sequence is thus:

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/d9941f4184ea7677a056402b98d8b741af937f80" alt="fibonacci-example">

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Fibonacci_number))

[Here](src/main/java/com/simpleprograms/FibonacciNumbers.java) you can see the implementation of Fibonacci numbers in
Java and [here](src/main/kotlin/com/simpleprograms/FibonacciNumbers.kt)
in Kotlin.

### FirstUniqueCharacterInString

You need to find the first non-repeating character in the string that the user enters.

Example:

Given the string: "Hello World! Hello!".

First unique character: "W".

[Here](src/main/java/com/simpleprograms/FirstUniqueCharacterInString.java) you can see the solution to this task in
Java.

### FizzBuzz

The program should print numbers from 1 to 100. But instead of multiples of three, it prints "Fizz", and instead of
numbers that are multiples of five, - "Buzz". Instead of numbers that are multiples of both three and five at the same
time, it prints "FizzBuzz".

[Here](src/main/java/com/simpleprograms/FizzBuzz.java) you can see the solution to the popular FizzBuzz task in Java
and [here](src/main/kotlin/com/simpleprograms/FizzBuzz.kt) in Kotlin.

### HappyBirthday

This simple program prints a cake to the console, the size of which depends on the age of the birthday person.

A similar program is present in
the [Android Basics in Kotlin](https://developer.android.com/codelabs/basic-android-kotlin-training-kotlin-birthday-message?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-one%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-kotlin-birthday-message#8)
by Google.

[Here](src/main/kotlin/com/simpleprograms/HappyBirthday.kt) you can see the implementation of this program in Kotlin.

### NumberBaseConverter

We’re all quite used to our good old decimal system of numerals. But let’s not forget that there are other ways to
count! Whether we need to convert numbers from one system to another just for fun or to store large data more
efficiently, a converter proves helpful. In this project, you will create your own tool that will help you convert
numbers from one system to another.

To convert a fractional number from one base to another, you need to split the number into two parts: integer and
fractional. Convert each part from their base to decimal independently and then convert them (once again, separately) to
the target base. Finally, combine both parts and get the final result!

The most challenging part will probably be converting the decimal fractional part to the target base. Don't worry,
though: since you already know how to convert fractions from decimal to binary, it should not be a problem for you!
Converting fractions from decimal to any base is practically the same: just use the proper denominator, which is the
target base, instead of 2.

This task is on [JetBrains Academy](https://hyperskill.org/projects/181).

[Here](src/main/java/com/simpleprograms/NumberBaseConverter.java) you can see the implementation of this program in
Java.

### PerfectNumbers

In number theory, a perfect number is a positive integer that is equal to the sum of its positive divisors, excluding
the number itself. For instance, 6 has divisors 1, 2 and 3 (excluding itself), and 1 + 2 + 3 = 6, so 6 is a perfect
number.

<table style="text-align:center;">
<tbody>
<tr>
<th>Rank</th>
<td>1</td>
<td>2</td>
<td>3</td>
<td>4</td>
<td>5</td>
<td>6</td>
<td>7</td>
</tr>

<tr>
<th>Perfect number</th>
<td>6</td>
<td>28</td>
<td>496</td>
<td>8128</td>
<td>33550336</td>
<td>8589869056</td>
<td>137438691328</td>
</tr>
</tbody>
</table>

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Perfect_number))

[Here](src/main/java/com/simpleprograms/PerfectNumbers.java) you can see the implementation of a sequence of perfect
numbers in Java.

**Attention! To display more than four numbers, you will have to wait!** :)

### Polynomial

In mathematics and computer science, Horner's method (or Horner's scheme) is an algorithm for polynomial evaluation.
Although named after William George Horner, this method is much older, as it has been attributed to Joseph-Louis
Lagrange by Horner himself, and can be traced back many hundreds of years to Chinese and Persian mathematicians. After
the introduction of computers, this algorithm became fundamental for computing efficiently with polynomials.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Horner%27s_method))

[Here](src/main/kotlin/com/simpleprograms/Polynomial.kt) you can see the implementation of this algorithm in Kotlin.

### PrimeNumbers

A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers. A
natural number greater than 1 that is not prime is called a composite number. For example, 5 is prime because the only
ways of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself. However, 4 is composite because it is a product
(2 × 2) in which both numbers are smaller than 4. Primes are central in number theory because of the fundamental theorem
of arithmetic: every natural number greater than 1 is either a prime itself or can be factorized as a product of
primes that is unique up to their order.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Primes-vs-composites.svg/800px-Primes-vs-composites.svg.png" width="220" height="309" alt="primes-image">

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Prime_number))

[Here](src/main/java/com/simpleprograms/PrimeNumbers.java) you can see the implementation of prime numbers in Java.

### QuadraticEquation

There are many ways to solve quadratic equations. This program uses the discriminant method and the p-q-method and
allows you to solve simple quadratic equations.

Of course, this program has limitations:

- the program works only with decimal fractions (1 = 1.0)
- the equation must be simplified in advance and reduced to the form ax^2 + bx + c = 0

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Quadratic_equation))

[Here](src/main/kotlin/com/simpleprograms/QuadraticEquation.kt) you can see the implementation of this program in
Kotlin.

### RecamanSequence

In mathematics and computer science, the Recaman's sequence (or Recaman's sequence) is a well known sequence defined by
a recurrence relation, because its elements are related to the previous elements in a straightforward way, they are
often defined using recursion.

It takes its name after its inventor Bernardo Recamán Santos (Bogotá, August 5, 1954), a Colombian mathematician.

The Recaman's
sequence <img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/f98223b2560de036588b919037549a149aeb7eda" alt="recaman-sequence-formula">
is defined as:

<img src="https://wikimedia.org/api/rest_v1/media/math/render/svg/89ab504e66d289aeb91cdd3c9b3d88212a13f506" alt="recaman-sequence-formula">

The first terms of the sequence are:

0, 1, 3, 6, 2, 7, 13, 20, 12, 21, 11, 22, 10, 23, 9, 24, 8, 25, 43, 62, 42, 63, 41, 18, 42, 17, 43, 16, 44, 15, 45, 14,
46, 79, 113, 78, 114, 77, 39, 78, 38, 79, 37, 80, 36, 81, 35, 82, 34, 83, 33, 84, 32, 85, 31, 86, 30, 87, 29, 88, 28,
89, 27, 90, 26, 91, 157, 224, 156, 225, 155, ...

I like the drawing better:

<img src="https://upload.wikimedia.org/wikipedia/en/thumb/d/da/Reacam%C3%A1nSequenceDrawing.png/375px-Reacam%C3%A1nSequenceDrawing.png"  alt="recaman-sequence-image">

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Recam%C3%A1n%27s_sequence))

[Here](src/main/java/com/simpleprograms/RecamanSequence.java) you can see the implementation of the Recaman's sequence
in Java.

### Restaurant

This simple program prints the order of a restaurant visitor to the console. During the development,
the [builder pattern](https://en.wikipedia.org/wiki/Builder_pattern) was used.

A similar program is present in
the [Android Basics in Kotlin](https://developer.android.com/codelabs/basic-android-kotlin-training-lists?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-lists#6)
by Google.

[Here](src/main/kotlin/com/simpleprograms/Restaurant.kt) you can see the implementation of this program in Kotlin.

### RightRotation

A **right rotation** is an operation that shifts each element of an array to the right. For example, if an array is
{1,2,3,4,5} and we right rotate it by 1, the new array will be {5,1,2,3,4}. If we rotate it by 2, the new array will be
{4,5,1,2,3}. It goes like this: {1,2,3,4,5} -> {5,1,2,3,4} -> {4,5,1,2,3}.

Write a program that performs a right rotation on an array by a given number.

**Input format**

The first line is an array of numbers. The second line is the number of rotations.

**Output format**

Resulting array

This task is on [JetBrains Academy](https://hyperskill.org/learn/step/3663).

[Here](src/main/java/com/simpleprograms/RightRotation.java) you can see the solution of this task in Java.

### RotateRectangleArray

Given a rectangle array n×m in size. Rotate it by 90 degrees clockwise, by recording the result into the new array m×n
in size.

**Input data format**

Input consists of the two numbers n and m, not exceeding 100, and then an array n×m in size.

**Output data format**

Output the resulting array. Separate numbers by a single space in the output.

This task is on [JetBrains Academy](https://hyperskill.org/learn/step/1927).

[Here](src/main/java/com/simpleprograms/RotateRectangleArray.java) you can see the solution of this task in Java.

### SimpleCurrencyConverter

Have you ever wondered how many Japanese yens you can have for 100 USD? In this project, you will write a program that
converts a provided currency to another.

We will loop our program to make it run continuously until the exit command is prompted.

First, ask the user what they want to do.

Give two choices to users: one is conversion, the other is the exit. Users need to input 1 and 2, respectively.

In case of any wrong input, you need to ask again for the input and repeat the process.

Output the following message: What do you want to convert? After this, users provide input that indicates a currency to
convert from and a currency to convert to. Don't forget to handle all unknown and invalid inputs.

Calculate and output the result that must take 4 decimal places.

To simplify getting input from the console, we're using a JS library, check out
the [documentation](https://github.com/hyperskill/sync-input#usage) to see how it's used.

Don’t forget that when getting the input for the desired currency, the program should be able to process lower and
uppercase letters. Also, if an unknown input is provided by users, print the following message:
"Unknown currency".

The value for the converted amount should not be less than 1. If it's less, output "The amount cannot be less than 1".
If the amount is not a number, output "The amount has to be a number".

Print the following message when users choose to exit the program: "Have a nice day!".

Print the following message when unknown input occurs: "Unknown input".

This task is on [JetBrains Academy](https://hyperskill.org/projects/231).

[Here](src/main/js/com/simpleprograms/SimpleCurrencyConverter.js) you can see the solution of this task in JavaScript.

### TicTacToe

Coming soon...

[Here](src/main/java/com/simpleprograms/TicTacToe.java) you can see the implementation of this game in Java.

### TortoiseRacing

Two tortoises started a race. The first tortoise starts right away, and the second gives is a head start. If the
distance between the tortoises is known, how long will it take for the second to catch up with the first?

We will assume that the speed of the second is always greater than the speed of the first and that all numbers are
non-negative integers.

The answer should be displayed as [hours, minutes, seconds].

This task is on [Codewars](https://www.codewars.com/kata/55e2adece53b4cdcb900006c/java).

[Here](src/main/java/com/simpleprograms/TortoiseRacing.java) you can see the implementation of this program in Java.

## Technologies

- The [Java](https://www.oracle.com/java/) and the
  [Kotlin](https://kotlinlang.org/) ([Temurin Open JDK version 17.0.2](https://adoptium.net/)) programming languages
  were chosen for development.

- Development is carried out in [IntelliJ IDEA](https://www.jetbrains.com/idea/) Ultimate Edition.

- [WakaTime](https://wakatime.com/) is used to track activity.

- [Microsoft To Do](https://todo.microsoft.com/tasks/) is used to schedule tasks.

## Development progress

Development is in an active state.

As there is no clear plan, any interesting programs are welcome.

**Freedom to be creative!**

## Project statistics

[![wakatime](https://wakatime.com/badge/github/VitasSalvantes/SimplePrograms.svg)](https://wakatime.com/badge/github/VitasSalvantes/SimplePrograms)

See more on [WakaTime](https://wakatime.com/@VitasSalvantes/projects/qomqnujpcs)

*Activity tracking started on **July 1, 2021**.*

## How to install

It is enough to copy code of any program and run it in any suitable development environment, or use the command
line/terminal.

## How to contribute

If you want to take part in the development of this project, please
read [this](https://github.com/VitasSalvantes/SimplePrograms/blob/master/CONTRIBUTING.md) file.
