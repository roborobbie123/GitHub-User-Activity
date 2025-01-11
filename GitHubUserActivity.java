import java.util.Scanner;

public class GitHubUserActivity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username in this format: <username>");
        while(true) {
            String username = scanner.nextLine();
            if(username.charAt(0) != '<' && username.charAt(username.length() - 1) != '>') {
                System.out.println("invalid username");
            } else {
                username = username.replace("<", "").replace(">", "");
                String path = "https://api.github.com/users/" + username + "/events";
                System.out.println(path);
                break;
            }

        }


    }
}
