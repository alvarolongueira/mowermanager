# mowermanager

## Why
We need to develop an application that helps in controlling brand new mowers.

We will consider only one single green grass plateau to simply the problem, which is curiously rectangular, 

A mower’s position and location are represented by a combination of X and Y coordinates and 
a letter representing one of the four cardinal compass points (N, E, S, W). 

The plateau is divided up into a grid to simplify navigation. 
An example position might be 0, 0, N, which means the mower is in the bottom left corner and facing North.

In order to control a mower, sends a simple string of letters. 
* The possible letters are “L”, “R” and ”M”. “L” and “R” make the mower spin 90 degrees left or right respectively, 
without moving from its current spot. 
* “M” means to move forward onegrid point and maintain the same Heading.
Assume that the square directly North from (X, Y) is (X, Y + 1).

##### Input

The first line of input is the upper-right coordinates of the plateau, 
the bottom-left coordinates are assumed to be 0, 0.
The rest of the input is information pertaining to the mowers that have been deployed. 

Each mower has two lines of input. 
The first line gives the mower’s position, and the second line is a series of instructions telling the mower how to explore the plateau. 

The position is made up of two integers and a letter separated by spaces, corresponding to the X and Y coordinates and the mower’s orientation.
Each mower will be finished sequentially, which means that the second mower won’t start
to move until the first one has finished moving.

##### Output

The output for each mower should be its final coordinates and heading.

Input Test Case #1:
```
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
```

Output Test Case #2:
```
1 3 N
5 1 E
```

## How
The approach was split the problem in smaller ones. Just doing specific classes for each purpose.

I defined the two main entities: position and cardinal. That's all I needed to do any operation.
The rest was built around these two concepts. The movement and the object mower only needed call the previous. 

I created a factory to input/output. To make it simple, input is reading file (instructions_list.txt) and 
output uses standard ouput.

## Where
To run tests there is a suite TestSuite that contains:

* CardinalFactoryTest: check the spin

* PositionWithLimitsTest: check the movements and position throw the grid

* MowerTest: check the combination between position and cardinal

* ManagerServiceTest: integration test to check the example from the instructions

Main classes:

* MowerManagerApplication: run the application, read file instructions_list.txt and write the ouput

## What

* ManagerService: do the logic

* CardinalFactory: is responsible to spin

* Cardinal: indicates direction, and what movement to go according the direction

* PositionWithLimits: change position according the movement received and prevent go outside the grid

* Action: list of available commands 

* Mower: the object that aggregates position, cardinal and movement

* InputService/OuputService: interfaces to communicate outside the application

* CommFactory: decide which implementation use to communicate 

* Instruction: transform any input received to a standard object to separate business from communication


## Who
* **Alvaro Longueira** - [alvarolongueira](https://github.com/alvarolongueira)


