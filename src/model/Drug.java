
package model;

/**
 *
 * @author 
 * 
 * Md. Tariqul Islam - 191002037
 * Omit Kumar        - 191002120
 * Joy Kumar Majumder- 191002121
 * Sonia Akter Mona  - 191002197
 * Abdur Razzak      - 191002206
 * 
 */

public class Drug {
    private int id;
    private int sl;
    private String name;
    private String genricName;
    private String note;
    private String createdAt;
    private int useInPrescription;
    private int useInTemplate;
    
    

    public Drug() {
    }

    public Drug(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    

    public Drug(int id, int sl, String name, String genricName, String note, String createdAt) {
        this.id = id;
        this.sl = sl;
        this.name = name;
        this.genricName = genricName;
        this.note = note;
        this.createdAt = createdAt;
    }

    public Drug(int id, int sl, String name, String genricName, String note, String createdAt, int useInPrescription, int useInTemplate) {
        this.id = id;
        this.sl = sl;
        this.name = name;
        this.genricName = genricName;
        this.note = note;
        this.createdAt = createdAt;
        this.useInPrescription = useInPrescription;
        this.useInTemplate = useInTemplate;
    }
    

    public Drug(int id, String name, String genricName, String note) {
        this.id = id;
        this.name = name;
        this.genricName = genricName;
        this.note = note;
    }
    
    
    public Drug(String name, String genricName, String note, String createdAt) {
        this.name = name;
        this.genricName = genricName;
        this.note = note;
        this.createdAt = createdAt;
    }
    
    
    public Drug(int id, String name, String genricName, String note, String createdAt) {
        this.id = id;
        this.name = name;
        this.genricName = genricName;
        this.note = note;
        this.createdAt = createdAt;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenricName() {
        return genricName;
    }

    public void setGenricName(String genricName) {
        this.genricName = genricName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public int getUseInPrescription() {
        return useInPrescription;
    }

    public void setUseInPrescription(int useInPrescription) {
        this.useInPrescription = useInPrescription;
    }

    public int getUseInTemplate() {
        return useInTemplate;
    }

    public void setUseInTemplate(int useInTemplate) {
        this.useInTemplate = useInTemplate;
    }
      
}
