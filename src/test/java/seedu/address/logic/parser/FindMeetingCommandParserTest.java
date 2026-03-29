package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.FindMeetingCommand;

public class FindMeetingCommandParserTest {

    private FindMeetingCommandParser parser = new FindMeetingCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ",
                String.format(String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindMeetingCommand.MESSAGE_USAGE)));
    }

    @Test
    public void parse_prefixPresentButEmptyArg_throwsParseException() {
        assertParseFailure(parser, " d/ dt/ i/ ",
                String.format(FindMeetingCommand.MESSAGE_NO_PARAMS_FOUND, FindMeetingCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_descriptionPrefix_returnsFindMeetingCommand() {
        FindMeetingCommand expected = new FindMeetingCommand(
                List.of("meeting"),
                Collections.emptyList(),
                Collections.emptySet());

        assertParseSuccess(parser, " d/meeting", expected);
        assertParseSuccess(parser, " d/ meeting", expected);
    }

    @Test
    public void parse_datePrefix_returnsFindMeetingCommand() {
        FindMeetingCommand expected = new FindMeetingCommand(
                Collections.emptyList(),
                List.of("2026"),
                Collections.emptySet());

        assertParseSuccess(parser, " dt/2026", expected);
        assertParseSuccess(parser, " dt/ 2026", expected);
    }

    @Test
    public void parse_indicesPrefix_returnsFindMeetingCommand() {
        FindMeetingCommand expected = new FindMeetingCommand(
                Collections.emptyList(),
                Collections.emptyList(),
                Set.of(Index.fromOneBased(1)));

        assertParseSuccess(parser, " i/1", expected);
        assertParseSuccess(parser, " i/ 1", expected);
    }

    @Test
    public void parse_multiplePrefixes_returnsFindMeetingCommand() {
        FindMeetingCommand expected = new FindMeetingCommand(
                List.of("meeting"),
                List.of("2026"),
                Collections.emptySet());

        assertParseSuccess(parser, " d/meeting dt/2026", expected);
        assertParseSuccess(parser, " d/ meeting dt/2026", expected);
        assertParseSuccess(parser, " d/meeting dt/ 2026", expected);
        assertParseSuccess(parser, " d/ meeting dt/ 2026", expected);
    }

}
