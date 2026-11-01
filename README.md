# cs193-wordle-terminal

A program that allows the user to play the Wordle of the day within terminal.

## The Problem

I'm trying to solve the problem of being able to solve the daily wordle without having to go to the nytimes site.

## How It Works

1) Grabs the wordle of the day from nytimes
2) Once terminal is opened it prompts the user to guess
3) If the guess is right is congratulates them and closes
4) If wrong it shows what letters were in the word and prompts them again
5) Repeats last 2 steps 6 times
6) If user uses up all guesses, word is revealed and program closes

- **System diagram**
<img width="672" height="887" alt="WordleTerminalFlowchart drawio" src="https://github.com/user-attachments/assets/f26b9bb0-797c-4275-bed8-f7b89310a55c" />

## Tech Stack

- **Language:** Java
- **Libraries:** json-simple
- **External tools:** JSON

## Setup

```bash
 git clone https://github.com/jazzmcgowan86/cs193-wordle-terminal.git
 cd cs193-wordle-terminal
 ./install.sh
```

## Usage

```bash
 ./wordleTerminal.sh ~/Documents
 javac wordleTerminal
 java wordleTerminal
```

## Roadmap

 - [ ] Making sure it’s the right length
 - [ ] Letters being colored showing which letter is correct, in the word or in the wrong spot, or not in it
 - [ ] Messages saying you win or you lose
 
## Author

Jazmine McGowan, https://github.com/jazzmcgowan86
