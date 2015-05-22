#The Main Guide

##Things to still be implemented:
Organize sprites into their respective levels.
Implement the getTile method in the specific levels rather then Level.


##Step 1: Import the "Game" Folder to Eclipse
The game was compiled with JavaSE 1.6

##Package: gfx
Contains all of the main classes for handling graphics.

###SpriteSheet class represents spritesheets.
arguments: string representation of the path, width of sheet, height of sheet

###Sprite class represents sprites within the spritesheets. There are two ways to construct them: via an image or by color.
arguments by image: width of sprite, height of sprite, x index (beginning with 0), y index (beginning with 0), the sheet object that it belongs too
arguments by color (creates a sprite of one color): width of sprite, height of sprite, color code (with 0x in front)

##Package: entity.mob
Contains all mobs

###Player class represents the player object
They reference sprites for the specific sprite to render.

##Package: Level
Contains levels

###SpawnLevel represents a test level (extends level)
Constructed with a string representing the path to the pixel representation of the level. The colors are saved into variable tiles.

###Level represents levels in general
getTile(int x, int y) returns the tile to be rendered at x, y. Currently set to return a tile corresponding to a specific color (represented by the hexadecimal proceeded by "0xff").

###RandomLevel represents a random level
Generates a random level with generateLevel() (currently an int from 0 to 4).
