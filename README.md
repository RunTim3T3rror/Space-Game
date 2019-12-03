# Space-Game
## Instructions to Run
1. Download the Space-Game folder from github either by using `git clone https://github.com/RunTim3T3rror/Space-Game.git` or by downloading the zip.
2. Open Eclipse
3. On Eclipse click "File" and select "New" then "Java Project"
4. Unselect "Use default location" from the New Java Project Popup
5. Click Browse to select a new Location and navigate to the Space-Game-master folder and click "select folder"
6. Click Finish at the bottom right of the New java Project Popup
7. If Eclipse askes you to create a module-info.java select "Don't Create" at the bottom right
8. The JavaFX library should automatically be added to the Referenced Libaries. If they aren't add all the Jars in the "libs" folder of the project to the build path.
9. Right click on the "Resources" folder in the root of the project goto "Build Path" and select "Use as source folder"
10. Navigate to "src/application" and open Main.java
11. Click the green run button at the top and the project should run
12. Controls for the game are found below
## Controls
### Main Menu
![alt text](https://github.com/RunTim3T3rror/Space-Game/raw/master/Screenshtos/Main%20Menu.PNG "Main Menu")
* Use UP and DOWN arrow keys to navigate
* Press the ENTER key to make a selection
### Play (first menu option)
![alt text](https://github.com/RunTim3T3rror/Space-Game/raw/master/Screenshtos/Play.PNG "Play")
* Use LEFT and RIGHT arrow keys to move the player left and right
* Press F to shoot
* Press D if you wish to skip a level
* Press BACK SPACE to return to the main menu
### Create Level (second menu option)
![alt text](https://github.com/RunTim3T3rror/Space-Game/raw/master/Screenshtos/Create.PNG "Crete")
* Use LEFT RIGHT UP DOWN arrow keys to move selected tile
* Press 1 to spawn a simple enemy in the selected tile
* Press 2 to spawn a invisible enmy in the selected tile
* Press 3 to spawn a boss enemy in the selected tile
* Press 0 to remove an enemy in the selected tile
* Press S to save the custom level
* Press BACK SPACE to return to the main menu
* <b> NOTE: To play a custom level once saved you MUST restart the game </b>
### Load Level (third menu option)
![alt text](https://github.com/RunTim3T3rror/Space-Game/raw/master/Screenshtos/Custom.PNG "Play Custom")
* Use same controls as Play (first menu option) 
### Lost/Won View
![alt text](https://github.com/RunTim3T3rror/Space-Game/raw/master/Screenshtos/Won.PNG "Won Level")
* Press ENTER to return to the Main Menu
