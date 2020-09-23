package ActivityPackage;

public class Activity {
    String activityName;
    double activityPrice;
    int activityAge;
    int activityHeight;

    public Activity(String activityName, double activityPrice, int activityAge, int activityHeight) {
        this.activityName = activityName;
        this.activityPrice = activityPrice;
        this.activityAge = activityAge;
        this.activityHeight = activityHeight;
    }

    public String readActivity(){
        return "Type: " + getActivityName() + ", Price: " + getActivityPrice() + ", Age: " + getActivityAge() + ", Height: " + getActivityHeight();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(double activityPrice) {
        this.activityPrice = activityPrice;
    }

    public int getActivityAge() {
        return activityAge;
    }

    public void setActivityAge(int activityAge) {
        this.activityAge = activityAge;
    }

    public int getActivityHeight() {
        return activityHeight;
    }

    public void setActivityHeight(int activityHeight) {
        this.activityHeight = activityHeight;
    }
}
