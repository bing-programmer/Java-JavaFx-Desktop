//--Shey Adepoju --//
package Classes;

public class Bookings {

    private Integer BkId;
    private String BkDate;
    private String  BkNo;
    private Integer TravelerCount;
    private Integer CustId;
    private String TripTypeId;
    private Integer PkgId;

    public Integer getBkId() {
        return BkId;
    }

    public void setBkId(Integer bkId) {
        BkId = bkId;
    }

    public String getBkDate() {
        return BkDate;
    }

    public void setBkDate(String bkDate) {
        BkDate = bkDate;
    }

    public String getBkNo() {
        return BkNo;
    }

    public void setBkNo(String bkNo) {
        BkNo = bkNo;
    }

    public Integer getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(Integer travelerCount) {
        TravelerCount = travelerCount;
    }

    public Integer getCustId() {
        return CustId;
    }

    public void setCustId(Integer custId) {
        CustId = custId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        TripTypeId = tripTypeId;
    }

    public Integer getPkgId() {
        return PkgId;
    }

    public void setPkgId(Integer pkgId) {
        PkgId = pkgId;
    }
    
    //--Bookings Constructor----------//
    public Bookings(Integer bkId, String bkDate, String bkNo, Integer travelerCount, Integer custId, String tripTypeId, Integer pkgId) {
        BkId = bkId;
        BkDate = bkDate;
        BkNo = bkNo;
        TravelerCount = travelerCount;
        CustId = custId;
        TripTypeId = tripTypeId;
        PkgId = pkgId;
    }
}
