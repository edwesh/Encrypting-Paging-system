import javax.swing.table.AbstractTableModel;
class Table extends AbstractTableModel{
    static String name = "Frame Number";
    static String name_p = "Encrypted Password";
    String[] n={name,name_p};
    static int accessTime;
    static String[] outPut = new String[64];
    Object[][] p = new Object[accessTime][2];
 
    public Table()
    {
        for (int i = 0; i < accessTime; i++)
        {
            p[i][0] = i+1;
            p[i][1] = outPut[i];
        }
    }
    
    public void assignValue(String encryption)     
    {
        outPut[accessTime] = encryption;   
    }
    
    public int getColumnCount() 
    {
        return n.length;
    }

    public int getRowCount() 
    {
        return p.length;
    }

    public String getColumnName(int col) 
    {
        return n[col];
    }

    public Object getValueAt(int row, int col) 
    {
        return p[row][col];
    }
}