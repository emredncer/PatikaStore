```markdown
# PatikaStore - An Inventory Management System

## Usage

Upon running the application, you'll be presented with the main menu, which offers the following options:

- Notebook Operations: Manage the notebook products.
- Mobile Phone Operations: Manage the mobile phone products.
- Sort Brands: Display a list of brands sorted alphabetically.
- Exit Store: Close the application.

### Notebook Operations

- Add a Notebook: Add a new notebook product with user-defined details.
- Filter Notebooks by Brand Name: List notebooks by a specific brand name.
- Get a Notebook by ID Number: Retrieve details of a notebook by its ID.
- Delete a Notebook: Remove a notebook by its ID.

### Mobile Phone Operations

- Add a Mobile Phone: Add a new mobile phone product with user-defined details.
- Filter Mobile Phones by Brand Name: List mobile phones by a specific brand name.
- Get a Mobile Phone by ID Number: Retrieve details of a mobile phone by its ID.
- Delete a Mobile Phone: Remove a mobile phone by its ID.

### Sort Brands

This option will display a list of brand names sorted alphabetically.

## Project Structure

The project is organized into several Java classes:

- `Main.java`: The entry point of the application, responsible for displaying the main menu.
- `PatikaStore.java`: Manages the navigation between different menus and user inputs.
- `Product.java`: The base class for both Notebook and Mobile Phone products, containing common attributes.
- `Notebook.java`: Extends the Product class and represents the Notebook product type.
- `MobilePhone.java`: Extends the Product class and represents the Mobile Phone product type.
- `NotebookOperation.java`: Provides operations to manipulate Notebook products.
- `MobilePhoneOperation.java`: Provides operations to manipulate Mobile Phone products.
- `Brand.java`: Defines the Brand class for managing brand names and sorting them.

Have fun!
