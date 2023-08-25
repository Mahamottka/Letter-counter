package tableModel;

import model.Znak;
import serdes.CsvSerDes;
import utils.Counting;
import utils.Filter;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TableModel extends AbstractTableModel {

    private static final int POCET_SLOUPCU = 3;
    private static final int SLOUPEC_ZNAK = 0;
    private static final int SLOUPEC_ABS = 1;
    private static final int SLOUPEC_REL = 2;
    private CsvSerDes csvSerDes = new CsvSerDes();
    private Filter filter = new Filter();
    private Counting counting = new Counting();

    private List<Znak> listZnak = new ArrayList<>();
    private List<String> csvZnaky = new ArrayList<>();

    public TableModel() {
    }

    public void nacti(String soubor) throws IOException {
        List<Znak> temp = new ArrayList<>();
        System.out.println("test2");
        csvZnaky = csvSerDes.nacti(soubor);
        System.out.println("test3");
        temp.addAll(filter.countLetters(csvZnaky));
        listZnak = counting.countFinal(temp, csvZnaky);
        fireTableDataChanged();
    }

    public void uloz(String soubor) throws IOException {
        csvSerDes.uloz(soubor, listZnak);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case SLOUPEC_ABS, SLOUPEC_REL:
                return Integer.class;
            case SLOUPEC_ZNAK:
                return String.class;
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }
    }

    @Override
    public String getColumnName(int columnIndex){
        switch (columnIndex){
            case 0: return "Znak";
            case 1: return "Abs. četnost";
            case 2: return "Rel. četnost";
        }
        throw new RuntimeException("Unknown Column Index" + columnIndex);

    }

    @Override
    public int getRowCount() {
        return listZnak.size();
    }

    @Override
    public int getColumnCount() {
        return POCET_SLOUPCU;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Znak znak = listZnak.get(rowIndex);

        switch (columnIndex) {
            case SLOUPEC_ZNAK:
                return znak.getNazev();
            case SLOUPEC_ABS:
                return znak.getAbsCetnost();
            case SLOUPEC_REL:
                return znak.getRelCetnost();
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }
    }

    @Override
    public void setValueAt(Object hodnota, int rowIndex, int columnIndex) {
        Znak znak = listZnak.get(rowIndex);

        switch (columnIndex) {
            case SLOUPEC_ZNAK:
                znak.setNazev((String) hodnota);
                break;
            case SLOUPEC_ABS:
                znak.setAbsCetnost((Integer) hodnota);
                break;
            case SLOUPEC_REL:
                znak.setRelCetnost((Integer) hodnota);
                break;
            default:
                throw new IllegalArgumentException("Nesprávný index sloupce tabulky.");
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
