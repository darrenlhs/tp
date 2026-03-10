package seedu.address.logic.parser;

import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteTagCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.tag.Tag;


public class DeleteTagCommandParserTest {
    private DeleteTagCommandParser parser = new DeleteTagCommandParser();
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        List<Index> targetIndices = new ArrayList<>();
        targetIndices.add(INDEX_FIRST_PERSON);
        Person personToDeleteFrom = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Set<Tag> tags = personToDeleteFrom.getTags();
        assertParseSuccess(parser, "1", new DeleteTagCommand(targetIndices, tags));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser,
                "a",
                "Error: Format is invalid.\n" + DeleteTagCommand.MESSAGE_FORMAT);
    }
}
