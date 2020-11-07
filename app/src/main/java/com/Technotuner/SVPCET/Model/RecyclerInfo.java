package com.Technotuner.SVPCET.Model;

public class RecyclerInfo {

    String complaintFullName, complaintMobileNo, complaintLocation, complaintDescription, complaintImage, complaintCity;

    public RecyclerInfo() {
    }

    public String getComplaintCity() {
        return complaintCity;
    }

    public void setComplaintCity(String complaintCity) {
        this.complaintCity = complaintCity;
    }

    public RecyclerInfo(String complaintFullName, String complaintMobileNo, String complaintLocation, String complaintDescription, String complaintImage, String complaintCity) {
        this.complaintFullName = complaintFullName;
        this.complaintMobileNo = complaintMobileNo;
        this.complaintLocation = complaintLocation;
        this.complaintDescription = complaintDescription;
        this.complaintImage = complaintImage;
        this.complaintCity = complaintCity;
    }

    public String getComplaintFullName() {
        return complaintFullName;
    }

    public void setComplaintFullName(String complaintFullName) {
        this.complaintFullName = complaintFullName;
    }

    public String getComplaintMobileNo() {
        return complaintMobileNo;
    }

    public void setComplaintMobileNo(String complaintMobileNo) {
        this.complaintMobileNo = complaintMobileNo;
    }

    public String getComplaintLocation() {
        return complaintLocation;
    }

    public void setComplaintLocation(String complaintLocation) {
        this.complaintLocation = complaintLocation;
    }

    public String getComplaintDescription() {
        return complaintDescription;
    }

    public void setComplaintDescription(String complaintDescription) {
        this.complaintDescription = complaintDescription;
    }

    public String getComplaintImage() {
        return complaintImage;
    }

    public void setComplaintImage(String complaintImage) {
        this.complaintImage = complaintImage;
    }
}
