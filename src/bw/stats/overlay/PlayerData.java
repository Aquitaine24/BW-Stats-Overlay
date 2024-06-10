package bw.stats.overlay;


public class PlayerData {
    private String username;
    private int stars;
    private double kd;
    private double bedkd;
    private double winloseratio;
    private int finalkills;
    private int finaldeaths;
    private int winstreak;

    public PlayerData(String username, int stars, double kd, double bedkd, double winloseratio, int finalkills, int finaldeaths, int winstreak){
        this.username = username;
        this.stars = stars;
        this.kd = kd;
        this.bedkd = bedkd;
        this.finalkills = finalkills;
        this.finaldeaths = finaldeaths;
        this.winstreak = winstreak;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public int getStars(){
        return stars;
    }

    public void setStars(int stars){
        this.stars = stars;
    }

    public double getKD(){
        return kd;
    }

    public void setKD(double kd){
        this.kd = kd;
    }

    public double getBedKD(){
        return bedkd;
    }

    public void setBedKD(double bedkd){
        this.bedkd = bedkd;
    }

    public double getWinLoseRatio(){
        return winloseratio;
    }

    public void setWinLoseRatio(double winloseratio){
        this.winloseratio = winloseratio;
    }

    public int getFinalKills(){
        return finalkills;
    }

    public void setFinalKills(int finalkills){
        this.finalkills = finalkills;
    }

    public int getFinalDeaths(){
        return finaldeaths;
    }

    public void setFinalDeaths(int finaldeaths){
        this.finaldeaths = finaldeaths;
    }

    public int getWinStreak(){
        return winstreak;
    }

    public void setWinStreak(int winstreak){
        this.winstreak = winstreak;
    }


    
}
