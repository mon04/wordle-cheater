## wordle cheater
A command-line program that suggests solutions for the [online word-guessing game, WORDLE](https://www.powerlanguage.co.uk/wordle/).

### How to use this program
Run ```WordleCheater.java``` and enter your hints when prompted.

**Example 1**
```
Welcome to wordle cheater!
**************************
Enter your green pattern: h____

Enter your yellow pattern: e__o_

Enter your gray letters: tyvnsifa

Your suggested WORDLES are:
hello
hohed
hoked
holed
holme
homed
homer
homme
hoped
hoper
horde
horme
howbe
howre
hoxed
```

**Example 2**
```
Welcome to wordle cheater!
**************************
Enter your green pattern: h_ll_

Enter your yellow pattern: _____

Enter your gray letters: a

Your suggested WORDLES are:
hello
hells
hillo
hills
hilly
hollo
holly
hullo
hulls
hully
```

### Some data about the WORDLE list\*
* ```    char``` a letter in the alphabet
* ```   freq.``` how many times this letter occurs in the list (repeats incl.)
* ```in words``` how many WORDLES contain this letter at least once
* ```       %``` the left-adjacent column expressed as a percentage of the total

```
char    	freq. 	     % 	    in words 	     %
------------------------------------------------------
   s    	6665 	51.380 	        5936 	45.760
   e    	6662 	51.357 	        5705 	43.979
   a    	5990 	46.176 	        5330 	41.088
   o    	4438 	34.212 	        3911 	30.150
   r    	4158 	32.054 	        3909 	30.134
   i    	3759 	28.978 	        3589 	27.667
   l    	3371 	25.987 	        3114 	24.006
   t    	3295 	25.401 	        3033 	23.381
   n    	2952 	22.757 	        2787 	21.485
   u    	2511 	19.357 	        2436 	18.779
   d    	2453 	18.910 	        2298 	17.715
   y    	2074 	15.988 	        2031 	15.657
   c    	2028 	15.634 	        1920 	14.801
   p    	2019 	15.564 	        1885 	14.531
   m    	1976 	15.233 	        1868 	14.400
   h    	1760 	13.568 	        1708 	13.167
   g    	1644 	12.673 	        1543 	11.895
   b    	1627 	12.542 	        1519 	11.710
   k    	1505 	11.602 	        1444 	11.132
   w    	1039 	 8.010 	        1028 	 7.925
   f    	1115 	 8.595 	         990 	 7.632
   v    	 694 	 5.350 	         674 	 5.196
   z    	 434 	 3.346 	         391 	 3.014
   j    	 291 	 2.243 	         289 	 2.228
   x    	 288 	 2.220 	         287 	 2.212
   q    	 112 	 0.863 	         111 	 0.856
```
*\*word list may differ from the one used by WORDLE*