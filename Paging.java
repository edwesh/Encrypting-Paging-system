import javax.swing.*;
class Paging
{
    public Paging()
    {
        JFrame f = new JFrame();
        Table mt = new Table();
        JTable t = new JTable(mt);
        JScrollPane s = new JScrollPane(t);
        f.getContentPane().add(s);
        f.setTitle("Paging output");
        f.pack();
        f.setVisible(true);
    }
}


