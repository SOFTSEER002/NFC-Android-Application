package com.ahsanshamim.nfcreader.Models.candidate;

import com.google.gson.annotations.SerializedName;

public class CandidateItems {

    @SerializedName("tenantId")
    public int tenantId;
    @SerializedName("candidateCategoryId")
    public int candidateCategoryId;
    @SerializedName("candidateFirstName")
    public String candidateFirstName;
    @SerializedName("nfcPrint")
    public String nfcPrint;
    @SerializedName("candidateMiddleName")
    public String candidateMiddleName;
    @SerializedName("candidateLastName")
    public String candidateLastName;
    @SerializedName("candidateDob")
    public String candidateDob;
    @SerializedName("candidateAddress")
    public String candidateAddress;
    @SerializedName("candidateMobileNumber")
    public String candidateMobileNumber;
    @SerializedName("candidateEmail")
    public String candidateEmail;
    @SerializedName("uniqueIdCode")
    public String uniqueIdCode;
    @SerializedName("photo")
    public String photo;
    @SerializedName("userDescription")
    public String userDescription;
    @SerializedName("interviewLocation")
    public int interviewLocation;
    @SerializedName("interviewApproval")
    public boolean interviewApproval;
    @SerializedName("interviewDate")
    public String interviewDate;
    @SerializedName("authenticateCandidate")
    public boolean authenticateCandidate;
    @SerializedName("candidateArrived")
    public boolean candidateArrived;
    @SerializedName("candidateArrivedDateTime")
    public String candidateArrivedDateTime;
    @SerializedName("candidateArrivedSubmittedBy")
    public String candidateArrivedSubmittedBy;
    @SerializedName("arrivalLocationViolation")
    public boolean arrivalLocationViolation;
    @SerializedName("interviewed")
    public boolean interviewed;
    @SerializedName("candidateExit")
    public boolean candidateExit;
    @SerializedName("candidateExitedDateTime")
    public String candidateExitedDateTime;
    @SerializedName("candidateExitSubmmitedBy")
    public String candidateExitSubmmitedBy;
    @SerializedName("barCode")
    public String barCode;
    @SerializedName("nfc")
    public String nfc;
    @SerializedName("rfid")
    public String rfid;
    @SerializedName("qrc")
    public String qrc;
    @SerializedName("organizationUnitId")
    public int organizationUnitId;
    @SerializedName("encryptionKeyId")
    public int encryptionKeyId;
    @SerializedName("printStatus")
    public boolean printStatus;
    @SerializedName("writeStatus")
    public boolean writeStatus;
    @SerializedName("print")
    public String print;
    @SerializedName("candidateHeight")
    public String candidateHeight;
    @SerializedName("candidateWeight")
    public String candidateWeight;
    @SerializedName("candidateGenotype")
    public String candidateGenotype;
    @SerializedName("candidateBloodGroup")
    public String candidateBloodGroup;
    @SerializedName("isDeleted")
    public boolean isDeleted;
    @SerializedName("deleterUserId")
    public String deleterUserId;
    @SerializedName("deletionTime")
    public String deletionTime;
    @SerializedName("lastModificationTime")
    public String lastModificationTime;
    @SerializedName("lastModifierUserId")
    public String lastModifierUserId;
    @SerializedName("creationTime")
    public String creationTime;
    @SerializedName("creatorUserId")
    public String creatorUserId;
    @SerializedName("id")
    public int id;


    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public int getCandidateCategoryId() {
        return candidateCategoryId;
    }

    public void setCandidateCategoryId(int candidateCategoryId) {
        this.candidateCategoryId = candidateCategoryId;
    }

    public String getCandidateFirstName() {
        return candidateFirstName;
    }

    public void setCandidateFirstName(String candidateFirstName) {
        this.candidateFirstName = candidateFirstName;
    }

    public String getNfcPrint() {
        return nfcPrint;
    }

    public void setNfcPrint(String nfcPrint) {
        this.nfcPrint = nfcPrint;
    }

    public String getCandidateMiddleName() {
        return candidateMiddleName;
    }

    public void setCandidateMiddleName(String candidateMiddleName) {
        this.candidateMiddleName = candidateMiddleName;
    }

    public String getCandidateLastName() {
        return candidateLastName;
    }

    public void setCandidateLastName(String candidateLastName) {
        this.candidateLastName = candidateLastName;
    }

    public String getCandidateDob() {
        return candidateDob;
    }

    public void setCandidateDob(String candidateDob) {
        this.candidateDob = candidateDob;
    }

    public String getCandidateAddress() {
        return candidateAddress;
    }

    public void setCandidateAddress(String candidateAddress) {
        this.candidateAddress = candidateAddress;
    }

    public String getCandidateMobileNumber() {
        return candidateMobileNumber;
    }

    public void setCandidateMobileNumber(String candidateMobileNumber) {
        this.candidateMobileNumber = candidateMobileNumber;
    }

    public String getCandidateEmail() {
        return candidateEmail;
    }

    public void setCandidateEmail(String candidateEmail) {
        this.candidateEmail = candidateEmail;
    }

    public String getUniqueIdCode() {
        return uniqueIdCode;
    }

    public void setUniqueIdCode(String uniqueIdCode) {
        this.uniqueIdCode = uniqueIdCode;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public int getInterviewLocation() {
        return interviewLocation;
    }

    public void setInterviewLocation(int interviewLocation) {
        this.interviewLocation = interviewLocation;
    }

    public boolean isInterviewApproval() {
        return interviewApproval;
    }

    public void setInterviewApproval(boolean interviewApproval) {
        this.interviewApproval = interviewApproval;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(String interviewDate) {
        this.interviewDate = interviewDate;
    }

    public boolean isAuthenticateCandidate() {
        return authenticateCandidate;
    }

    public void setAuthenticateCandidate(boolean authenticateCandidate) {
        this.authenticateCandidate = authenticateCandidate;
    }

    public boolean isCandidateArrived() {
        return candidateArrived;
    }

    public void setCandidateArrived(boolean candidateArrived) {
        this.candidateArrived = candidateArrived;
    }

    public String getCandidateArrivedDateTime() {
        return candidateArrivedDateTime;
    }

    public void setCandidateArrivedDateTime(String candidateArrivedDateTime) {
        this.candidateArrivedDateTime = candidateArrivedDateTime;
    }

    public String getCandidateArrivedSubmittedBy() {
        return candidateArrivedSubmittedBy;
    }

    public void setCandidateArrivedSubmittedBy(String candidateArrivedSubmittedBy) {
        this.candidateArrivedSubmittedBy = candidateArrivedSubmittedBy;
    }

    public boolean isArrivalLocationViolation() {
        return arrivalLocationViolation;
    }

    public void setArrivalLocationViolation(boolean arrivalLocationViolation) {
        this.arrivalLocationViolation = arrivalLocationViolation;
    }

    public boolean isInterviewed() {
        return interviewed;
    }

    public void setInterviewed(boolean interviewed) {
        this.interviewed = interviewed;
    }

    public boolean isCandidateExit() {
        return candidateExit;
    }

    public void setCandidateExit(boolean candidateExit) {
        this.candidateExit = candidateExit;
    }

    public String getCandidateExitedDateTime() {
        return candidateExitedDateTime;
    }

    public void setCandidateExitedDateTime(String candidateExitedDateTime) {
        this.candidateExitedDateTime = candidateExitedDateTime;
    }

    public String getCandidateExitSubmmitedBy() {
        return candidateExitSubmmitedBy;
    }

    public void setCandidateExitSubmmitedBy(String candidateExitSubmmitedBy) {
        this.candidateExitSubmmitedBy = candidateExitSubmmitedBy;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    public String getQrc() {
        return qrc;
    }

    public void setQrc(String qrc) {
        this.qrc = qrc;
    }

    public int getOrganizationUnitId() {
        return organizationUnitId;
    }

    public void setOrganizationUnitId(int organizationUnitId) {
        this.organizationUnitId = organizationUnitId;
    }

    public int getEncryptionKeyId() {
        return encryptionKeyId;
    }

    public void setEncryptionKeyId(int encryptionKeyId) {
        this.encryptionKeyId = encryptionKeyId;
    }

    public boolean isPrintStatus() {
        return printStatus;
    }

    public void setPrintStatus(boolean printStatus) {
        this.printStatus = printStatus;
    }

    public boolean isWriteStatus() {
        return writeStatus;
    }

    public void setWriteStatus(boolean writeStatus) {
        this.writeStatus = writeStatus;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public String getCandidateHeight() {
        return candidateHeight;
    }

    public void setCandidateHeight(String candidateHeight) {
        this.candidateHeight = candidateHeight;
    }

    public String getCandidateWeight() {
        return candidateWeight;
    }

    public void setCandidateWeight(String candidateWeight) {
        this.candidateWeight = candidateWeight;
    }

    public String getCandidateGenotype() {
        return candidateGenotype;
    }

    public void setCandidateGenotype(String candidateGenotype) {
        this.candidateGenotype = candidateGenotype;
    }

    public String getCandidateBloodGroup() {
        return candidateBloodGroup;
    }

    public void setCandidateBloodGroup(String candidateBloodGroup) {
        this.candidateBloodGroup = candidateBloodGroup;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getDeleterUserId() {
        return deleterUserId;
    }

    public void setDeleterUserId(String deleterUserId) {
        this.deleterUserId = deleterUserId;
    }

    public String getDeletionTime() {
        return deletionTime;
    }

    public void setDeletionTime(String deletionTime) {
        this.deletionTime = deletionTime;
    }

    public String getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(String lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public String getLastModifierUserId() {
        return lastModifierUserId;
    }

    public void setLastModifierUserId(String lastModifierUserId) {
        this.lastModifierUserId = lastModifierUserId;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
