package Files.ItemInside;

public enum SpecialRoles {
    PRESIDING_JUDGE,
    REPORTING_JUDGE,
    REASONS_FOR_JUDGMENT_AUTHOR,
    ALL;

    @Override
    public String toString() {

        switch (this) {
            case PRESIDING_JUDGE:
                return  "przewodniczacy składu sędziowskiego";
            case REPORTING_JUDGE:
                return  "sędzia sprawozdawca";
            case REASONS_FOR_JUDGMENT_AUTHOR:
                return   "autor uzasadnienia";
            case ALL:
                return "Total";
            default:
                return  "";

        }

    }
}
