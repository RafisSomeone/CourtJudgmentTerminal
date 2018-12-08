package Files.ItemInside;

public enum CourtType {
    COMMON,
    SUPREME,
    ADMINISTRATIVE,
    CONSTITUTIONAL_TRIBUNAL,
    NATIONAL_APPEAL_CHAMBER,
    ALL;

    @Override
    public String toString() {

        switch (this) {
            case COMMON:
                return  "Common Court";
            case SUPREME:
                return  "Supreme Court";
            case ADMINISTRATIVE:
                return   "Administrative Court";
            case CONSTITUTIONAL_TRIBUNAL:
                return   "Constitutional Triblunal";
            case NATIONAL_APPEAL_CHAMBER:
                return   "National Appeal Chamber";
            case ALL:
                return "Total";
            default:
                return  "";

        }

    }
}