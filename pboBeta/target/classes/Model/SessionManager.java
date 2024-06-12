package Model;

public class SessionManager {
    private static int loggedInUserId = -1; // Initialize as -1 to indicate no user is logged in

    public static void login(int userId) {
        loggedInUserId = userId;
    }

    public static void logout() {
        loggedInUserId = -1;
    }

    public static int getLoggedInUserId() {
        return loggedInUserId;
    }

    public static boolean isLoggedIn() {
        return loggedInUserId != -1;
    }
}
