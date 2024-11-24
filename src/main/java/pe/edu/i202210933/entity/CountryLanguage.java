package pe.edu.i202210933.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {
    @Id
    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;

    @Id
    @Column(name = "Language", length = 30)
    private String language;

    @Column(name = "IsOfficial")
    private String isOfficial;

    @Column(name = "Percentage")
    private double percentage;


    public CountryLanguage() {
    }

    public CountryLanguage(String language, String isOfficial, Double percentage, Country country) {
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "country=" + country +
                ", language='" + language + '\'' +
                ", isOfficial=" + isOfficial +
                ", percentage=" + percentage +
                '}';
    }
}
