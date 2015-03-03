/**
\@brief Device Class: abstraction to Device

\@author Renato S. Carrijo <rscarrijo@yahoo.com>, March, 2015
*/
package gsdinfo;

/**
 *
 * @author Admin
 */
public class Module {
        
    private String ModuleItem_ModuleIdentNumber;
    private String ModuleInfo_CategoryRef;
    private String ModuleInfo_Name_TextId;
    private String ModuleInfo_InfoText_TextId;
    private String ModuleInfo_OrderNumber_Value;

    /**
     * @return the ModuleItem_ModuleIdentNumber
     */
    public String getModuleItem_ModuleIdentNumber() {
        return ModuleItem_ModuleIdentNumber;
    }

    /**
     * @param ModuleItem_ModuleIdentNumber the ModuleItem_ModuleIdentNumber to set
     */
    public void setModuleItem_ModuleIdentNumber(String ModuleItem_ModuleIdentNumber) {
        this.ModuleItem_ModuleIdentNumber = ModuleItem_ModuleIdentNumber;
    }

    /**
     * @return the ModuleInfo_CategoryRef
     */
    public String getModuleInfo_CategoryRef() {
        return ModuleInfo_CategoryRef;
    }

    /**
     * @param ModuleInfo_CategoryRef the ModuleInfo_CategoryRef to set
     */
    public void setModuleInfo_CategoryRef(String ModuleInfo_CategoryRef) {
        this.ModuleInfo_CategoryRef = ModuleInfo_CategoryRef;
    }

    /**
     * @return the ModuleInfo_Name_TextId
     */
    public String getModuleInfo_Name_TextId() {
        return ModuleInfo_Name_TextId;
    }

    /**
     * @param ModuleInfo_Name_TextId the ModuleInfo_Name_TextId to set
     */
    public void setModuleInfo_Name_TextId(String ModuleInfo_Name_TextId) {
        this.ModuleInfo_Name_TextId = ModuleInfo_Name_TextId;
    }

    /**
     * @return the ModuleInfo_InfoText_TextId
     */
    public String getModuleInfo_InfoText_TextId() {
        return ModuleInfo_InfoText_TextId;
    }

    /**
     * @param ModuleInfo_InfoText_TextId the ModuleInfo_InfoText_TextId to set
     */
    public void setModuleInfo_InfoText_TextId(String ModuleInfo_InfoText_TextId) {
        this.ModuleInfo_InfoText_TextId = ModuleInfo_InfoText_TextId;
    }

    /**
     * @return the ModuleInfo_OrderNumber_Value
     */
    public String getModuleInfo_OrderNumber_Value() {
        return ModuleInfo_OrderNumber_Value;
    }

    /**
     * @param ModuleInfo_OrderNumber_Value the ModuleInfo_OrderNumber_Value to set
     */
    public void setModuleInfo_OrderNumber_Value(String ModuleInfo_OrderNumber_Value) {
        this.ModuleInfo_OrderNumber_Value = ModuleInfo_OrderNumber_Value;
    }
    
}
