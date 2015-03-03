/**
\@brief GSDInfo Class (MAIN)

\@author Renato S. Carrijo <rscarrijo@yahoo.com>, March, 2015
*/
package gsdinfo;

import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;
import java.io.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.xml.xpath.XPathConstants;
import org.w3c.dom.*;

public class GSDInfo {

    private static Collection<Device> devices = new ArrayList<Device>();
    
    private static void executeAction(int codigo) {  
        switch (codigo) {  
            case 0:  
                System.out.println("Program finished!");  
                break;              
            case 1:  
                import_GSD_from_GSDFolder();
                break;         
            case 2:                  
                printDevices();
                break;                  
            case 3:  
                retrieve_InfoText_VendorName_DeviceFunctionFamily();
                break;  
            case 4:                  
                retrieve_ModuleInfo();
                break;  
            case 5:                  
                retrieve_Name_Help();
                break;
            case 6:                  
                printDevices();
                break;                  
        }           
    }     
    
    public static void printDevices()
    {
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("LISTA DE EQUIPAMENTOS IMPORTADOS A PARTIR DO GSD_FOLDER:");
        System.out.println("Number of Devices: [" + devices.size() + "]");
        System.out.println("-------------------------------------------------------------------------");
        for(Device d: devices)
        {
            System.out.println("Device: [" + d.getDeviceID() + "]");
            System.out.println("GSD XML FILE: " + d.getGSDFile());
            System.out.println("DeviceID: " + d.getDeviceID() + " VendorID: " + d.getVendorID());
            System.out.println("VendorName: " + d.getVendorName());
            System.out.println("InfoText: " + d.getInfoText());
            System.out.println("");
        }
        System.out.println("-------------------------------------------------------------------------");

    }
    
    
    
    public static void importSingleDevice(String GSDFile)
    {
        System.out.print("Importing Device from [ " + GSDFile + " ] ... ");

        String XML_FILE = "./src/GSD_FOLDER/".concat(GSDFile);
        
        XPathReader reader = new XPathReader(XML_FILE);
      
        Device device = new Device();      

        String sDeviceID = null;
        String sVendorID = null;
        String sModuleItemID = null;
        String sInfoText = null;
        String sVendorName = null;
        String sDeviceFunction = null;
     
        String expDeviceID = "/ISO15745Profile/ProfileBody/DeviceIdentity/@DeviceID";
        String expVendorID = "/ISO15745Profile/ProfileBody/DeviceIdentity/@VendorID";
        String expModuleItemID = null;
        String expInfoText = "/ISO15745Profile/ProfileBody/DeviceIdentity/InfoText/@TextId";
        String expVendorName = "/ISO15745Profile/ProfileBody/DeviceIdentity/VendorName/@Value";
        String expDeviceFunction = "/ISO15745Profile/ProfileBody/DeviceFunction/Family/@MainFamily";
    
        sDeviceID = reader.read(expDeviceID, XPathConstants.STRING).toString();
        sVendorID = reader.read(expVendorID, XPathConstants.STRING).toString();

        sInfoText = reader.read(expInfoText, XPathConstants.STRING).toString();
        sVendorName = reader.read(expVendorName, XPathConstants.STRING).toString();
        sDeviceFunction = reader.read(expDeviceFunction, XPathConstants.STRING).toString();
      
        device.setDeviceID(sDeviceID);
        device.setVendorID(sVendorID);
        device.setModuleItemID(sModuleItemID);
        device.setInfoText(sInfoText);
        device.setVendorName(sVendorName);
        device.setDeviceFunction(sDeviceFunction);
        device.setGSDFile(GSDFile);
        
        devices.add(device);
        System.out.println("DONE!");
    }
    
    public static void import_GSD_from_GSDFolder(){        
        System.out.println("Importando arquivos GSD da pasta GSD_FOLDER...");
                
        File diretorio = new File("./src/GSD_FOLDER");
        File[] arquivos = diretorio.listFiles(); 
  
        if(arquivos != null){ 
            int length = arquivos.length; 
  
            for(int i = 0; i < length; ++i){ 
                File f = arquivos[i]; 
            
                if(f.isFile()){ 
                    String fileName = f.getName();
                    //Check for XML extension
                    if ( fileName.toLowerCase().endsWith("xml")) {
                        //System.out.println(fileName);
                        
                        importSingleDevice(fileName);
                        
                    }                                        
                } 
                else if(f.isDirectory()){ 
                    //Do nothing
                    //System.out.println("Diretorio: " + f.getName()); 
                } 
            } 
        }      
                
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("Resultado: " + devices.size() + " devices importados com sucesso!");
        System.out.println("-------------------------------------------------------------------------");
    }
    
    public static void retrieve_InfoText_VendorName_DeviceFunctionFamily(){
        
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" Retornar InfoText, VendorName e DeviceFunctionFamily");
        System.out.println("-------------------------------------------------------------------------");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));          
        String VendorID = null;
        String DeviceID = null;
       
        System.out.print("Digite o DeviceID: ");
        try{
            DeviceID = in.readLine();
  
        }catch (IOException e){
            e.printStackTrace();                
        }

        System.out.print("Digite o VendorID: ");
        try{
            VendorID = in.readLine();
  
        }catch (IOException e){
            e.printStackTrace();                
        }        
        
        for(Device d: devices)
        {
            if(  DeviceID.toLowerCase().equals(d.getDeviceID().toLowerCase()) && VendorID.toLowerCase().equals(d.getVendorID().toLowerCase()) )
            {
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Device encontrado!");
                System.out.println("InfoText: " + d.getInfoText());
                System.out.println("VendorName: " + d.getVendorName());
                System.out.println("DeviceFunctionFamily: " + d.getDeviceFunction());
                System.out.println("GSD XML: " + d.getGSDFile());                
                System.out.println("-------------------------------------------------------------------------");
            }
      
        }
    }
    
    
    public static Module retrieveModuleFromXML(String GSDFile){
        
        String XML_FILE = "./src/GSD_FOLDER/".concat(GSDFile);
        
        XPathReader reader = new XPathReader(XML_FILE);
      
        Module module = new Module();

        String sModuleItem_ModuleIdentNumber = null;
        String sModuleInfo_CategoryRefsDeviceID = null;
        String sModuleInfo_InfoText_TextIdsDeviceID = null;
        String sModuleInfo_Name_TextIdsDeviceID = null;
        String sModuleInfo_OrderNumber_ValuesDeviceID = null;
        
     
        String expModuleItem_ModuleIdentNumber = "/ISO15745Profile/ProfileBody/ApplicationProcess/DeviceAccessPointList/ModuleList/ModuleItem";
        String expModuleInfo_CategoryRefsDeviceID = "/ISO15745Profile/ProfileBody/DeviceIdentity/@DeviceID";
        String expModuleInfo_InfoText_TextIdsDeviceID = "/ISO15745Profile/ProfileBody/DeviceIdentity/@VendorID";
        String expModuleInfo_Name_TextIdsDeviceID = null;
        String expModuleInfo_OrderNumber_ValuesDeviceID = "/ISO15745Profile/ProfileBody/DeviceIdentity/InfoText/@TextId";
        
    
        sModuleItem_ModuleIdentNumber = reader.read(expModuleItem_ModuleIdentNumber, XPathConstants.STRING).toString();
        sModuleInfo_CategoryRefsDeviceID = reader.read(expModuleInfo_CategoryRefsDeviceID, XPathConstants.STRING).toString();
        sModuleInfo_InfoText_TextIdsDeviceID = reader.read(expModuleInfo_InfoText_TextIdsDeviceID, XPathConstants.STRING).toString();
        sModuleInfo_Name_TextIdsDeviceID = reader.read(expModuleInfo_Name_TextIdsDeviceID, XPathConstants.STRING).toString();
        sModuleInfo_OrderNumber_ValuesDeviceID = reader.read(expModuleInfo_OrderNumber_ValuesDeviceID, XPathConstants.STRING).toString();
        
        module.setModuleItem_ModuleIdentNumber(sModuleItem_ModuleIdentNumber);
        module.setModuleInfo_CategoryRef(sModuleInfo_CategoryRefsDeviceID);
        module.setModuleInfo_InfoText_TextId(sModuleInfo_InfoText_TextIdsDeviceID);
        module.setModuleInfo_Name_TextId(sModuleInfo_Name_TextIdsDeviceID);
        module.setModuleInfo_OrderNumber_Value(sModuleInfo_OrderNumber_ValuesDeviceID);
        
        return module;
    }
    
    public static void retrieve_ModuleInfo(){
        //String DeviceID, String VendorID, String ModuleItemID  
       
        System.out.println("-------------------------------------------------------------------------");
        System.out.println(" Retornar ModuleInfo a partir de ModuleItemID");
        System.out.println("-------------------------------------------------------------------------");
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));          
        String VendorID = null;
        String DeviceID = null;
        String ModuleItemID = null;
       
        System.out.print("Digite o DeviceID: ");
        try{
            DeviceID = in.readLine();
  
        }catch (IOException e){
            e.printStackTrace();                
        }

        System.out.print("Digite o VendorID: ");
        try{
            VendorID = in.readLine();
  
        }catch (IOException e){
            e.printStackTrace();                
        }        
        
        System.out.print("Digite o ModuleItemID: ");
        try{
            VendorID = in.readLine();
  
        }catch (IOException e){
            e.printStackTrace();                
        }         
        for(Device d: devices)
        {
            if(  DeviceID.toLowerCase().equals(d.getDeviceID().toLowerCase()) && VendorID.toLowerCase().equals(d.getVendorID().toLowerCase()) )
            {
                String GSDFile = d.getGSDFile();
                Module module = retrieveModuleFromXML(GSDFile);
                
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Device encontrado!");
                System.out.println("DeviceID: " + d.getDeviceID() + ", VendorID: " + d.getVendorID());
                System.out.println("VendorName: " +  d.getVendorName());
                
                System.out.println("ModuleItemID: " +  ModuleItemID);
                System.out.println("ModuleItem_ModuleIdentNumber: " + module.getModuleItem_ModuleIdentNumber());
                System.out.println("ModuleInfo_CategoryRef: " + module.getModuleInfo_CategoryRef());
                System.out.println("ModuleInfo_Name_TextId: " + module.getModuleInfo_Name_TextId());
                System.out.println("ModuleInfo_InfoText_TextId: " + module.getModuleInfo_InfoText_TextId());
                System.out.println("ModuleInfo_OrderNumber_Value: " + module.getModuleInfo_OrderNumber_Value());               
                
                System.out.println("-------------------------------------------------------------------------");
            }      
        }        
    }

    public static void retrieve_Name_Help(){
        //String DeviceID, String VendorID, String ErrorType    
        System.out.println("Retornar Name e Help a partir de ErrorType"); 
    }
    
    public static void showMenu(){
        int codigo = -1;  
        while (codigo != 0) {  
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("                      M E N U     P R I N C I P A L ");
            System.out.println("-------------------------------------------------------------------------\n");
            System.out.println("DIGITE A TECLA CORRESPONDENTE:\n");           
            System.out.println("1 - Importar arquivos GSD da pasta GSD_FOLDER");
            System.out.println("2 - Imprimir equipamentos importados");              
            System.out.println("3 - Retornar DeviceIdentity(InfoText, VendorName) e DeviceFunction Family");
            System.out.println("4 - Retornar ModuleInfo a partir de ModuleItemID");
            System.out.println("5 - Retornar Name e Help a partir de ErrorType");
            System.out.println("0 - Sair");              
            System.out.println("-------------------------------------------------------------------------");
            
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));  
            try {  
                codigo = Integer.parseInt(buffer.readLine());  
                executeAction(codigo);  
            } catch (IOException e) {  
                throw new RuntimeException(e);  
            }              
        }                
    }
            
    public static void main(String[] args) {
        // TODO code application logic here
        showMenu();
    }
    
}
