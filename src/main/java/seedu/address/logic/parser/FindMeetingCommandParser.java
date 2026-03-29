package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MEETING_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERSON_INDICES;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.FindMeetingCommand;
import seedu.address.logic.parser.exceptions.ParseException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Parses input arguments and creates a new FindMeetingCommand object
 */
public class FindMeetingCommandParser implements Parser<FindMeetingCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindMeetingCommand
     * and returns a FindMeetingCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindMeetingCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,
                        PREFIX_MEETING_DESCRIPTION, PREFIX_MEETING_DATE, PREFIX_PERSON_INDICES);

        String preamble = argMultimap.getPreamble().trim();

        List<String> descriptionKeywords = argMultimap.getAllValues(PREFIX_MEETING_DESCRIPTION);
        List<String> dateKeywords = argMultimap.getAllValues(PREFIX_MEETING_DATE);
        List<String> personIndicesList = argMultimap.getAllValues(PREFIX_PERSON_INDICES);

        Set<Index> personIndices = new HashSet<>();

        if (!personIndicesList.isEmpty() && !personIndicesList.get(0).isEmpty()) {
            personIndices = ParserUtil.parseIndices(personIndicesList.get(0), FindMeetingCommand.MESSAGE_USAGE);
        }

        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty() || !preamble.isEmpty()) {
            // there should be nothing before the first prefix (d/)
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindMeetingCommand.MESSAGE_USAGE));
        }

        return new FindMeetingCommand(descriptionKeywords,
                dateKeywords,
                personIndices);
    }

}
