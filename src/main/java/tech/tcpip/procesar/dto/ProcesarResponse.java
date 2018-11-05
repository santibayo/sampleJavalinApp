package tech.tcpip.procesar.dto;

public class ProcesarResponse {
    private String folio;
    private String resultCode;
    private String diagnosticCode;
    private String diagnosticDescription;
    private String helpText;

    public ProcesarResponse() {
    }

    public ProcesarResponse(String folio, String resultCode, String diagnosticCode, String diagnosticDescription, String helpText) {
        this.folio = folio;
        this.resultCode = resultCode;
        this.diagnosticCode = diagnosticCode;
        this.diagnosticDescription = diagnosticDescription;
        this.helpText = helpText;
    }


    @Override
    public String toString() {
        return "ProcesarResponse{" +
                "folio='" + folio + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", diagnosticCode='" + diagnosticCode + '\'' +
                ", diagnosticDescription='" + diagnosticDescription + '\'' +
                ", helpText='" + helpText + '\'' +
                '}';
    }


    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getDiagnosticCode() {
        return diagnosticCode;
    }

    public void setDiagnosticCode(String diagnosticCode) {
        this.diagnosticCode = diagnosticCode;
    }

    public String getDiagnosticDescription() {
        return diagnosticDescription;
    }

    public void setDiagnosticDescription(String diagnosticDescription) {
        this.diagnosticDescription = diagnosticDescription;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }
}
