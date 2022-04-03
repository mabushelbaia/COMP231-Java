public class City {
    private String cityName;
    private double longitude;
    private double latitude;
    private int tempreture;
    public City(){
        cityName = "";
        longitude = 0.00;
        latitude = 0.00;
        tempreture = 0;
    }
    public City(String newName, double newLong,double newLati,int newTemp) {
        cityName = newName;
        longitude = newLong;
        latitude = newLati;
        tempreture = newTemp;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTempreture() {
        return tempreture;
    }

    public void setTempreture(int tempreture) {
        this.tempreture = tempreture;
    }
    public void printCityInfo(){
        System.out.println(cityName + " " + longitude + " " + latitude + " " +tempreture);
    }
}
