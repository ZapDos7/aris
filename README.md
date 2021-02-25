# ARIS

### _A simple JAVA program that simulates ARIS's process sequences._
##### The 28th Panhellenic Competition in Informatics's first phase's task

### Premise
During a 24 hour period, the super-computer ARIS can perform processes for M research teams, divided in N execution windows (M∈[1, 1.000.000], N∈[1, 1.000.000])
We need to calculate the amount of programs/processes that will be completed, as well as the execution windows required for both the shortest and longest programs.

### Input & Output Files
* The input file `aris.in` must contain 2 lines, as such:
```
N M
a, b, c, ...
```
The first line contains the number of execution windows & research teams/programs, respectively.
The second line contains N integers Si, with Si∈[1,M] and i ∈1,N]
* The output file `aris.out` must contain 1 line, as such:
```
K X Y
```
where K will be the number of teams whose work has been concluded (K may be less than M!), X the amount of execution windows required for the shortest program and Y for the longest.

##### Example of input and output
`aris1.in`:
```
10 5
1 2 3 4 1 5 1 2 1
```
`aris1.out`:
```
5 1 4
```
_Explanation: All 5 teams' works have been concluded, the shortest programs (4,5) were concluded in 1 execution window and the longest (1) needed 4 windows._
`aris2.in`:
```
12 6
3 5 5 1 2 3 1 5 3 5 3 2
```
`aris2.out`:
```
4 2 4
```
_Explanation: 4 teams' works have been concluded, the shortest programs (1,2) were concluded in 2 execution windows and the longest (3,5) needed 4 windows. Teams 4 and 6 had no execution time._

### Sources
1. [Hellenic Society of Scientists and Professionals in Informatics and Communications](http://epy.gr/)
2. [Panhellenic Competition in Informatics](http://www.pdp.gr/)
3. [ARIS's CPU Power](http://hpc.grnet.gr/)
