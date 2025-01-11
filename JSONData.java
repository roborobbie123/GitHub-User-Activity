public class JSONData {
    private String type;
    private String repo;
    private int count;

    public JSONData(){}

    public JSONData(String repo, int count, String type) {
        this.repo = repo;
        this.count = count;
        this.type = type;
    }

    public String getRepo() {
        return repo;
    }
    public void setRepo(String repo) {
        this.repo = repo;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


}
