package fail_Fast_Safe;

/**
 * @Classname DataDTO
 * @Description TODO
 * @Date 2020/10/25 15:49
 * @Created by nihongyu
 */
public class DataDTO {
    String PARENTNODEID;
    String DIMCODE;
    String ACCOUNTTYPE;
    String VALUETYPE;
    String DICTYPE;
    String ATTRNAME;
    String ATTRTYPE;

    public String getPARENTNODEID() {
        return PARENTNODEID;
    }

    public void setPARENTNODEID(String PARENTNODEID) {
        this.PARENTNODEID = PARENTNODEID;
    }

    public String getDIMCODE() {
        return DIMCODE;
    }

    public void setDIMCODE(String DIMCODE) {
        this.DIMCODE = DIMCODE;
    }

    public String getACCOUNTTYPE() {
        return ACCOUNTTYPE;
    }

    public void setACCOUNTTYPE(String ACCOUNTTYPE) {
        this.ACCOUNTTYPE = ACCOUNTTYPE;
    }

    public String getVALUETYPE() {
        return VALUETYPE;
    }

    public void setVALUETYPE(String VALUETYPE) {
        this.VALUETYPE = VALUETYPE;
    }

    public String getDICTYPE() {
        return DICTYPE;
    }

    public void setDICTYPE(String DICTYPE) {
        this.DICTYPE = DICTYPE;
    }

    public String getATTRNAME() {
        return ATTRNAME;
    }

    public void setATTRNAME(String ATTRNAME) {
        this.ATTRNAME = ATTRNAME;
    }

    public String getATTRTYPE() {
        return ATTRTYPE;
    }

    public void setATTRTYPE(String ATTRTYPE) {
        this.ATTRTYPE = ATTRTYPE;
    }

    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public String getDIM_CODE() {
        return DIM_CODE;
    }

    public void setDIM_CODE(String DIM_CODE) {
        this.DIM_CODE = DIM_CODE;
    }

    public String getTWONODEID() {
        return TWONODEID;
    }

    public void setTWONODEID(String TWONODEID) {
        this.TWONODEID = TWONODEID;
    }

    public String getONENODENAME() {
        return ONENODENAME;
    }

    public void setONENODENAME(String ONENODENAME) {
        this.ONENODENAME = ONENODENAME;
    }

    public String getKINDCODE() {
        return KINDCODE;
    }

    public void setKINDCODE(String KINDCODE) {
        this.KINDCODE = KINDCODE;
    }

    public String getLINKPERSON() {
        return LINKPERSON;
    }

    public void setLINKPERSON(String LINKPERSON) {
        this.LINKPERSON = LINKPERSON;
    }

    public String getTWOCHILDRENNUM() {
        return TWOCHILDRENNUM;
    }

    public void setTWOCHILDRENNUM(String TWOCHILDRENNUM) {
        this.TWOCHILDRENNUM = TWOCHILDRENNUM;
    }

    public String getONECHILDRENNUM() {
        return ONECHILDRENNUM;
    }

    public void setONECHILDRENNUM(String ONECHILDRENNUM) {
        this.ONECHILDRENNUM = ONECHILDRENNUM;
    }

    public String getLINKPHONE() {
        return LINKPHONE;
    }

    public void setLINKPHONE(String LINKPHONE) {
        this.LINKPHONE = LINKPHONE;
    }

    public String getPROVID() {
        return PROVID;
    }

    public void setPROVID(String PROVID) {
        this.PROVID = PROVID;
    }

    public String getDIMNAME() {
        return DIMNAME;
    }

    public void setDIMNAME(String DIMNAME) {
        this.DIMNAME = DIMNAME;
    }

    public String getATTRCODE() {
        return ATTRCODE;
    }

    public void setATTRCODE(String ATTRCODE) {
        this.ATTRCODE = ATTRCODE;
    }

    public String getSOURCESYSTEM() {
        return SOURCESYSTEM;
    }

    public void setSOURCESYSTEM(String SOURCESYSTEM) {
        this.SOURCESYSTEM = SOURCESYSTEM;
    }

    public String getBUSINESSCALIBER() {
        return BUSINESSCALIBER;
    }

    public void setBUSINESSCALIBER(String BUSINESSCALIBER) {
        this.BUSINESSCALIBER = BUSINESSCALIBER;
    }

    public String getSUPPORTTIME() {
        return SUPPORTTIME;
    }

    public void setSUPPORTTIME(String SUPPORTTIME) {
        this.SUPPORTTIME = SUPPORTTIME;
    }

    public String getONENODEID() {
        return ONENODEID;
    }

    public void setONENODEID(String ONENODEID) {
        this.ONENODEID = ONENODEID;
    }

    public String getTWONODENAME() {
        return TWONODENAME;
    }

    public void setTWONODENAME(String TWONODENAME) {
        this.TWONODENAME = TWONODENAME;
    }

    public String getSHOW_LIMIT_SQL() {
        return SHOW_LIMIT_SQL;
    }

    public void setSHOW_LIMIT_SQL(String SHOW_LIMIT_SQL) {
        this.SHOW_LIMIT_SQL = SHOW_LIMIT_SQL;
    }

    public String getDIMTYPE() {
        return DIMTYPE;
    }

    public void setDIMTYPE(String DIMTYPE) {
        this.DIMTYPE = DIMTYPE;
    }

    String ACCOUNT;
    String DIM_CODE;
    String TWONODEID;
    String ONENODENAME;
    String KINDCODE;
    String LINKPERSON;
    String TWOCHILDRENNUM;
    String ONECHILDRENNUM;
    String LINKPHONE;
    String PROVID;
    String DIMNAME;
    String ATTRCODE;
    String SOURCESYSTEM;
    String BUSINESSCALIBER;
    String SUPPORTTIME;
    String ONENODEID;
    String TWONODENAME;
    String SHOW_LIMIT_SQL;
    String DIMTYPE;


    @Override
    public String toString() {
        return "DataDTO{" +
                "PARENTNODEID='" + PARENTNODEID + '\'' +
                ", DIMCODE='" + DIMCODE + '\'' +
                ", ACCOUNTTYPE='" + ACCOUNTTYPE + '\'' +
                ", VALUETYPE='" + VALUETYPE + '\'' +
                ", DICTYPE='" + DICTYPE + '\'' +
                ", ATTRNAME='" + ATTRNAME + '\'' +
                ", ATTRTYPE='" + ATTRTYPE + '\'' +
                ", ACCOUNT='" + ACCOUNT + '\'' +
                ", DIM_CODE='" + DIM_CODE + '\'' +
                ", TWONODEID='" + TWONODEID + '\'' +
                ", ONENODENAME='" + ONENODENAME + '\'' +
                ", KINDCODE='" + KINDCODE + '\'' +
                ", LINKPERSON='" + LINKPERSON + '\'' +
                ", TWOCHILDRENNUM='" + TWOCHILDRENNUM + '\'' +
                ", ONECHILDRENNUM='" + ONECHILDRENNUM + '\'' +
                ", LINKPHONE='" + LINKPHONE + '\'' +
                ", PROVID='" + PROVID + '\'' +
                ", DIMNAME='" + DIMNAME + '\'' +
                ", ATTRCODE='" + ATTRCODE + '\'' +
                ", SOURCESYSTEM='" + SOURCESYSTEM + '\'' +
                ", BUSINESSCALIBER='" + BUSINESSCALIBER + '\'' +
                ", SUPPORTTIME='" + SUPPORTTIME + '\'' +
                ", ONENODEID='" + ONENODEID + '\'' +
                ", TWONODENAME='" + TWONODENAME + '\'' +
                ", SHOW_LIMIT_SQL='" + SHOW_LIMIT_SQL + '\'' +
                ", DIMTYPE='" + DIMTYPE + '\'' +
                '}';
    }
}
