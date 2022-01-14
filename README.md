## Wordle Cheater
Welcome to my command-line program that gives word suggestions for the [online language game, Wordle](https://www.powerlanguage.co.uk/wordle/). I wrote this program for fun and for practice with implementing a linked list.

### How to use this program
Run ```WordleCheater.java``` and enter your arguments when prompted. A list of suggested words will be printed to the console. Currently only green and (optionally) gray letters are supported. You can enter one or two arguments.

* The first of these will be the pattern of green letters you have found so far (use '_' to denote positions where the letter is unknown).
* The second (optional) argument will be a string of gray letters, or those letters you know your solution does **not** contain.

**Example 1** - Enter a pattern of green letters:
```
Welcome to Wordle Cheater!
Please enter a pattern: _el_o
bello
cello
deloo
helco
helio
hello
jello
```

**Example 2** - Enter a pattern of green letters followed by a string of gray letters:
```
Welcome to Wordle Cheater!
Please enter a pattern: _el_o hbc
deloo
jello
```

*I have no association with Wordle or its creator.*
