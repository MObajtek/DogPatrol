package logistyka.review;

public class Review {
    private int stars; //out of 5
    private String comment;

    public Review(int stars, String comment) {
        this.stars = stars;
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "stars=" + stars +
                ", comment='" + comment + '\'' +
                '}';
    }
}
