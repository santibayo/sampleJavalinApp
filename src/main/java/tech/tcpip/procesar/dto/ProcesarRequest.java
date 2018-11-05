package tech.tcpip.procesar.dto;

public class ProcesarRequest {

    private String curp;
    private String amount;
    private String contributionType;




    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getContributionType() {
        return contributionType;
    }

    public void setContributionType(String contributionType) {
        this.contributionType = contributionType;
    }

    @Override
    public String toString() {
        return "ProcesarRequest{" +
                "curp='" + curp + '\'' +
                ", amount='" + amount + '\'' +
                ", contributionType='" + contributionType + '\'' +
                '}';
    }
}
