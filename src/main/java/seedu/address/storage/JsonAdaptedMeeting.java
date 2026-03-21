package seedu.address.storage;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.model.meeting.Meeting;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Meeting}.
 */
class JsonAdaptedMeeting {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Meeting's %s field is missing!";

    private final String description;
    private final String date; // store date as String in YYYY-MM-DD format

    /**
     * Constructs a {@code JsonAdaptedMeeting} with the given details.
     */
    @JsonCreator
    public JsonAdaptedMeeting(@JsonProperty("description") String description,
                              @JsonProperty("date") String date) {
        this.description = description;
        this.date = date;
    }

    /**
     * Converts a given {@code Meeting} into this class for Jackson use.
     */
    public JsonAdaptedMeeting(Meeting source) {
        this.description = source.getDescription();
        this.date = source.getDate().toString();
    }

    @JsonValue
    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    /**
     * Converts this Jackson-friendly adapted meeting object into the model's {@code Meeting} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted meeting.
     */
    public Meeting toModelType() throws IllegalValueException {
        if (!Meeting.isValidDescription(description) || !Meeting.isValidDateString(date)) {
            throw new IllegalValueException(Tag.MESSAGE_CONSTRAINTS);
        }
        LocalDate parsedDate = ParserUtil.parseDate(date);
        return new Meeting(description, parsedDate);
    }
}
