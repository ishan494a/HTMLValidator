# HTML Validator

The HTML Validator is a simple Java Swing application that allows users to input a text and validate if the parentheses (and other related characters) are balanced.

## Features

- **Input Text Area**: Allows users to input text containing HTML code or any text with parentheses.
- **Validation Button**: Clicking the "Validate" button checks whether the parentheses in the input are balanced or not.
- **Result Text Area**: Displays the result of the validation process - whether the input has balanced parentheses or not.

## How to Use

1. Enter the text containing HTML code or any text with parentheses in the top text area.
2. Click the "Validate" button to check if the parentheses are balanced.
3. The result will be displayed in the bottom text area.

## Implementation Details

The validation process involves extracting only the parentheses from the input text and checking if they are balanced using a stack data structure.

### Class Structure

- **HTMLValidator**: The main class that extends `JFrame` and creates the GUI components.
- **onlyParentheses**: A method that extracts only parentheses from the input text.
- **isValid**: A method that checks whether the extracted parentheses are balanced or not using a stack.

### Dependencies

- Java Swing library for GUI components.

## How to Run

1. Compile the Java file: `javac HTMLValidator.java`
2. Run the compiled class: `java HTMLValidator`

## Example
<img width="399" alt="Screenshot 2023-11-25 at 10 10 22 AM" src="https://github.com/ishan494a/HTMLValidator/assets/128569642/847e75d7-9762-4557-869a-5243d078f384">

