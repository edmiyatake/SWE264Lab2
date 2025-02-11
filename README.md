# SWE264 Lab2

Edwin Miyatake

Task: Modifications to Current System

Your task is to modify the current system to support new modifications described below. Include all of
the following modifications in a single new system. Make sure that you use good programming
practices, including comments.

Operating System: Windows 11 Version 23H2
Computer Architecture: AMD64
IDE: Visual Studio Code 1.96.4

Setup:
1. Unzip file and open a terminal that navigates to the directory SWE264LAB2
2. For this lab, it is not executable unless I had Java SE 8 so i had to install Java 8 Update 441 from Adoptium
3. Check so that the output when running "java -version" is correct
    java version "1.8.0_441"
    Java(TM) SE Runtime Environment (build 1.8.0_441-b07)
    Java HotSpot(TM) Client VM (build 25.441-b07, mixed mode, sharing)
4. Should be safe to compile files using javac *.java but I had some problems so I had to do it specific to Java 1.8 by running "javac -source 1.8 -target 1.8 *.java"
5. Finally, running java SystemMain Students.txt and Course.txt should bring up the text gui.


Test Cases Used

Part B

Student IDs

- G00123456 
- G00123432 
- G45643133 
- G01234567

Course IDs

- CS112

Section IDs

- A

Part C

Student ID

- G00123456

Conflicting Course IDs

- CS211 A (M 11:00 - 12:30, Kurtz)
- CS112 A (M 10:30 - 12:00, Horton)

- CS421 A (T 11:00 - 12:30, Schmidt)
- CS211 B (T 09:30 - 12:00, Worth)

Non-Conflicting Course ID
- CS475 A (M 09:00 - 10:30, Delmar)
- CS211 A (M 11:00 - 12:30, Kurtz)