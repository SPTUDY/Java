package hyerim.section02.ex;

public class MovieReviewMain2 {
    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃타임";
        aboutTime.review = "인생 시간 영화";

        MovieReview[] movies = new MovieReview[]{inception, aboutTime};
        for (int i = 0; i < movies.length; i++) {
            System.out.println("영화제목: " + movies[i].title + " | 영화리뷰: " + movies[i].review);
        }
        for (MovieReview m : movies) {
            System.out.println("영화제목: " + m.title + " | 영화리뷰: " + m.review);

        }

    }
}
