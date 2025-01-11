import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
                try {
                    URL url = new URL(path);

                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    int responseCode = connection.getResponseCode();
                    if(responseCode == HttpURLConnection.HTTP_OK) {
                        System.out.println("valid");
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = reader.readLine()) != null) {
                            response.append(inputLine);
                        }
                        reader.close();
                        System.out.println(response.toString());
                        break;
                    } else {
                        System.out.println("GET request failed. Response code: " + responseCode);
                    }
                }
                catch(Exception e) {
                    System.out.println("could not connect to GitHub");
                    break;
                }
                break;
            }
        }



    }
}
