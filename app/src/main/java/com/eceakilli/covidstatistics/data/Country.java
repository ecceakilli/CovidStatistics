package com.eceakilli.covidstatistics.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("country")
    @Expose  //Boş gelebilir demek.
    private String countyName;

    @SerializedName("cases")
    @Expose
    private Double cases;

    @SerializedName("deaths")
    @Expose
    private Double deaths;

    @SerializedName("recovered")
    @Expose
    private Double recovered;

    public CountryInfo getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfo countryInfo) {
        this.countryInfo = countryInfo;
    }

    @SerializedName("countryInfo")
    @Expose
    private CountryInfo countryInfo;

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Double getCases() {
        return cases;
    }

    public void setCases(Double cases) {
        this.cases = cases;
    }

    public Double getDeaths() {
        return deaths;
    }

    public void setDeaths(Double deaths) {
        this.deaths = deaths;
    }

    public Double getRecovered() {
        return recovered;
    }

    public void setRecovered(Double recovered) {
        this.recovered = recovered;
    }



  public class CountryInfo{

      @SerializedName("flag")
      @Expose
      private String flag;


      public String getFlag() {
          return flag;
      }

      public void setFlag(String flag) {
          this.flag = flag;
      }




    }


}
