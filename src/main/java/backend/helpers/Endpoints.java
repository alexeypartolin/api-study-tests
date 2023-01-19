package backend.helpers;

public class Endpoints {

    public static class Get {
        public static String getListUsersFromPage(int pageNumber) {
            return "/api/users?page=" + pageNumber;
        }
    }
}
