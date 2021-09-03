# Simple programs

This repository presents implementations of various algorithms in various programming languages (the [author](https://github.com/VitasSalvantes) mainly uses Java). You can suggest your own options for implementing
existing examples (naming them in accordance with the samples) or new options in any programming language.

## Content

- [How does it work](#How-does-it-work)
- [List of all programs](#List-of-all-programs)
- [Technologies](#Technologies)
- [Development progress](#Development-progress)
- [Project statistics](#Project-statistics)
- [How to install](#How-to-install)
- [How to contribute](#How-to-contribute)

## How does it work

For quick access to the description of the program and its implementation you can use
the [list of all programs](#List-of-all-programs).

## List of all programs

- [AmountOfSalaries](#AmountOfSalaries)
- [AnagramDetection](#AnagramDetection)
- [AtbashCipher](#AtbashCipher)
- [ArrayInitialization](#ArrayInitialization)
- [BubbleSort](#BubbleSort)
- [CaesarCipher](#CaesarCipher)
- [ChangingArrayType](#ChangingArrayType)
- [CodeWordCipher](#CodeWordCipher)
- [CommonDenominators](#CommonDenominators)
- [ConsoleCalc](#ConsoleCalc)
- [CountTheDigit](#CountTheDigit)
- [ExchangedValues](#ExchangedValues)
- [Factorial](#Factorial)
- [FibonacciNumbers](#FibonacciNumbers)
- [FirstUniqueCharacterInString](#FirstUniqueCharacterInString)
- [FizzBuzz](#FizzBuzz)
- [HappyBirthday](#HappyBirthday)
- [HelloWorld](#HelloWorld)
- [IsSquare](#IsSquare)
- [MultiplicationTableForNumber](#MultiplicationTableForNumber)
- [PerfectNumbers](#PerfectNumbers)
- [PrimeNumbers](#PrimeNumbers)
- [QuadraticEquation](#QuadraticEquation)
- [RecamanSequence](#RecamanSequence)
- [SquareEveryDigit](#SquareEveryDigit)
- [TortoiseRacing](#TortoiseRacing)

### AmountOfSalaries

[Here](AmountOfSalaries.java) you can see how the static method of summing salaries of two workers (instances of the
same class) is implemented in Java.

### AnagramDetection

An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the
original letters exactly once. For example, the word *anagram* itself can be rearranged into *nag a ram*, also the word
binary into brainy and the word *adobe* into *abode*.

The original word or phrase is known as the subject of the anagram. Any word or phrase that exactly reproduces the
letters in another order is an anagram. Someone who creates anagrams may be called an "anagrammatist", and the goal of a
serious or skilled anagrammatist is to produce anagrams that reflect or comment on their subject.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Anagram))

[Here](AnagramDetection.java) you can see the implementation of the anagram detection in Java.

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

[Here](AtbashCipher.java) you can see the implementation of Atbash Cipher in Java.

### ArrayInitialization

[Here](ArrayInitialization.java) you can see how array initialization is implemented in the class constructor in Java.

### BubbleSort

Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that repeatedly steps through the
list, compares adjacent elements and swaps them if they are in the wrong order. The pass through the list is repeated
until the list is sorted. The algorithm, which is a comparison sort, is named for the way smaller or larger elements "
bubble" to the top of the list.

Take an array of numbers " 5 1 4 2 8" and sort the array from lowest number to greatest number using bubble sort. In
each step, elements written in bold are being compared. Three passes will be required:

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

[Here](BubbleSort.kt) you can see example of bubble sort implementation in Kotlin.

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

[Here](CaesarCipher.java) you can see the implementation of Caesar Cipher (i used offset to the right) in Java.

### ChangingArrayType

[Here](ChangingArrayType.java) you can see how a class with two arrays (the first with int values, the second with
String values) is implemented in Java. The second array takes all the values of the first array, converts them to String
type and stores them in reverse order.

### CodeWordCipher

Substitution of single letters separately — simple substitution — can be demonstrated by writing out the alphabet in
some order to represent the substitution. This is termed a substitution alphabet. The cipher alphabet may be shifted or
reversed (creating the Caesar and Atbash ciphers, respectively) or scrambled in a more complex fashion, in which case it
is called a mixed alphabet or deranged alphabet. Traditionally, mixed alphabets may be created by first writing out a
keyword, removing repeated letters in it, then writing all the remaining letters in the alphabet in the usual order.

Using this system, the keyword "zebras" gives us the following alphabets:

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
<td>Z</td>
<td>E</td>
<td>B</td>
<td>R</td>
<td>A</td>
<td>S</td>
<td>C</td>
<td>D</td>
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
<td>T</td>
<td>U</td>
<td>V</td>
<td>W</td>
<td>X</td>
<td>Y</td>
</tr>
</tbody>
</table>

(See more in [Wikipedia](https://en.m.wikipedia.org/wiki/Substitution_cipher))

[Here](CodeWordCipher.java) you can see the implementation of code word cipher in Java.

### CommonDenominators

This simple program converts any number of fractions to a common denominator.

The algorithm of work is quite simple:

1. We get a two-dimensional array, where each element is a fraction and consists of the first number (numerator) and the
   second (denominator), and we simplify it (we reduce the numerator and denominator)
2. We are looking for the least common multiple for all denominators
3. We bring all fractions to a common denominator (it is equal to the least common multiple)
4. We get the answer as a string like "(numerator_1,denominator_1)(numerator_2,denominator_2)...(numerator_n,
   denominator_n)"

This task is on [Codewars](https://www.codewars.com/kata/54d7660d2daf68c619000d95).

[Here](CommonDenominators.java) you can see the implementation of this program in Java.

### ConsoleCalc

[Here](ConsoleCalc.java) you can see the implementation of a simple calculator in Java. You can enter an unlimited
number of numbers and perform various mathematical operations with them.

### ExchangedValues

[Here](ExchangedValues.java) you can see how to exchange values between two variables without using a third in Java
and [here](ExchangedValues.kt) in Kotlin.

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

[Here](Factorial.java) you can see the implementation of Factorial in Java, [here](Factorial.kt) in Kotlin
and [here](Factorial.py) in Python.

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

[Here](FibonacciNumbers.java) you can see the implementation of Fibonacci numbers in Java, [here](FibonacciNumbers.kt)
in Kotlin and [here](FibonacciNumbers.py) in Python.

### FirstUniqueCharacterInString

You need to find the first non-repeating character in the string that the user enters.

Example:

Given the string: "Hello World! Hello!".

First unique character: "W".

[Here](FirstUniqueCharacterInString.java) you can see the solution to this task in Java.

### FizzBuzz

The program should print numbers from 1 to 100. But instead of multiples of three, it prints "Fizz", and instead of
numbers that are multiples of five, - "Buzz". Instead of numbers that are multiples of both three and five at the same
time, it prints "FizzBuzz".

[Here](FizzBuzz.java) you can see the solution to the popular FizzBuzz task in Java and [here](FizzBuzz.kt) in Kotlin.

### HappyBirthday

This simple program prints a cake to the console, the size of which depends on the age of the birthday person.

A similar program is present in
the [Android Basics in Kotlin](https://developer.android.com/codelabs/basic-android-kotlin-training-kotlin-birthday-message?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-one%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-kotlin-birthday-message#8)
by Google.

[Here](HappyBirthday.kt) you can see the implementation of this program in Kotlin.

### HelloWorld

A "Hello, World!" program generally is a computer program that outputs or displays the message "Hello, World!". Such a
program is very simple in most programming languages, and is often used to illustrate the basic syntax of a programming
language. It is often the first program written by people learning to code. It can also be used as a sanity test to make
sure that a computer software intended to compile or run source code is correctly installed, and that the operator
understands how to use it.

While small test programs have existed since the development of programmable computers, the tradition of using the
phrase "Hello, World!" as a test message was influenced by an example program in the seminal 1978 book "The C
Programming Language". The example program in that book prints "", and was inherited from a 1974 Bell Laboratories
internal memorandum by Brian Kernighan, "Programming in C: A Tutorial".

(See more in [Wikipedia](https://en.wikipedia.org/wiki/%22Hello,_World!%22_program))

[Here](HelloWorld.java) you can see an example of this program in Java and [here](HelloWorld.kt) in Kotlin.

### IsSquare

In mathematics, a square is the result of multiplying a number by itself.

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Square_(algebra)))

[Here](IsSquare.java) you can see an example of defining a square in Java.

### MultiplicationTableForNumber

This is a simple program that prints the multiplication table for a single number from 0 to 10.

This task is on [Codewars](https://www.codewars.com/kata/5a2fd38b55519ed98f0000ce).

[Here](MultiplicationTableForNumber.java) you can see the implementation of this program in Java
and [here](MultiplicationTableForNumber.kt) in Kotlin.

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

[Here](PerfectNumbers.java) you can see the implementation of a sequence of perfect numbers in Java.

**Attention! To display more than four numbers, you will have to wait!** :)

### PrimeNumbers

A prime number (or a prime) is a natural number greater than 1 that is not a product of two smaller natural numbers. A
natural number greater than 1 that is not prime is called a composite number. For example, 5 is prime because the only
ways of writing it as a product, 1 × 5 or 5 × 1, involve 5 itself. However, 4 is composite because it is a product (2 ×

2) in which both numbers are smaller than 4. Primes are central in number theory because of the fundamental theorem of
   arithmetic: every natural number greater than 1 is either a prime itself or can be factorized as a product of primes
   that is unique up to their order.

<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Primes-vs-composites.svg/800px-Primes-vs-composites.svg.png" width="220" height="309" alt="primes-image">

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Prime_number))

[Here](PrimeNumbers.java) you can see the implementation of prime numbers in Java.

### QuadraticEquation

There are many ways to solve quadratic equations. This program uses the discriminant method and the p-q-method and
allows you to solve simple quadratic equations.

Of course, this program has limitations:

- the program works only with decimal fractions (1 = 1.0)
- the equation must be simplified in advance and reduced to the form ax^2 + bx + c = 0

(See more in [Wikipedia](https://en.wikipedia.org/wiki/Quadratic_equation))

[Here](QuadraticEquation.kt) you can see the implementation of this program in Kotlin.

### RecamanSequence

In mathematics and computer science, the Recamán's sequence (or Recaman's sequence) is a well known sequence defined by
a recurrence relation, because its elements are related to the previous elements in a straightforward way, they are
often defined using recursion.

It takes its name after its inventor Bernardo Recamán Santos (Bogotá, August 5, 1954), a Colombian mathematician.

The Recamán's
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

[Here](RecamanSequence.java) you can see the implementation of the Recaman sequence in Java.

### SquareEveryDigit

It's necessary to display the squares of all digits included in the number entered by the user.

For example, if we write 139, we get 1981, because 1\*1=1, 3\*3=9, 9\*9=81.

[Here](SquareEveryDigit.java) you can see the implementation of this algorithm in Java.

### TortoiseRacing

Two tortoises started a race. The first tortoise starts right away, and the second gives is a head start. If the
distance between the tortoises is known, how long will it take for the second to catch up with the first?

We will assume that the speed of the second is always greater than the speed of the first and that all numbers are
non-negative integers.

The answer should be displayed as [hours, minutes, seconds].

This task is on [Codewars](https://www.codewars.com/kata/55e2adece53b4cdcb900006c/java).

[Here](TortoiseRacing.java) you can see the implementation of this program in Java.

## Technologies

- [Java](https://www.oracle.com/java/) ([AdoptOpenJDK version 11.0.10](https://adoptopenjdk.net/)),
  [Kotlin](https://kotlinlang.org/) ([AdoptOpenJDK version 11.0.10](https://adoptopenjdk.net/))
  and [Python](https://www.python.org/) programming languages were chosen for development.

- Development was carried out in [IntelliJ IDEA](https://www.jetbrains.com/idea/) Ultimate Edition (license for
  students).

- [WakaTime](https://wakatime.com/) was used to track activity.

- [Microsoft To Do](https://todo.microsoft.com/tasks/) was used to schedule tasks.

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

If you want to take part in the development of this project, please read [this](<!--TODO-->) file.