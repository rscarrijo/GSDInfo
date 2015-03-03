/**
\@brief Device Class: abstraction to Device

\@author Renato S. Carrijo <rscarrijo@yahoo.com>, March, 2015
*/
package gsdinfo;

public class Device {
    
    private String DeviceID;
    private String VendorID;
    private String ModuleItemID;
    private String InfoText;
    private String VendorName;
    private String DeviceFunction;       
    private String GSDFile;

    /**
     * @return the DeviceID
     */
    public String getDeviceID() {
        return DeviceID;
    }

    /**
     * @param DeviceID the DeviceID to set
     */
    public void setDeviceID(String DeviceID) {
        this.DeviceID = DeviceID;
    }

    /**
     * @return the VendorID
     */
    public String getVendorID() {
        return VendorID;
    }

    /**
     * @param VendorID the VendorID to set
     */
    public void setVendorID(String VendorID) {
        this.VendorID = VendorID;
    }

    /**
     * @return the ModuleItemID
     */
    public String getModuleItemID() {
        return ModuleItemID;
    }

    /**
     * @param ModuleItemID the ModuleItemID to set
     */
    public void setModuleItemID(String ModuleItemID) {
        this.ModuleItemID = ModuleItemID;
    }

    /**
     * @return the InfoText
     */
    public String getInfoText() {
        return InfoText;
    }

    /**
     * @param InfoText the InfoText to set
     */
    public void setInfoText(String InfoText) {
        this.InfoText = InfoText;
    }

    /**
     * @return the VendorName
     */
    public String getVendorName() {
        return VendorName;
    }

    /**
     * @param VendorName the VendorName to set
     */
    public void setVendorName(String VendorName) {
        this.VendorName = VendorName;
    }

    /**
     * @return the DeviceFunction
     */
    public String getDeviceFunction() {
        return DeviceFunction;
    }

    /**
     * @param DeviceFunction the DeviceFunction to set
     */
    public void setDeviceFunction(String DeviceFunction) {
        this.DeviceFunction = DeviceFunction;
    }
    
    /**
     * @return the GSDFile
     */
    public String getGSDFile() {
        return GSDFile;
    }

    /**
     * @param GSDFile the GSDFile to set
     */
    public void setGSDFile(String GSDFile) {
        this.GSDFile = GSDFile;
    }    
    
}
