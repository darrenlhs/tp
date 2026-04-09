package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {
    /**
     * To future developers: Note that PREFIX_NAME and PREFIX_NEWTAG have the same prefix.
     * We are aware that the two could cause potential confusion. However, we have decided to keep both because:
     * 1) They are never used in the same commands (so no risk of conflicts/confusion).
     * 2) NEWTAG is intuitive (old vs new), so using another prefix might risk user confusion.
     **/

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_SEPARATOR = new Prefix("/");
    public static final Prefix PREFIX_COMMA = new Prefix(",");
    public static final Prefix PREFIX_OLDTAG = new Prefix("o/");
    public static final Prefix PREFIX_NEWTAG = new Prefix("n/");
    public static final Prefix PREFIX_MEETING_DESCRIPTION = new Prefix("d/");
    public static final Prefix PREFIX_MEETING_DATE = new Prefix("dt/");
    public static final Prefix PREFIX_ADD_CONTACT_TO_MEETING_INDEX = new Prefix("add/");
    public static final Prefix PREFIX_DELETE_CONTACT_FROM_MEETING_INDEX = new Prefix("del/");
    public static final Prefix PREFIX_CONTACT_INDICES = new Prefix("i/");
}
