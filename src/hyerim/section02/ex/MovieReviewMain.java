package hyerim.section02.ex;

public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃타임";
        aboutTime.review = "인생 시간 영화";

        System.out.println("영화제목: " + inception.title + " | 영화리뷰: " + inception.review);
        System.out.println("영화제목: " + aboutTime.title + " | 영화리뷰: " + aboutTime.review);

    }
}
