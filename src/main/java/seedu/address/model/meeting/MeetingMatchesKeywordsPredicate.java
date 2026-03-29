package seedu.address.model.meeting;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

/**
 * Tests that a {@code Meeting}'s fields match any of the keywords given.
 */
public class MeetingMatchesKeywordsPredicate implements Predicate<Meeting> {

    private final List<String> descriptionKeywords;
    private final List<String> dateKeywords;
    private final Set<UUID> uuidsToMatch;

    /**
     * Constructor for MeetingMatchesKeywordsPredicate class
     *
     * @param descriptionKeywords substring to match for Meeting descriptions
     * @param dateKeywords substring to match for Meeting dates
     * @param uuidsToMatch set to match for Meeting participant UUIDs
     */
    public MeetingMatchesKeywordsPredicate(List<String> descriptionKeywords,
                                           List<String> dateKeywords,
                                           Set<UUID> uuidsToMatch) {
        this.descriptionKeywords = descriptionKeywords;
        this.dateKeywords = dateKeywords;
        this.uuidsToMatch = uuidsToMatch;
    }

    @Override
    public boolean test(Meeting meeting) {
        String description = meeting.getDescription().toLowerCase();
        String date = meeting.getDate().toString();
        Set<UUID> participantIDs = meeting.getParticipantsID();

        boolean doAnyKeywordsMatchDescription = descriptionKeywords
                .stream()
                .anyMatch(k -> description.contains(k.toLowerCase()));

        boolean doAnyKeywordsMatchDate = dateKeywords
                .stream()
                .anyMatch(k -> date.contains(k.toLowerCase()));

        boolean doesMeetingContainAllUuids = !uuidsToMatch.isEmpty()
                && participantIDs.containsAll(uuidsToMatch);

        return doAnyKeywordsMatchDescription || doAnyKeywordsMatchDate || doesMeetingContainAllUuids;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof MeetingMatchesKeywordsPredicate)) {
            return false;
        }

        MeetingMatchesKeywordsPredicate otherPredicate = (MeetingMatchesKeywordsPredicate) other;
        return descriptionKeywords.equals(otherPredicate.descriptionKeywords)
                && dateKeywords.equals(otherPredicate.dateKeywords)
                && uuidsToMatch.equals(otherPredicate.uuidsToMatch);
    }

}
