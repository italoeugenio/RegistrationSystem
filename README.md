## What is the goal of this project?

This project was created to improve my Java and OOP skills. It is a registration system that users can interact with via CLI (command-line interface). The system allows users to enter information, and then generates a **`.txt`** file with the names of the registered users.

## Project Structure

- **`src/form`:** Contains the logic for reading and writing data.
- **`src/model`:** Defines the `Person` model using Object-Oriented Programming principles.
- **`src/resources`:** Contains the `forms.txt` file with the first four questions for user input.
- **`src/user`:** Contains the menu and user management logic.
- **`src/utils`:** Contains validation functions for name, email, age, and height.
- **`src/application`:** Contains the entry point of the application, including the `main` method that runs the program.

## Important Notes

- The **`registration`** folder will be created when you exit the program by selecting option **0** from the menu.
- To restart the registration process or make changes, simply **delete the `registration` folder** and run the program again from the **`main`** method.
