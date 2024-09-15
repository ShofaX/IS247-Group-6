public class Item {
    private String name;
    private String description;

    // Constructor for creating an item with a name and description
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getter for item name
    public String getName() {
        return name;
    }

    // Getter for item description
    public String getDescription() {
        return description;
    }

    // Override toString method for a more descriptive output
    @Override
    public String toString() {
        return "Item: " + name + " - " + description;
    }
}

