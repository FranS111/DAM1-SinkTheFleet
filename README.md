## **Core Features**
- **Dynamic Ship Placement**: 
  - Ships are placed randomly in either horizontal or vertical orientation based on user input.
  - Ensures ships do not overlap.

- **Grid Management**:
  - Displays the grid after every turn, showing updates for hits ("TOCA") or misses ("AGUA").

- **Turn-based Gameplay**:
  - Player inputs grid coordinates to bomb.
  - Prevents repeated bombing of the same location.

- **Win Condition**:
  - Game automatically detects when all ships are destroyed and ends with a victory message.

---

## **Game Flow**
1. The program initializes a 10x10 grid filled with water (`AGUA`).
2. Prompts the player to choose ship orientation:
   - `H` for horizontal.
   - `V` for vertical.
3. Randomly places 4 ships on the grid.
4. The player inputs row and column coordinates to bomb.
5. Feedback is given for each attempt:
   - **"Tocado!"** for a hit.
   - **"Agua!"** for a miss.
6. The game continues until all ships are destroyed.

---

## **How to Run**
1. Compile the program using:
   ```bash
   javac Examen.java
