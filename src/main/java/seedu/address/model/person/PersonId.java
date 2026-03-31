package seedu.address.model.person;

import java.util.UUID;

/**
 * Represents a unique ID for a Person.
 * - If no string is provided, generates a new random ID.
 * - If a string is provided, validates it as a proper UUID.
 * Guarantees: immutable;
 */
public class PersonId {

    private final UUID id;

    /**
     * Wraps an existing string ID.
     * If the string is null, empty, or invalid, generates a new random ID instead.
     *
     * @param idString existing ID string (can be null or empty)
     */
    public PersonId(String idString) {
        if (idString == null || idString.isBlank()) {
            this.id = UUID.randomUUID();
        } else {
            UUID parsedId;
            try {
                parsedId = UUID.fromString(idString);
            } catch (IllegalArgumentException e) {
                // Invalid UUID string means generate random instead
                parsedId = UUID.randomUUID();
            }
            this.id = parsedId;
        }
    }

    /** Returns the underlying UUID. */
    public UUID getId() {
        return id;
    }

    @Override
    public String toString() {
        return id.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof PersonId && id.equals(((PersonId) other).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
