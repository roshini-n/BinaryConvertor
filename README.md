# Binary Converter

**Description**  
Binary Converter is a simple Android application that converts a given integer into its 32-bit binary representation. It also includes an implicit intent feature that allows users to navigate to an external website to learn more about the binary number system.

## Features

### Core Functionality
- Converts an integer into a 32-bit binary string using `Integer.toBinaryString()`.
- Displays the result in a `TextView` (`displayTV`).
- Handles invalid input gracefully by displaying "00000000000000000000000000000000" in case of conversion failure.

### Layout & UI
- `EditText` (`valueET`) for entering the number.
  - Hint text for `valueET` indicating that only numbers are allowed.
- `TextView` (`inputLabelTV`) above `valueET` with the label "Enter a number:".
- `Button` ("To Binary") to perform the conversion, aligned to the top-right of the screen.
- `TextView` (`displayTV`) centered below the button, initially showing "No result".

### Implicit Intent
- A "Learn Binary" button that opens an external website ([Binary Number - Wikipedia](https://en.wikipedia.org/wiki/Binary_number)).

## Additional Enhancements (Bonus Features)
- **COMPLEMENT operation**: Flip all bits of the binary string.
- **2’s COMPLEMENT operation**: Flip the bits and add one (ignoring overflow bits).
- **HEX conversion**: Convert the input number into a hexadecimal representation.
- **Reverse conversion**: 
  - Replace `displayTV` with an editable text field.
  - Add a "To Decimal" button to convert a binary string back into a decimal number.
- **Animations & Visual Effects**: Enhance the UI with dynamic elements.

## Requirements
- Android Studio
- Minimum SDK: 21 (Android 5.0 Lollipop)
- Kotlin/Java for development


## How to Use
1. Enter a number in the input field.
2. Tap the "To Binary" button to view its 32-bit binary representation.
3. If the input is invalid, a default binary string ("00000000000000000000000000000000") will be displayed.
4. Click "Learn Binary" to navigate to an external website for more information.

