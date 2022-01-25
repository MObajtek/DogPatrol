package logistyka;

public class Walker {
    /* Czy pola które w przysżłości byłyby chronione,
    jak adress i kontakt
    nie zabrać z descr. i wrzucić tu?
    Tak samo pytanie jak ze schedule
     */
    private WalkerDescription walkerDescription;
    private ReviewList reviewsOfWalker;
    private ErrandList listOfActiveErrands;
    private ErrandList listOfArchivalErrands;
    private Schedule schedule;
    boolean authorization; //o ile chcemy

    public WalkerDescription getWalkerDescription() {
        return walkerDescription;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
