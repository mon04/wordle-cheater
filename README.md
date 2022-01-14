## Wordle Cheater
Welcome to my command-line program that gives word suggestions for the [online word-guessing game, Wordle](https://www.powerlanguage.co.uk/wordle/). I wrote this program for fun and for practice with implementing a linked list.

### How to use this program
Run ```WordleCheater.java``` and enter your hints when prompted. Currently only ```green``` letters and ```gray``` letters are supported. ```green``` letters are those letters whose position in the solution you know, and ```gray``` letters are those letters you know are **not** contained in the solution.

**Example 1** - You know some ```greens```, you don't know any ```grays```:
```
Welcome to wordle cheater!
**************************

Enter your green letters: _el_o

Enter your gray letters: 

Your suggested words are:
cello
helio
hello
jello
rello
telco
```

**Example 2** - You know some ```greens``` and some ```grays```:
```
Welcome to wordle cheater!
**************************

Enter your green letters: _el_o

Enter your gray letters: jrc

Your suggested words are:
helio
hello
```

**Example 3** - You don't know any ```greens```, only some ```grays```:
```
Welcome to wordle cheater!
**************************

Enter your green letters: _____

Enter your gray letters: auqwrtypsdfgjkzxcvbnm

Your suggested words are:
helio
hello
hillo
hollo
looie
ollie
```
