package Files.ItemInside;

public enum JudgmentType {
    DECISION,
    RESOLUTION,
    SENTENCE,
    REGULATION,
    REASONS;

    @Override
    public String toString() {

        switch (this) {
            case DECISION:
                return  "Decision";
            case RESOLUTION:
                return  "Resoultion";
            case SENTENCE:
                return   "Sentence";
            case REGULATION:
                return   "referencedRegulation";
            case REASONS:
                return   "Reasons";
            default:
                return  "";

        }

    }
}