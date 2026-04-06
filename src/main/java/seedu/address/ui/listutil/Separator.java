package seedu.address.ui.listutil;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

/**
 * A UI component that displays a horizontal line separator with a title in the center.
 */
public class Separator extends UiPart<Region> {

    private static final String FXML = "Separator.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    @FXML
    private Label title;

    /**
     * Creates a {@code Separator} with the given {@code titleText}.
     */
    public Separator(String titleText) {
        super(FXML);

        title.setText(titleText);
    }
}
